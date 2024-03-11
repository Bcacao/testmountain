package mountain.Mountain.API.member.dao;

import mountain.Mountain.API.member.entity.MemberEntity;
import mountain.Mountain.API.member.model.AutoLoginDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberDAO {

    // 회원가입
    boolean save(MemberEntity member);

    // 회원정보 조회
    MemberEntity findMember(String memberId);

    // 중복체크(account, email) 기능
    int isDuplicate(String memberId);

}