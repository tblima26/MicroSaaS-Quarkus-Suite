# 🧱 Micro SaaS - Arquitetura de Microsserviços com Quarkus

Este projeto é uma simulação de um ambiente corporativo dividido em quatro microsserviços independentes, cada um com responsabilidade única e comunicação via eventos Kafka. A estrutura foi construída com foco em boas práticas, segurança e escalabilidade.

---

## 🔗 Microsserviços

| Serviço        | Descrição |
|----------------|-----------|
| **cotacao**     | API responsável por gerenciar e atualizar cotações. Publica eventos no Kafka, usa PostgreSQL e MongoDB. |
| **proposta**    | API para criação e gerenciamento de propostas comerciais, consumindo os valores da API de cotação. |
| **reporting**   | Geração de relatórios com base nos dados das APIs `cotacao` e `proposta`, com exportação para CSV. |
| **gateway-bff** | API responsável pela autenticação (JWT via Keycloak), roteamento e segurança entre os serviços. |

---

## ⚙️ Tecnologias

**Base comum:**
- Java 17
- Quarkus 3.x
- Apache Kafka
- PostgreSQL
- Hibernate ORM + Panache
- REST com Jackson
- Lombok
- Testes com JUnit 5 e Rest-Assured
- OIDC (JWT) com Keycloak

**Extras por serviço:**

| Serviço     | Tecnologias Adicionais |
|-------------|-------------------------|
| `cotacao`   | MongoDB Client, Quartz, REST Client |
| `proposta`  | quarkus-oidc-client, keycloak-core |
| `reporting` | Apache Commons CSV |
| `gateway-bff` | quarkus-oidc, quarkus-rest-client-oidc-token-propagation, Swagger (OpenAPI) |

---

## 🗂️ Estrutura do Projeto

micro-saas/

├── cotacao/

├── proposta/

├── reporting/

├── gateway-bff/

└── README.md


Cada serviço possui seu próprio `pom.xml` e configurações isoladas, facilitando o desenvolvimento, testes e deploy independente, mesmo dentro do mesmo repositório.

---

## 🔐 Segurança

- Autenticação centralizada no `gateway-bff` usando Keycloak e JWT.
- Serviços internos validam os tokens conforme necessário.
- O acesso externo é sempre roteado pelo gateway.

---

## 🛰️ Comunicação

- Os serviços se comunicam via **Apache Kafka** (eventos).
- Fluxos síncronos são controlados pelo `gateway-bff` via chamadas REST.
- O `reporting` pode consumir dados diretamente dos bancos e/ou eventos Kafka.

---

> Este projeto não tem fins comerciais. Foi criado com foco em aprendizado e demonstração de arquitetura moderna com Quarkus e microsserviços.

---

