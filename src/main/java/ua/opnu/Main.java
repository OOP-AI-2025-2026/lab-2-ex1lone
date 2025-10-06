package ua.opnu;

import java.util.ArrayList;

public class Student {
    private String name;
    private int year; // від 1 до 4
    private ArrayList<String> courses;

    private static final int TUITION_PER_YEAR = 20000;

    // Конструктор
    public Student(String name, int year) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ім'я студента не може бути порожнім");
        }
        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Рік навчання має бути від 1 до 4");
        }
        this.name = name;
        this.year = year;
        this.courses = new ArrayList<>();
    }

    // Додавання дисципліни
    public void addCourse(String courseName) {
        if (courseName == null || courseName.isEmpty()) {
            throw new IllegalArgumentException("Назва дисципліни не може бути порожньою");
        }
        courses.add(courseName);
    }

    // Видалення всіх дисциплін
    public void dropAll() {
        courses.clear();
    }

    // Кількість дисциплін
    public int getCourseCount() {
        return courses.size();
    }

    // Ім'я студента
    public String getName() {
        return name;
    }

    // Рік навчання
    public int getYear() {
        return year;
    }

    // Сума грошей за навчання
    public int getTuition() {
        return TUITION_PER_YEAR * year;
    }

    // Головний метод для демонстрації
    public static void main(String[] args) {
        // Створюємо студента
        Student student = new Student("Іван", 2);

        // Додаємо дисципліни
        student.addCourse("Математика");
        student.addCourse("Програмування");
        student.addCourse("Фізика");

        // Виводимо кількість дисциплін
        System.out.println(student.getName() + ": кількість вивчаємих дисциплін - " + student.getCourseCount());

        // Виводимо рік навчання
        System.out.println(student.getName() + ": рік навчання - " + student.getYear());

        // Виводимо суму грошей, сплачену за навчання
        System.out.println(student.getName() + ": заплатив за навчання - " + student.getTuition());
    }
}
