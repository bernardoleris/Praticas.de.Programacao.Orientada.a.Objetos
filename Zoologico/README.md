[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=11262166&assignment_repo_type=AssignmentRepo)

# Exercício Zoológico

## Parte 1 - Herança

Nesta primeira parte vamos exercitar os **conceitos básicos de herança** e ver como eles nos ajudam a **evitar duplicação de código** nas classes que **formam** uma hierarquia de herança.

### Passo 1.1 - Modelar as classes

_Atenção:_ Este passo não envolve implementação; deve ser respondido aqui no próprio arquivo README.

Suponha que queiramos criar um sistema para um Zoológico que precise tratar as seguintes espécies de animais: tigre, chimpanzé, avestruz e tucano.

- Sabe-se que todos os animais têm as seguintes características: um nome, uma espécie, uma determinada quantidade de patas e um som característico (tecnicamente, sua onomatopeia, ex: se fosse um gato, seria “miau”, se fosse uma galinha: “cocorico”).
- Além disso, os animais que possuem pelo têm a informação da cor do seu pelo; já os animais que voam têm a informação se voam bem ou voam mal.

O sistema deve possuir:

- Métodos para consulta de cada atributo de todos os animais.
- Método que retorne uma string com a descrição resumida de um animal, conforme os exemplos abaixo:
  - `Simba é um(a) tigre`.
  - `Blue é um(a) tucano`.
- Método que retorne uma string com a descrição completa de um animal, como a do exemplo abaixo:
  - `Simba é um(a) tigre que faz grrrr e tem pelo laranja`.
  - `Blue é um(a) tucano que faz tuc-tuc e voa bem`.

Neste passo você deve apenas **modelar as classes necessárias** para representar todos os animais utilizando o conceito de herança:

- Ou seja, você **deverá definir** apenas os nomes: de cada classe, dos seus atributos e seus métodos.
- Para isso: **altere esse arquivo README** com a sua definição das classes (no trecho abaixo) e **faça um commit**.

Dicas:

- Avalie cuidadosamente os atributos a serem definidos, evitando replicação de código.
- Lembre-se que suas classes não devem permitir que um programador crie objetos de animais que não façam sentido.
  - Por exemplo: não faz sentido criar um avestruz com três pernas, ou que faça "au au".
  - Portanto, avalie bem como os atributos devem ser inicializados (e quais classes precisam ser criadas).
- Uma classe que representa uma espécie de animal deve ter nome no singular, já que um objeto dessa classe representará um único animal.
  - Por exemplo, uma classe para representar um chimpanzé deveria se chamar `Chimpanze`, e não `Chimpanzes`.

> Escreva aqui sua resposta
> Classe Animal - Atributos: nome, especie, qtdePatas, som - Metodos: getters, getDescricaoResumida, getDescricaoCompleta.
> Classe SerPeludo(herda de Animal) - Atributos: corPelo - Metodos: getters, getDescricaoCompleta(sobrescrito).
> Classe SerVoador(herda de Animal) - Atributos: qualidadeVoo - Metodos: getters, getDescricaoCompleta(sobrescrito).
> Classe Tigre(herda de SerPeludo)- Atributos: - Metodos:
> Classe Chimpanze(herda de SerPeludo)- Atributos: - Metodos:
> Classe Tucano(herda de SerVoador)- Atributos: - Metodos:
> Classe Avestruz(herda de SerVoador) - Atributos: - Metodos:

> Exemplo de formato:
>
> Classe A (herda de B) - Atributos: atr1, atr2 e atr3 - Métodos: metodoA, metodoB e metodoC

### Passo 1.2 - Implementar a Hierarquia de Herança

_Dica: Antes de começar esse passo, valide a sua modelagem do passo anterior com o professor.
Isso poderá evitar retrabalho na implementação._

Neste passo você deve **implementar todas as classes** necessárias para representar os animais, e que você definiu no passo anterior.

Dicas:

