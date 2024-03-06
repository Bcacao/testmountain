package mountain.Mountain.API.member.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class MemberEntity {
    private String member_id;
    private String member_pw;
    private String member_name;
    private String member_nick;
    private Date member_time;
    private String member_image;
    private String member_gender;
}
