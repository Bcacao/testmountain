package mountain.Mountain.API.member.model;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequestDTO {

    private String member_id;
    private String member_pw;

}
