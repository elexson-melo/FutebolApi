package br.com.mercadolivre.elexsonmelofutebolapi.Service;

import br.com.mercadolivre.elexsonmelofutebolapi.Model.Partida;
import br.com.mercadolivre.elexsonmelofutebolapi.Repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    public List<Partida> listarPartidas() {
        return partidaRepository.findAll();
    }

    public Partida cadastrarPartidas(Partida partida) {
        return partidaRepository.save(partida);
    }

    public void atualizarPartida(Long id, Partida novaPartida) {
        Partida partidaExistente = partidaRepository.findById(id).orElse(null);

        if (partidaExistente != null) {
            partidaExistente.setHomeTeam(novaPartida.getHomeTeam());
            partidaExistente.setAwayTeam(novaPartida.getAwayTeam());
            partidaExistente.setResult(novaPartida.getResult());
            partidaExistente.setDateAndTime(novaPartida.getDateAndTime());
            partidaExistente.setStadium(novaPartida.getStadium());

            partidaRepository.save(partidaExistente);
        }
    }
    public void deletarPartida(Long id) {
        partidaRepository.deleteById(id);
    }

    public Partida save(Partida partida) {
        return partida;
    }
}