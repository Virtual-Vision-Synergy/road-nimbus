# Road Nimbus - Application de signalement de travaux routiers

## 📋 Description
Cette application Spring Boot permet de signaler et gérer les travaux routiers avec authentification et documentation API via Swagger.

## 🛠 Technologies
- **Backend** : Spring Boot 4.0.1, Java 17
- **Base de données** : PostgreSQL 15
- **Documentation API** : OpenAPI/Swagger
- **Sécurité** : Spring Security
- **Containerisation** : Docker & Docker Compose

## 🚀 Exécution du projet

### Option 1 : Avec Docker Compose (Recommandé)

```bash
# Cloner le projet
git clone https://github.com/Virtual-Vision-Synergy/road-nimbus.git
cd road-nimbus

# Lancer l'application complète
docker compose up -d --build
```

Cette commande va :
- Construire l'image Docker de l'application
- Démarrer une base PostgreSQL sur le port 5432
- Lancer l'application Spring Boot sur le port 8080

### Option 2 : Exécution locale

```bash
# 1. Démarrer seulement la base de données
docker compose up postgres -d

# 2. Modifier application.properties pour pointer vers localhost
# Changer: spring.datasource.url=jdbc:postgresql://postgres:5432/roadworks
# Par:     spring.datasource.url=jdbc:postgresql://localhost:5432/roadworks

# 3. Lancer l'application
mvn spring-boot:run
```

## 📍 URLs importantes

Une fois l'application démarrée :

- **Documentation API (Swagger)** : http://localhost:8080/swagger-ui/index.html
- **API REST** : http://localhost:8080
- **Documentation OpenAPI** : http://localhost:8080/v3/api-docs

## 🔐 Authentification

L'application utilise un token statique pour l'authentification :
- **Token** : `roadworks-static-token`
- **Header** : `Authorization: Bearer roadworks-static-token`

## 📊 Base de données

- **Nom** : `roadworks`
- **Utilisateur** : `myuser`
- **Mot de passe** : `secret`
- **Port** : `5432`

## 🗂 Structure du projet

```
src/main/java/com/project/
├── auth/                 # Authentification et sécurité
├── config/              # Configuration (Swagger)
├── front/               # DTOs et utilitaires frontend
├── map/                 # Gestion des cartes
└── signalement/         # Gestion des signalements
```

## 🐛 Dépannage

### Erreur de connexion à la base
Vérifiez que PostgreSQL est bien démarré :
```bash
docker compose ps postgres
```

### Port déjà utilisé
Si le port 8080 est occupé, modifiez dans `application.properties` :
```properties
server.port=8081
```

## 📝 API Endpoints

- **GET** `/swagger-ui/index.html` - Interface Swagger
- **POST** `/auth/*` - Endpoints d'authentification
- **GET/POST** `/signalements/*` - Gestion des signalements
- **GET** `/map/*` - Services de cartographie