### Domain Driven Design in Java
#### This is small project for reviewing Domain Driven Design concepts such as: Ubiquitous Language, Aggregates, Events and more. 
- Reference - it´s based on Alura course: https://cursos.alura.com.br/course/java-domain-driven-design-conceitos
- it´s a continuation of: https://github.com/marciodegan/clean-architecture-school-example
##
#### General notes:
- "Desenvolver software orientado ao domínio"
- Como deixar o explicito os conceitos do domínio do software? Geralmente o que fica explicito no código é a questão da tecnologia.

### Como deveria ser:
- Ficha Cadastral do paciente
- Solicitação de exame médico
- Consulta de laudos
- Impressão de receitas médicas
- Busca de pacientes pelo CPF
####
- Os termos em destaque são termos relacionados ao domínio da aplicação.
- Facilmente se percebe a que a aplicação se trata, exemplo, de uma clínica ou hospital.

## MAS COMO É NA PRÁTICA:
- Padrão MVC - pra separar as camadas do projeto
- Requisições assíncronas
- Data Access Object
- Spring Boot
- Ajax com JQuery
- Identidade Visual
####
- O foco é todo na tecnologia em questões de biblitecas, padrões, frameworks, separação em camadas, performance, requisitos não funcionais.
- O foco é totalmente em tecnologia que não fala sobre o que é a aplicação. É uma aplicação hospitalar, financeira, bancária? Não é possivel identificar.
- Para sistemas complexos, isso dificulta a manutenção, para novos entrantes no projeto, 

### PRINCIPAIS CONCEITOS DDD:
- Foco no domínio
- Linguagem Ubíqua - linguagem universal focada no domínio da aplicacao. um linguagem comum para facilitar comunicação entre a equipe técnica e a equipe especialista do domínio da aplicação.
- Contexto delimitado 
- Blocos de Construção

#### Building blocks ou Blocos de construção:
- Entity
- Value Object
- Repository
- Factory
- Service

#### Linguagem Ubiqua 
- Exemplos no código => classe Indicação. Indicante ao invés do indicador, pois o termo utilizado pelo time de dominio é o indicante. Sempre conversar usando os termos falados pelos especialista do negocio. 

<img src="https://user-images.githubusercontent.com/58707950/140654634-6315f3ef-3bfc-406b-ac63-0848d9350479.png" width="30%"></img> 
<img src="https://user-images.githubusercontent.com/58707950/140654633-745e44f4-a19f-4823-b4f1-a8f43087cb30.png" width="30%"></img>


#### Invariantes
- É uma regra de negócio que deve sempre ser verdadeira para os objetos serem válidos.
- Se um aluno tiver mais do que 2 telefones em nosso sistema, essa regra foi violada, logo, o Aluno estará em um estado inválido. Invariantes nada mais são do que regras de negócio que precisam ser verificadas para garantir sua consistência.


#### AGGREGATE ROOT
- Quando temos uma classe funcionando como aggregate root (ex.: Student), ela que deve manter e fazer todo o controle de acesso as informações (como valueObjects).
- Evita-se duplicação de código.
- Usando o exemplo do código: evita que alguém de fora da classe (ex.: Student), adicione um telefone (e ainda com validação erradas). 
- Então toda a manipulação dos Phones deve ser feita pela classe Student que é a AGGREGATE ROOT.
- REGRA: Mexeu com Aggregate root, cuidar com as informações que carrega para não ferir a consistencia.
- MORE on Aggregate - Martin Fowler´s: https://martinfowler.com/bliki/DDD_Aggregate.html

#### EVENTOS DE DOMÍNIO
- Usando o exemplo do código: RegisterStudent é um evento.
- Pode ter um evento que registra um log / faz alguma outra lógica / enviar email.
- Qual a motivação para termos eventos de domínio em nossa aplicação? Poder programar nossa aplicação para reagir a eventos de forma flexível. Trabalhando com eventos, o mesmo evento pode gerar várias ações, o que nos dá muita flexibilidade.

#### CONTEXTOS DELIMITADOS / BOUNDED CONTEXTS
- A aplicação terá um contexto de Gamificação que ficará separado do contexto do domínio. 
- Exemplo: gamificação cuida só do contexto de selos, pontos; não precisando saber das regras do contexto academico por exemplo -> regras de matrícula do aluno.
- Se transformam em dois microserviços desacoplados.
- Existe um acoplamento por exemplo com CPF que é do contexto "academico", e é necessário no contexto "gamificacao", pois classe Selo depende de CPF.
- Assim não é possível extrair totalmente gamificacao e o deixa-lo isolado.
- O ideal é buscar uma alternativa ===> MAPAS DE CONTEXTO.
- ver sobre módulos do java9 e módulos do maven
- MORE: https://martinfowler.com/bliki/BoundedContext.html

<img src="https://user-images.githubusercontent.com/58707950/140791755-db32924f-8101-45ce-b0c0-c9c22fd88c77.png" width="23%"></img> <img src="https://user-images.githubusercontent.com/58707950/140791758-84108c29-7842-4850-adf7-13ac3aee75cd.png" width="23%"></img> <img src="https://user-images.githubusercontent.com/58707950/140791760-33e6ee84-2922-4e45-9911-69537e0fe322.png" width="23%"></img> <img src="https://user-images.githubusercontent.com/58707950/140791761-66ad1da0-460a-4d81-a934-cc588a794d36.png" width="23%"></img> 
