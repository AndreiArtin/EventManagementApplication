package com.example.event_management;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Firma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;

    @OneToMany(mappedBy = "firma")
    private List<Programare> programari;


}
