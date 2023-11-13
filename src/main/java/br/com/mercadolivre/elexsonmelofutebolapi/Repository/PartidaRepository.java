package br.com.mercadolivre.elexsonmelofutebolapi.Repository;

import br.com.mercadolivre.elexsonmelofutebolapi.Model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {
}
