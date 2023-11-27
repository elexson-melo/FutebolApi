package br.com.mercadolivre.elexsonmelofutebolapi.Controller;

import br.com.mercadolivre.elexsonmelofutebolapi.Model.PartidaModel;
import br.com.mercadolivre.elexsonmelofutebolapi.Service.PartidaService;
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


    @PostMapping("/add")
    public ResponseEntity<PartidaService> cadastrarPartida(@RequestBody PartidaService partidaService) {
        PartidaService novaPartidaService = partidaService;
        return new ResponseEntity<>(novaPartidaService, HttpStatus.CREATED);
    }
    @GetMapping("/partidas")
    public List<PartidaModel> listarPartidas() {
        return partidaService.listarPartidas();
    }

    @GetMapping("/por-estadio/{estadio}")
    public List<PartidaModel> buscarPorEstadio(@RequestParam String estadio) {
        return partidaService.buscarPorEstadio(estadio);
    }

    @GetMapping("/goleada/{diferenca}")
    public ResponseEntity<List<PartidaModel>> buscarGoleada(@PathVariable int diferenca) {
        List<PartidaModel> partidaModels = partidaService.buscarPorGoleada(diferenca);
        return new ResponseEntity<>(partidaModels, HttpStatus.OK);
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
    @PutMapping("/{id}")
    public ResponseEntity<PartidaModel> atualizarPartida(@PathVariable Long id, @RequestBody PartidaModel novaPartidaModel) {
        partidaService.atualizarPartida(id, novaPartidaModel);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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


