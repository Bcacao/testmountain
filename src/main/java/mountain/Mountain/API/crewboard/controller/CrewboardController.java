package mountain.Mountain.API.crewboard.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mountain.Mountain.API.crew.service.CrewService;
import mountain.Mountain.API.crewboard.model.CreateCrewBoardRequestDto;
import mountain.Mountain.API.crewboard.model.DeleteCrewBoardRequestDto;
import mountain.Mountain.API.crewboard.model.FindAllResponseDto;
import mountain.Mountain.API.crewboard.model.UpdateCrewBoardRequestDto;
import mountain.Mountain.API.crewboard.service.CrewboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/crewboard")
public class CrewboardController {

    private final CrewboardService crewboardService;

    // 크루모집방 등록 요청
    @PostMapping
    public ResponseEntity<?> createCrewBoard(
            @RequestBody CreateCrewBoardRequestDto requestDto,
            @RequestParam String memberId
            ){
        try {
            // 크루모집방 등록
            crewboardService.makeCrewBoard(requestDto, memberId);
            // 내가 쓴 게시물 목록 보기
            List<FindAllResponseDto> responseDto = crewboardService.findMyCrewBoard("boy53151");
            return ResponseEntity.ok().body(responseDto);
        } catch (RuntimeException  e) {
            log.error(e.getMessage());
            return ResponseEntity
                    .badRequest().body(e.getMessage());
        }
    }

    // 크루모집방 수정 요청
    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH })
    public ResponseEntity<?> updateCrewBoard(
            @RequestBody UpdateCrewBoardRequestDto requestDto,
            @RequestParam String memberId
            ){
        try {
            // 크루 모집방 수정
            crewboardService.modifyCrewBoard(requestDto, memberId);
            // 내가 쓴 게시물 목록 보기
            List<FindAllResponseDto> responseDto = crewboardService.findMyCrewBoard("boy53151");
            return ResponseEntity.ok().body(responseDto);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity
                    .badRequest().body(e.getMessage());
        }
    }

    // 크루모집방 삭제 요청
    @DeleteMapping
    public ResponseEntity<?> deleteCrewBoard(
        @RequestBody DeleteCrewBoardRequestDto requestDto,
        @RequestParam String memberId
    ){
        try {
            // 크루 모집방 삭제
            crewboardService.removeCrewBoard(requestDto, memberId);
            // 내가쓴 게시물 목록 보기
            List<FindAllResponseDto> responseDto = crewboardService.findMyCrewBoard("boy53151");
            return ResponseEntity.ok().body(responseDto);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .badRequest().body(e.getMessage());
        }
    }

    // 크루모집방 전체 목록 요청
    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        // 내가쓴 게시물 목록 보기
        List<FindAllResponseDto> responseDto = crewboardService.findAllCrewBoard();

        return ResponseEntity.ok().body(responseDto);
    }
    // 크루모집방 내가만든 방 목록 요청
    @GetMapping("/findmy")
    public ResponseEntity<?> findmy(@RequestParam String memberId){
        // 내가쓴 게시물 목록 보기
        List<FindAllResponseDto> responseDto = crewboardService.findMyCrewBoard(memberId);

        return ResponseEntity.ok().body(responseDto);
    }
}
