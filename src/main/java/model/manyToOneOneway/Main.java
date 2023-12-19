package model.manyToOneOneway;

import model.manyToOneTwoWay.Member1;
import model.manyToOneTwoWay.Team1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateproject");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Team team = new Team();
        team.setTeamname("1팀");
        em.persist(team);

        // 멤버에게는 팀을 지정했지만 팀에게는 멤버를 지정하지 않았을 때
        Member member = new Member();
        member.setUsername("1유저");
        member.setTeam(team);
        em.persist(member);

        Member member2 = new Member();
        member2.setUsername("2유저");
        member.setTeam(team);
        em.persist(member2);

        tx.commit();
    }
}
