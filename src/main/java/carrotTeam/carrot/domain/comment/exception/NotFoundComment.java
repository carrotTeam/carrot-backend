package carrotTeam.carrot.domain.comment.exception;

import carrotTeam.carrot.global.error.ErrorCode;
import carrotTeam.carrot.global.error.exception.BusinessException;

public class NotFoundComment extends BusinessException {

  public NotFoundComment() {
    super(ErrorCode.COMMENT_NOT_FOUND);
  }
}
