package com.example.event_management;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Eveniment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;

    @ManyToMany(mappedBy = "evenimente")
    private List<Locatie> locatii;

    @OneToMany(mappedBy = "eveniment")
    private List<Programare> programari;


}
