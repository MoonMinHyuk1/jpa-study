package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Team teamA = new Team();
            teamA.setName("팀A");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("팀B");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setTeam(teamB);
            em.persist(member3);

            em.flush();
            em.clear();

//            String query = "select m from Member m join fetch m.team";
//            String query = "select distinct t from Team t join fetch t.members"; //jpql 의 distinct 는 같은 식별자를 가진 team 엔티티 제거
//            String query = "select i from Item i where type(i) IN (Book, Movie)";
//            String query = "select count(m) from Member m";
//            String query = "select m from Member m where m = :member";
//            em.createQuery(query).setParameter("member", member1).getResultList(); //member1.id 로 검색

//            List<Member> resultList = em.createQuery("Member.findByUsername", Member.class)
//                    .setParameter("username", "회원1")
//                    .getResultList();

            int resultCount = em.createQuery("update Member m set m.age = 20")
                    .executeUpdate();

            tx.commit();

//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            member.changeTeam(team);
//            member.setType(MemberType.ADMIN);
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            String query3 = "select m.team from Member m"; //묵시적 내부 조인, 사용 권장X
//            String query4 = "select t from Member m join m.team t";
//            em.createQuery(query3);
//            em.createQuery(query4);
//
//            String query =
//                    "select " +
//                            "case when m.age <= 10 then '학생요금' " +
//                            "     when m.age >= 60 then '경로요금' " +
//                            "     else '일반요금' end " +
//                    "from Member m";
//            TypedQuery<String> result = em.createQuery(query, String.class);
//
//            String query1 = "select coalesce(m.username, '이름 없는 회원') from Member m";
//            em.createQuery(query1);
//
//            String query2 = "select nullif(m.username, '관리자') as username from Member m";
//            em.createQuery(query2);
//
//            tx.commit();

//            String query = "select m.username, 'HELLO', TRUE from Member m" +
//                            "where m.type = jpql.MemberType.ADMIN";
//            List<Object[]> result = em.createQuery(query)
//                    .getResultList();
//
//            tx.commit();

//            List<Member> result = em.createQuery("select m from Member m order by m.age desc", Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(10)
//                    .getResultList();
//
//            tx.commit();

//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            em.persist(member);
//
//            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
//            List<Member> resultList = query1.getResultList();
//            Member singleResult = query1.getSingleResult(); //결과가 무조건 하나
//
//            TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
//            Query query3 = em.createQuery("select m.username, m.age from Member m");
//            TypedQuery<Member> query4 = em.createQuery("select m from Member m where m.username = :username", Member.class)
//                            .setParameter("username", "member1");
//            Member singleResult1 = query4.getSingleResult();
//
//            tx.commit();
        } catch(Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
