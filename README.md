# ProvaDesenvolvimento

## Frameworks ,Bibliotecas e ferramentas utilizadas

Maven - Foi utilizado o maven para o gerenciamento de dependência, buscando nos repositórios os jars necessários para a execução do sistema    

JPA com hibernate - Para persistência dos dados, foi optado pelo uso de jpa com hibernate, pela facilidade de persistir objetos imbutidos.

CDI - Utilizado para oferecer dentro dos projetos a injeção de dependencia oferecendo a inversão de controle.

java 1.7 

JBOSS wildfly-8.2.1.Final

Jersey - Framework que implementa especificação para o JAX-RS. Basicamente o jersey tem um servidor e um cliente REST 

Eclipse Mars (software)

SoapUI (software)- Interface para consumo de webservice. Optei por também realizar testes utilizando essa ide, pela facilidade de executar requisições em webservices

MySql - Banco de dados

Angularjs - AngularJS é um framework JavaScript open-source, mantido pelo Google,
Seu objetivo é aumentar aplicativos que podem ser acessados por um navegador web, sob o padrão model–view–controller (MVC).

Bbootstrap - Utilizão com o ituito de deixar a camada web responsiva e utilização de templates para uma visualização mais agradável.

Grid-ui - Biblioteca angular com funcionalidades de grid.

ngCookie - Biblioteca angular com a funcionalidade de gravar e recuperar cookies salvos no navegador.

maskui- Biblioteca angular com a funcionalidade de mascaras para campos de textos.



Estruturas do projetos

EntitiesVO - Entidades para travegar objetos entre as camadas.
DAOS - responsavel por conter as entidades do banco e controla os acessos ao banco
BUSINESS - camada responsavel pela camada de negocio da aplicação
Services - Camada de webservices que será exposto pela aplicação 
WebSite - camada de visualização contendo a parte grafica e o grud pedido no exercicio 2

## Design pattern Utilizados

Model-view-controller (MVC)
Value Object (VO)
Data Acess Objetct (DAO)
Service-Oriented Architecture (SOA)
Dependency Injection (DI)