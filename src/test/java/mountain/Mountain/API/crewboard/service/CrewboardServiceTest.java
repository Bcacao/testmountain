package mountain.Mountain.API.crewboard.service;

import mountain.Mountain.API.crew.service.CrewService;
import mountain.Mountain.API.crewboard.dao.CrewboardDAO;
import mountain.Mountain.API.crewboard.entity.CrewBoardEntity;
import mountain.Mountain.API.crewboard.model.CreateCrewBoardRequestDto;
import mountain.Mountain.API.crewboard.model.DeleteCrewBoardRequestDto;
import mountain.Mountain.API.crewboard.model.FindAllResponseDto;
import mountain.Mountain.API.crewboard.model.UpdateCrewBoardRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CrewboardServiceTest {

    @Autowired
    CrewboardService crewboardService;

    @Autowired
    CrewService crewService;

   /* @Test
    @DisplayName("crewboard 하나 생성 되야함")
    void createCrewBoardTest(){
        // given
        CreateCrewBoardRequestDto dto =
                new CreateCrewBoardRequestDto();
        dto.setCrewboardContent("등산멤버모집33");
        dto.setCrewboardMountain("설악산33");
        String memberId = "boy53153";

        // when
        crewboardService.makeCrewBoard(dto,memberId);



    }*/

  /*  @Test
    void updateTest(){
        // given
        UpdateCrewBoardRequestDto dto = new UpdateCrewBoardRequestDto();
        dto.setCrewboardNo(8);
        dto.setCrewboardContent("한라산 가실분");
        dto.setCrewboardMountain("한라산");

        String memeberId = "boy53151";

        crewboardService.modifyCrewBoard(dto, memeberId);
    }*/

  /*  @Test
    void deleteTest(){

        DeleteCrewBoardRequestDto dto = new DeleteCrewBoardRequestDto();
         dto.setCrewboardNo(8);

        String memeberId = "boy53151";

        crewboardService.removeCrewBoard(dto, memeberId);


    }*/

   /* @Test
    void test(){
       CrewBoardEntity crewBoardEntity = CrewBoardEntity.builder()
                        .crewboard_content("설악산 가실분>")
                                .crewboard_mountain("설악산")
                                        .member_id("boy53151")
               .build();
        crewboardDAO.createCrewBoard(crewBoardEntity);
    }*/

/*    @Test
    void findAlltest() {

        List<FindAllResponseDto> allCrewBoard = crewboardService.findAllCrewBoard();


        allCrewBoard.forEach(c->System.out.println(c.toString()));
    }*/

   /* @Test
    void findAlltest() {
        String memberId = "boy53151";
        List<FindAllResponseDto> allCrewBoard = crewboardService.findMyCrewBoard(memberId);





        allCrewBoard.forEach(c->System.out.println(c.toString()));
    }*/
/*
    @Test
    void joinTest(){

        crewService.joinCrew(11, "boy53154");

    }*/

/*    @Test
    void deleteCrewTest(){

        crewService.deleteCrew(11,"boy53152");

    }*/

}