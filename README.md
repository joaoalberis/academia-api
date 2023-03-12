# Academia API
Academia API é um projeto simples criado para permitir que usuários criem, atualizem e excluam informações de alunos, matrículas e avaliações físicas em uma academia. O projeto também permite a busca de alunos, matrículas e avaliações físicas por ID, nome, data de nascimento e outros campos. Esse projeto foi criado para praticar os conhecimentos adquiridos durante o curso da dio de spring boot e projeto pratico.

# Endpoints
A seguir estão os endpoints disponíveis nesta API:

### Alunos
- GET /alunos - Retorna todos os alunos cadastrados na base de dados.
- GET /alunos/{id} - Retorna os detalhes de um aluno específico com base no ID fornecido.
- GET /alunos?nome={nome} - Retorna os alunos correspondentes ao nome passado
- GET /alunos?dataNascimento={dataNascimento} - Retorna os alunos correspondentes a data de nascimento passada
- GET /alunos/avaliacoes/{id} - Retorna todas as avaliações de um determinado aluno pelo id passado
- POST /alunos - Cria um novo registro de aluno na base de dados, utilizando as informações setadas no body.
- PUT /alunos/{id} - Atualiza as informações de um aluno específico com base no ID fornecido e as informações fornecidas no body.
- DELETE /alunos/{id} - Exclui um aluno específico com base no ID fornecido.

### Matrículas
- GET /matriculas - Retorna todas as matrículas cadastradas na base de dados.
- GET /matriculas?bairro={bairro} - Retorna as matrículas correspondentes que tem o bairro correspondente.
- GET /matriculas?dataMatricula={dataMatricula} - Retorna as matrículas correspondentes que tem a data de matricula menor que a fornecida .
- POST /matriculas - Cria uma nova matrícula na base de dados, utilizando as informações setadas no body.
- DELETE /matriculas/{id} - Exclui uma matrícula específica com base no ID fornecido.

### Avaliações Físicas
- GET /avaliacoes - Retorna todas as avaliações físicas cadastradas na base de dados.
- GET /avaliacoes/{id} - Retorna os detalhes de uma avaliação física específica com base no ID fornecido.
- GET /avaliacoes?peso={peso} - Retorna as avaliações físicas correspondentes ao peso passado.
- GET /avaliacoes?altura={altura} - Retorna as avaliações físicas correspondentes a altura passada.
- POST /avaliacoes- Cria uma nova avaliação física na base de dados, utilizando as informações setadas no body.
- PUT /avaliacoes/{id} - Atualiza as informações de uma avaliação física específica com base no ID fornecido.
- DELETE /avaliacoes/{id} - Exclui uma avaliação física específica com base no ID fornecido.

# Como executar
Para executar o projeto, é necessário cloná-lo em sua máquina e configurar o arquivo application.yml com as informações do banco de dados que deseja utilizar. O projeto utiliza Spring e suas devidas dependências do JPA, Hibernate, Validation e do banco de dados.

Segue a estrutura do arquivo application.yml:

```yml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/academia?useTimezone=true&serverTimezone=UTC&useLegacyDate
    username:
    password:
  jpa:
    show-sql: true
    hibernate:
      ddl-auto: update
    properties:
      hibernate.format_sql: true 
```

# Como contribuir
Se você quiser contribuir para o projeto, basta dar um fork e fazer as suas atualizações.

# Licença
O projeto não possui uma licença definida, uma vez que foi criado apenas para fins de estudo.

# Autor
O projeto foi desenvolvido por João Alberis, um estudante de back-end de 18 anos.
