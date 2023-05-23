package carrotTeam.carrot.domain.post.service;

import carrotTeam.carrot.domain.post.domain.entity.Post;
import carrotTeam.carrot.domain.post.domain.entity.RedisPost;
import carrotTeam.carrot.domain.post.domain.repository.PostRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
@RequiredArgsConstructor
public class RedisScheduled {
  private final PostRepository postRepository;
  private final RedisTemplate<String, RedisPost> redisTemplate;
  @Scheduled(fixedDelay = 10000) //10초마다 실행
  public void flushViews() {
    System.out.println("조회수 스케쥴러 실행 중 !!!"); //이후 log로 변경 예정

    Set<String> keys = redisTemplate.keys("*");
    Map<String, Object> redisHash = new HashMap<>();

    for (String s : keys) {
      redisHash.put(s, redisTemplate.opsForValue().get(s));
    }

    //  레디스에서 조회수 변경이 있는 id만 찾아서 리스트로 제작
    List<RedisPost> redisPosts = redisHash.values().stream()
        .map(obj -> (RedisPost) obj)
        .filter(redisPost -> redisPost.getViewCount() != 0)
        .collect(Collectors.toList());

    for (Object key : keys) {
      RedisPost redisPost = redisTemplate.opsForValue().get(key.toString());
      redisPost.cleanViewCount();
      redisTemplate.opsForValue().set(key.toString(), redisPost);
    }

    redisPosts.forEach(redisPost -> {
      Post post = postRepository.findById(redisPost.getId())
          .orElseThrow(() -> new IllegalArgumentException("Post not found for id " + redisPost.getId()));
      post.updateView(redisPost.getViewCount());
      postRepository.save(post);
    });
  }

  @Scheduled(fixedRate = 50000) //50초마다 실향
  public void cleanupRedisMemory() {
    redisTemplate.getConnectionFactory().getConnection().flushAll();
    System.out.println("레디스 메모리 초기화 진행 중 !!!"); //이후 log로 변경 예정
  }
}
