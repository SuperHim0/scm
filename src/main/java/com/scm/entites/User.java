package com.scm.entites;

import java.util.ArrayList;

import ch.qos.logback.core.subst.Token.Type;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    private String userId;
    @Column(nullable = false)
    private String UserName;
    @Column(length = 1000)
    private String about;
    private String password;
    @Column(nullable = false,unique = true)
    private String phoneNumber;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(length = 10000)
    private String profilePic;
    //information
    private boolean enable = false;
    private boolean emailVerified = false;
    private boolean phoneVerified = false;

    //CHeckeing how user loging 
    private Providers provider= Providers.SELF; 
    private String providerUserId;

    //adding fild if neeed 
    //mappedby user to tell that only mapped from user not from contact
    //here cascade use to delete the contact if user is deleted
    //fetch tells tells that until call you dont fatch the conatct
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,  
    fetch = FetchType.LAZY,
    orphanRemoval = true)
    private List<Contact> Contacts = new ArrayList<>();

    

}
