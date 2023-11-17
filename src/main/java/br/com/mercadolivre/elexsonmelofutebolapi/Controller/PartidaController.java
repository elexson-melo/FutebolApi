package br.com.mercadolivre.elexsonmelofutebolapi.Controller;

import br.com.mercadolivre.elexsonmelofutebolapi.Model.Partida;
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
    public ResponseEntity<Partida> cadastrarPartida(@RequestBody Partida partida) {
        Partida novaPartida = partidaService.save(partida);
        return new ResponseEntity<>(novaPartida, HttpStatus.CREATED);
    }
    @GetMapping
    public List<Partida> listarPartidas() {
        return partidaService.listarPartidas();
    }

    @GetMapping("/by-estadio/{estadio}")
    public List<Partida> buscarPorEstadio(@RequestParam String estadio) {
        return partidaService.buscarPorEstadio(estadio);
    }

    @GetMapping("/goleada/{diferenca}")
    public ResponseEntity<List<Partida>> buscarGoleada(@PathVariable int diferenca) {
        List<Partida> partidas = partidaService.findGoleada(diferenca);
        return new ResponseEntity<>(partidas, HttpStatus.OK);
    }

    @GetMapping("/semgols")
    public ResponseEntity<List<Partida>> buscarPartidasSemGols() {
        List<Partida> partidas = partidaService.buscarPorSemGols();
        return new ResponseEntity<>(partidas, HttpStatus.OK);
    }

    @GetMapping("/clube/{nomeClube}")
    public ResponseEntity<List<Partida>> buscarPartidasPorClube(@PathVariable String nomeClube,
                                                                @RequestParam(required = false) String tipo) {
        List<Partida> partidas = partidaService.buscarPartidasPorClube(nomeClube, tipo);
        return ResponseEntity.ok(partidas);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Partida> obterPartidaPorId(@PathVariable int id) {
        Partida partida = (Partida) partidaService.obterPartidaPorId(id);
        if (partida != null) {
            return ResponseEntity.ok(partida);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partida> atualizarPartida(@PathVariable Long id, @RequestBody Partida novaPartida) {
        partidaService.atualizarPartida(id, novaPartida);
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


