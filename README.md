# Gereciador de Produtos

   O presente projeto tem como principal finalidade o gerenciamento/manutenção de um sistema de produtos

## Projeto Java: gerenciador-produtos-api
   O projeto java foi concebido com intuito de facilitar a subida da aplicação.
Foi escolhido a seguinte plataforma arquitetural:
- Maven
- Springboot Suite (Spring Rest, Spring Data JPA, Spring Web)
- Lombok
- JUnit4
- H2 Database.
- FlywayDB

Os motivos foram:

### Maven
   A suite de utilização do Maven atua como um gerenciador de dependências eficaz no projeto além de gerenciar o ciclo de vida do mesmo.

### Springboot
   A aplicação utiliza springboot em seu core. A suite spring proporciona facilidade de desenvolver a aplicação com uma plataforma completamente estável e fácil de utilizar, está no mercado a mais de 15 anos e é padrão na utilização de microserviços

### Lombok
   O projeto lombok facilita as tarefas diarias como: Criar Getters, Setters, Buuilder, classes imutáveis, injeção de loggers com SL4J e Log4j.
   É necessário que, caso a aplicação seja importada em uma IDE, a mesma tenha o plugin do gradle instalado.

### JUnit4
   Utilzado no desenvolvimento de testes unitários para validação das funcionalidades além da familiaridade com o framework.

### H2 Database
   Utilizado o banco em memória H2 pelo escopo do projeto e porque com Springboot fica fácil desenvolver a aplicação de forma sustentável

### FlywayDB
   Utilizado no versionamento dos scripts tanto para criação das tabelas quanto inserção de registros para popular o banco

### Camada Rest
A utilização da camada Rest segue as principais convenções.

### Como testar?
   Para executar o projeto backend no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

   Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:8080/api/produtos
```

## Projeto Angular: gerenciador-produtos-ui
Projeto criado com principais funcionalidades CRUD, navegação entre abas, tratamento de rotas e exceções.

Utilizadas as seguintes tecnologias:
- Angular: Versao mais atual
- Angular Material UI: renderizacao de componentes ao usuario

### Iniciando a aplicação
Para executar o projeto frontend no terminal, digite o seguinte comando:

```shell script
npm i
npm start
```

   Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:4200
```


## Para o futuro
 *  A ideia, se a delimitação do tempo fosse maior, era no projeto Java finalizar a parte de testes e cobertura em uma faixa acima de 90%, Swagger para gerar a documentação dos endpoints e adicionar serviço de autenticação nas requisições Rest. 
 *  No projeto em Angular, adicionar a filtragem e ordenação na tabela de produtos e aprimorar a validação dos campos durante o cadastro. 
 *  Por fim, a dockerização da aplicação backend e frontend.
  
Aproveite! 
  
  
  
