package br.com.mercadolivre.elexsonmelofutebolapi.Controller;

import br.com.mercadolivre.elexsonmelofutebolapi.Model.Partida;
import br.com.mercadolivre.elexsonmelofutebolapi.Repository.PartidaRepository;
import br.com.mercadolivre.elexsonmelofutebolapi.Service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/Partida")
public class PartidaController {

    @Autowired
    private PartidaService partidaService;

    @GetMapping
    public List<Partida> listarPartidas() {
        return partidaService.listarPartidas();
    }

    @GetMapping("/by-estadio/{estadio}")
    public List<Partida> findByEstadio(@PathVariable String estadio) {
        return partidaService.findByEstadio(estadio);
    }

    @GetMapping("/semgols")
    public List<Partida> findPartidaSemGols() {
        return partidaService.findPartidaSemGols();
    }

    @GetMapping("/goleadas/{diferenca}")
    public List<Partida> findGoleadas(@PathVariable int diferenca) {
        return partidaService.findGoleadas(diferenca);
    }

    @PostMapping("/add")
    public ResponseEntity<Partida> cadastrarPartida(@RequestBody Partida partida) {
        Partida novaPartida = partidaService.save(partida);
        return new ResponseEntity<>(novaPartida, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public void atualizarPartida(@PathVariable Long id, @RequestBody Partida novaPartida) {
        partidaService.atualizarPartida(id, novaPartida);
    }

    @DeleteMapping("/{id}")
    public void deletarPartida(@PathVariable Long id) {
        partidaService.deletarPartida(id);
    }
}

