# Desafio Pleno Turn2C

## Descrição
Essa aplicação é um sistema desenvolvido em Java usando o framework `Spring Boot`.
Para o desenvolvimento foi seguido um padrão de camadas , implementado um CRUD e tambem possui 4 tipos de objetos
`Usuario`, `Vendedor`, `Cliente` e `Master`. Cada um possui atributos parecidos, e alguns deles tem atributos diferentes tambem sendo eles `Vendedor` e `Cliente`, e o `Master` tem o perfil tanto de `Vendedor` como de `Cliente`

## Estrutura do Projeto

- **Camada de Apresentação (Controller):** Responsável por expor os endpoints REST e mapear as requisições para os serviços correspondentes.
- **Camada de Serviço (Service):** Contém a lógica de negócios da aplicação, incluindo a validação de dados e o processamento das requisições.
- **Camada de Persistência (Repository):** Responsável pela comunicação com o banco de dados, utilizando o Spring Data JPA para gerenciar as entidades.
- **Camada de Modelo (Entity):** Define as entidades da aplicação, como `Usuario`, `Vendedor`, `Cliente` e `Master`.
- **Camada de DTO (Data Transfer Object):** Contém objetos que são usados para transferir dados entre a camada de apresentação e a camada de serviço.

## Funcionalidades

- **CRUD Completo para Usuários:**
  - Foram feitas as 4 Ocorrencias de um CRUD para cada Objeto sendo elas CREATE, READ, UPDATE, DELETE: `Usuario`, `Vendedor`, `Cliente` e `Master`.
  - Lista dos Atributos em comum: `nome`, `email`.
  - Lista dos Atributos especificos:
    - Atributos para o `Vendedor`: `comissao`, `vendasRealizadas`.
    - Atributos para o `Cliente`: `cpf`, `historicoCompras`.
    - Atributos para `Master`: O Master ele é como um ADMIN da aplicação, então ele tem o perfil de `Vendedor` e `Cliente`.

- **Serviço REST:**
  - Exposição de endpoints REST para operações CRUD.
  - Recepção de DTOs para mapear as requisições para o domínio construído.
  - Tratamento de exceções, garantindo que erros sejam adequadamente tratados e retornados com mensagens apropriadas.

- **Persistência de Dados:**
  - Uso do Spring Data JPA para persistência de dados em um banco de dados relacional.

- **Testes Unitários:**
  - Testes para validar os serviços disponíveis, garantindo a integridade da aplicação.

- **Documentação com Swagger OpenAPI:**
  - Documentação dos serviços REST utilizando Swagger para facilitar a integração e o entendimento da API.

- **Boas Práticas de Programação:**
  - Tentei aplicar o maximo possivel de SOLID e tambem Clean Code, possa ser que me falte experiência para conseguir montar um projeto melhor que consiga seguir 100% das melhores praticas, mas para esse `Desafio`, tentei aplicar oque conhecia e busquei um pouco mais.
  - A implementação de outros patterns tambem possa ser que não tenha ficado das melhores, pois não trabalhei com muitos padrões diferentes de Facade e Component, mas acredito que possa aprender muito e nas proximas aplicações entregar eles de uma forma melhor.

## Requisitos

Para conseguir rodar a aplicação utilizei os seguintes requisitos:

- Java 17
- Maven 3.6+
- Banco de dados: H2
- Postman para testar os ENDPOINTS

`Observações`: Poderia ser implementado dentro da aplicação o String Security com uma definição melhor do que é cada `Usuario`, dessa forma seria mais facil entender que o `Cliente` e o `Vendedor` teriam uma role `Comum` ja o `Master` teria a role `Admin`,
Essa implementação deixaria mais robusta a aplicação e tambem garantiria que os Perfis tivessem cada um sua determinada tarefa, sendo somento o `Master` podendo ter dois perfis.


## Modelo de Entidades

Na minha aplicação eu montei as Entidades dessa forma:

### Entidades

- **Usuario**
  - `Long id`
  - `String nome`
  - `String email`

- **Vendedor**
  - `String comissao`
  - `String vendasRealizadas`
  - `Set<Perfil> perfis`

- **Cliente**
  - `String cpf`
  - `String historicoCompras`
  - `Set<Perfil> perfis`

- **Master**
  - `Set<Perfil> perfis`
  - Pode ter perfis de `Vendedor` e `Cliente`

### Perfis

- Enumeração que define os tipos de perfis que um `Master` pode ter: `CLIENTE`, `VENDEDOR`, etc.

## Exemplo de Uso

### Criar um novo Cliente:

