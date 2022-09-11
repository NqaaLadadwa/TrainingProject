package com.itvnue.Training.project.Registration;

import com.itvnue.Training.project.Models.RoleName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {

    private final String username;
    private final String password;
    private final String userEmail;
    private final RoleName roleName;

}
