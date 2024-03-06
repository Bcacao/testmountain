package mountain.Mountain.API.comment.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class CommentEntity {
    private int comment_no;
    private int board_no;
    private String member_id;
    private String comment_content;
    private Date comment_time;
}
