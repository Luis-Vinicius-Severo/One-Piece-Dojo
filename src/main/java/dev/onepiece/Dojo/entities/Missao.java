package dev.onepiece.Dojo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbmissao")
public class Missao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String classificacao;
    @Column(nullable = false)
    private String tipoMissao;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusMissao status;

    @ManyToOne
    @JoinColumn(name = "pirata_id")
    private Pirata pirata;
}
