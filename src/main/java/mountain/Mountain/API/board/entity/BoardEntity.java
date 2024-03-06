package mountain.Mountain.API.board.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class BoardEntity {
    private int board_no;
    private String board_content;
    private Date DATE;
    private String member_id;
    private int image_no;
}
