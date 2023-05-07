package carrotTeam.carrot.domain.post.exception;

import carrotTeam.carrot.global.error.ErrorCode;
import carrotTeam.carrot.global.error.exception.BusinessException;

public class NotFoundPost extends BusinessException {

    public NotFoundPost() {
        super(ErrorCode.POST_NOT_FOUND);
    }
}
