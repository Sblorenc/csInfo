package pl.coderslab.CsInfo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.CsInfo.entity.Matches;
import pl.coderslab.CsInfo.entity.Player;
import pl.coderslab.CsInfo.entity.Team;
import pl.coderslab.CsInfo.repository.TeamRepo;
import pl.coderslab.CsInfo.service.TeamService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepo teamRepo;

    @Override
    public Team findById(Long id){
        return teamRepo.findTeamById(id).get();
    }
    @Override
    public List<Team> findAll(){
        return teamRepo.findAll();
    }

    @Override
    public void deleteTeam (Long id){
        teamRepo.deleteTeamById(id);
    }
    @Override
    public  void save (Team team){
        teamRepo.save(team);
    }
    @Override
    public void update(Team team){
        teamRepo.save(team);
    }

}
