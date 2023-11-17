package br.com.mercadolivre.elexsonmelofutebolapi.Service;

import br.com.mercadolivre.elexsonmelofutebolapi.Model.Partida;
import br.com.mercadolivre.elexsonmelofutebolapi.Repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    public List<Partida> listarPartidas() {
        return partidaRepository.findAll();
    }
    public void atualizarPartida(Long id, Partida novaPartida) {
        Optional<Partida> optionalPartida = partidaRepository.findById(id);

        if (optionalPartida.isPresent()) {
            Partida partida = optionalPartida.get();
            partida.setClubeMandante(novaPartida.getClubeMandante());
            partida.setClubeVisitante(novaPartida.getClubeVisitante());
            partida.setResultadoMandante(novaPartida.getResultadoMandante());
            partida.setResultadoVisitante(novaPartida.getResultadoVisitante());
            partida.setResultado(novaPartida.getResultado());
            partida.setDataHora(novaPartida.getDataHora());
            partida.setEstadio(novaPartida.getEstadio());

            partidaRepository.save(partida);
        }
    }
    public void deletarPartida(Long id) {
        partidaRepository.deleteById(id);


    }

    public Partida save(Partida partida) {
        return partida;
    }

    public List<Partida> buscarPorEstadio(String estadio) {
        return partidaRepository.findByEstadio(estadio);
    }

    public List<Partida> buscarPorSemGols() {
        return partidaRepository.buscarPorSemGols();
    }

    public List<Partida> findGoleada(int diferenca) {
        return partidaRepository.findByGoleada(diferenca);
    }

    public List<Partida> buscarPartidasPorClube(String nomeClube, String tipo) {
        if ("mandante".equalsIgnoreCase(tipo)) {
            return partidaRepository.findByClubeMandante(nomeClube);
        } else if ("visitante".equalsIgnoreCase(tipo)) {
            return partidaRepository.findByClubeVisitante(nomeClube);
        } else {
            return partidaRepository.findByClubeMandanteOrClubeVisitante(nomeClube, nomeClube);
        }
    }

    public void deletarPartida(String clubeMandante, String clubeVisitante, LocalDateTime dateTime) {
    }
}










        