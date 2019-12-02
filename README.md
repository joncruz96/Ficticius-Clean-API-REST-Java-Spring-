# Ficticius-Clean-API-REST-Java-Spring-

Desenvolvimento de API's utilizando o framework Spring Java, para o cadastro de veículos da empresa Ficticius Clean.

## API REST

Foi criado uma API REST de Veículos, onde possa cadastrar, consultar, alterar e deletar os veículos.

Principais requisições:

GET - http://localhost:8090/veiculoes

GET(ID) - http://localhost:8090/veiculoes/1

POST - http://localhost:8090/veiculoes

PUT - http://localhost:8090/veiculoes/3

DELETE - http://localhost:8090/veiculoes/2

## Banco de Dados - h2

Utiizado o banco de dados h2, em que é criado em memória quando a aplicação Spring é iniciada.

Para conferir os dados da tabela Veículo acesse: http://localhost:8090/h2 e insira os dados:

login: totvs
senha: totvs

## API CalculoPrevisaoDeGastos

Criado API para realizar o cálculo da previsão de gastos dos veículos cadastrados (class ControleVeiculos) e retornar uma lista de veículos ordenados pelo valor de combustível total gasto por cada um.

Criado uma class de testes para verificar se o cálculo da previsão de gastos foi executado e retornado os valores corretamente.