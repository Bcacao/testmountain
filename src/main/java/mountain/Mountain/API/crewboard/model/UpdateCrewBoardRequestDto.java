package mountain.Mountain.API.crewboard.model;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UpdateCrewBoardRequestDto {


    private String crewboardMountain;
    private String crewboardContent;
    private int crewboardNo;

}
