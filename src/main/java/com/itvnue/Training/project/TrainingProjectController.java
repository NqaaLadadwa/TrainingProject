package com.itvnue.Training.project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainingProjectController {

    @RequestMapping("/hello")
    public String index(){
        return "Hello";
    }

   /* @Autowired
    private UserrRepository userrRepository;
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Userr());

        return "register_form";
    }

     @PostMapping("/register")
    public String processRegister(Userr userr) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userr.getPassword());
        userr.setPassword(encodedPassword);

        userrRepository.save(userr);

        return "register_success";
    }*/
}
