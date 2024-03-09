package mountain.Mountain.API.crewboard.dao;

import mountain.Mountain.API.crewboard.entity.CrewBoardEntity;
import mountain.Mountain.API.crewboard.model.FindAllResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CrewboardDAO {

    // CrewBoard방 생성
    boolean createCrewBoard(CrewBoardEntity crewBoardEntity);

    // CrewBoard방 찾기
    CrewBoardEntity findCrewBoard(int crewboard_no);
    // CrewBoard방 수정
    boolean updateCrewBoard(CrewBoardEntity crewboardModel);
    // CrewBoard방 삭제
    boolean deleteCrewBoard(int crewboard_no);
    // CrewBoard방 전체 검색
    List<FindAllResponseDto> findAllCrewBoard();
    // CrewBoard방 내방만 검색
    List<FindAllResponseDto> findMyCrewBoard(String member_id);

}
