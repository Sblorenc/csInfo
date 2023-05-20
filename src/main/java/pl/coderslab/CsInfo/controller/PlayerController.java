package pl.coderslab.CsInfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.CsInfo.entity.Player;
import pl.coderslab.CsInfo.entity.Team;
import pl.coderslab.CsInfo.service.PlayerService;
import pl.coderslab.CsInfo.service.TeamService;


@Controller
public class PlayerController {
    private final PlayerService playerService;


    PlayerController(PlayerService playerService,TeamService teamService){
        this.playerService = playerService;
    }

    @GetMapping(path = "players")
    String playersList(Model model){
        model.addAttribute("playersList",playerService.findAll());
    return "players/playersList";}

    @GetMapping(path = "/players/{id}")
    String playerById(Model model,@PathVariable Long id){
        final Player player = playerService.findById(id);
        if (player.getTeam()!=null){
        Team team = player.getTeam();
        model.addAttribute("team", team);}
        model.addAttribute("player",player);
    return "players/playerById";}

    @GetMapping(path = "/delete/{id}")
    String playerDelete(@PathVariable Long id){
        playerService.deleteById(id);
        return "redirect:/players";
    }
}
