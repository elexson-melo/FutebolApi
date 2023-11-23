package br.com.mercadolivre.elexsonmelofutebolapi.Controller;

import br.com.mercadolivre.elexsonmelofutebolapi.Model.PartidaModel;
import br.com.mercadolivre.elexsonmelofutebolapi.Service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/Partida")
public class PartidaController {

    @Autowired
    private PartidaService partidaService;


    @PostMapping("/add")
    public ResponseEntity<PartidaModel> cadastrarPartida(@RequestBody PartidaModel partidaModel) {
        PartidaModel novaPartidaModel = partidaService.save(partidaModel);
        return new ResponseEntity<>(novaPartidaModel, HttpStatus.CREATED);
    }
    @GetMapping("/listar-partidas")
    public List<PartidaModel> listarPartidas() {
        return partidaService.listarPartidas();
    }

    @GetMapping("/by-estadio/{estadio}")
    public List<PartidaModel> buscarPorEstadio(@RequestParam String estadio) {
        return partidaService.buscarPorEstadio(estadio);
    }

    @GetMapping("/goleada/{diferenca}")
    public ResponseEntity<List<PartidaModel>> buscarGoleada(@PathVariable int diferenca) {
        List<PartidaModel> partidaModels = partidaService.findGoleada(diferenca);
        return new ResponseEntity<>(partidaModels, HttpStatus.OK);
    }

    @GetMapping("/semgols")
    public ResponseEntity<List<PartidaModel>> buscarPartidasSemGols() {
        List<PartidaModel> partidaModels = partidaService.buscarPorSemGols();
        return new ResponseEntity<>(partidaModels, HttpStatus.OK);
    }

    @GetMapping("/clube/{nomeClube}")
    public ResponseEntity<List<PartidaModel>> buscarPartidasPorClube(@PathVariable String nomeClube,
                                                                     @RequestParam(required = false) String tipo) {
        List<PartidaModel> partidaModels = partidaService.buscarPartidasPorClube(nomeClube, tipo);
        return ResponseEntity.ok(partidaModels);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PartidaModel> obterPartidaPorId(@PathVariable int id) {
        PartidaModel partidaModel = (PartidaModel) partidaService.obterPartidaPorId(id);
        if (partidaModel != null) {
            return ResponseEntity.ok(partidaModel);
        } else {
            return ResponseEntity.notFound().build();
        }
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


