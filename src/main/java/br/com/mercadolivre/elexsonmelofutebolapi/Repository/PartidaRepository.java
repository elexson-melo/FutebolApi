package br.com.mercadolivre.elexsonmelofutebolapi.Repository;

import br.com.mercadolivre.elexsonmelofutebolapi.Model.Partida;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {
    @Query("SELECT p FROM Partida p WHERE ABS(p.golsCasa - p.golsCasa) >= :diferenca")
    List<Partida> findByGoleada(int diferenca);

    @Query("SELECT p FROM Partida p WHERE p.golsCasa = 0 AND p.golsFora = 0")
    List<Partida> findBySemGols();

    List<Partida> findByGolsCasaAndGolsFora(int g, int i1);

    List<Partida> findByEstadio(String estadio);
}

