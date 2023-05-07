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


//     User

//     Post

//     Comment
    COMMENT_NOT_FOUND(400, "C001", "댓글을 찾을 수 없습니다!")
    ;

    private final int status;
    private final String code;
    private final String message;
}
