# Instruções para executar o projeto
1 - Carregar o projeto como "Maven Project" no eclipse; 

2 - Subir o mysql ou outro banco de preferência (necessário fazer ajustes do driver na classe DatabaseConnection.java);

3 - Criar um banco de dados chamado "empresa";

4 - Criar o banco "empresa" através do arquivo "funcionarios.sql", localizado na raíz do diretório;


Se tudo ocorrer bem, a URL http://localhost:8080/empresa/api/funcionarios deverá trazer o seguinte retorno:
```
{
  funcionarios: [ ]
}
```

# API
## GET /funcionarios
Obter todos os funcionários cadastrados.

Retorno:
```
{
    "total": 1,
    "funcionarios": [
        {
            "id": 13,
            "nome": "Marcos Souza",
            "email": "kim@souza.com",
            "cpf": "04207515135",
            "nascimento": "jul 22, 2017",
            "telefone": "982080507"
        }
    ]
}
```

## GET /funcionario/{id}
Obter um funcionário específico através de um ID.

Retorno:
```
{
    "funcionario": {
        "id": 13,
        "nome": "Marcos Souza",
        "email": "kim@souza.com",
        "cpf": "04207515135",
        "nascimento": "jul 22, 2017",
        "telefone": "982080507"
    }
}
```

## POST /funcionario
Cadastrar um funcionário enviando um objeto json no body da requisição.

Body:
```
{
  "nome":"Marcos Souza",
  "email":"kim@souza.com",
  "cpf":"04207515135",
  "nascimento":"2017-07-22",
  "telefone":"982080507"
}
```

Retorno:
```
{
    "funcionario": {
        "id": 15,
        "nome": "Marcos Souza",
        "email": "kim@souza.com",
        "cpf": "04207515135",
        "nascimento": "jul 22, 2017",
        "telefone": "982080507"
    }
}
```

## PUT /funcionario
Atualizar os dados de um funcionário específico.

Body:
```
{
  "id":15,
  "nome":"Pedro",
  "email":"pedrokra@gmail.com",
  "cpf":"12345678910",
  "nascimento":"1992-11-06",
  "telefone":"982080507"
}
```

Retorno:
```
{
    "funcionario": {
        "id": 15,
        "nome": "Pedro",
        "email": "pedrokra@gmail.com",
        "cpf": "12345678910",
        "nascimento": "nov 6, 1992",
        "telefone": "982080507"
    }
}
```

## DELETE /funcionario/{id}
Deletar um funcionário específico através de um ID.

Retorno:
```
{
    "sucesso" : true
}
```
