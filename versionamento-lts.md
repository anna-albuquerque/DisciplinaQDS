# Versionamento Semântico

## 1. Spring Boot
Versão do Spring Boot no pom.xml: **3.3.5**
``` 
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.3.5</version>
    </parent>

```
Spring Boot segue o versionamento semântico.
O número da versão "3.3.5" indica que é a versão onde cada número significa:
- 3 é a versão principal (**major**), indicando mudanças que podem não ser compatíveis com versões anteriores.
- 3 é a versão secundária (**minor**), indicando novas funcionalidades compatíveis com versões anteriores.
- 5 é a versão de correção (**patch**), indicando correções de bugs e melhorias.

Sobre a **versão LTS**: O Spring Boot não tem um ciclo de LTS formal como outros projetos (por exemplo, o Node.js ou o Ubuntu). No entanto, a equipe do Spring Boot geralmente oferece suporte para versões principais por um período prolongado, o que pode ser considerado um suporte de longo prazo informal.

Página do Spring Boot que explica sobre seu sistema de versões [Spring Boot Support](https://spring.io/projects/spring-boot#support)
Página do repositório do Spring Boot que faça sobre o seu suporte a versões [Spring Boot Versões Suportadas](https://github.com/spring-projects/spring-boot/wiki/Supported-Versions) explicando que seguem o ciclo de vida de suporte do VMware Tanzu.

</br></br>

## 2. Springdoc OpenAPI
Versão do Springdoc OpenAPI no pom.xml: **2.6.0**
``` 
 <springdoc.version>2.6.0</springdoc.version>
```
Springdoc OpenAPI também segue o versionamento semântico. 
O número da versão "2.6.0" indica que é a versão onde cada número significa:

- 2 é a versão principal (major), indicando mudanças que podem não ser compatíveis com versões anteriores.
- 6 é a versão secundária (minor), indicando novas funcionalidades compatíveis com versões anteriores.
- 0 é a versão de correção (patch), indicando correções de bugs e melhorias.

Sobre a **versão LTS**:  O Springdoc OpenAPI não tem um ciclo de LTS formal. O suporte geralmente está alinhado com o suporte do Spring Boot, já que o Springdoc OpenAPI é uma biblioteca que depende do Spring Boot.

</br></br>

# Componentes com versões LTS (Long-Term Support)
No meu projeto, procurei e não achei além dos já citados em aula, exemplos que usassem versões LTS. Por isso, trouxe exemplos que não estão em uso no meu projeto, mas seguem padrões de atualizações LTS apenas para fins didáticos.

## 1. Node.js
O Node.js tem um ciclo de lançamento bem definido, com versões LTS que recebem suporte por um período estendido. Aqui estão as referências oficiais:
[Página de versões LTS do Node.js:](https://nodejs.org/en/about/releases/)
Nessa página, o Node.js detalha seu ciclo de lançamento, incluindo as versões LTS. 
_Por exemplo:_
**Versões LTS atuais (em outubro de 2023):** Node.js 18.x e Node.js 20.x.

O suporte LTS para cada versão dura 30 meses (2,5 anos).
**Exemplo de versões LTS do Node.js:**
Node.js 18.x: LTS até abril de 2025.
Node.js 20.x: LTS até abril de 2026.

**Como verificar a versão LTS:**
Você pode usar o comando nvm (Node Version Manager) para instalar e gerenciar versões LTS do Node.js:

```
nvm install --lts
nvm use --lts
``` 
 
## 2. PostgreSQL e LTSO PostgreSQL
Também oferece suporte de longo prazo para versões específicas, com atualizações de segurança e correções de bugs por um período estendido.

[Documentação Oficial do PostgreSQL](https://www.postgresql.org/support/versioning/)
Nessa página, o PostgreSQL explica que cada versão principal é suportada por 5 anos. Durante esse período, a equipe do PostgreSQL lança correções de segurança e bugs para versões suportadas.

_Exemplo de versões LTS do PostgreSQL:_
PostgreSQL 12: Suportado até novembro de 2024.
PostgreSQL 13: Suportado até novembro de 2025.
PostgreSQL 14: Suportado até novembro de 2026.

**Como verificar a versão LTS:**
Você pode consultar a página oficial de downloads do [PostgreSQL para ver as versões suportadas:](https://www.postgresql.org/download/)
