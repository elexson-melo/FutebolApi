# FutebolApi

## Praticando Comandos,Criando Tabelas e Manipulando dados utilizando MySQL

### Primeira Tarefa: Criar Tabela Partidas:

- CREATE DATABASE partidaDB;
- CREATE TABLE partidas(
- id INT not null auto_increment,
- clubeVisitante VARCHAR(255),
- clubeMandanteVARCHAR(255),
- data_Hora DATETIME(6),
- estadio VARCHAR(255),
- resultado VARCHAR(255),
- resultadoMandante INT,
- resultadoVisitante INT,
- primary key (id)
- );
  
### Segunda Tarefa: Inserir múltiplos dados nesta tabela:

- INSERT INTO partidas
(clubemandante,clubevisitante,data_hora,estadio,resultado,resultadomandante,resultadovisitante)
VALUES
('Brasil','Argentina','2022-09-16 21:30:00','Maracana','0x1','0','1');
