package br.com.mercadolivre.elexsonmelofutebolapi.Controller;

import br.com.mercadolivre.elexsonmelofutebolapi.Model.PartidaModel;
import br.com.mercadolivre.elexsonmelofutebolapi.Service.PartidaService;
import br.com.mercadolivre.elexsonmelofutebolapi.dto.PartidaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Partida")
public class PartidaController {

    @Autowired
    private PartidaService partidaService;


    @GetMapping("/partidas")
    public List<PartidaModel> buscarTodasPartidas() {
        return partidaService.buscarTodasPartidas();
    }

    @GetMapping("/por-estadio/{estadio}")
    public List<PartidaModel> buscarPorEstadio(@RequestParam String estadio) {
        return partidaService.buscarPorEstadio(estadio);
    }

    @GetMapping("/goleada/{diferenca}")
    public ResponseEntity<List<PartidaModel>> buscarGoleada(@PathVariable int diferenca) {
        List<PartidaModel> partidaModel = partidaService.buscarPorGoleada(diferenca);
        return new ResponseEntity<>(partidaModel, HttpStatus.OK);
    }

    @GetMapping("/semgols")
    public ResponseEntity<List<PartidaModel>> buscarPartidasSemGols() {
        List<PartidaModel> partidaModel = partidaService.buscarPorSemGols();
        return new ResponseEntity<>(partidaModel, HttpStatus.OK);
    }

    @GetMapping("/clube/{nomeClube}")
    public ResponseEntity<List<PartidaModel>> buscarPartidasPorClube(@PathVariable String nomeClube,
                                                                     @RequestParam(required = false) String nome) {
        List<PartidaModel> partidaModel = partidaService.buscarPartidasPorClube(nomeClube, nome);
        return ResponseEntity.ok(partidaModel);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PartidaModel> obterPartidaPorId(@PathVariable Long id) {
        Optional<PartidaModel> partida = partidaService.obterPartidaPorId(id);
        return partida.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }
    @PostMapping("/add")
    public PartidaModel cadastrarPartida(@RequestBody PartidaDto partidaDto) {
        return partidaService.cadastrarPartida(partidaDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartidaModel> atualizarPartida(@PathVariable Long id, @RequestBody PartidaDto partidaDto) {
        PartidaModel partidaAtualizada = partidaService.atualizarPartida(id, partidaDto);

        if (partidaAtualizada != null) {
            return new ResponseEntity<>(partidaAtualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{clubeMandante}/{clubeVisitante}/{dataHora}")
    public void deletarPartida(@PathVariable String clubeMandante, @PathVariable String clubeVisitante,
                               @PathVariable String dataHora) {
        LocalDateTime dateTime = LocalDateTime.parse(dataHora);
        partidaService.deletarPartida(clubeMandante, clubeVisitante, dateTime);
    }
    @DeleteMapping("/{id}")
    public void deletarPartida(@PathVariable Long id) {
        partidaService.deletarPartida(id);
    }
}


