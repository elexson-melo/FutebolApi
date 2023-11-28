package br.com.mercadolivre.elexsonmelofutebolapi.dto;

import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

public class PartidaDto {
    private String clubeMandante;
    private String clubeVisitante;
    private int resultadoMandante;
    private int reultadoVisitante;
    private LocalDateTime dataHora;
    private String estadio;
}