- Não crie todas as classes de uma vez. Comece criando apenas o necessário para ter objetos de uma única espécie.
- Em seguida, na classe que tem o método `main`, crie um objeto daquela espécie e chame alguns métodos diretamente no código para testar sua implementação.
- Depois de validar e garantir que está tudo certo com a primeira classe, aí sim crie as classes para as demais espécies.

Não se esqueça de fazer um commit ao terminar esse passo.

### Passo 1.3 - Criar a classe Zoologico

**Crie uma classe chamada `Zoologico`** que gerencie os objetos de cada espécie.

A classe deverá ter:

- Uma coleção (`ArrayList` ou `HashMap`) para cada espécie de animal.
  - Obs.: mesmo que já conheça polimorfismo, por objetivos didáticos, é importante que crie coleções separadas neste exercício.
- Métodos para adicionar animais de cada espécie de animal.

  - Os métodos devem receber os dados necessários e dentro deles é que os objetos serão criados.

- Método que recebe o nome de um animal e retorna sua descrição completa.
- Método que lista a descrição resumida de todos os animais do zoológico.
- Método que lista a descrição completa de todos os animais do zoológico.

O código inicial de uma classe `InterfaceUsuario`, que implementa o menu de opções para o usuário do programa, já foi fornecido para você.
Você deverá **alterar a classe `InterfaceUsuario`** para que ela chame os métodos da sua classe `Zoológico` (e obtenha dados do usuário, quando necessário).

Teste suas implementações!

Ao final, não se esqueça de fazer um commit e sincronizar suas alterações.

## Parte 2 - Diagrama de Classes UML

Vamos agora aprender a criar **diagramas de classes UML** para nossos projetos.

**Importante**: nesse exercício nós vamos fazer o inverso do que seria ideal, pois nós vamos criar um Diagrama de Classes depois de já ter implementado o código.
Vamos fazer isso para que seja mais simples entender como fazer um diagrama.
Mas o correto na verdade seria primeiro pensar na modelagem e fazer o Diagrama de Classes para depois implementar o código.

### Passo 2.1 - Diagrama de Classes Simplificado

Crie um diagrama de classes simplificado para o projeto do Zoológico (veja dicas sobre como fazer mais abaixo):

- Neste tipo de diagrama, basta representar as classes (não é necessário representar atributos e nem métodos).

```mermaid
classDiagram
    App <-- InterfaceUsuario
    InterfaceUsuario <-- Zoologico
    Zoologico <-- Animal
    Animal <|-- SerPeludo
    Animal <|-- SerVoador
    SerPeludo <|-- Chimpanze
    SerPeludo <|-- Tigre
    SerVoador <|-- Tucano
    SerVoador <|-- Avestruz
```

### Passo 2.2 - Diagrama de Classes Completo

_Dica: valide com o professor o diagrama do passo anterior antes de fazer o diagrama completo_

Crie agora um diagrama de classe completo, incluindo os atributos e métodos de todas as classes.

```mermaid
classDiagram
    App <-- InterfaceUsuario
    InterfaceUsuario <-- Zoologico
    Zoologico <-- Animal
    Animal <|-- SerPeludo
    Animal <|-- SerVoador
    SerPeludo <|-- Chimpanze
    SerPeludo <|-- Tigre
    SerVoador <|-- Tucano
    SerVoador <|-- Avestruz
    class InterfaceUsuario{
        -Scanner entrada
        -Zoologico zoologico
        +InterfaceUsuario()
        +void executar()
        +void exibirMenu()
        +void tratarMenu(int opcao)
        +String pedirString(String instrucao)
        +void CadastrarAnimal()
        +void descreverAnimal()
        +void listarAnimais()
        +void listarAnimaisCompleto()
    }
    class Zoologico{
        -ArrayList<Avestruz>
        -ArrayList<Tigre>
        -ArrayList<Tucano>
        -ArrayList<Chimpanze>
        +void adicionarAvestruz(String nome, String qualidadeVoo)
        +void adicionarTigre(String nome, String corPelo)
        +void adicionarTucano(String nome, String qualidadeVoo)
        +void adicionarChimpanze(String nome, String corPelo)
        +void listarDescricaoResumida()
        +void listarDescricaoCompleta()
        +void void retornaDescricao(String nome)
    }
    class Animal{
        -String nome
        -String especie
        -String som
        -int qtdePatas
        +Animal(String nome, String especie, String som, int qtdePatas)
        +String getDescricaoResumida()
        +String getDescricaoCompleta()
        +String getNome()
        +String getEspecie()
        +String getSom()
        +int getQtdePatas()
    }
    class SerPeludo{
        -String corPelo
        +SerPeludo(String nome, String especie, String som, int qtdePatas, String corPelo)
        +String getDescricaoCompleta()
        +String getCorPelo()
    }
    class SerVoador{
        -String qualidadeVoo
        +SerVoador(String nome, String especie, String som, int qtdePatas, String qualidadeVoo)
        +String getDescricaoCompleta()
        +String getQualidadeVoo()
    }
    class Tucano{
        +Tucano(String nome, String qualidadeVoo)
    }
    class Tigre{
        +Tigre(String nome, String corPelo)
    }
    class Chimpanze{
        +Chimpanze(String nome, String corPelo)
    }
    class Avestruz{
        +Avestruz(String nome, String qualidadeVoo)
    }
    class App{
        +static void main(String[] args)
    }
```

