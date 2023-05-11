package carrotTeam.carrot.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** {주체}_{이유} message 는 동사 명사형으로 마무리 */
@Getter
@AllArgsConstructor
public enum ErrorCode {
  // Global
  INTERNAL_SERVER_ERROR(500, "G001", "서버 오류"),
  INPUT_INVALID_VALUE(400, "G002", "잘못된 입력"),

  // User
  USER_NOT_FOUND(400, "U001", "사용자가 존재하지 않습니다!"),

  // Post
  POST_NOT_FOUND(400, "P001", "게시글이 존재하지 않습니다!"),

  // Comment
  COMMENT_NOT_FOUND(400, "C001", "댓글이 존재하지 않습니다!");

  private final int status;
  private final String code;
  private final String message;
}
