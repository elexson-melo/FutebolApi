# FutebolApi

## Praticando Comandos,Criando Tabelas e Manipulando dados utilizando MySQL

### Primeira Tarefa: Criar Tabela Partidas:

 CREATE DATABASE partidaDB;
 CREATE TABLE partidas(
 id INT not null auto_increment,
 clube_visitante VARCHAR(30),
 clube_mandanteVARCHAR(30),
 data_Hora DATETIME(6),
 estadio VARCHAR(30),
 resultado VARCHAR(30),
 resultado_mandante INT,
 resultado_visitante INT,
 primary key (id)
 );
  
### Segunda Tarefa: Inserir múltiplos dados nesta tabela(de uma só vez):

 INSERT INTO partidas
 (clube_mandante,clube_visitante,data_Hora,estadio,resultado,resultado_mandante,resultado_visitante)
 VALUES
 ('Palmeiras','Corinthians','2022-10-28 22:00:00','Cachamay','2x5','2','5'),
 ('Santos','Flamengo','2022-10-26 21:00:00','Nunes','4x1','4','1'),
 ('Fluminense','Botafogo','2022-10-25 21:30:00','Kempes','4x0','4','0');
 SELECT * FROM partidas;
  
### Terceira Tarefa: Deletar somente Partidas de um determinado clube:

  DELETE FROM partidas
  WHERE id= '9'
  SELECT * FROM partidas;

### Quarta Tarefa: Selecionar algumas partidas específicas (selecionar partidas com goleadas): 

  SELECT clube_mandante, clube_visitante,resultado FROM partidas
  WHERE resultado_mandante > 3 or resultado_visitante <= 0;
  
