package com.isi.secureappspring.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TD_AccountUserEntity")
public class AccountUserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "User_Email")
    private String email;

    @Column(name = "User_Password")
    private String password;

    @Column(name = "User_Status", columnDefinition = "boolean default false")
    private Boolean status;
}
