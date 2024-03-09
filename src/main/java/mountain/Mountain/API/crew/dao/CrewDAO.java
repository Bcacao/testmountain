package mountain.Mountain.API.crew.dao;

import mountain.Mountain.API.crew.entity.CrewEntity;
import mountain.Mountain.API.crewboard.entity.CrewBoardEntity;
import mountain.Mountain.API.crewboard.model.FindAllResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CrewDAO {

    // crew 생성
    boolean createCrew(int crewboard_no);
    // crew 참가
    boolean joinCrew(CrewEntity crewModel);
    // crew 참가 삭제
    boolean deleteCrew(int crew_no);
    // crew 현재 참가 인원 체크
    int countJoin(int crewboard_no);
    // crew 참겨 여부 체크
    int checkJoin(String crew_member_id, int crewboard_no);
    // crew 내가 참가한 crew_no 찾기
    CrewEntity findCrew(String crew_member_id, int crewboard_no);
}
