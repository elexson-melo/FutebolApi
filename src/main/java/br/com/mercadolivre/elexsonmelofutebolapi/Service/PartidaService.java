package br.com.mercadolivre.elexsonmelofutebolapi.Service;

import br.com.mercadolivre.elexsonmelofutebolapi.Model.PartidaModel;
import br.com.mercadolivre.elexsonmelofutebolapi.Repository.PartidaRepository;
import br.com.mercadolivre.elexsonmelofutebolapi.dto.PartidaDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    public List<PartidaModel> buscarTodasPartidas() {
        return partidaRepository.findAll();
    }
    public Optional<PartidaModel> obterPartidaPorId(Long id) {
        return partidaRepository.findById(id);
    }
    public void deletarPartida(Long id) {
        partidaRepository.deleteById(id);
    }
    public PartidaModel atualizarPartida(Long id, PartidaDto partidaDto) {
        Optional<PartidaModel> optionalPartidaModel = partidaRepository.findById(id);
        if (optionalPartidaModel.isPresent()) {
            PartidaModel partidaModel = optionalPartidaModel.get();
            BeanUtils.copyProperties(partidaDto, partidaModel);
            return partidaRepository.save(partidaModel);
        } else {
            return null;
        }
    }
    public PartidaModel cadastrarPartida(PartidaDto partidaDto) {
        PartidaModel novapartidaModel = new PartidaModel();
        BeanUtils.copyProperties(partidaDto,novapartidaModel);
        return partidaRepository.save(novapartidaModel);
    }

    private boolean isIntervaloRespeitado(String clube, LocalDateTime dataHora) {
        List<PartidaModel> partidasClubeMandante = partidaRepository.findByClubeMandanteAndDataHoraAfter(clube, dataHora);
        List<PartidaModel> partidasClubeVisitante = partidaRepository.findByClubeVisitanteAndDataHoraAfter(clube, dataHora);

        return partidasClubeMandante.isEmpty() && partidasClubeVisitante.isEmpty();
    }

    // Buscas:

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
    //Metodo para Validar Partidas sem resultado, ou Resultado Negativo, e Partidas com Data e Horario Futuras:

    /*private void validarPartida(PartidaModel partidaModel) {
        if (partidaModel.getResultadoMandante() < 0 || partidaModel.getResultadoVisitante() < 0) {
            throw new IllegalArgumentException("O resultado não pode ser negativo.");
        }

        if (partidaModel.getDataHora().isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("A data e hora da partida não podem estar no futuro.");
        }
    }*/

    public void deletarPartida(String clubeMandante, String clubeVisitante, LocalDateTime dateTime) {
    }
}












        