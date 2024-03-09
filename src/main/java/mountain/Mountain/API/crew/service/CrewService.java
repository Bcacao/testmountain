package mountain.Mountain.API.crew.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mountain.Mountain.API.crew.dao.CrewDAO;
import mountain.Mountain.API.crew.entity.CrewEntity;
import mountain.Mountain.API.crewboard.dao.CrewboardDAO;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CrewService {

    final CrewDAO crewDAO;

    // crew 참가
    public boolean joinCrew(int crewboardNo, String crewMemberId){

        CrewEntity crewModel = CrewEntity.builder()
                .crewboard_no(crewboardNo)
                .crew_member_id(crewMemberId)
                .build();

        // crew에 내가 참여 했는지 여부 확인(참여 안헀으면0)
        int checkedJoin = crewDAO.checkJoin(crewMemberId, crewboardNo);
        log.info("3333333"+checkedJoin);
        // crew에 몇명이 참여해 있는지 확인
        int countedJoin = crewDAO.countJoin(crewboardNo);

        if(checkedJoin == 0 && countedJoin < 4){
            return crewDAO.joinCrew(crewModel);
        }

        return false;

    }

    // crew 참가 삭제
    public boolean deleteCrew(int crewboardNo, String crewMemberId){

        // crew에 내가 참여 했는지 여부 확인(참여 안헀으면0)
        int checkedJoin = crewDAO.checkJoin(crewMemberId, crewboardNo);


        if(checkedJoin == 1){
            CrewEntity crew = crewDAO.findCrew(crewMemberId, crewboardNo);
            return crewDAO.deleteCrew(crew.getCrew_no());
        }

        return false;
    }

    // crew 현재 참가 인원 체크
    public int countedJoin(int crewboardNo){

        return crewDAO.countJoin(crewboardNo);
    }

    // crew 참가 여부 체크
    public boolean checkedJoin(String crewMemberId, int crewboardNo){

        int checkjoin = crewDAO.checkJoin(crewMemberId, crewboardNo);

        return checkjoin != 0;
    }

}
