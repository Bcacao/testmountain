package mountain.Mountain.API.member.model;

import lombok.*;

import java.sql.Date;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberJoinRequestDTO {
    private String member_id;
    private String member_pw;
    private String member_name;
    private String member_nick;
    private String member_gender;
}
