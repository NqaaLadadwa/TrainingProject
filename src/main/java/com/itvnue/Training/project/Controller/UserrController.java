package com.itvnue.Training.project.Controller;

import com.itvnue.Training.project.Controller.dto.UserrDto;
import com.itvnue.Training.project.Models.RoleName;
import com.itvnue.Training.project.Models.Userr;
import com.itvnue.Training.project.Repository.UserrRepository;
import com.itvnue.Training.project.Service.UserrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserrController {

    private final UserrService userrService;
    @Autowired
    private UserrRepository userrRepository;

    @Autowired
    public UserrController(UserrService userrService) {
        this.userrService = userrService;
    }

    @GetMapping
    public List<Userr> getUsers() {
        return userrService.getUsers();
    }

    @PostMapping
    public void addNewUser(@RequestBody UserrDto userrDto) {
        userrService.addNewUser(userrDto);
    }

    @DeleteMapping(path = "{userrId}")
    public void deleteUser(@PathVariable("userrId") int userrId) {
        userrService.deleteUser(userrId);
    }

    @PutMapping(path = "{userrId}")
    public void updateUser(@RequestBody Userr userr) {

        userrService.updateUser(userr);

    }

}
