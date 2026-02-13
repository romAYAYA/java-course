import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Student {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        HashSet<Student> students = new HashSet<>();

        System.out.println("Введите информацию о студенте: \"ФИО, номер группы, номер студенческого билета\"");

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            String[] parts = input.split(", ");
            if (parts.length != 3) {
                System.out.println("Неверный формат ввода");
                System.out.println("Введите информацию о студенте (для завершения работы программы введите \"end\")");
                continue;
            }

            String name = parts[0];
            String group = parts[1];
            String studentId = parts[2];

            Student student = new Student(name, group, studentId);

            if (!students.add(student)) {
                System.out.println("Студент с таким номером студенческого билета уже существует");
            }

            System.out.println("Введите информацию о студенте (для завершения работы программы введите \"end\")");
        }

        System.out.println("Список студентов:");
        for (Student student : students) {
            System.out.println("  - " + student);
        }

        scanner.close();
    }

    private final String name;
    private final String group;
    private final String studentId;

    public Student(String name, String group, String studentId) {
        this.name = name;
        this.group = group;
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(group, student.group) && Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, studentId);
    }

    @Override
    public String toString() {
        return name + ", " + group + ", " + studentId;
    }
}
