package br.com.mercadolivre.elexsonmelofutebolapi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


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
    private String homeTeam;
    @Column
    private String awayTeam;
    @Column
    private String result;
    @Column
    private String date;
    @Column
    private String time;
    @Column
    private String stadium;


    public Partida() {

    }
    public Partida(String homeTeam, String awayTeam, String result, String date, String time, String stadium) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.result = result;
        this.date = date;
        this.time = time;
        this.stadium = stadium;
    }
}
