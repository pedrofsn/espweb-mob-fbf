# Instruções para executar o projeto
1 - Carregar o projeto como "Maven Project" no eclipse; 

2 - Subir o mysql ou outro banco de preferência (necessário fazer ajustes do driver na classe DatabaseConnection.java);

3 - Criar um banco de dados chamado "empresa";

4 - Criar a tabela com o script abaixo;

```
CREATE TABLE funcionarios ( id serial NOT NULL PRIMARY KEY, nome varchar(255) NOT NULL, cargo varchar(255) NOT NULL);
```

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
    "funcionarios": [
        {
            "id": 1,
            "nome": "Pedrofsn",
            "cargo": "Desenvolvedor"
        },
        {
            "id": 2,
            "nome": "Sebba",
            "cargo": "Desenvolvedor"
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
        "id": 2,
        "nome": "Pedrofsn2",
        "cargo": "Desenvolvedor"
    }
}
```

## POST /funcionario
Cadastrar um funcionário enviando um objeto json no body da requisição.

Body:
```
 {
  "nome": "Pedrofsn",
  "cargo": "Desenvolvedor"
 }
```

Retorno:
```
{
  "funcionario": {
    "id": 11,
    "nome": "Pedrofsn",
    "cargo": "Desenvolvedor"
  }
}
```

## PUT /funcionario
Atualizar os dados de um funcionário específico.

Body:
```
{
   "id": 2,
   "nome": "Pedro F. S. Neto",
   "cargo": "Fullstack Developer"
}
```

Retorno:
```
{
  "funcionario": {
    "id": 2,
    "nome": "Pedro F. S. Neto",
    "cargo": "Fullstack Developer"
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
