package mountain.Mountain.API.member.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mountain.Mountain.API.member.dao.MemberDAO;
import mountain.Mountain.API.member.entity.MemberEntity;
import mountain.Mountain.API.member.model.LoginRequestDTO;
import mountain.Mountain.API.member.model.MemberJoinRequestDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    final MemberDAO memberDAO;

    // 회원가입 처리 서비스
    public void join(
            MemberJoinRequestDTO dto, String savePath
    ){
        // entity로 변환
        MemberEntity memberEntity = MemberEntity.builder()
                .member_id(dto.getMember_id())
                .member_pw(dto.getMember_pw())
                .member_name(dto.getMember_name())
                .member_nick(dto.getMember_nick())
                .member_image(savePath)
                .member_gender(dto.getMember_gender())
                .build();

        // 저장
        boolean save = memberDAO.save(memberEntity);
        if(!save) {
            throw new RuntimeException("Failed to join member.");
        }

    }

    // 아이디 중복검사
    public boolean checkSignUpValue(
            String memberId
    ){
        int duplicate = memberDAO.isDuplicate(memberId);
        return duplicate == 1;
    }

    // 로그인 검증
    public LoginResult authenticate(
            LoginRequestDTO dto,
            HttpSession session,
            HttpServletResponse response
    ){
        // 회원가입 여부 확인
        MemberEntity member = memberDAO.findMember(dto.getMember_id());
        if(member == null){
            return LoginResult.NO_ACC;
        }
        // 비밀번호 일치 확인
        if(!member.getMember_pw().equals(dto.getMember_pw())){
            return LoginResult.NO_PW;
        }
        // 쿠키 생성
        Cookie autoLoginCookie = new Cookie("id",session.getId());
        autoLoginCookie.setPath("/"); // 전체 경로
        // 쿠키를 클라이언트에 응답전송
        response.addCookie(autoLoginCookie);


        log.info("{}님 로그인 성공!", member.getMember_id());
        return LoginResult.SUCCESS;

    }



}
