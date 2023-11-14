package br.com.mercadolivre.elexsonmelofutebolapi.Service;

import br.com.mercadolivre.elexsonmelofutebolapi.Model.Partida;
import br.com.mercadolivre.elexsonmelofutebolapi.Repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    public List<Partida> listarPartidas() {
        return partidaRepository.findAll();
    }

    public void atualizarPartida(Long id, Partida novaPartida) {
        Partida partidaExistente = partidaRepository.findById(id).orElse(null);

        if (partidaExistente != null) {
            partidaExistente.setTimeCasa(novaPartida.getTimeFora());
            partidaExistente.setTimeCasa(novaPartida.getTimeFora());
            partidaExistente.setGolsCasa(novaPartida.getGolsFora());
            partidaExistente.setGolsCasa(novaPartida.getGolsFora());
            partidaExistente.setDataEHora(novaPartida.getDataEHora());
            partidaExistente.setEstadio(novaPartida.getEstadio());

            partidaRepository.save(partidaExistente);
        }
    }

    public void deletarPartida(Long id) {
        partidaRepository.deleteById(id);
    }

    public Partida save(Partida partida) {
        return partida;
    }
    public List<Partida> getDrawMatches() {
        return partidaRepository.findByGolsCasaAndGolsFora(0, 0);
    }

    public List<Partida> getMatchesByStadium(String estadio) {
        return partidaRepository.findByEstadio(estadio);
    }

}





        