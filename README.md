# Tree pages

Tree Pages is an application designed to improve reading comprehension and retention using the Pomodoro technique and active reading strategies.
## Future features

- Pomodoro clock
- Book garden
- Library
- Streak page
- Profile


## Tech Stack

**Programming language:** Java

**Package manager:** Maven

**Framework:** Springboot 

**Database**: Postgresql

**Database versioning**: Flyway

When there's a long time you don't touch a project, what should u do?

If you haven't touched a project for a long time, don't immediately start coding. First, rebuild your mental model of the project. Think of it as waking up a sleeping codebase. 🧠
A good "returning to a project" routine

1. Run the project first

git status
git log --oneline -10

Then actually start it and see whether it still works.

For a Java/Spring Boot project, for example:

./mvnw spring-boot:run

or, if you're using Maven globally:

mvn spring-boot:run

2. Read the README

Don't trust your memory. Check:

    What is this project supposed to do?

    How do I run it?

    What technologies does it use?

    What was I working on?

If the README is outdated, update it while you're reacquainting yourself.

3. Understand the current architecture

For your Spring projects, I'd usually inspect:

src/
├── main/
│   └── java/
│       ├── controller/
│       ├── service/
│       ├── repository/
│       └── model/
└── resources/
└── application.properties

Ask yourself:

    "If I make a request to this API, where does that request go?"

For example:

HTTP request
↓
Controller
↓
Service
↓
Repository
↓
PostgreSQL

Once that flow makes sense again, you're back in the driver's seat.

4. Look at Git history

This is particularly useful if you forgot why you wrote something.

git log --oneline --graph --all

Then inspect interesting commits:

git show <commit>

Your commit history can basically function as a diary of your previous self.

5. Check unfinished work

Look for:

git status

and search for:

TODO
FIXME

Also check your GitHub issues/project board if you use one.

6. Make one tiny change

Don't immediately attempt the huge feature you were working on.

Make something small, such as:

    Fix a typo

    Add a simple endpoint

    Improve a README section

    Add a test

    Refactor one tiny piece

Then:

git add .
git commit -m "chore: resume project"

That gets your brain back into the project's conventions.
For your TreePages/Spring Boot project specifically

Since you've been working with Spring Boot + PostgreSQL + Docker, I'd do this:

cd ~/path/to/treepages

git status
git log --oneline -10

docker ps

./mvnw test
./mvnw spring-boot:run

Then test the API manually.

After that, inspect:

pom.xml
application.properties
Entity classes
Repositories
Services
Controllers

I'd especially check whether your PostgreSQL Docker container and database configuration still match the application. That's one of those things that can make a project feel "broken" when the Java code itself is perfectly fine.
The general rule

When returning after months:

    Run → Read → Understand → Test → Make a tiny change → Resume development.

Don't spend three hours rereading every file. You want to reconstruct the map, not memorize every tree. 🌳

And for future projects, leaving a README.md section called "Where I left off" with 3–5 bullets is incredibly useful.

go ahead, see that project
DevPolar003/tree-pages

Yep. I looked through the repository itself, and now I can give you a much more concrete "welcome back to the project" plan.

Your repo is Tree Pages, a Spring Boot application intended to improve reading comprehension/retention using Pomodoro and active-reading techniques. Right now it has 6 commits and the repository is still fairly small, which is actually excellent for getting back into it.
What I see in the project

Your current stack is:

    Java 26

    Spring Boot 4.0.6

    Maven

    Spring Data JPA

    PostgreSQL

    Flyway

    Spring WebMVC

That's all explicitly reflected in your pom.xml and README.

The project currently has:

tree-pages/
├── .mvn/
├── src/
│   ├── main/
│   └── test/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md

The src directory contains both your main Java code and tests.

And your planned product features are:

Tree Pages
│
├── Pomodoro clock
├── Book garden
├── Library
├── Streak page
└── Profile

So here's what I'd do today

Don't start implementing a new feature yet.

You're at the perfect stage for a project archaeology session.
1. Clone/open the project

git clone https://github.com/DevPolar003/tree-pages.git
cd tree-pages

If you already have it locally:

cd tree-pages
git status

You want to establish:

    "What state did I actually leave this in?"

2. Look at your last commits

Run:

git log --oneline --decorate --graph --all

You only have six commits at the moment, so this should be very readable.

Then:

git show <last-commit>

This is much more useful than rereading the whole project.

You're trying to answer:

    "What was I thinking when I stopped?"

3. Make sure the infrastructure still works

Since your project uses PostgreSQL + Flyway, start PostgreSQL first.

From your previous setup, you were using Docker for PostgreSQL, so check:

docker ps

Then check Java:

java -version

And Maven:

./mvnw -version

Your project currently declares Java 26, so make sure your installed JDK actually matches that requirement.

Then:

./mvnw test

This is important.

Don't fix anything before seeing what happens.

If it fails, the failure itself tells us where the project currently stands.
4. Then inspect src/main

This is where I would spend most of your time.

Don't read every line.

Instead, build this mental map:

HTTP request
│
▼
Controller
│
▼
Service
│
▼
Repository
│
▼
PostgreSQL

Then identify which of those layers actually exist in Tree Pages.

That's the part I would reconstruct before touching the code.
And I noticed something important

Your README describes the product vision, but it doesn't yet describe the current implementation state.

For example, it says:

    Pomodoro clock
    Book garden
    Library
    Streak page
    Profile

as future features.

That's useful for the vision, but not very useful six months later when you're asking:

    "What the hell was I doing here?"

I'd eventually change the README to something more like:

## Current Status

### Implemented
- [x] Project setup
- [x] PostgreSQL configuration
- [x] Flyway configuration
- [ ] Fix the database structure
- [ ] Create all the restAPI structure
### Currently Working On
- ...

### Next Task
- ...

### Known Problems
- ...

### Architecture
- Controller
- Service
- Repository
- Entity

That tiny section will save Future You from having to become an archaeologist again.
One thing I'd not do

Don't immediately think:

    "The project is old, so I should rewrite it."

That's one of the classic student-project traps.

Your project is small enough that understanding what you already built is probably more valuable than rebuilding it.

If you want, we can go one step further and
walk through the actual src/main code together,
reconstruct what you already implemented,
identify what is missing, and
turn it into a concrete development roadmap.









