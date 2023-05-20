package pl.coderslab.CsInfo.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.CsInfo.entity.Player;
import pl.coderslab.CsInfo.entity.Team;
import pl.coderslab.CsInfo.service.PlayerService;
import pl.coderslab.CsInfo.service.TeamService;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TeamFormController {

   private final TeamService teamService;
   private final PlayerService playerService;

   @GetMapping("team/form")
    public String teamForm(Model model){
       model.addAttribute("team", new Team());
       model.addAttribute("players", playerService.findAll());
       return "teams/teamForm";
   }
   @PostMapping("team/form")
    public String teamAddForm(@RequestParam String name, @RequestParam boolean searching, @RequestParam String esea, @RequestParam List<Player> players)  {
       Team team = new Team();
       team.setName(name);
       team.setSearching(searching);
       team.setEsea(esea);
       team.setPlayerList(players);
       for (Player player: players){
          player.setTeam(team);
          player.setSearch(false);
       }
       teamService.save(team);
       return "redirect:/teams";
   }
   @GetMapping("teams/update/{id}")
   public String teamUpdateForm(@PathVariable Long id, Model model){
      final Team team = teamService.findById(id);
      model.addAttribute("team",team);
      return "teams/teamEdit";
   }
   @PostMapping(path="teams/update/{id}")
   public String teamUpdateForm(@PathVariable Long id, @RequestParam String name, @RequestParam String esea, @RequestParam boolean searching){
      Team team = teamService.findById(id);
      team.setName(name);
      team.setEsea(esea);
      team.setSearching(searching);
      teamService.update(team);
      return "redirect:/teams";
   }
}
