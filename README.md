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


Junto ao projeto, será publicado um word com as evidências dos testes executados.


Para execução das evidências foram utilizadas o sopui e execuções do proprio sistema.

Juntamente com os serviços de endereço , foi disponibilizado um serviço para cadastro de usuários no sistema, para auxilio da correção da prova. Como o foco do exercicio não era cadastro de usuários . 
A parte de login em expecifico não teve processos de validação na tela com mensagens de erro ,..etc.

###Orientações

Após o projeto ser baixado, devem ser importados como maven project ou convertidos para projetos eclipses com o comando mvn eclipse:eclipse, apesar que só utilizei eles como projeto maven.

No servidor de aplicativos devem ser publicados os projetos Servicos e WebSite. Lembrando que utilizei o servidor wildfly-8.2.1.Final.

Antes de utilizar o sistema , deve-se cadastrar usuários na base, foi disponibilizado um serviço que adciona usuários, que se encontra em http://<endereço>:<porta>/Services/rest/zip/salvar.

###Exercicio 01
 O serviço que se refere a esse exercicio se é zipFind da classe SearchZip
###Exercicio 02
 Conjunto de sistemas disponibilizados
###Exercicio 03
 A resolução desse exercicio se encontra no projeto Exercicio03
###Exercicio 04
Ao clicar no link vc desencadeia um fluxo de informações dentro do computador. Diversos protocolos se interagem para o fornecimento da informação requisitada. Para que o protocolo HTTP  transfira os dados, é necessários os protocolos TCP e IP tornem possíveis uma conexão através de sockets TCP/IP .
Através de mensagens o protocolo http faz a comunicação entre o cliente e o servidor. Mensagens são enviadas pelo cliente que faz uma requisição de um recurso ao servidor, só então o servidor envia uma mensagem de resposta ao cliente com a solicitação. 
O cliente estabelece uma conexão com um servidor enviando uma requisição, contendo a URI, a versão do protocolo, uma mensagem com os modificadores da requisição, informações do requisitante.
O servidor responde o requisitante com sua versão do protocolo utilizado e um código de operação (podendo ser de sucesso ou erro), seguido pelas informações do servidor,  e possível conteúdo requisitado. Após oferecida pelo  servidor, é encerrada a conexão que fora estabelecida. 



