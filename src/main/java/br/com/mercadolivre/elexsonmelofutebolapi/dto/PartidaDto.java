package br.com.mercadolivre.elexsonmelofutebolapi.dto;

import br.com.mercadolivre.elexsonmelofutebolapi.Model.Partida;
import br.com.mercadolivre.elexsonmelofutebolapi.Service.PartidaService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PartidaDto {
    ResponseEntity<List<Partida>> listarPartidas();

    ResponseEntity obterPartidaPorId(Long id);

    ResponseEntity cadastrarPartida(Partida partida);

    ResponseEntity atualizarPartida(Long id, ResponseEntity partida);

    void deletarPartida(Long id);

}
