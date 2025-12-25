package dev.onepiece.Dojo.repositories;

import dev.onepiece.Dojo.entities.Pirata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PirataRepository extends JpaRepository<Pirata, UUID> {
    List<Pirata> findByRacaIgnoreCase(String raca);
}
