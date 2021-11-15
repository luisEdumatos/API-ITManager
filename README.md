# API ITManager
API para sistema de gestão de TI terceirizada

## End-Points
### Cliente
- .../clientes/ (Todos clientes)
- .../clientes/:id/ (Informações gerais do cliente)
- .../clientes/:id/colaboradores (Colaboradores de cliente)
- .../clientes/:id/estacoes (Estacoes de trabalho do cliente)
- .../clientes/:id/fornecedores (Fornecedores relacionados ao cliente)
- .../clientes/:id/infraestrutura (Infraestrutura do cliente)
- .../clientes/:id/enderecos (Enderecos do cliente)

### Colaborador
- .../clientes/:id/colaboradores/ (Todos colaboradores do cliente)
- .../clientes/:id/colaboradores/:id (Informações gerais do colaborador)
- .../clientes/:id/colaboradores/:id/credenciais (Credenciais do colaborador)
- .../clientes/:id/colaboradores/:id/estacoes (Estacoes do colaborador) 
- .../clientes/:id (Retorno ao cliente que pertence o colaborador)



