package pl.coderslab.CsInfo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.CsInfo.entity.Role;
import pl.coderslab.CsInfo.entity.User;
import pl.coderslab.CsInfo.repository.UserRepo;
import pl.coderslab.CsInfo.service.RoleService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RegisterController {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    private final RoleService roleService;

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute(new User());
        return "home/registration";
    }
    @PostMapping("/register")
    public String registered(@RequestParam String username, @RequestParam String email, @RequestParam String password){
        User user = new User();
        Role role = roleService.findByName("ADMIN");
        List<Role>roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        userRepo.save(user);
    return "redirect:/home";}
}
