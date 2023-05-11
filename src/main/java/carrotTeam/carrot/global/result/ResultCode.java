package carrotTeam.carrot.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** {행위}_{목적어}_{성공여부} message 는 동사 명사형으로 마무리 */

@Getter
@AllArgsConstructor
public enum ResultCode {

    // user
    CREATE_USER_SUCCESS("U001", "200","유저가 생성되었습니다!"),
    GET_ONE_POST_USER_SUCCESS("U002", "200","유저의 정보를 조회하였습니다!"),
    PUT_USER_SUCCESS("U003", "200", "유저의 정보를 변경하였습니다."),
    DELETE_USER_SUCCESS("U004", "200", "유저의 정보를 삭제하였습니다!"),
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
