package br.com.mercadolivre.elexsonmelofutebolapi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@Table(name = "partidas")
public class Partida {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String timeCasa;
    @Column
    private String timeFora;
    @Column
    private String resultado;
    @Column
    private int golsCasa;
    @Column
    private int golsFora;
    @Column
    private LocalDateTime dataEHora;
    @Column
    private String estadio;

    public Partida() {

    }
    public Partida(String timeCasa, String timeFora, String resultado, LocalDateTime dataEHora, String estadio, int golsCasa, int golsFora) {
        this.timeCasa = timeCasa;
        this.timeFora = timeFora;
        this.resultado  = resultado;
        this.golsCasa = golsCasa;
        this.golsFora = golsFora;
        this.dataEHora = dataEHora;
        this.estadio = estadio;
    }
}
