package mountain.Mountain.API.crewboard.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class CrewBoardEntity {
    private int crewboard_no;
    private String member_id;
    private int crew_no;
    private String crewboard_mountain;
    private String crewboard_content;
    private Date crewboard_time;
}
