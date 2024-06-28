package ba.smoki.taifun.user.mvc;

import ba.smoki.taifun.user.repository.User;
import ba.smoki.taifun.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    //http://localhost:8080/saveUser
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        System.out.println(user);
        try {
            String plainPassword = user.getPassword();
            String hashedPassword = passwordEncoder.encode(plainPassword);
            user.setPassword(hashedPassword);
            user.setRole("USER");
            userRepository.save(user);
            return "redirect:/login";
        } catch (Exception e) {
            return "redirect:/register?error=Bad registration";
        }
    }
}
