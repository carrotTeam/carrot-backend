package carrotTeam.carrot.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** {행위}_{목적어}_{성공여부} message 는 동사 명사형으로 마무리 */

@Getter
@AllArgsConstructor
public enum ResultCode {

    // user

    // post

    // comment
    CREATE_COMMENT_SUCCESS("C001", "200", "댓글이 등록되었습니다!")
    ;

    private final String code;
    private final String status;
    private final String message;
}
