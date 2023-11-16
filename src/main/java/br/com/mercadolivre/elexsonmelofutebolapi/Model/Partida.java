package br.com.mercadolivre.elexsonmelofutebolapi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "partidas")
public class Partida {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String clubeMandante;
    @Column
    private String clubeVisitante;
    @Column
    private String resultado;
    @Column
    private int resultadoMandante;
    @Column
    private int resultadoVisitante;
    @Column
    private LocalDateTime dataHora;
    @Column
    private String estadio;

    public Partida (String clubeMandante, String clubeVisitante, String resultado, LocalDateTime dataHora, String estadio, int resultadoMandante, int resultadoVisitante) {
        this.clubeMandante = clubeMandante;
        this.clubeVisitante = clubeVisitante;
        this.resultado = resultado;
        this.resultadoMandante = resultadoMandante;
        this.resultadoVisitante = resultadoVisitante;
        this.dataHora = dataHora;
        this.estadio = estadio;
    }

    public Partida() {

    }
}


