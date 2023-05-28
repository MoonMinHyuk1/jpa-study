package study.querydsl.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberTest {
    @Autowired
    EntityManager em;
    
    @Test
    public void testEntity() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);
        
        Member meber1 = new Member("member1", 10, teamA);
        Member meber2 = new Member("member2", 20, teamA);
        Member meber3 = new Member("member3", 30, teamB);
        Member meber4 = new Member("member4", 40, teamB);
        em.persist(meber1);
        em.persist(meber2);
        em.persist(meber3);
        em.persist(meber4);
        
        //초기화
        em.flush();
        em.clear();

        List<Member> members = em.createQuery("select m from Member m", Member.class)
                .getResultList();
        
        for(Member member : members) {
            System.out.println("member = " + member);
            System.out.println("member.getTeam() = " + member.getTeam());
        }
    }
}