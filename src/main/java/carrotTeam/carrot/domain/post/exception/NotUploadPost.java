package carrotTeam.carrot.domain.post.exception;

import carrotTeam.carrot.global.error.ErrorCode;
import carrotTeam.carrot.global.error.exception.BusinessException;

public class NotUploadPost extends BusinessException {

  public NotUploadPost() {
    super(ErrorCode.POST_NOT_UPLOAD);
  }
}
