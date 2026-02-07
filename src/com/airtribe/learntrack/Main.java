package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.repository.impl.InMemoryCourseRepo;
import com.airtribe.learntrack.repository.impl.InMemoryEnrollmentRepo;
import com.airtribe.learntrack.repository.impl.InMemoryStudentRepo;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        StudentRepository studentRepo = new InMemoryStudentRepo();
        CourseRepository courseRepo = new InMemoryCourseRepo();
        EnrollmentRepository enrollmentRepo = new InMemoryEnrollmentRepo();

        StudentService studentService = new StudentService(studentRepo);
        CourseService courseService = new CourseService(courseRepo);
        EnrollmentService enrollmentService =
                new EnrollmentService(enrollmentRepo, studentRepo, courseRepo);

        while (true) {
            try {
                printMainMenu();
                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1" -> studentMenu(studentService);
                    case "2" -> courseMenu(courseService);
                    case "3" -> enrollmentMenu(enrollmentService);
                    case "0" -> {
                        System.out.println("Exiting LearnTrack. Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void studentMenu(StudentService service) {
        while (true) {
            try {
                printSection("STUDENT MANAGEMENT");
                System.out.println("1. Create Student");
                System.out.println("2. View All Students");
                System.out.println("3. Activate Student");
                System.out.println("4. Deactivate Student");
                System.out.println("5. Search Student by ID");
                System.out.println("0. Back");
                printChoicePrompt();

                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1" -> {
                        int id = IdGenerator.nextStudentId();
                        System.out.print("First Name: ");
                        String fn = scanner.nextLine();
                        System.out.print("Last Name: ");
                        String ln = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();

                        service.createStudent(id, fn, ln, email);
                        System.out.println("Student created with ID: " + id);
                    }
                    case "2" -> {
                        List<Student> students = service.viewAllStudents();
                        if (students.isEmpty()) {
                            System.out.println("No students found.");
                        } else {
                            for (Student s : students) {
                                System.out.println(
                                        s.getId() + " | " +
                                                s.getDisplayName() + " | " +
                                                s.getEmail() + " | " +
                                                (s.isActive() ? "ACTIVE" : "INACTIVE")
                                );
                            }
                        }
                    }
                    case "3" -> {
                        System.out.print("Enter Student ID: ");
                        int id = readInt();
                        service.activateStudent(id);
                        System.out.println("Student activated.");
                    }
                    case "4" -> {
                        System.out.print("Enter Student ID: ");
                        int id = readInt();
                        service.deactivateStudent(id);
                        System.out.println("Student deactivated.");
                    }
                    case "5" -> {
                        System.out.print("Enter Student ID: ");
                        int id = readInt();
                        Student s = service.searchStudentById(id);
                        System.out.println("ID: " + s.getId());
                        System.out.println("Name: " + s.getDisplayName());
                        System.out.println("Email: " + s.getEmail());
                        System.out.println("Status: " + (s.isActive() ? "ACTIVE" : "INACTIVE"));
                    }
                    case "0" -> { return; }
                    default -> System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void courseMenu(CourseService service) {
        while (true) {
            try {
                printSection("COURSE MANAGEMENT");
                System.out.println("1. Create Course");
                System.out.println("2. View All Courses");
                System.out.println("3. Activate Course");
                System.out.println("4. Deactivate Course");
                System.out.println("0. Back");
                printChoicePrompt();

                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1" -> {
                        int id = IdGenerator.nextCourseId();
                        System.out.print("Course Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Description: ");
                        String desc = scanner.nextLine();
                        System.out.print("Duration (weeks): ");
                        int weeks = readInt();

                        service.addCourse(id, name, name + id, desc, weeks);
                        System.out.println("Course created with ID: " + id);
                    }
                    case "2" -> {
                        List<Course> courses = service.viewAllCourses();
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        } else {
                            for (Course c : courses) {
                                System.out.println(
                                        c.getCourseId() + " | " +
                                                c.getCourseName() + " | " +
                                                (c.isActive() ? "ACTIVE" : "INACTIVE")
                                );
                            }
                        }
                    }
                    case "3" -> {
                        System.out.print("Enter Course ID: ");
                        service.activateCourse(readInt());
                        System.out.println("Course activated.");
                    }
                    case "4" -> {
                        System.out.print("Enter Course ID: ");
                        service.deactivateCourse(readInt());
                        System.out.println("Course deactivated.");
                    }
                    case "0" -> { return; }
                    default -> System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void enrollmentMenu(EnrollmentService service) {
        while (true) {
            try {
                printSection("ENROLLMENT MANAGEMENT");
                System.out.println("1. Enroll Student");
                System.out.println("2. View All Enrollments");
                System.out.println("0. Back");
                printChoicePrompt();

                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1" -> {
                        int id = IdGenerator.nextEnrollmentId();
                        System.out.print("Student ID: ");
                        int sid = readInt();
                        System.out.print("Course ID: ");
                        int cid = readInt();

                        service.enrollStudent(id, sid, cid);
                        System.out.println("Enrollment successful. ID: " + id);
                    }
                    case "2" -> {
                        var enrollments = service.viewAllEnrollments();
                        if (enrollments.isEmpty()) {
                            System.out.println("No enrollments found.");
                        } else {
                            System.out.println("ID | Student | Course | Status");
                            for (var e : enrollments) {
                                System.out.println(
                                        e.getId() + " | " +
                                                e.getStudentId() + " | " +
                                                e.getCourseId() + " | " +
                                                e.getEnrollmentStatus()
                                );
                            }
                        }
                    }
                    case "0" -> { return; }
                    default -> System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n================================");
        System.out.println("     LEARNTRACK SYSTEM");
        System.out.println("================================");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Enrollment Management");
        System.out.println("0. Exit");
        printChoicePrompt();
    }

    private static void printSection(String title) {
        System.out.println("\n-------- " + title + " --------");
    }

    private static void printChoicePrompt() {
        System.out.print("Choose option: ");
    }
}
