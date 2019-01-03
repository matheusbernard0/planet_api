# Planet API

API Rest para exposição de planetas do mundo de Star Wars.


## Observações sobre a implementação

* Como o número de aparições dos planetas consta na SWAPI, realizei uma integração com a mesma para efetuar consultas e consumir os dados relativos a cada planeta.

     Levando em consideração que não possuímos os **id's** dos planetas da SWAPI na nossa aplicação, implementei o consumo das informações da SWAPI da seguinte forma :

    Na primeira chamada em que a aplicação realiza ao SWAPI eu pego todos os planetas, a quantidade de filmes em que cada planeta aparece e crio um 'HashMap<String, Integer>' em que o nome do planeta é a chave e a quantidade de filmes em que o mesmo aparece é o valor. Após criado o mapa, armazeno este em Cache e realizo e, até que a informação expire, não preciso mais realizar chamadas a SWAPI. Assim consigo diminuir o número de chamadas HTTP que minha aplicação realiza, diminui o número de tratamentos de objetos complexos provinientes da SWAPI e mantém a minha aplicação bem mais performática que ao buscar todos os planetas a cada requisição.   
    
* Implementei um tratamento de exceção que trata de toda e qualquer exceção lançada pela aplicação e retorna um Http Response com seu devido código Http e um Http Body contendo seus atributos padronizados para melhor tratamento em uma aplicação cliente.

* Utilizei o Swagger juntamente com o Swagger UI para documentação e facilitação do consumo da API.
    
* Como nenhuma restrição foi feita em relação ao cadastro de planetas, os planetas que forem inseridos na API e não existirem na SWAPI terão seus valores de aparições em filmes zerados.


## Ferramentas Utilizadas

* **Spring Boot**

* **Spring Data JPA**

* **Swagger**

* **MongoDB**


## Estrutura do Projeto

As classes do projeto estão agrupadas semanticamente nos seguintes pacotes:

 * config : Pacote que contém as classes responsáveis por toda e qualquer configuração da aplicação.
 
 * exception : Pacote que contém as classes responsáveis por tratar e padronizar toda e qualquer exception lançada pela aplicação.
 
 * model : Pacote que contém as classes responsáveis por representar entidades do banco de dados e dados de entrada e saída da aplicação.
 
 * repository : Pacote que contém as classes responsáveis por executar o acesso ao banco de dados da aplicação.
 
 * resource : Pacote que contém as classes responsáveis por receber as requisições da aplicação e delegá-las às classes de serviço.
 
 * service : Pacote que contém as classes responsáveis por executar toda lógica de negócio da aplicação.  
 
 
