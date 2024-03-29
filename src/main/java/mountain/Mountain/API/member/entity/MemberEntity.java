package mountain.Mountain.API.member.entity;

import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberEntity {
    private String member_id;
    private String member_pw;
    private String member_name;
    private String member_nick;
    private LocalDateTime member_time;
    private String member_image;
    private String member_gender;
}
