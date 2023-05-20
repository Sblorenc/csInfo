package pl.coderslab.CsInfo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.CsInfo.entity.User;
import pl.coderslab.CsInfo.repository.UserRepo;

@Controller
@RequiredArgsConstructor
public class RegisterController {
    private final UserRepo userRepo;

    @GetMapping("/register")
    public String register(){
        return "home/registration";
    }
    @PostMapping("/register")
    public String registered(@RequestParam String username, @RequestParam String email, @RequestParam String password){
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        userRepo.save(user);
    return "redirect:/home";}
}
