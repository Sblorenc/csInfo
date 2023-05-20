package pl.coderslab.CsInfo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.CsInfo.entity.Matches;
import pl.coderslab.CsInfo.entity.Team;
import pl.coderslab.CsInfo.service.MatchesService;
import pl.coderslab.CsInfo.service.TeamService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MatchController {

    private TeamService teamService;
    private MatchesService matchesService;


    MatchController(TeamService teamService, MatchesService matchesService) {

        this.teamService = teamService;
        this.matchesService = matchesService;
    }

    @GetMapping(path = "offerForm")
    public String offerForm(Model model) {
        model.addAttribute("teams", teamService.findAll());
        model.addAttribute("maxDate", matchesService.dateMax());
        model.addAttribute("minDate", matchesService.dateMin());
        model.addAttribute("timeMin", matchesService.timeMin());
        return "matches/offerForm";
    }

    @PostMapping(path = "offerForm")
    public String offerForm(@RequestParam String time, @RequestParam LocalDate date, @RequestParam Team team1, @RequestParam Team team2) {
        if (team1==null||team2==null||date==null){
            return "errors/matchOfferError";
        }
        Matches matches = new Matches();
        matches.setTime(time);
        matches.setDate(date);
        List<Team> teamList = new ArrayList<>();
        teamList.add(team1);
        teamList.add(team2);
        matches.setTeamList(teamList);
        matchesService.save(matches);
        return "home/home";
    }

    @GetMapping(path = "matchesHome")
    public String matchesHome() {
        return "matches/matchesHome";
    }

    @GetMapping(path = "matches/delete/{id}")
    public String matchesDelete(@PathVariable Long id) {
        matchesService.deleteById(id);
        return "home/home";
    }
}