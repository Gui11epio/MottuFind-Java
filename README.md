Grupo:
Guilherme Camasmie Laiber de Jesus,
Pedro Manzo Yokoo,
Fernando Fernandes Prado

#LINK PARA O SWAGGER
``
http://localhost:8080/swagger-ui/index.html#/
``


#Json para testes

A ordem de criação para testes: Filial -> Pátio -> Moto

Filial:
``
{
"nome": "Unidade São Paulo",
"cidade": "São Paulo",
"pais": "Brasil"
}
``

Pátio:
``
{
"nome": "Pátio Central",
"largura": 50.0,
"comprimento": 100.0,
"filialId": 1
}
``

Moto:
``
{
"placa": "ABC1234",
"modelo": "CG 160 Fan",
"marca": "Honda",
"cor": "Preta",
"status": "disponivel",
"patioId": 1
}
``



