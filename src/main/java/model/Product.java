package model;

import javax.persistence.*;

@Entity
@Table(name = "Product")
// db에서 원하는 테이블 명으로 설정
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    // db에서 원하는 칼럼명으로 설정
    private String name;

    /*
        @ManyToMany, @ManyToOne, @OneToMany, @OneToOne
        Product가 n이고 Category가 1이므로 @ManyToOne
        SELECT * FROM A LEFT JOIN B ON A.bid = B.id

        @JoinColumn(name = "table명_PK명")
    */
    @ManyToOne
    @JoinColumn(name = "Category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
