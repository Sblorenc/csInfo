package pl.coderslab.CsInfo.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private int age;

    private String pos;

    private boolean search;

    private String steam;

    private String faceit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id",
    nullable = true)
    private Team team;
}
