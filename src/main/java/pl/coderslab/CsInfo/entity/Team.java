package pl.coderslab.CsInfo.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String esea;

    private boolean searching;

    @OneToMany(mappedBy = "team")
    private List<Player>playerList = new ArrayList<>();


}
