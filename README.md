# 📦 Sprint4

Este projeto é uma API REST desenvolvida com **Spring Boot** para o gerenciamento e monitoramento de motos. Ela permite operações típicas como cadastro, listagem e controle de dados relacionados.

### Grupo:

Guilherme Camasmie Laiber de Jesus - 554894, 

Pedro Manzo Yokoo - 556115, 

Fernando Fernandes Prado - 557982

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Gradle
- Spring Data JPA
- Oracle Database
- Swagger/OpenAPI
- ModelMapper
- Spring Cache
- Bean Validation
- Docker
- Flyway
- Spring Security
- ThymeLeaf

## ⚙️ Como Executar o Projeto

### Passos

1. Clone o repositório ou extraia o conteúdo do `.zip`. **Se precisar baixar o SDK, instale do Java 17**
   
2. - Vá nos três pontinhos  
![image](https://github.com/user-attachments/assets/5efa2b64-c870-4136-a5b9-f22159c3b2db)

- Clique em **"Run with Parameters"**  
![image](https://github.com/user-attachments/assets/f55d4cf2-9cf6-432a-ac06-77f5b379b813)

- Vá em **"Modify options"**  
![image](https://github.com/user-attachments/assets/4c51e9ba-018e-4fc0-beac-81881b78a8ed)

- Ache e clique na opção "**Environment varibles**"  
![image](https://github.com/user-attachments/assets/bc1d0969-7712-4532-83a0-e6778dbecdc7)

- Clique no ícone ao lado da pasta  
![image](https://github.com/user-attachments/assets/82c657b8-5f39-4746-ae3f-8a11675052d9)

- Adicione "**db.user**" e "**db.passwb**" e, nos valores, coloque seu usuário e senha do Oracle DB.  
Depois clique **OK**, **APPLY** e **RUN**  
![image](https://github.com/user-attachments/assets/46029a42-c5be-40bc-a9d2-3e298b822e04)

3. Entre na pasta resources e entre no arquivo **application.properties**.
   
   ![image](https://github.com/user-attachments/assets/5b43a0e1-5cd5-42d2-acf3-8fe6d5d202b6)

4.Dentro do arquivo, altere o datasource, se necessário:

![image](https://github.com/user-attachments/assets/e2134110-0527-4bfb-a51a-964daa91b6a7)

5. Volte para a Main do projeto e rode ele.

## Rodar as Migration

Por já estarem criadas a única coisa que você precisa fazer é rodar o projeto, assim as tabelas vão ser criadas sozinhas. 

**Antes faça os passos acima!!!!. É necessário uma conexão com banco para as tabelas serem criadas**

## 🧭 Como Utilizar a API via o site ThymeLeaf
A API pode ser acessada via site para fazer os testes do projeto. Disponível após subir o projeto:

🔗 Acesse:

http://localhost:8080/home

## 🧭 Para acessar pelo Render

🔗 Acesse:

https://mottufind-java.onrender.com


## 🗂️ Ordem de Criação dos Recursos
Essa é a ordem de criação para poder utilizar o projeto

- 👥 Criação do Usuário

- 👥 Fazer Login com esse Usuário

- 📍 Criar uma Filial

- 🚧 Criar um Pátio

- 🏍️ Criar uma Moto

## Exemplos de criação


### 👥 Usuário/Login

**username**
``````bash
admin
``````

**password**
``````bash
$2a$10$exampleHashedPassword1
``````


### 📍 Filial

**nome**
```bash
Unidade Rio de Janeiro
```

**Cidade**
```bash
Rio de Janeiro
```

**Pais**
```bash
Brasil
```


### 🚧 Pátio

**nome**
```bash
Pátio Central
````

**largura**
````bash
100.0
````

**comprimento**
````bash
200.0
````

**filialId**
````bash
1
````

### 🏍️ Moto

**placa**
````bash
ABC1D23
````

**modelo**
`````bash
SPORT
`````

**marca**
`````bash
Honda
``````

**status**
``````bash
MANUTENCAO
``````

**patioId**
`````bash
1
``````

**tagId**
`````bash
1
``````





