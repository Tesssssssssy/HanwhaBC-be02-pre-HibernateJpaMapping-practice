package model.manyToOneTwoWay;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateproject");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Team1 team1 = new Team1();
        team1.setTeamname("1팀");
        em.persist(team1);

        Team1 team2 = new Team1();
        team2.setTeamname("2팀");
        em.persist(team2);

        // 멤버에게는 팀을 지정했지만 팀에게는 멤버를 지정하지 않았을 때
        Member1 member1 = new Member1();
        member1.setUsername("1유저");
        member1.setTeam1(team1);
        member1.setTeam1(team2);
        /*
            team이 바뀌긴 한데 team1에 있던 유저는 빼줘야 함.
            Member1 class의 setTeam에서 처리해준다.
        */
        em.persist(member1);

        Member1 member2 = new Member1();
        member2.setUsername("2유저");
        member2.setTeam1(team1);
        em.persist(member2);

        /*
        team1.getMember1List().add(member1);
        team1.getMember1List().add(member2);
        */

        /*
            나중에는 테이블 2개 사이만 관계가 있을 뿐 아니라
            다른 테이블과도 관계가 있을 수 있어 매우 헷갈리는 일이 생길 수 있다.
        */

        tx.commit();
    }
}
