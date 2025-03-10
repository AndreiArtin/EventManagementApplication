package com.example.event_management;

import jakarta.persistence.*;

@Entity
public class Utilizator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;
    private String email;
    private String telefon;

    // Getters and Setters
}
