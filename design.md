

# Design Notes

## Why ArrayList Instead of Array

ArrayList was used instead of arrays because the number of students, courses, and enrollments is not fixed.

ArrayList provides:
- Dynamic resizing
- Easier addition and removal of elements
- Cleaner iteration and better readability

Using arrays would require manual resizing and copying, which increases complexity and reduces maintainability.

---

## Where Static Members Were Used and Why

Static members were primarily used in the `IdGenerator` utility class.

Reasons for using static members:
- ID generation logic is shared across the application
- No object state is required
- IDs must remain globally consistent

Using static methods avoids unnecessary object creation and centralizes ID generation logic.

Static members were intentionally avoided in services and repositories to prevent shared mutable state and improve testability.

---

## Where Inheritance Was Used and What Was Gained

Inheritance was implemented using an abstract `Person` class.

Common attributes in `Person`:
- id
- firstName
- lastName
- email

Classes that extend `Person`:
- Student
- Trainer

Benefits gained:
- Removed duplication of common fields and methods
- Enforced consistency across person-based entities
- Allowed reuse of shared behavior like `getDisplayName()`
- Improved extensibility for future person types

Inheritance helped keep the code clean, reusable, and aligned with Object-Oriented principles.

---

## Summary
The application design emphasizes:
- Separation of concerns
- Maintainability
- Scalability
- Proper use of OOP and SOLID principles

The architecture allows easy replacement of in-memory repositories with database-backed implementations without changing service logic.
