package pl.coderslab.CsInfo.service;

import pl.coderslab.CsInfo.entity.Player;
import pl.coderslab.CsInfo.entity.Team;


import java.util.List;

public interface PlayerService {
    List<Player> findAll();
    Player findById(Long id);

    void deleteById (Long id);

    void save(Player player);

    void update(Player player);

    List<Player> findByTeam(Team team);
}
