# Falhas identificadas:
## 1. A01: Broken Access Control (Controle de Acesso Quebrado) 
“Essa vulnerabilidade ocorre quando a aplicação insuficiente de controles de acesso e autorização permite que invasores acessem funcionalidades ou dados não autorizados...”.
Ou seja, acontece quando um aplicativo não implementa um controle de acesso adequado. **Evidências:** no caso desse projeto nem um tipo de controle de acesso está implementado o que permite que um usuário mal-intencionado consiga acessar dados ou funcionalidades que não deveria. Isso pode envolver a manipulação de URLs, parâmetros ou métodos para acessar recursos restritos.
**Como resolver:**
Implementar controles de acesso baseados em funções ou em permissões explícitas.
Garantir que todas as permissões sejam verificadas no lado do servidor, independentemente de qualquer manipulação no lado do cliente.
Adicionar testes e auditar constantemente os controles de acesso para garantir que estão sendo aplicados corretamente.

## 2. A02: Cryptographic Failures (Falhas Criptográficas)
“Esse risco ocorre devido à proteção inadequada de dados confidenciais durante o trânsito e em repouso...”.
Ou seja, este risco envolve o uso inadequado ou a ausência de criptografia para proteger dados sensíveis, como senhas, números de cartão de crédito ou outros dados pessoais. A criptografia fraca ou a implementação incorreta de algoritmos criptográficos pode expor esses dados a atacantes.
**Evidências:** Não há um sistema de criptografia para armazenar os dados no projeto. 
**Como resolver:**
- Utilizar algoritmos criptográficos fortes como AES (Advanced Encryption Standard) com chaves de 256 bits para proteger dados sensíveis.
- Armazenar senhas utilizando algoritmos de hash seguros como bcrypt ou Argon2, nunca em texto simples.
- Implementar TLS/SSL para garantir a segurança na transmissão de dados sensíveis pela rede.

## 3. A09: Security Logging and Monitoring Failures (Falhas de Registro e Monitoramento de Segurança)
“Registro e monitoramento inadequados podem dificultar a detecção e a resposta oportunas a incidentes de segurança, dificultando a identificação e a mitigação de ataques ou atividades não autorizadas...”.
Ou seja, quando não há um registro adequado dos eventos de segurança ou monitoramento contínuo, as ameaças podem passar despercebidas. 
**Evidências:** No caso desse projeto, não há logs de atividades sensíveis, como tentativas de login falhadas, falhas de autorização ou acesso a dados sensíveis, justamente por também não ter o Controle de Acesso, e sem esses logs não seria possível detectar um ataque de força bruta em andamento por exemplo.
**Como resolver:**
Implementar um sistema de logs centralizado que registre eventos de segurança críticos, como falhas de autenticação e ações de usuários privilegiados.
Monitorar ativamente esses logs para detectar atividades suspeitas.

</br></br></br>

# OWASP TOP 10

1.	## Controles de acesso quebrados: 
Essa vulnerabilidade ocorre quando a aplicação insuficiente de controles de acesso e autorização permite que invasores acessem funcionalidades ou dados não autorizados. Isso pode ocorrer devido a referências diretas a objetos (IDORs) inseguras, que podem surgir quando um aplicativo falha ao validar ou autorizar a entrada do usuário usada como referência direta a um objeto interno. Isso também pode ocorrer devido à ausência de controles de acesso em nível de função, quando o aplicativo valida apenas os controles de acesso no estágio inicial de autenticação ou autorização, mas não aplica esses controles de forma consistente em todas as funções ou operações do aplicativo. Um firewall de aplicativo da Web (WAF) pode ajudar a proteger contra esses ataques monitorando e aplicando controles de acesso para impedir o acesso não autorizado a objetos ou recursos confidenciais.

2.	## Falhas criptográficas: 

Esse risco ocorre devido à proteção inadequada de dados confidenciais durante o trânsito e em repouso. Falhas criptográficas podem levar a violações de dados, acesso não autorizado a informações confidenciais e não conformidade com regulamentações de privacidade de dados, como o Regulamento Geral de Proteção de Dados da UE (GDPR), e padrões financeiros como os Padrões de Segurança de Dados PCI (PCI DSS). Essas falhas podem resultar de armazenamento criptográfico inseguro, armazenamento de dados em texto simples ou gerenciamento de chaves inseguro. O risco também pode derivar de vazamento de informações, que pode ter origem na geração de chaves fracas ou números aleatórios ou em falhas em protocolos criptográficos. 


3.	## Ataques de injeção: 
Falhas de injeção ocorrem quando invasores inserem dados não confiáveis ou hostis em linguagens de comando ou consulta, ou quando dados fornecidos pelo usuário não são validados, filtrados ou higienizados pelo aplicativo, levando à execução não intencional de comandos maliciosos. Esta categoria de risco abrange ataques NoSQL, comando do sistema operacional, LDAP e injeção de SQL, e também inclui Cross-Site Scripting (XSS) , no qual os invasores injetam scripts maliciosos do lado do cliente, como JavaScript, em páginas da web visualizadas por outros usuários. Isso pode resultar no roubo de informações confidenciais, como credenciais de login, dados pessoais ou cookies de sessão. Um WAF pode ajudar a detectar e bloquear tentativas de injeção de código malicioso inspecionando e filtrando solicitações de entrada, incluindo XSS refletido (não persistente), armazenado (persistente) e baseado em módulo de objeto de documento (DOM), impedindo que cheguem ao aplicativo.

4.	## Design inseguro: 

