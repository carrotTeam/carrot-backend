package carrotTeam.carrot.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** {행위}_{목적어}_{성공여부} message 는 동사 명사형으로 마무리 */

@Getter
@AllArgsConstructor
public enum ResultCode {

    // user

    // post
    CREATE_POST_SUCCESS("C004", "200", "게시글이 등록되었습니다"),
    UPDATE_POST_SUCCESS("C005", "200", "게시글이 수정되었습니다"),
    DELETE_POST_SUCCESS("C006","200","게시글을 삭제하였습니다!"),
    GET_ALL_POST_SUCCESS("C007", "200", "전체 게시글을 조회하였습니다!"),
    GET_USER_POST_SUCCESS("C008", "200", "유저 게시글을 조회하였습니다!"),
    // comment
    CREATE_COMMENT_SUCCESS("C001", "200", "댓글이 등록되었습니다!"),
    GET_ONE_POST_COMMENT_SUCCESS("C002", "200", "게시글의 댓글을 조회하였습니다!"),
    DELETE_COMMENT_SUCCESS("C003","200","게시글의 댓글을 삭제하였습니다!"),
    ;

    private final String code;
    private final String status;
    private final String message;
}
