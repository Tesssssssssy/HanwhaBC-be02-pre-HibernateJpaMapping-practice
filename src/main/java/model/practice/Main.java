package model.practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateproject");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        List<Order> list = new ArrayList<>();
        list.add(em.find(Order.class, 1));
        list.add(em.find(Order.class, 2));
        list.add(em.find(Order.class, 3));


        User user = em.find(User.class, 1);
        user.setOrderList(list);


        System.out.println("email: " + user.getEmail());
        System.out.println("name: " + user.getName());
        System.out.println("password: " + user.getPassword());
        System.out.println("grade: " + user.getGrade().getGrade());
        System.out.print("order: ");
        for (Order order : user.getOrderList()) {
            System.out.print(order.getProductName() + " ");
        }
        System.out.println();


        /*
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setProductName("주문"+(i+1));

            Grade grade = new Grade();
            grade.setGrade("등급"+(i+1));

            for (int j = 1; j <= 10; j++) {
                User user = new User();
                user.setEmail("user"+(i*10+j)+"@naver.com");
                user.setName("user"+(i*10+j));
                user.setPassword("qwer1234");
                user.setGrade(grade);
                em.persist(user);
            }
            em.persist(order);
            em.persist(grade);
        }
        */



        tx.commit();
    }
}
