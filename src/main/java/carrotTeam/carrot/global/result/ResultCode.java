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
    CREATE_COMMENT_SUCCESS("C001", "200", "댓글이 등록되었습니다!"),
    GET_ONE_POST_COMMENT_SUCCESS("C002", "200", "게시글의 댓글을 조회하였습니다!"),
    DELETE_COMMENT_SUCCESS("C003","200","게시글의 댓글을 삭제하였습니다!"),
    ;

    private final String code;
    private final String status;
    private final String message;
}
