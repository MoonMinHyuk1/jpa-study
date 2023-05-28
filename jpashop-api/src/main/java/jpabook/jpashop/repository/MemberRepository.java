package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    //select m from Member m where m.name = ?
    List<Member> findByName(String name); //메서드 이름을 보고 ?를 채워 넣는다.(findByName)
}
