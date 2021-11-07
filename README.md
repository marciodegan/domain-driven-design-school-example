### This is small project to demonstrate Clean Architecture based on Alura course: https://cursos.alura.com.br/course/java-clean-architecture

#### General notes:
- Componentes do software e suas relações
- Infraestrutura do software
- Estrutura e design do código
- Suporte aos requisitos de negócio
- Simplificar evoluções no software
- Arquitetura também está fortemente relacionada com os Requisitos não funcionais do software: Performance, Escalabilidade, Disponibilidade, Confiabilidade, Segurança, Manutenibilidade e Extensibilidade.
- More: https://resources.sei.cmu.edu/library/asset-view.cfm?assetid=513807
#### 
- Arquitetura em Camadas: MVC -> User Interface, Business (regras de negócio), Data(persistencia de dados)
####
- Onion Architecture: 
####
- Clean Architecture: Isolar o codigo de dominio da aplicacao, pra fazer a ponte é usado inversão de dependencias atraves de interfaces.
- Favorece boas práticas de OO
- Codigo de dominio com alta "testabilidade"
- Independencia de frameworks e detalhes de infraestrutura
####
- Screaming Architecture: https://blog.cleancoder.com/uncle-bob/2011/09/30/Screaming-Architecture.html
- o nosso domínio (camada mais interna) é independente de qualquer detalhe exterior. Nossa aplicação depende apenas do nosso domínio, e não conhece detalhes de infraestrutura. A camada de infraestrutura apoia as camadas mais interiores.
####
- Ao desenvolver um sistema complexo, o domínio deve ser o foco. Por isso, ele é a camada central dos padrões de arquitetura.
- Web, frameworks e mecanismos de persistência (como bancos de dados) são meros detalhes. São ferramentas para executar suas regras de negócio.
- Executar a sua aplicação pela CLI deve ser tão fácil quanto através de uma API. O mesmo vale para uma interface Web.
- Oconceito de modelarmos a nossa aplicação pensando primeiramente no domínio é chamado de Domain Driven Design, ou design orientado a domínio.
- Munidos desta mentalidade, podemos garantir uma melhor manutenibilidade e extensibilidade de nosso projeto.

### Service
- As nossas regras de negócio devem ficar nas entidades e VOs, mas nem sempre isso faz sentido. Quando precisamos executar alguma ação que não faça parte de nenhuma entidade nem de um VO, podemos utilizar uma classe Service.
- Nem sempre uma classe *Service( está diretamente relacionada com alguma entidade.
- Exemplo: o conceito de cifrar senha pertence a camada de domínio. Mas a implementação em si, é da infrastrutura porque tem relação com os algorítmos de hash e isso é detalhe da infraestrutura

### Application
- O que entra na camada de aplicação pode ser um assunto polêmico. A interface de envio de e-mail que acabamos de criar poderia muito bem estar em nosso domínio, sem ferir nenhuma regra.
- Use Cases ficam no Application. Exemplo: Servico de Matricular um Aluno.
- Os termos Use Case, Application Service e Command Handler são basicamente sinônimos e servem para fornecer pontos de entrada na sua aplicação, de forma independente dos mecanismos de entrega (Web, CLI, etc).

> #### Domain Services são classes que representam uma ação entre mais de uma entidade.
> ####
> #### Application Services controlam o fluxo de alguma regra em nossa aplicação.
> ####
> #### Infrastructure Services são implementações de interfaces presentes nas camadas de domínio ou de aplicação.