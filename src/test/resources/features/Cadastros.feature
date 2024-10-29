#language: pt
  Funcionalidade: Cadastro de Usuários
    Como usuário da API
    Quero cadastrar um novo usuário
    para que o usuário seja salvo corretamente no sistema
  Cenário: Cadastro bem-sucedido de usuário:
    Dado que eu tenha os seguintes dados do usuário:
      | campo      | valor                |
      | nome       | maria da silva       |
      | email      | mariasilva@gmail.com |
      | senha      | 1234567              |
      | role       | ADMIN                |
    Quando eu enviar a requisição para o endpoint "/auth/register" de usuários
    Então o status code da resposta deve ser 201
