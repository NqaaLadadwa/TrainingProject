package com.itvnue.Training.project.Registration;


import com.itvnue.Training.project.Models.RoleName;
import com.itvnue.Training.project.Models.Userr;
import com.itvnue.Training.project.Registration.Token.ConfirmationToken;
import com.itvnue.Training.project.Registration.Token.ConfirmationTokenService;
import com.itvnue.Training.project.Service.UserrService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Component
public class RegistrationService {

    private final UserrService userrService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;


    public String register(RegistrationRequest request) {


        boolean isValidEmail = emailValidator.test(request.getUserEmail());
        if (!isValidEmail){
            throw new IllegalStateException("email not valid");
        }

        return userrService.signUp(
                new Userr(
                        request.getUsername(),
                        request.getUserEmail(),
                        request.getPassword(),
                        request.getRoleName()

                )
        );


    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        userrService.enableUserr(confirmationToken.getUserr().getUserEmail());
        return "confirmed";
    }


}
