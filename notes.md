
### Notes:

#### Entity and ValueObjects:
- Entidades possuem uma identidade única, enquanto VOs são considerados iguais, se todos os seus atributos tiverem valores iguais.
- Se dois e-mails possuem o mesmo endereço, podemos considerá-los como o mesmo e-mail. Já duas pessoas com o nome, altura e idade não necessariamente são a mesma pessoa.
- MORE: https://martinfowler.com/bliki/ValueObject.html

- Value Object, já que dois telefones com DDD e número iguais são considerados o mesmo telefone.
- Se a igualdade entre dois objetos de uma classe é verificada através da comparação de todos os seus valores, se trata de um Value Object.
