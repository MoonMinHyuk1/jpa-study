package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            //객체지향 쿼리언어1
//            List<Member> result = em.createQuery(
//                    "select m from Member m where m.username like '%kim%'",
//                    Member.class
//            ).getResultList();
//
//            for(Member member : result) {
//                System.out.println("member = " + member);
//            }

//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Member> query = cb.createQuery(Member.class);
//            Root<Member> m = query.from(Member.class);
//            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
//            String username = "AAA";
//
//            if(username != null) {
//                cq = cq.where(cb.equal(m.get("username"), username));
//            }
//            List<Member> resultList = em.createQuery(cq)
//                    .getResultList();
//            List result = em.createNativeQuery("select MEMBER_ID, city, street, zipcode, USERNAME from MEMBER", Member.class)
//                    .getResultList();

            tx.commit();

            //값 타입
//            Address address = new Address("city", "street", "10000");
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setHomeAddress(address);
//            em.persist(member);
//
//            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setHomeAddress(copyAddress);
//            em.persist(member2);
//
//            member.getHomeAddress().setCity("newCity");

//            Member member = new Member();
//            member.setUsername("member1");
//            member.setHomeAddress(new Address("homeCity", "street", "10000"));
//            member.getFavoriteFoods().add("치킨");
//            member.getFavoriteFoods().add("족발");
//            member.getFavoriteFoods().add("피자");
//            member.getAddressHistory().add(new AddressEntity("old1", "street", "10000"));
//            member.getAddressHistory().add(new AddressEntity("old2", "street", "10000"));
//
//            em.persist(member);
//            em.flush();
//            em.clear();
//
//            System.out.println("============ START ============");
//            Member findMember = em.find(Member.class, member.getId());
//
//            List<AddressEntity> addressHistory = findMember.getAddressHistory();
//            for(AddressEntity address : addressHistory) {
//                System.out.println("address = " + address.getAddress().getCity());
//            }
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for(String favoriteFood : favoriteFoods) {
//                System.out.println("favoriteFood = " + favoriteFood);
//            }
//
//            Address a = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));
//
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");
//
//            findMember.getAddressHistory().remove(new AddressEntity("old1", "street", "10000"));
//            findMember.getAddressHistory().add(new AddressEntity("new1", "street", "10000"));
//
//            tx.commit();

            //프록시와 연관관계 관리
            //지연로딩
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Team team2 = new Team();
//            team2.setName("teamB");
//            em.persist(team2);
//
//            Member member = new Member();
//            member.setUsername("hello");
//            member.setTeam(team);
//            em.persist(member);
//
//            Member member2 = new Member();
//            member2.setUsername("hello");
//            member2.setTeam(team2);
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
////            Member m = em.find(Member.class, member.getId());
//
//            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();
//
//            for (Member findMember : members) {
//                System.out.println("team.name = " + findMember.getTeam().getName());
//            }

//            Member findMember = em.find(Member.class, member.getId());
//            Member findMember = em.getReference(Member.class, member.getId());

//            em.detach(findMember);

//            System.out.println("member.id = " + findMember.getId());
//            System.out.println("member.name = " + findMember.getUsername());

//            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(findMember));
//            System.out.println("getClass = " + findMember.getClass());
//            Hibernate.initialize(findMember); //강제초기화
//            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(findMember));

//            System.out.println(findMember.getTeam().getName());

//            //Cascade
//            Parent parent = new Parent();
//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
////            em.persist(child1);
////            em.persist(child2);
//            em.flush();
//            em.clear();
//
//            Parent findParent = em.find(Parent.class, parent.getId());
//            findParent.getChildren().remove(0);
//
//            tx.commit();

//            //고급 매핑
//            Movie movie = new Movie();
//            movie.setDirector("aaa");
//            movie.setActor("bbb");
//            movie.setName("바람과함께사라지다");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//            em.flush();
//            em.clear();
//
//            Movie findMovie = em.find(Movie.class, movie.getId());
//
//            tx.commit();

//            //다양한 연관관계 매핑
//            Member member = new Member();
//            member.setUsername("member1");
//            em.persist(member);
//
//            Team team = new Team();
//            team.setName("teamA");
//            team.getMembers().add(member);
//
//            em.persist(team);
//
//            tx.commit();

//            //연관관계 매핑 기초
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//
//            for(Member m : members) {
//                System.out.println("m = " + m.getUsername());
//            }
//
//            tx.commit();

            //엔티티 매핑
            //비영속
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
            //영속
//            em.persist(member);

//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(10)
//                    .getResultList();
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("=================");

//            Member member = em.find(Member.class, 150L);
//            em.detach(member); //준영속상태(엔티티 단위)
//            em.clear(); //영속성 컨텍스트 초기화
//            em.close(); //영속성 컨텍스트 종료
//            member.setName("ZZZZZ");

//            Member member = new Member(200L, "member200");
//            em.persist(member);
//            em.flush();

//            Member member = new Member();
//            member.setUsername("A");
//            member.setRoleType(RoleType.USER);

//            em.persist(member);

//            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }
}
