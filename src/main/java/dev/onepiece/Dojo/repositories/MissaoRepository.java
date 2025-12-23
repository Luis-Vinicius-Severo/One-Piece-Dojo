package dev.onepiece.Dojo.repositories;

import dev.onepiece.Dojo.entities.Missao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MissaoRepository extends JpaRepository<Missao, UUID> {
}