Esta é uma categoria ampla que representa diferentes fraquezas, expressas como controles de segurança ausentes ou ineficazes e falhas arquitetônicas. Essas falhas podem ocorrer quando um aplicativo é projetado para depender de processos inerentemente inseguros ou quando os controles de segurança necessários para defesa contra ataques específicos não são implementados. Esses riscos podem ser reduzidos por meio do uso crescente de modelagem de ameaças, padrões de design seguros e arquiteturas de referência.  

5.	## Configurações incorretas de segurança: 
A falta de reforço de segurança em estruturas de aplicativos web, plataformas, servidores ou controles de segurança pode levar ao acesso não autorizado, à exposição de informações confidenciais ou a outras vulnerabilidades de segurança. Riscos devido a configurações incorretas de segurança também podem resultar de permissões configuradas incorretamente em serviços de nuvem ou da instalação ou ativação de recursos desnecessários, como portas, serviços, contas ou privilégios não utilizados. A configuração incorreta de aplicativos da Web e APIs é um risco significativo porque os principais provedores de nuvem têm diferentes posturas de segurança padrão e a arquitetura está se tornando cada vez mais descentralizada e distribuída em uma estrutura de várias nuvens.    

6.	## Componentes vulneráveis e desatualizados: 
O uso de componentes desatualizados, sem patches ou vulneráveis, como bibliotecas, estruturas ou plug-ins, pode expor aplicativos a falhas de segurança conhecidas, aumentando o risco de exploração. Esses riscos podem resultar de software sem suporte ou desatualizado, incluindo o sistema operacional (SO), servidor web/de aplicativos, sistema de gerenciamento de banco de dados (SGBD), aplicativos, APIs e todos os componentes, ambientes de execução e bibliotecas. Essas ameaças são particularmente perigosas quando as organizações não têm medidas oportunas e baseadas em risco para corrigir ou atualizar a plataforma, as estruturas e as dependências subjacentes de um sistema, deixando o sistema exposto a dias ou semanas de exposição desnecessária a riscos conhecidos. Cadeias de fornecimento de software complexas e automação por meio de pipelines de CI/CD aumentam o risco de introdução de software vulnerável na pilha de TI. Um WAF pode servir como uma solução paliativa essencial para proteger contra exploração de vulnerabilidades.  

7.	## Falhas de identificação e autenticação: 
Fraquezas na autenticação, identidade e gerenciamento de sessão podem permitir que invasores comprometam contas de usuários, senhas, tokens de sessão ou explorem o tratamento inseguro de sessões. Falhas nessas áreas podem permitir ataques automatizados, como preenchimento de credenciais . Vulnerabilidades relacionadas a senhas são a fonte mais comum desses riscos, pois muitas pessoas reutilizam senhas ou usam senhas padrão, fracas ou bem conhecidas. Problemas de gerenciamento de sessão também podem levar a ataques relacionados à autenticação, principalmente se as sessões do usuário ou os tokens de autenticação não forem invalidados corretamente durante o logout ou um período de inatividade. Ataques que ignoram controles de autenticação são um risco crescente para aplicativos da web e APIs, conforme detalhado nos projetos OWASP Top 10, API Security Top 10 e Automated Threats.  

8.	## Falhas de software e integridade de dados: 
Essas vulnerabilidades resultam de código e infraestrutura de aplicativos que não conseguem proteger contra violações de integridade de dados e software. Isso pode ocorrer quando um aplicativo depende de plugins, bibliotecas ou módulos de fontes, repositórios e CDNs não confiáveis. Isso também pode ocorrer durante atualizações de software, modificações de dados confidenciais e alterações de pipeline de CI/CD que não são validadas. Os invasores podem potencialmente enviar suas próprias atualizações para serem distribuídas e executadas em todas as instalações. A desserialização insegura, em que um aplicativo pega dados serializados não confiáveis e os consome sem garantir que sejam válidos, também faz parte dessa categoria de risco, permitindo ataques como execução remota de código (RCE) e escalonamento de privilégios. 

9.	## Falhas no registro e monitoramento de segurança:
 Registro e monitoramento inadequados podem dificultar a detecção e a resposta oportunas a incidentes de segurança, dificultando a identificação e a mitigação de ataques ou atividades não autorizadas. Isso pode significar que eventos auditáveis, como logins, logins com falha e transações de alto valor não são identificados ou registrados, e que os aplicativos não detectam ataques ativos em tempo real.  

10.	## Server-Side Request Forgery (SSRF): 
Essas vulnerabilidades ocorrem quando um aplicativo não valida ou higieniza uma URL inserida por um usuário antes de extrair dados de um recurso remoto. Os invasores podem usar essas falhas para forçar aplicativos a acessar destinos maliciosos da web, mesmo que protegidos por um firewall ou outra defesa. Esses ataques também podem acontecer se o recurso direcionado tiver relações de confiança com outros sistemas, como um serviço de metadados em nuvem ou APIs de back-end, permitindo que um invasor faça solicitações a esses serviços confiáveis e extraia informações confidenciais ou execute ações não autorizadas.Para ajudar a mitigar o SSRF, projete sistemas para acesso com privilégios mínimos e use um WAF para definir explicitamente os parâmetros do identificador uniforme de recursos (URI) em sua política de segurança e permitir/não permitir hosts que podem acessá-los.

FONTE: [OWASP TOP 10](https://owasp.org/Top10/), [O que é OWASP? Introdução às 10 principais vulnerabilidades e riscos do OWASP](https://www.f5.com/pt_br/glossary/owasp)

