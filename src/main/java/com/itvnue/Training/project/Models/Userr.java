package com.itvnue.Training.project.Models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity

@Table(name = "userr")
public class Userr implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private int id;


    @Column(name = "username")
    private String username;


    @Column(name = "passwordd")
    private String password;

    @Column(name = "user_email", unique = true)
    private String userEmail;

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    // Define the column as enum
    private RoleName roleName;

    private Boolean locked = false;
    private Boolean enabled = false;


    public Userr(String username,
                 String password,
                 String userEmail,
                 RoleName roleName) {
        this.username = username;
        this.password = password;
        this.userEmail = userEmail;
        this.roleName = roleName;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(roleName.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userEmail;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    //Relationships
    @OneToMany(mappedBy = "parentUser", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    //@JoinColumn(name = "invoice_id", referencedColumnName = "id")
    private List<Invoice> invoices;

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        return "Userr{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", roleName=" + roleName +
                ", invoices=" + invoices +
                '}';
    }


}
