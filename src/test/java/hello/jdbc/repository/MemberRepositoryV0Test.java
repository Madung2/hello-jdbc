package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import static org.assertj.core.api.Assertions.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repository = new MemberRepositoryV0();


    @Test
    void crud() throws SQLException {
        //save
        Member member = new Member("memberV4", 10000);
        repository.save(member);

        //findById
        Member findMember = repository.findById(member.getMemberId());
        log.info("findMember={}", findMember);
        log.info("member!=findMember {}", member==findMember);
        log.info("member equals findMember {}", member.equals(findMember));
        assertThat(findMember).isEqualTo(member);
    }
}