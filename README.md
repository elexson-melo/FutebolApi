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

- INSERT INTO partidas
  (clubemandante,clubevisitante,data_hora,estadio,resultado,resultadomandante,resultadovisitante)
- VALUES
  ('Venezuela','Brasil','2022-10-28 22:00:00','Cachamay','2x5','2','5'),
  ('Bolivia','Peru','2022-10-26 21:00:00','Nunes','4x1','4','1'),
  ('Argentina','Colombia','2022-10-25 21:30:00','Kempes','2x2','2','2');
  
### Terceira Tarefa: Deletar somente Partidas de um determinado clube:

- DELETE FROM partidas
- WHERE clubeMandante= 'Chile'
- SELECT * FROM partidas;

### Quarta Tarefa: Selecionar algumas partidas específicas (selecionar partidas com goleadas): 

- SELECT clubeMandante, clubeVisitante FROM partidas
- WHERE resultadoMandante >= 3 or resultadoVisitante <= 0;