#### Dicas para fazer o Diagrama de Classes UML

Para fazer o diagrama você pode optar por usar:

- um software qualquer (como o `Dia`).
- ou um algum editor online como o https://www.diagrameditor.com/
- ou ainda usar o `Mermaid` que permite fazer o diagrama aqui mesmo, diretamente no arquivo README do projeto.

Caso use um software ou um editor online, exporte a modelagem para uma imagem no formato `png` e coloque o arquivo em uma pasta `doc` dentro da pasta principal do projeto.

Já o `Mermaid` é interessante pois o GitHub possui uma integração com ele que permite exibir um diagrama de classes UML em um arquivo Markdown, como este arquivo README.
Para isso, basta "escrever" o diagrama de classes usando a [sintaxe](https://mermaid.js.org/syntax/classDiagram.html) do `Mermaid`, como no exemplo abaixo.

> Obs.: Para que você consiga visualizar o Diagrama de Classes dentro do VS Code, instale a extensão `Markdown Preview Mermaid Support` e acesse a visualização do arquivo README.md (atalho Ctrl+Shift+V).

```mermaid
classDiagram
    App --> Classe A
    ClasseA *-- ClasseB
    ClasseA o-- ClasseC
    ClasseB -- ClasseD
    class ClasseA{
        -atributoInteiro: int
        +ClasseA(int)
        +metodoX() boolean
        +metodoY(String) void
    }
```

## Parte 3 - Polimorfismo

Nesta terceira parte vamos exercitar **os conceitos de polimorfismo** e perceber como eles nos ajudam a **evitar duplicação** de código nas classes que **utilizam** classes de uma hierarquia de herança.

### Passo 3.1 - Experimentando Polimorfismo 1

Vamos começar exercitando nosso entendimento sobre os conceitos de polimorfismo.
Para isso, crie uma classe chamada `Teste` com um método `main` e, dentro dele, faça o seguinte:

- Declare uma variável chamada `animal` do tipo `Animal` e atribua a ela um objeto da classe `Tigre`.
- Chame o método `getNome` usando a variável `animal`.
- Agora, usando a mesma variável `animal`, atribua a ela um objeto da classe `Tucano`.
- Chame o método `getNome` usando a variável criada.

Explique abaixo, da forma mais completa possível, como é possível que a mesma variável `animal` possa ser usada para chamar métodos de objetos de classes diferentes.

> Isso é possível devido ao polimorfismo, que é a capacidade de um objeto poder ser referenciado de várias formas, em vista disso, conforme o teste realizado, a variável animal é declarada como do tipo Animal, o que significa que ela pode armazenar qualquer objeto que seja uma instância da classe Animal ou de suas subclasses (Tigre, Tucano,Chimpanze, Avestruz, SerPeludo, SerVoador), em que uma variável de um tipo mais genérico (superclasse) pode receber uma instância de um tipo mais específico (subclasse).

Ao terminar, faça um commit com as alterações da classe `Teste` e as alterações neste arquivo README.

### Passo 3.2 - Experimentando Polimorfismo 2

Agora, altere o método `main` da classe `Teste` e faça o seguinte:

- Crie um método chamado `exibirDescricaoCompleta` que recebe uma variável do tipo `Animal`.
  - Dentro dele, chame o método de descrição completa usando o parâmetro `animal`.
  - E exiba o resultado na tela.
- No método `main`, chame o método `exibirDescricaoCompleta` passando um objeto da classe `Tigre`.

O que é exibido?

> É exibido a descrição completa do tigre que foi passado por parâmetro.

O método de descrição completa chamado inicialmente pertence a qual classe?

> Pertence à classe SerPeludo, que herda de Animal.

Agora chame o método `exibirDescricaoCompleta` passando um objeto da classe `Avestruz`.

O que é exibido?

> É exibido a descrição completa do avestruz que foi passado por parâmetro.

O método de descrição completa chamado inicialmente pertence a qual classe?

> Pertence à classe SerVoador, que herda de Animal.

Explique, da forma mais completa possível, como o mesmo trecho de código (método `exibirDescricaoCompleta`) pode ser usado para chamar métodos de classes diferentes.

> Devido ao polimorfimo, as instâncias das classes que herdam da superclasse, as quais são Tigre, Tucano,Chimpanze, Avestruz, SerPeludo, SerVoador, são capazes de ser recebidas por uma variável de tipo estático da classe mais genérica, que no caso é a Animal. Ou seja, passando por parâmetro qualquer objeto da classe que seja da própria classe requisitada ou qualquer um que seja de uma classe que tenha relação de herança com a classse principal, o compilador irá reconhecer e fazer o tratamento usual. Em Java, o tipo estático de uma variável é determinado em tempo de compilação e está associado ao tipo declarado da variável, tendo como exemplo se declararmos uma variável com o tipo Animal, em que a variável terá um tipo estático Animal. No entanto, o tipo dinâmico refere-se ao tipo real do objeto que a variável armazena em tempo de execução. Quando um objeto é criado a partir de uma classe que herda da superclasse Animal, como Tigre, Tucano, Chimpanzé, Avestruz, SerPeludo ou SerVoador, ele é considerado uma instância do tipo estático Animal e também tem um tipo dinâmico correspondente à classe específica do objeto.A JVM trata essa questão usando o conceito de ligação dinâmica (dynamic binding) durante a execução do programa. Isso significa que o método chamado em tempo de execução é determinado com base no tipo dinâmico do objeto, e não no tipo estático da variável. Quando um método é chamado em um objeto através de uma variável de tipo Animal, a JVM verifica o tipo real do objeto em tempo de execução e procura pelo método correspondente nesse tipo específico. Se o método estiver presente na classe específica do objeto, ele será executado. Caso contrário, a JVM procurará na hierarquia de classes até encontrar uma implementação do método.

Ao terminar, faça um novo commit com as alterações (na classe Teste e neste arquivo README).

### Passo 3.3 - Usando Polimorfismo no Projeto Zoologico

Vamos agora perceber como o polimorfismo ajuda a reduzir a replicação de código.

Para isso, você deve alterar a classe `Zoologico`:

- Substitua as coleções de animais de cada espécie por uma única coleção (`ArrayList` ou `HashMap`) com todos os animais.
- E, devido a essa modificação, implemente as alterações necessárias nos métodos da classe.
- **Atenção**: deixe o código anterior comentado para que o professo consiga corrigir a Parte 1 e a Parte 3 do seu exercício.

Do ponto de vista do usuário, seu programa deverá continuar funcionando da mesma forma que você havia feito no exercício da aula anterior.
Mas repare que agora seu projeto terá um _Design_ de classes melhor.

Teste suas alterações!

Ao final, faça um novo commit no seu repositório.

### Passo 3.4 - Identificando o uso de Polimorfismo

Para todas as perguntas abaixo, você deve indicar exatamente a classe e o número da linha de código onde cada situação acontece.

1. Indique pelo menos uma **variável polimórfica** utilizada no seu código e explique porque ela é uma variável polimórfica.

> Nome da classe:
> Zoologico
> Número da linha:
> 14
> Nome da variável:
> animais
> Explicação: A variável "animais" é polimórfica porque é declarada como uma lista (ArrayList) do tipo Animal, que é a superclasse. Isso significa que a variável pode armazenar objetos de qualquer classe que seja uma subclasse de Animal. Sendo a classe Avestruz uma subclasse de Animal, ao criar uma instância de Avestruz chamada "avestruz" e adicioná-la à lista "animais" usando o método "animais.add(avestruz)", ocorre o polimorfismo, que irá permitir tratar objetos de diferentes classes de forma uniforme, desde que essas classes sejam subtipos da superclasse. 

2. Identifique algum ponto no código onde está sendo usado o **princípio da substituição** e explique o que é este princípio.

> Nome da classe:
> Zoologico
> Número da linha:
> 19
> Explicação: O Princípio de Substituição de Liskov diz que objetos podem ser substituídos por seus subtipos sem que isso afete a execução correta do programa. No código, um objeto da classe Avestruz substituiu um objeto da classe Animal.

3. Identifique algum ponto no código onde uma variável tem **tipo estático diferente de seu tipo dinâmico** (indique quais são os tipos estático e dinâmico da variável neste ponto).

> Nome da classe:
> Teste
> Número da linha:
> 3
> Nome da variável:
> animal
> Tipo estático:
> variável animal é do tipo Animal
> Tipo dinâmico: variável animal tem o tipo dinâmico Tigre

4. Identifique onde ocorre uma chamada de método na qual seja utilizado o conceito de **polimorfismo de método**.

> Nome da classe:
> Zoologico
> Número da linha: 107

### Passo 3.5 - Atualização do Diagrama de Classes

Faça as alterações necessárias nos diagramas de classes para que eles representem o seu código alterado após o passo 2.3.

Obs.: não é necessário incluir a classe `Teste`.

```mermaid
classDiagram
    App --> InterfaceUsuario
    InterfaceUsuario --> Zoologico
    Zoologico --> Animal
    Animal --|> SerPeludo
    Animal --|> SerVoador
    SerPeludo --|> Chimpanze
    SerPeludo --|> Tigre
    SerVoador --|> Tucano
    SerVoador --|> Avestruz
    class InterfaceUsuario{
        -Scanner entrada
        -Zoologico zoologico
        +InterfaceUsuario()
        +void executar()
        +void exibirMenu()
        +void tratarMenu()
        +String pedirString()
        +void CadastrarAnimal()
        +void descreverAnimal()
        +void listarAnimais()
        +void listarAnimaisCompleto()
    }
    class Zoologico{
        -ArrayList<Animais>
        -Avestruz avestruz
        -Tigre tigre
        -Tucano tucano
        -Chimpanze chimpanze
        +void adicionarAvestruz()
        +void adicionarTigre()
        +void adicionarTucano()
        +void adicionarChimpanze()
        +void listarDescricaoResumidaAnimais()
        +void listarDescricaoCompletaAnimais()
        +void void retornaDescricao()
    }
    class Animal{
        -String nome
        -String especie
        -String som
        -int qtdePatas
        +Animal
        +String getDescricaoResumida()
        +String getDescricaoCompleta()
        +String getNome()
        +String getEspecie()
        +String getSom()
        +int getQtdePatas()
    }
    class SerPeludo{
        -String corPelo
        +SerPeludo()
        +String getDescricaoCompleta()
        +String getCorPelo()
    }
    class SerVoador{
        -String qualidadeVoo
        +SerVoador
        +String getDescricaoCompleta()
        +String getQualidadeVoo()
    }
    class Tucano{
        +Tucano()
    }
    class Tigre{
        +Tigre()
    }
    class Chimpanze{
        +Chimpanze()
    }
    class Avestruz{
        +Avestruz()
    }
    class App{
        +static void main
    }
```

> Dica: Cuidado com linhas se cruzando no diagrama de classes, pois podem confundir os relacionamentos.
