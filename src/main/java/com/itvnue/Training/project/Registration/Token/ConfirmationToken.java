package com.itvnue.Training.project.Registration.Token;

import com.itvnue.Training.project.Models.Userr;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {

    @Id
    @Column(name = "id")

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "token")
    private String token;

    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    @Column(nullable = false, name = "expires_at" )
    private LocalDateTime expiresAt;

    @Column(name = "confirmed_at" )
    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(
            nullable = false, insertable = false, updatable = false,
            name = "user_id"
    )
    private Userr userr;

    public Userr getUserr() {
        return userr;
    }

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt, Userr userr) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.userr = userr;
    }
}
