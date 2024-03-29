package mountain.Mountain.API.crewboard.entity;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CrewBoardEntity {
    private int crewboard_no;
    private String member_id;
    private String crewboard_mountain;
    private String crewboard_content;
    private LocalDateTime crewboard_time;
}
