package model.manyToOneTwoWay;

import javax.persistence.*;

@Entity
@Table(name = "many_to_one_twoway_member")
public class Member1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "Team_id")
    private Team1 team1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team1 getTeam1() {
        return team1;
    }

    // 아래 메소드는 단순 setter라기 보다는 연관 관계 편의 메소드
    public void setTeam1(Team1 team1) {
        if (this.team1 != null) {   // 아직 team1이 저장되어 있는 상태에서 team2가 들어온 것.
            this.team1.getMember1List().remove(this);
        }

        this.team1 = team1;
        team1.getMember1List().add(this);

        /*
            team1.getMember1List().add(member1);
            team1.getMember1List().add(member2);

            setter에서 처리를 해주면서 main에서 위 코드를 생략할 수 있다.
        */
    }
}
