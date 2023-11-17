package br.com.mercadolivre.elexsonmelofutebolapi.Service;

import br.com.mercadolivre.elexsonmelofutebolapi.Model.Partida;
import br.com.mercadolivre.elexsonmelofutebolapi.Repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    public List<Partida> listarPartidas() {
        return partidaRepository.findAll();
    }
    public Partida cadastrarPartida(Partida partida) {
        if (!isIntervaloRespeitado(partida.getClubeMandante(), partida.getDataHora()) ||
                !isIntervaloRespeitado(partida.getClubeVisitante(), partida.getDataHora())) {
            throw new RuntimeException("Intervalo de 48 horas não respeitado para pelo menos um dos clubes.");
        }
        return partidaRepository.save(partida);
    }
    private boolean isIntervaloRespeitado(String clube, Date dataHora) {
        List<Partida> partidasClubeMandante = partidaRepository.findByClubeMandanteAndDataHoraAfter(clube, dataHora);
        List<Partida> partidasClubeVisitante = partidaRepository.findByClubeVisitanteAndDataHoraAfter(clube, dataHora);

        return partidasClubeMandante.isEmpty() && partidasClubeVisitante.isEmpty();
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

   /*private void validarPartida(Partida partida) {
        if (partida.getDataHora().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("A data e hora da partida não podem estar no passado.");
        }
        if (StringUtils.isAnyBlank(partida.getClubeMandante(), partida.getClubeVisitante(), partida.getEstadio())) {
            throw new IllegalArgumentException("O nome dos clubes, o estádio, a data e a hora da partida são obrigatórios.");
        }
        if (partida.getResultadoMandante() < 0 || partida.getResultadoVisitante() < 0) {
            throw new IllegalArgumentException("Os resultados não podem ser negativos.");
        }
    }
}*/
    //Tentativa de Método de Validacao por Horário:

       /* private void validarDataHoraPartida(LocalDateTime dataHora) {
        LocalDateTime minDateTime = LocalDateTime.now().withHour(8).withMinute(0);
        LocalDateTime maxDateTime = LocalDateTime.now().withHour(22).withMinute(0);

        if (dataHora.isBefore(minDateTime) || dataHora.isAfter(maxDateTime)) {
            throw new RuntimeException("Horário da Partida Inválido");
        }
    }
}*/

    public List<Partida> obterPartidaPorId(int id) {
        return PartidaRepository.obterPartidaPorId(id);
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

    public Partida save(Partida partida) {
        return partida;
    }
}










        