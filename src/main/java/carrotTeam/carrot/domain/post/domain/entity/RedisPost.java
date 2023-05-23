package carrotTeam.carrot.domain.post.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@RedisHash("post")
public class RedisPost implements Serializable {

  @Id
  private Long id;
  private Long viewCount;

  public RedisPost() {
    this.viewCount = 0L;
  }

  public void increaseViewCount() {
    this.viewCount++;
  }

  public void cleanViewCount() {
    this.viewCount = 0L;
  }
}
