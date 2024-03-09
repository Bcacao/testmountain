package mountain.Mountain.API.crewboard.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mountain.Mountain.API.crew.dao.CrewDAO;
import mountain.Mountain.API.crewboard.dao.CrewboardDAO;
import mountain.Mountain.API.crewboard.entity.CrewBoardEntity;
import mountain.Mountain.API.crewboard.model.CreateCrewBoardRequestDto;
import mountain.Mountain.API.crewboard.model.DeleteCrewBoardRequestDto;
import mountain.Mountain.API.crewboard.model.FindAllResponseDto;
import mountain.Mountain.API.crewboard.model.UpdateCrewBoardRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CrewboardService {

    final CrewboardDAO crewboardDAO;
    final CrewDAO crewDAO;

    // 크루 모집방 생성
    public void makeCrewBoard(CreateCrewBoardRequestDto dto, String memberId){

        // dto를 entity로 변환
        CrewBoardEntity crewboardModel = CrewBoardEntity.builder()
                .crewboard_mountain(dto.getCrewboardMountain())
                .crewboard_content(dto.getCrewboardContent())
                .member_id(memberId)
                .build();

        // 쿼리문이 동작하면 true 동작하지 않으면 false
        crewboardDAO.createCrewBoard(crewboardModel);

        // crew table 생성
        crewDAO.createCrew(crewboardModel.getCrewboard_no());


    }

    // 크루 모집방 수정
    public boolean modifyCrewBoard(UpdateCrewBoardRequestDto dto, String memberId){

        // 수정할 crewboard를 crewboardNo로 검색
        CrewBoardEntity foundCrewBoard = crewboardDAO.findCrewBoard(dto.getCrewboardNo());

        // dto를 entity로 변환
        CrewBoardEntity crewboardModel = CrewBoardEntity.builder()
                .crewboard_mountain(dto.getCrewboardMountain())
                .crewboard_content(dto.getCrewboardContent())
                .crewboard_no(dto.getCrewboardNo())
                .build();

        // session에서 memberId 와 검색한 crewboard의 memberId가 같은지 확인
        if(foundCrewBoard.getMember_id().equals(memberId)){

            return crewboardDAO.updateCrewBoard(crewboardModel);
        }

        return false;

    }

    // 크루 모집방 삭제
    public boolean removeCrewBoard(DeleteCrewBoardRequestDto dto, String memberId){

        // 수정할 crewboard를 crewboardNo로 검색
        CrewBoardEntity foundCrewBoard = crewboardDAO.findCrewBoard(dto.getCrewboardNo());

        // session에서 memberId 와 검색한 crewboard의 memberId가 같은지 확인
        if(foundCrewBoard.getMember_id().equals(memberId)){
            return crewboardDAO.deleteCrewBoard(dto.getCrewboardNo());
        }

        return false;
    }

    // 크루 모집방 목록 전체
    public List<FindAllResponseDto> findAllCrewBoard(){

        // crewboard 전체 list
        return crewboardDAO.findAllCrewBoard();

    }

    // 내가 만든 크루 모집방 목록
    public List<FindAllResponseDto> findMyCrewBoard(String memberId){

        // crewboard 내가 만든방 list
        return crewboardDAO.findMyCrewBoard(memberId);

    }

}
