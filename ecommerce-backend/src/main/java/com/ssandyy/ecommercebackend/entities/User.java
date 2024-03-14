package com.ssandyy.ecommercebackend.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    @Column (length = 5000)
    private String address;
    private UserRole role;
    @Lob
    @Column(columnDefinition = "Longblob")
    private byte[] profilepicture;
    private LocalDateTime deleted;
}
