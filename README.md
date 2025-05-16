Grupo: 
Guilherme Camasmie Laiber de Jesus - 554894, 
Pedro Manzo Yokoo - 556115, 
Fernando Fernandes Prado - 557982


# 📦 Sprint1 - API de Java

Este projeto é uma API REST desenvolvida com **Spring Boot** para o gerenciamento e monitoramento de motos. Ela permite operações típicas como cadastro, listagem e controle de dados relacionados.

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Gradle
- Spring Data JPA
- Oracle Database
- Swagger/OpenAPI
- ModelMapper
- Spring Cache

## ⚙️ Como Executar o Projeto

### Passos

1. Clone o repositório ou extraia o conteúdo do `.zip`
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


3. Entre na main do projeto, **Sprint1Application**, e rode o programa

## 🧭 Como Utilizar a API via Swagger
A API pode ser acessada via Swagger para fazer os testes do projeto. Disponível após subir o projeto:

🔗 Acesse:

http://localhost:8080/swagger-ui/index.html#/

## 🗂️ Ordem de Criação dos Recursos
Para que a API funcione corretamente, recomenda-se seguir esta ordem ao cadastrar os dados. 
**Nos POST já vão estar disponíveis exemplos que podem ser usados na hora da criação**:

📍 Filial

- Endpoint: POST /api/filiais

Crie uma nova filial com os dados como nome, cidade, etc.

- Endpoint: GET /api/filiais

Pega as filiais por meio de páginas. Ao testar esse GET, remova o "string" dentro do **sort**

🚧 Pátio

- Endpoint: POST /api/patios

Cada pátio deve estar vinculado a uma filial existente.

- Endpoint: GET /api/patios

Pega os patios por meio de páginas. Ao testar esse GET, remova o "string" dentro do **sort**


🏍️ Moto

- Endpoint: POST /api/motos

Cada moto deve estar associada a um pátio existente, que por sua vez está vinculado a uma filial.

- Endpoint: GET /api/patios

Pega as motos por meio de páginas. Ao testar esse GET, remova o "string" dentro do **sort**


## ✅ Validações dos Dados
O projeto aplica diversas validações nos campos recebidos pelas requisições, garantindo integridade e consistência dos dados enviados. As validações são feitas por meio de anotações da Bean Validation (javax.validation.constraints) nas classes de entrada (DTOs), como FilialRequest, PatioRequest e MotoRequest.

🔒 Validações aplicadas:
📌 Filial
- nome: obrigatório (@NotBlank), até 60 caracteres (@Size), permite letras, números, espaços e traços (@Pattern)

- cidade: obrigatório (@NotBlank), apenas letras e espaços (@Pattern)

- pais: obrigatório (@NotBlank), apenas letras e espaços (@Pattern)

📌 Pátio
- nome: obrigatório (@NotBlank), de 3 a 40 caracteres (@Size), apenas letras, números, espaços e traços (@Pattern)

- largura: obrigatório (@NotNull), entre 5.0 e 500.0 metros (@DecimalMin/@DecimalMax)

- comprimento: obrigatório (@NotNull), entre 5.0 e 1000.0 metros (@DecimalMin/@DecimalMax)

- filialId: obrigatório (@NotNull), deve ser positivo (@Positive)

📌 Moto
- placa: obrigatório (@NotBlank), deve seguir o padrão Mercosul: ABC1D23 (@Pattern)

- modelo: obrigatório (@NotNull), deve ser um dos valores do enum MotoModelo

- marca: obrigatório (@NotBlank), apenas letras e espaços (@Pattern)

- status: obrigatório (@NotNull), deve ser um dos valores do enum MotoStatus

- patioId: obrigatório (@NotNull), deve ser positivo (@Positive)

- tagId: obrigatório (@NotNull), deve ser positivo (@Positive)











