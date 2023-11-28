package br.com.mercadolivre.elexsonmelofutebolapi.Model;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;



@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "partidas")
public class PartidaModel {
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

    public PartidaModel() {

    }
}


