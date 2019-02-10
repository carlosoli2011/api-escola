## API Estudo VR

# Introdução
API de Controle de cursos

# Requerimentos Java 1.8 Postgres 9 Maven 3.X
Clone este repositório git clone https://github.com/carlosoli2011/api-escola.git

# Banco de dados
Será criado ao subir a aplicação appescola na porta 5432 do postgres instalado em seu pc

# Para modificar as configurações de acesso ao banco de dados na aplicação
```sh
abra: /src/main/resources/application.properties
altere as propriedades: url, username e password de acordo com seus dados do postgres. 
Caso precise alterar a porta padão 8080 da aplicação modifique a propriedade server.port=8080 para a porta desejada
```

# Para rodar a aplicação:
```sh
mvn package
java -jar target/api-0.0.1-SNAPSHOT.jar
```

Você também pode rodar sua aplicação utilizando 
```sh
mvn spring-boot:run
```

A Aplicação estará rodando em http://localhost:8080 ou na que você alterou.

# Documentação
Para acessar a url de documentação das requisições http://localhost:8080/api
Nela você encontrará todas as informações para conseguir consumir um serviço via http
Alguns exemplos: POST /curso GET /curso POST /Aluno GET /professor

Para mais detalhes e regras sobre a api acesse: 
https://documenter.getpostman.com/view/6621513/RztprTg4

Autenticação
api-estudo-vr não necessita de autenticação
