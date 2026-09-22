# Tree Pages

Tree Pages is an application designed to improve reading comprehension and retention by combining the Pomodoro technique with active reading strategies.

---

## Tech Stack

* **Language:** Java 25
* **Framework:** Spring Boot
* **Database:** PostgreSQL
* **Database Versioning:** Flyway
* **Build Tool:** Maven

---

##  Roadmap & Status

### Implemented
- [x] Project setup
- [x] PostgreSQL configuration 
- [x] Flyway configuration

### Currently Working On
- DTOs and Database Migrations
- Spring Security integration
- Spring Web configuration

### Next Tasks
- [ ] Implement authentication configuration
- [ ] Create Book CRUD operations
- [ ] Add functionality to upload and read books

### Future Features
- Pomodoro timer
- Book garden
- User library
- Reading streak tracking
- User profiles

---

## Getting Started

### Prerequisites

Before running Tree Pages, ensure you have the following installed:
- Java 25
- Maven
- Docker and Docker Compose
- IntelliJ IDEA (recommended)

### Installation & Setup

**1. Clone the repository**
```bash
git clone https://github.com/DevPolar003/tree-pages

cd tree-pages
```

**2. Start Docker Componse**
```bash

docker compose up -d

docker compose ps

```

**3. Build and Run the Project**

Open the project in IntelliJ IDEA and run the main application. 
Once the application starts, you can access 
the currently available routes in your browser:

    Login: http://localhost:8080/templates/login.html

    Sign Up: http://localhost:8080/templates/signup.html

    Welcome: http://localhost:8080/templates/welcome.html
