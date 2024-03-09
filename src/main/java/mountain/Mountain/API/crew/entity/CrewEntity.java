package mountain.Mountain.API.crew.entity;

import lombok.Data;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CrewEntity {

    private int crew_no;
    private int crewboard_no;
    private String crew_member_id;


}
