# Transaction Reconciliation App
HFR
Mini-projet technique — Réconciliation de transactions financières.

## 📌 Objectif

Cette application back-end permet de :

- Charger automatiquement des transactions financières depuis un fichier JSON
- Réconcilier les transactions via les IDs primaires et secondaires
- Associer chaque transaction à son `eventRank` et `stepRank` à partir d'un référentiel métier
- Gérer les dates mal formées
- Fournir une API REST pour consulter les transactions

## 🧰 Stack utilisée

- Java 17 + Spring Boot
- PostgreSQL
- Docker + Docker Compose
- JPA / Hibernate
- Jackson pour le parsing JSON

---

## 🚀 Lancer l'application avec Docker

### Prérequis

- Docker
- Docker Compose

### Étapes

1. Cloner le projet :
   ```bash
   git clone <url-du-repo>
   cd <nom-du-dossier>
   ```

2. Compiler l'application :
   ```bash
   ./mvnw clean package -DskipTests
   ```

3. Lancer Docker :
   ```bash
   docker-compose up --build
   ```

---

## 📁 Structure importante

| Fichier / Dossier         | Rôle                                      |
|--------------------------|-------------------------------------------|
| `transactions.json`      | Contient les données à charger            |
| `init-event-dictionary.sql` | Initialise les données de référence (`event_dictionary`) |
| `Dockerfile`             | Dockerise l'application Spring Boot       |
| `docker-compose.yml`     | Lance la base PostgreSQL + l'app          |

---

## 🗃️ Base de données

- Base : `transactions_db`
- Utilisateur : `postgres`
- Mot de passe : `testHFR`
- Création automatique au démarrage via Docker

---

## 🔌 Endpoints REST disponibles

| Endpoint                                 | Description                                         |
|------------------------------------------|-----------------------------------------------------|
| `GET /api/transactions/search/{id}`      | Retourne la chaîne de transactions triée par `stepRank` puis `eventRank` |
| `GET /api/transactions/invalid-dates`    | Retourne les transactions avec une date invalide    |

---

## 💡 Notes

- Le script `init-event-dictionary.sql` est monté dans le conteneur PostgreSQL au premier lancement.
- Les transactions sont chargées automatiquement au démarrage via `CommandLineRunner`.

---

## 👨‍💻 Auteur

HFR
Test technique - Développeur Java / Spring Boot.