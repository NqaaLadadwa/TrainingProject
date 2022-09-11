package com.itvnue.Training.project.Service;

import com.itvnue.Training.project.Controller.dto.UserrDto;
import com.itvnue.Training.project.Models.RoleName;
import com.itvnue.Training.project.Models.Userr;
import com.itvnue.Training.project.Registration.Token.ConfirmationToken;
import com.itvnue.Training.project.Registration.Token.ConfirmationTokenService;
import com.itvnue.Training.project.Repository.UserrRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class UserrService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "User with email %s not found";
    @Autowired
    private final UserrRepository userrRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return (UserDetails) userrRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, userEmail)));
    }

    public List<Userr> getUsers() {
        return userrRepository.findAll();
    }

    @PostMapping("all/")
    public void addNewUser(UserrDto userrDto) {
        Userr userr = new Userr();
        userr.setId(userrDto.getId());
        userr.setUsername(userrDto.getUsername());
        userr.setPassword(userrDto.getPassword());
        userr.setUserEmail(userrDto.getUserEmail());
        userr.setRoleName(userrDto.getRoleName());

        userrRepository.save(userr);
    }

    public void deleteUser(int userId) {
        boolean exists =  userrRepository.existsById(userId);
        if (!exists){
            throw new IllegalStateException("user with id" + userId + "does not exist");
        }
        userrRepository.deleteById(userId);
    }

    public Userr updateUser(Userr userr){
        Optional<Userr> userrOptional = userrRepository.findById(userr.getId());
        //Check if the item is not existed (if not, add item)
        if (!userrOptional.isPresent()) {
            return userrRepository.save(userr);

        }
        Userr userr1 = userrOptional.get();
        userr1.setUsername(userr.getUsername());
        userr1.setUserEmail(userr.getUserEmail());
        userr1.setPassword(userr.getPassword());
        userr1.setRoleName(userr.getRoleName());


        return userrRepository.save(userr1);

    }
    public String signUp (Userr userr){
        boolean userExists = userrRepository.findByUserEmail(userr.getUserEmail()).isPresent();
        if (userExists){
            throw new IllegalStateException("email already taken");
        }
       String encodePassword = bCryptPasswordEncoder.encode(userr.getPassword());
        userr.setPassword(encodePassword);
        userrRepository.save(userr);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(

                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                userr
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }
    public int enableUserr(String userEmail) {
        return userrRepository.enableUserr(userEmail);
    }
}
