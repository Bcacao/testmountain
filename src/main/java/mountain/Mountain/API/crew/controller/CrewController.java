package mountain.Mountain.API.crew.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mountain.Mountain.API.crew.service.CrewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/crew")
public class CrewController {

    private final CrewService crewService;

    // 크루 참가
    @PostMapping
    public ResponseEntity<?> joinCrew(
        @RequestBody Map<String, Object> json,
        @RequestParam String memberId
        ){
        // 크루보드 넘버 받아서 크루 참가 등록
        String  crewboardNoStr  = (String) json.get("crewboardNo");
        int crewboardNo = Integer.parseInt(crewboardNoStr);
        crewService.joinCrew(crewboardNo,memberId);

        return ResponseEntity.ok().build();

    }

    // 크루 참가 삭제
    @DeleteMapping
    public ResponseEntity<?> deleteCrew(
            @RequestBody Map<String, Object> json,
            @RequestParam String memberId
    ){
        // 크루보드 넘버 받아서 크루 참가 삭제
        int crewboardNo = (int) json.get("crewboardNo");
        crewService.deleteCrew(crewboardNo,memberId);

        return ResponseEntity.ok().build();
    }
}
