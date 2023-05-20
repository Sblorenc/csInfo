package pl.coderslab.CsInfo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.CsInfo.entity.Player;
import pl.coderslab.CsInfo.service.PlayerService;

@Controller
@RequiredArgsConstructor
public class PlayerFormController {

    private final PlayerService playerService;

    @GetMapping(path = "players/form")
    String playerForm(Model model) {
        model.addAttribute("player", new Player());
        return "players/playerForm";
    }

    @PostMapping(path = "players/form")
    String playerForm(@RequestParam String steam, @RequestParam String faceit, @RequestParam String nickname, @RequestParam int age, @RequestParam String position, @RequestParam boolean searching) {
        final Player player = new Player();
        player.setNickname(nickname);
        player.setAge(age);
        player.setPos(position);
        player.setSearch(searching);
        player.setFaceit(faceit);
        player.setSteam(steam);
        playerService.save(player);
        return "redirect:/players";
    }
    @GetMapping (path = "/update/{id}")
    String playerUpdate (@PathVariable Long id, Model model){
        final Player player = playerService.findById(id);
        model.addAttribute("player",player);
    return "players/playerEdit";}

    @PostMapping(path = "/update/{id}")
    String playerUpdate(@PathVariable long id,@RequestParam String nickname, @RequestParam int age, @RequestParam String position, @RequestParam boolean searching, @RequestParam String faceit, @RequestParam String steam){
        Player player = playerService.findById(id);
        player.setNickname(nickname);
        player.setAge(age);
        player.setPos(position);
        player.setSteam(steam);
        player.setFaceit(faceit);
        player.setPos(position);
        player.setSearch(searching);
        playerService.update(player);
    return "redirect:/players";}
}
