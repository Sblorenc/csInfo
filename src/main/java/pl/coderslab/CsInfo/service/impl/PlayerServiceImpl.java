package pl.coderslab.CsInfo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import pl.coderslab.CsInfo.entity.Player;
import pl.coderslab.CsInfo.entity.Team;
import pl.coderslab.CsInfo.repository.PlayerRepo;
import pl.coderslab.CsInfo.service.PlayerService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
private final PlayerRepo playerRepo;

    @Override
    public Player findById (Long id){
        return playerRepo.findById(id).get();
    }
    @Override
    public List<Player> findAll(){
    return playerRepo.findAll();}
    @Override
    public void deleteById (Long id){
        playerRepo.deletePlayerById(id);
    }
    @Override
    public void save(Player player){
        playerRepo.save(player);
    }
    @Override
    public void update(Player player){
        playerRepo.save(player);
    }
    @Override
    public  List<Player> findByTeam(Team team) {
        return playerRepo.findPlayerByTeam(team);
    }
}
