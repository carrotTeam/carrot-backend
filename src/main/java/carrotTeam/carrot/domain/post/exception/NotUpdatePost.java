package carrotTeam.carrot.domain.post.exception;

import carrotTeam.carrot.global.error.ErrorCode;
import carrotTeam.carrot.global.error.exception.BusinessException;

public class NotUpdatePost extends BusinessException {

  public NotUpdatePost() {
    super(ErrorCode.POST_NOT_UPDATE);
  }

}
