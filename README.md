# FutebolApi

## Praticando Comandos,Criando Tabelas e Manipulando dados utilizando MySQL

### Primeira Tarefa: Criar Tabela Partidas:

- CREATE DATABASE partidaDB;
- CREATE TABLE partidas(
- id INT not null auto_increment,
- clubeVisitante VARCHAR(30),
- clubeMandanteVARCHAR(30),
- data_Hora DATETIME(6),
- estadio VARCHAR(30),
- resultado VARCHAR(30),
- resultadoMandante INT,
- resultadoVisitante INT,
- primary key (id)
- );
  
### Segunda Tarefa: Inserir múltiplos dados nesta tabela(de uma só vez):

- INSERT INTO partidas1
  (clubemandante,clubevisitante,data_hora,estadio,resultado,resultadomandante,resultadovisitante)
- SELECT
  ('Brasil','Argentina','2022-09-16 21:30:00','Maracana','0x1','0','1')
- FROM partidas;

### Terceira Tarefa: Deletar somente Partidas de um determinado clube:

- DELETE FROM partidas
- WHERE clubeMandante= 'Chile'
- SELECT * FROM partidas;

### Quarta Tarefa: Selecionar algumas partidas específicas (selecionar partidas com goleadas): 

- SELECT clubeMandante, clubeVisitante FROM partidas
- WHERE resultadoMandante >= 3 or resultadoVisitante <= 0;
