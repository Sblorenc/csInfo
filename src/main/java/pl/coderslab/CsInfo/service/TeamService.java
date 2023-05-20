package pl.coderslab.CsInfo.service;

import pl.coderslab.CsInfo.entity.Matches;
import pl.coderslab.CsInfo.entity.Player;
import pl.coderslab.CsInfo.entity.Team;

import java.time.LocalDate;
import java.util.List;

public interface TeamService {
    List<Team> findAll();

    Team findById(Long id);

    void deleteTeam(Long id);

    void save (Team team);

    void update (Team team);

}
