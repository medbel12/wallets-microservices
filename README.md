# POC - Application de Gestion des Porte-feuilles

## Problème

Ce projet consiste à développer un POC (Proof Of Concept) sous la forme d’une application web basée sur une architecture micro-service, utilisant l’écosystème Spring Boot et Spring Cloud côté backend, et un framework comme Angular ou React côté frontend. 

L’application doit permettre de gérer des porte-feuilles (Wallets) de devises ainsi que les transferts entre les porte-feuilles. 

### Fonctionnalités Principales

1. **Gestion des Wallets** :
   - Chaque Wallet appartient à un client.
   - Un client est défini par :
     - ID (numérique auto-incrémenté)
     - Nom
     - Email
   - Un Wallet est défini par :
     - ID (String de type UUID)
     - Solde
     - Date de création
     - Devise

   ![Gestion des Wallets](chemin/vers/image_gestion_wallets.png) <!-- Ajoutez ici une image de démonstration -->

2. **Gestion des Transferts** :
   - Chaque transfert est défini par :
     - ID
     - Date
     - Wallet source
     - Wallet destination
     - Montant
     - État (PENDING, VALIDATED, REJECTED)

   ![Gestion des Transferts](chemin/vers/image_gestion_transferts.png) <!-- Ajoutez ici une image de démonstration -->

### Micro-services Techniques

- **Service Gateway** : Basé sur Spring Cloud Gateway
- **Service Discovery** : Basé sur Eureka Server ou Consul Discovery (au choix)
- **Service de Configuration** : Basé sur Spring Cloud Config ou Consul Config (au choix)

### Documentation

- Génération de la documentation des services web RESTful en utilisant la spécification OpenAPIDoc (Swagger).

   ![Documentation API](chemin/vers/image_documentation_api.png) <!-- Ajoutez ici une image de démonstration -->

## Travaux Demandés

1. Créer un projet vide incluant les micro-services suivants :
   - wallet-service
   - transfer-service
   - gateway-service
   - discovery-service
   - config-service

2. Développer et tester les micro-services :
   - discovery-service
   - gateway-service
   - config-service

3. Développer et tester le micro-service wallet-service.

4. Développer et tester le micro-service transfer-service.

5. Développer un simple frontend web pour l’application.

   ![Frontend de l'Application](chemin/vers/image_frontend_application.png) <!-- Ajoutez ici une image de démonstration -->

6. Proposer une solution pour sécuriser l’application.

## Technologies Utilisées

- **Backend** : 
  - Spring Boot
  - Spring Cloud
  - Eureka / Consul (pour la découverte de services)
  - Swagger (pour la documentation API)

- **Frontend** : 
  - Angular / React

## Installation

1. Clonez le repository :
   ```bash
   git clone <url_du_repository>
   cd <nom_du_dossier>
