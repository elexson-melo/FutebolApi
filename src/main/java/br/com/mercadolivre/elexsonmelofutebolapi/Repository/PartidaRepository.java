package br.com.mercadolivre.elexsonmelofutebolapi.Repository;

import br.com.mercadolivre.elexsonmelofutebolapi.Model.PartidaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PartidaRepository extends JpaRepository<PartidaModel, Long> {
    @Query("SELECT p FROM PartidaModel p WHERE ABS(p.resultadoMandante - p.resultadoVisitante) >= :diferenca")
    List<PartidaModel> findByGoleada(int diferenca);

    @Query("SELECT p FROM PartidaModel p WHERE p.resultadoMandante = 0 AND p.resultadoVisitante = 0")
    List<PartidaModel> buscarPorSemGols();

    List<PartidaModel> findByEstadio(String estadio);

    List<PartidaModel> findByClubeMandante(String clubeMandante);

    List<PartidaModel> findByClubeVisitante(String clubeVisitante);

    List<PartidaModel> findByClubeMandanteOrClubeVisitante(String clubeMandante, String clubeVisitante);

    List<PartidaModel> findByClubeMandanteAndDataHoraAfter(String clubeMandante, LocalDateTime dataHora);

    List<PartidaModel> findByClubeVisitanteAndDataHoraAfter(String clubeVisitante, LocalDateTime dataHora);

    static List<PartidaModel> obterPartidaPorId(int id) {
        return null;
    }
}

