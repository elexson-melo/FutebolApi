package br.com.mercadolivre.elexsonmelofutebolapi.dto;

import br.com.mercadolivre.elexsonmelofutebolapi.Model.PartidaModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PartidaDto {
    ResponseEntity<List<PartidaModel>> listarPartidas();

    ResponseEntity obterPartidaPorId(Long id);

    ResponseEntity cadastrarPartida(PartidaModel partidaModel);

    ResponseEntity atualizarPartida(Long id, ResponseEntity partida);

    void deletarPartida(Long id);

}
