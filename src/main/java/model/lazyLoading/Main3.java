package model.lazyLoading;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateproject");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Member3 member3 = em.find(Member3.class, 1);
        System.out.println(member3.getId());
        System.out.println(member3.getUsername());
        System.out.println(member3.getTeam().getTeamname());

        tx.commit();

        /*
        for (int i = 0; i < 10; i++) {
            Team3 team3 = new Team3();
            team3.setTeamname("팀"+(i+1));
            for (int j = 1; j <= 10; j++) {
                Member3 member3 = new Member3();
                member3.setUsername("멤버"+(i*10+j));
                member3.setTeam(team3);
                em.persist(member3);
            }
            em.persist(team3);
        }
        */



    }
}
