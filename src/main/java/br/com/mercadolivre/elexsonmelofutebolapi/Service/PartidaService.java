package br.com.mercadolivre.elexsonmelofutebolapi.Service;

import br.com.mercadolivre.elexsonmelofutebolapi.Model.PartidaModel;
import br.com.mercadolivre.elexsonmelofutebolapi.Repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    public List<PartidaModel> listarPartidas() {
        return partidaRepository.findAll();
    }
    public PartidaModel cadastrarPartida(PartidaModel partidaModel) {
        if (!isIntervaloRespeitado(partidaModel.getClubeMandante(), partidaModel.getDataHora()) ||
                !isIntervaloRespeitado(partidaModel.getClubeVisitante(), partidaModel.getDataHora())) {
            throw new RuntimeException("Intervalo de 48 horas não respeitado para pelo menos um dos clubes.");
        }
        return partidaRepository.save(partidaModel);
    }
    private boolean isIntervaloRespeitado(String clube, LocalDateTime dataHora) {
        List<PartidaModel> partidasClubeMandante = partidaRepository.findByClubeMandanteAndDataHoraAfter(clube, dataHora);
        List<PartidaModel> partidasClubeVisitante = partidaRepository.findByClubeVisitanteAndDataHoraAfter(clube, dataHora);

        return partidasClubeMandante.isEmpty() && partidasClubeVisitante.isEmpty();
    }

    public void atualizarPartida(Long id, PartidaModel novaPartidaModel) {
        Optional<PartidaModel> optionalPartida = partidaRepository.findById(id);
        if (optionalPartida.isPresent()) {
            PartidaModel partidaModel = optionalPartida.get();
            partidaModel.setClubeMandante(novaPartidaModel.getClubeMandante());
            partidaModel.setClubeVisitante(novaPartidaModel.getClubeVisitante());
            partidaModel.setResultadoMandante(novaPartidaModel.getResultadoMandante());
            partidaModel.setResultadoVisitante(novaPartidaModel.getResultadoVisitante());
            partidaModel.setResultado(novaPartidaModel.getResultado());
            partidaModel.setDataHora(novaPartidaModel.getDataHora());
            partidaModel.setEstadio(novaPartidaModel.getEstadio());

            partidaRepository.save(partidaModel);
        }
    }
    public void deletarPartida(Long id) {
        partidaRepository.deleteById(id);

    }

    public List<PartidaModel> buscarPorEstadio(String estadio) {
        return partidaRepository.findByEstadio(estadio);
    }

    public List<PartidaModel> buscarPorSemGols() {
        return partidaRepository.findBySemGols();
    }

    public List<PartidaModel> buscarPorGoleada(int diferenca) {
        return partidaRepository.findByGoleada(diferenca);
    }

    public List<PartidaModel> buscarPartidasPorClube(String nomeClube, String tipo) {
        if ("mandante".equalsIgnoreCase(tipo)) {
            return partidaRepository.findByClubeMandante(nomeClube);
        } else if ("visitante".equalsIgnoreCase(tipo)) {
            return partidaRepository.findByClubeVisitante(nomeClube);
        } else {
            return partidaRepository.findByClubeMandanteOrClubeVisitante(nomeClube, nomeClube);
        }
    }
    public PartidaModel save(PartidaModel partidaModel) {
        return partidaModel;
    }

    public Optional<PartidaModel> obterPartidaPorId(Long id) {
        return partidaRepository.findById(id);
    }

    //Metodo para Validar Partidas sem resultado, ou Resultado Negativo, e Partidas com Data e Horario Futuras:

    /*private void validarPartida(PartidaRepository partidaRepository) {
        if (partidaRepository.getResultado() < 0) {
            throw new IllegalArgumentException("O resultado não pode ser negativo.");
        }

        if (partidaRepository.getDataHora().isAfter(Instant.from(LocalDateTime.now()))) {
            throw new IllegalArgumentException("A data e hora da partida não podem estar no futuro.");
        }
    }*/

    public void deletarPartida(String clubeMandante, String clubeVisitante, LocalDateTime dateTime) {
    }
}












        