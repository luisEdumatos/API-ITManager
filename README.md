# API ITManager
API para sistema de gestão de TI terceirizada

## End-Points
### Cliente
- .../client/ (Todos clientes) -> Prontos: POST
- .../clientes/:id/ (Informações gerais do cliente)
- .../clientes/:id/colaboradores/ (Colaboradores de cliente)
- .../clientes/:id/estacoes/ (Estacoes de trabalho do cliente)
- .../clientes/:id/fornecedores/ (Fornecedores relacionados ao cliente)
- .../clientes/:id/infraestrutura/ (Infraestrutura do cliente)
- .../clientes/:id/enderecos/ (Enderecos do cliente)

### Colaborador
- .../clientes/:id/colaboradores/ (Todos colaboradores do cliente) -> PRontos: POST (Obs: Alterar rota do endpoint)
- .../clientes/:id/colaboradores/:id (Informações gerais do colaborador)
- .../clientes/:id/colaboradores/:id/credenciais/ (Credenciais do colaborador)
- .../clientes/:id/colaboradores/:id/estacoes/ (Estações do colaborador) 
- .../clientes/:id/ (Retorno ao cliente que pertence o colaborador)

### Estações
- .../clientes/:id/estacoes/ (Todas estações do cliente)
- .../clientes/:id/estacoes/:id/ (Informações gerais da estação)
- .../clientes/:id/estacoes/:id/licencas/ (Licenças da estações)
- .../clientes/:id/estacoes/:id/credenciais/ (Credenciais da estação)
- .../clientes/:id/estacoes/:id/colaboradores/ (Colaboradores da estação)
- .../clientes/:id/ (Retorno ao cliente que pertence a estação)

### Credenciais
- .../clientes/:id/estacoes/:id/credenciais/ (Credenciais da estação)
- .../clientes/:id/estacoes/:id/credenciais/:id/ (Credencial especifica da estação)
- .../clientes/:id/colaboradores/:id/credenciais/ (Credenciais do colaborador)
- .../clientes/:id/colaboradores/:id/credenciais/:id/ (Credencial especifica do colaborador)

### Fornecedor
- .../fornecedores/ (Todos fornecedores)
- .../fornecedores/:id/enderecos/ (Enderecos do fornecedor)
- .../fornecedores/:id/ (Informações gerais do fornecedor)
- .../fornecedores/:id/provedores/ (Se fornecedor é provedor de internet)
- .../fornecedores/:id/licencas/ (Se fornecedor é provedor de licencas)
- .../fornecedores/:id/clientes/ (Clientes atendidos pelo fornecedor) 

### Infraestrutura
- .../clientes/:id/infraestrutura/:id/ (Informações gerais da infraestrutura)
- .../clientes/:id/infraestrutura/:id/equipamentos/ (Equipamentos da infraestrutura)

### Equipamento
- .../clientes/:id/infraestrutura/:id/equipamentos/:id (Informações do equipamento)
- .../clientes/:id/infraestrutura/:id/equipamentos/:id/credenciais (Credenciais do equipamento)

### Provedor
- .../fornecedores/:id/provedores/:id/ (Informações da internet provida) 

### Licença
- .../fornecedores/:id/licencas/:id/ (Informações da licença)






