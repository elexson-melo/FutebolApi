package br.com.mercadolivre.elexsonmelofutebolapi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "partidas")
public class PartidaModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public PartidaModel() {

    }
}


