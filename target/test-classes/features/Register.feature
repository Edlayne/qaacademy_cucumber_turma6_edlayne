  #language:pt
  #sintaxe gherkin

  @Register
  Funcionalidade: Como usuario do site Register
    Eu desejo realizar um cadastro
  Para validar se foi cadastrado com sucesso

  @teste001
  Cenario: Validar cadastro com sucesso no site Register
    Dado que eu acesso o site Register
    Quando preencho nome "Edlayne" e sobrenome: "Morais"
    E preencho campo endereço com o valor "Tão Tão Distante"
    E preencho campo email com o valor "edlayne.morais@gmail.com"
    E preencho campo telefone com o valor "11984736626"
    E clico no checkbox FeMale, clico no checkbox Movies
    E seleciono a Skills "Java"
    E seleciono um country
    E seleciono o ano "1989", o mes "March", e o dia "10"



