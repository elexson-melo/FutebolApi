package br.com.mercadolivre.elexsonmelofutebolapi.dto;

import java.util.Date;

public record PartidaRecordDto(String homeTeam, String awayTeam, String result, Date dateAndTime, String stadium) {
}
