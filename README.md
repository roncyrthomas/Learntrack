# LearnTrack Management System

## Project Description
LearnTrack is a console-based Java application designed to manage students, courses, and enrollments for a training institute.

The project follows clean Object-Oriented Programming principles and uses a layered architecture:
- Entity layer for core domain models
- Repository layer for in-memory data storage
- Service layer for business logic
- Main/UI layer for user interaction

The system allows users to:
- Create, activate, deactivate, and view students
- Create, activate, deactivate, and view courses
- Enroll students into courses
- View all enrollments
- Safely handle invalid user input without crashing
- Run continuously without unexpected termination

All data is stored in memory using repository implementations.

---

## Technologies Used
- Java (Core Java)
- Object-Oriented Programming (OOP)
- Collections Framework (ArrayList)
- Exception Handling

---

## How to Compile and Run

### Prerequisites
- Java JDK 17 or higher
- Terminal / Command Prompt or an IDE (IntelliJ IDEA, Eclipse, VS Code)

### Compile
From the project root directory, run:
```
javac -d out src/com/airtribe/learntrack/**/*.java
```

### Run
After compilation, run:
```
java -cp out com.airtribe.learntrack.Main
```

Alternatively, you can run the `Main` class directly from your IDE.

---

## Project Structure
```
src/
 └── com.airtribe.learntrack
     ├── entity
     ├── repository
     │    └── impl
     ├── service
     ├── util
     └── Main.java

docs/
 └── Design_Notes.md
```

---

## Notes
- The application uses menu-driven navigation with multi-level menus.
- The program never exits unexpectedly and handles all invalid inputs gracefully.
- The design allows easy future extension, such as adding database persistence.
