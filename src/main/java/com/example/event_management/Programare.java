package com.example.event_management;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "programare")
public class Programare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nume", nullable = false)
    private String nume;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "companie")
    private String companie;

    @Column(name = "detalii_eveniment", nullable = false)
    private String detaliiEveniment;

    @Column(name = "locatie_eveniment", nullable = false)
    private String locatieEveniment;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "firma_id", nullable = false)
    private Firma firma;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "eveniment_id", nullable = false)
    private Eveniment eveniment;

    public Programare() {}

    public Programare(String nume, String email, String telefon, String companie, String detaliiEveniment, String locatieEveniment, Firma firma, Eveniment eveniment) {
        this.nume = nume;
        this.email = email;
        this.telefon = telefon;
        this.companie = companie;
        this.detaliiEveniment = detaliiEveniment;
        this.locatieEveniment = locatieEveniment;
        this.firma = firma;
        this.eveniment = eveniment;
    }
}
