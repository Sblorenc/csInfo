package pl.coderslab.CsInfo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;

import java.time.LocalDate;
import java.util.ArrayList;


import java.util.List;


@Entity
@Getter
@Setter
@ToString
public class Matches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String time;

    private LocalDate date;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
          name = "team_matches",
          joinColumns = @JoinColumn(name = "team_id"),
          inverseJoinColumns = @JoinColumn(name = "match_id"))

    List<Team> teamList = new ArrayList<>();

}
