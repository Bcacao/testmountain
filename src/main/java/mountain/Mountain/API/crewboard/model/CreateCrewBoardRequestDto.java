package mountain.Mountain.API.crewboard.model;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CreateCrewBoardRequestDto {

    private String crewboardMountain;
    private String crewboardContent;

}
