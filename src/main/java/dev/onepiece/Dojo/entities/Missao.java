package dev.onepiece.Dojo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbmissao")
public class Missao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Classificacao classificacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMissao tipoMissao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusMissao statusMissao;

    @ManyToOne
    @JoinColumn(name = "pirata_id")
    private Pirata pirata;


public enum TipoMissao {
    EXPLORACAO,
    BATALHA_NAVAL,
    SAQUE
}

public enum Classificacao {
    A,
    B,
    C,
    D,
    S
}

public enum StatusMissao {
    CONCLUIDO,
    EM_ANDAMENTO
}

}