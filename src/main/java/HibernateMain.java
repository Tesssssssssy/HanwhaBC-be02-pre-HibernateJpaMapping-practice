import model.Category;
import model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HibernateMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateproject");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Product product = em.find(Product.class, 1);
        System.out.println(product.getCategory().getType());

        Category category = em.find(Category.class, 1);
        for (Product product1 : category.getProductList()) {
            System.out.println(category.getType() + " " + product1.getName());
        }

        tx.commit();

        /*
            Product product = em.find(Product.class, 1);
            System.out.println(product.getCategory().getType());
            // 1번 상품의 Category 이름 출력


                Category Entity 클래스에는 Product를 저장하는 변수를 만들지 않아서

                Category category = em.find(Category.class, 1);
                category.getProduct().,,,,  -> 불가

                => 이제 양방향 설정 했으므로 가능.


            Category category = em.find(Category.class, 1);

            for (Product product1 : category.getProductList()) {
                System.out.println(category.getType() + " " + product1.getName());
            }


                출력 안 됨.
                양방향으로 설정할 떄에는 주인을 설정해주어야 함.
                이렇게 하면 주인이 누군지 모른다.

        */


        /*
        Product, Category 데이터 넣기

        for (int i = 0; i < 10; i++) {
            Category category = new Category();
            category.setType("카테고리"+(i+1));
            for (int j = 1; j <= 10; j++) {
                Product product = new Product();
                product.setName("상품"+(i*10+j));
                product.setCategory(category);
                em.persist(product);
            }
            em.persist(category);
        }
        */

        /*
        <생성>
        Product product = new Product();
        product.setName("test01");
        em.persist(product);
        */


        /*
        <조회>
        Product product = em.find(Product.class, 1);
        // Product의 id값이 1인 값을 가져와라.
        // JPA에서 데이터 하나 하나는 객체.

        System.out.println(product.getId());
        System.out.println(product.getName());
        */

        /*
        <수정>
        Product product = em.find(Product.class, 1);
        product.setName("test02");
        */

        /*
        <삭제>
        Product product = em.find(Product.class, 1);
        em.remove(product);
        */
    }
}
