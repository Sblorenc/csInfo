package pl.coderslab.CsInfo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.CsInfo.entity.Matches;
import pl.coderslab.CsInfo.entity.Team;
import pl.coderslab.CsInfo.repository.MatchesRepo;
import pl.coderslab.CsInfo.service.MatchesService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MatchesServiceImpl implements MatchesService {

    private final MatchesRepo matchesRepo;

    @Override
    public List<Matches> findAll() {
        return matchesRepo.findAll();
    }

    @Override
    public void save(Matches matches) {
        matchesRepo.save(matches);
    }


    @Override
    public LocalDate dateMax() {
        LocalDate localDate = LocalDate.now().plusDays(7);
        return localDate;
    }

    @Override
    public LocalDate dateMin() {
        LocalDate localDate = LocalDate.now();
        return localDate;
    }

    @Override
    public String timeMin() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String timeStr = dateTimeFormatter.format(localTime);
        return timeStr;
    }

    @Override
    public List<Matches> findByTeams(Team team) {
        return matchesRepo.findMatchesByTeamList(team);
    }

    @Override
    public void deleteById(Long id) {
         matchesRepo.deleteMatchesById(id);
    }
}