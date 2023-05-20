package pl.coderslab.CsInfo.service;

import pl.coderslab.CsInfo.entity.Matches;
import pl.coderslab.CsInfo.entity.Team;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface MatchesService {

    List<Matches>findAll();

    void save(Matches matches);

    LocalDate dateMax();

    LocalDate dateMin();

    String timeMin();

    List<Matches>findByTeams(Team team);

    void deleteById(Long id);







}
