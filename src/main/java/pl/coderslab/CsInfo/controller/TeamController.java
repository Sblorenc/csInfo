package pl.coderslab.CsInfo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.CsInfo.entity.Player;
import pl.coderslab.CsInfo.service.MatchesService;
import pl.coderslab.CsInfo.service.PlayerService;
import pl.coderslab.CsInfo.service.TeamService;

import java.util.List;


@Controller
public class TeamController {

    private final TeamService teamService;
    private final MatchesService matchesService;
    private final PlayerService playerService;

    public TeamController(TeamService teamService, PlayerService playerService,MatchesService matchesService){

        this.teamService = teamService;
        this.playerService = playerService;
        this.matchesService = matchesService;
    }

    @GetMapping("teams")
    public String findAll(Model model){
        model.addAttribute("teamsList",teamService.findAll());
        return "teams/teamsList";
    }
    @GetMapping("team/{id}")
    public String teamById(@PathVariable Long id, Model model){
        model.addAttribute("matches", matchesService.findByTeams(teamService.findById(id)));
        model.addAttribute("players",playerService.findByTeam(teamService.findById(id)));
        model.addAttribute("team",teamService.findById(id));
        return "teams/teamById";
    }
    @GetMapping("team/delete/{id}")
    public String teamDelete(@PathVariable Long id){
        List<Player> playerList = playerService.findByTeam(teamService.findById(id));
        for (Player player: playerList) {
            player.setSearch(true);
            player.setTeam(null);
        }
        teamService.deleteTeam(id);
    return "redirect:/teams";
    }
}
