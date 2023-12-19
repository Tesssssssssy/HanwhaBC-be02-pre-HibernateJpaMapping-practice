package model.lazyLoading;

import javax.persistence.*;

@Entity
@Table(name = "many_to_one_lazyloding_member")
public class Member3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Team_id")
    private Team3 team;

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

    public Team3 getTeam() {
        return team;
    }

    public void setTeam(Team3 team) {
        this.team = team;
    }
}
