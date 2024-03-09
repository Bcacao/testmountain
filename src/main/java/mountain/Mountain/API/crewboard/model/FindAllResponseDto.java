package mountain.Mountain.API.crewboard.model;


import lombok.*;
import mountain.Mountain.API.crew.entity.CrewEntity;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class FindAllResponseDto {

    private int crewboard_no;
    private String member_id;
    private String crewboard_mountain;
    private String crewboard_content;
    private LocalDateTime crewboard_time;
    private List<CrewEntity> crewEntities;
}
