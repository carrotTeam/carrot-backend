package carrotTeam.carrot.domain.user.exception;

import carrotTeam.carrot.global.error.ErrorCode;
import carrotTeam.carrot.global.error.exception.BusinessException;

public class NotFoundUser extends BusinessException {
    public NotFoundUser() {super(ErrorCode.USER_NOT_FOUND); }
}
