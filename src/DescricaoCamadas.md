# Descrição das Camadas do Projeto

## Camada `main`
- **Responsabilidade**: Contém o ponto de entrada do aplicativo.
- **Funcionalidade**:
  - A classe `Main` é responsável por iniciar a aplicação.
  - Configura dependências e inicializa o contexto da aplicação.
- **Interação**:
  - Não depende diretamente de nenhuma outra camada, configura o estado inicial do sistema.

## Camada `controller`
- **Responsabilidade**: Controlar a interação entre a aplicação e o usuário/cliente.
- **Funcionalidade**:
  - Recebe solicitações.
  - Invoca métodos da camada de serviços para tratar as requisições.
  - Retorna respostas para o cliente.
- **Classes principais**:
  - `CrudController`: Gerencia operações CRUD.
  - `PaymentController`: Gerencia pagamentos.
  - `ProductController`: Gerencia produtos.
- **Interação**:
  - **Chama**: a camada de **serviços** para realizar a lógica de negócios.
  - **Não acessa diretamente**: a camada de **persistência** ou **domínio**, conforme as restrições do Decycle.

## Camada `services`
- **Responsabilidade**: Implementar a lógica de negócios.
- **Funcionalidade**:
  - Contém a lógica central para processar os dados.
  - Orquestra interações entre controladores e repositórios.
  - Aplica regras de negócios e validações.
- **Classes principais**:
  - `CustomerService`: Gerencia operações relacionadas ao cliente.
  - `IOrderService`: Define uma interface para operações de pedidos.
  - `OrderService`: Implementa a lógica de gerenciamento de pedidos.
  - `Payment`: Contém as lógicas de pagamento.
  - `Product`: Contém a lógicas dos produtos.
- **Interação**:
  - **Chama**: a camada de **persistência** para acessar ou manipular os dados armazenados.
  - **Pode acessar diretamente**: classes da camada **domínio** para usar objetos de domínio ou regras.

## Camada `domain`
- **Responsabilidade**: Representar os objetos de domínio e suas regras.
- **Funcionalidade**:
  - Define os principais objetos e conceitos do negócio, como `Customer`, `Order`, e `OrderDTO`.
  - Contém validações e regras simples de domínio.
- **Classes principais**:
  - `Customer` e `Order`: Representam entidades principais.
  - `CustomerDTO` e `OrderDTO`: São usados para transferência de dados.
- **Interação**:
  - **Usada por**: as camadas **serviços** e **persistência**.
  - **Não chama diretamente**: controladores ou repositórios.

## Camada `persistence`
- **Responsabilidade**: Gerenciar o acesso aos dados persistidos.
- **Funcionalidade**:
  - Contém repositórios que interagem com o banco de dados.
  - Fornece métodos para CRUD e consultas específicas.
- **Classes principais**:
  - `CustomerRepository`: Gerencia persistência de clientes.
  - `OrderRepository`: Gerencia persistência de pedidos.
- **Interação**:
  - **Chamada pela camada de serviços** para realizar operações de dados.
  - **Não acessa diretamente**: controladores ou a camada `main`.

## Interações entre as Camadas
As interações respeitam os seguintes princípios, com base nas restrições do **Decycle Maven Plugin**:

1. **Controladores**:
   - Podem chamar **serviços**.
   - Não interagem diretamente com **persistência** ou **domínio**.

2. **Serviços**:
   - Podem chamar **repositórios** e interagir com **domínio**.
   - Podem ser chamados pelos **controladores**.

3. **Domínio**:
   - Usado como base para troca de dados e lógica de negócio.
   - Não realiza chamadas ativas para outras camadas.

4. **Persistência**:
   - Chamado pelos **serviços**.
   - Não interage com outras camadas diretamente.

5. **Main**:
   - Atua como o ponto de entrada e pode inicializar configurações gerais, como criação de serviços ou instâncias iniciais.
