# Wallet Management Application POC

## Problème
Nous souhaitons développer un POC (Proof Of Concept) sous forme d’une application web basée sur une architecture micro-service en utilisant l’écosystème **Spring Boot** et **Spring Cloud** côté backend, et un framework comme **Angular** ou **React** côté frontend. 

L’application doit permettre de gérer des portefeuilles (Wallets) de devises ainsi que les transferts entre les portefeuilles. Cette application se composera de deux micro-services fonctionnels :

1. **Micro-service Wallet** : 
   - Gère les « Wallet ». 
   - Chaque Wallet appartient à un client.
   - Un client est défini par son ID (numérique auto-incrémenté), son nom et son email.
   - Un Wallet est défini par son ID (String de type UUID), son solde, sa date de création et sa devise.

2. **Micro-service Transfer** : 
   - Gère les transferts entre les Wallets.
   - Chaque transfert est défini par son ID, sa date, le Wallet source, le Wallet destination, son montant et son état (PENDING, VALIDATED, REJECTED).

## Micro-services Techniques
Les micro-services techniques à mettre en place sont :

- **Gateway Service** basé sur **Spring Cloud Gateway**
- **Discovery Service** basé sur **Eureka Server** ou **Consul Discovery** (au choix)
- **Configuration Service** basé sur **Spring Cloud Config** ou **Consul Config** (au choix)

Pour les micro-services, il est nécessaire de générer la documentation des web services RESTful en utilisant la spécification **OpenAPI** (Swagger).

## Travail à Réaliser
1. Créer un projet vide incluant les micro-services suivants : 
   - `wallet-service`
   - `transfer-service`
   - `gateway-service`
   - `discovery-service`
   - `config-service`
   
2. Développer et tester les micro-services :
   - **discovery-service**
   - **gateway-service**
   - **config-service**

3. Développer et tester le micro-service **wallet-service**.

4. Développer et tester le micro-service **transfer-service**.

5. Développer un simple frontend web pour l’application.

6. Proposer une solution pour sécuriser l’application.

## Installation et Configuration

### Prérequis
- Java JDK (version 11 ou supérieure)
- Maven (version 3.6 ou supérieure)
- Node.js et npm (pour le frontend, si Angular ou React est utilisé)

### Étapes d'Installation
1. Clonez le dépôt :
   ```bash
   git clone <repository-url>
   cd wallet-management
