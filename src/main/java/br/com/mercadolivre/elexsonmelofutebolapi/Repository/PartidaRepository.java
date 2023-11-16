package br.com.mercadolivre.elexsonmelofutebolapi.Repository;

import br.com.mercadolivre.elexsonmelofutebolapi.Model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {
    @Query("SELECT p FROM Partida p WHERE ABS(p.resultadoMandante - p.resultadoVisitante) >= :diferenca")
    List<Partida> findByGoleada(int diferenca);

    @Query("SELECT p FROM Partida p WHERE p.resultadoMandante = 0 AND p.resultadoVisitante = 0")
    List<Partida> buscarPorSemGols();

    List<Partida> findByEstadio(String estadio);

    List<Partida> findByClubeMandante(String clubeMandante);

    List<Partida> findByClubeVisitante(String clubeVisitante);

    List<Partida> findByClubeMandanteOrClubeVisitante(String clubeMandante, String clubeVisitante);

}

