package dev.onepiece.Dojo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Table(name = "tbpirata")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pirata {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tripulacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Raca raca;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPirata status;

    @OneToMany(mappedBy = "pirata")
    private List<Missao> missoes = new ArrayList<>() ;


public enum StatusPirata {
    ATIVO,
    CAPTURADO
 }

public enum Raca {
    Humano,
    Ciborgue,
    Mink,
    Anão,
    Tritão
}

}