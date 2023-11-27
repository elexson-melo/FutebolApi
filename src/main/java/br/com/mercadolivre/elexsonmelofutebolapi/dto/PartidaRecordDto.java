package br.com.mercadolivre.elexsonmelofutebolapi.dto;

import java.time.LocalDateTime;

public record PartidaRecordDto(String clubeMandante, String clubeVisitante, int resultado,int resultadoMandante,int resultadoVisitante, LocalDateTime dataHora) {

}
