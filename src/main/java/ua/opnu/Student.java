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
            throw new IllegalArgumentException("Ім'я студента не може бути пустим");
        }
        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Рік навчання повинен бути від 1 до 4");
        }
        this.name = name;
        this.year = year;
        this.courses = new ArrayList<>();
    }

    // Додати дисципліну
    public void addCourse(String courseName) {
        if (courseName == null || courseName.isEmpty()) {
            throw new IllegalArgumentException("Назва дисципліни не може бути пустою");
        }
        courses.add(courseName);
    }

    // Видалити всі дисципліни
    public void dropAll() {
        courses.clear();
    }

    // Повернути кількість дисциплін
    public int getCourseCount() {
        return courses.size();
    }

    // Повернути ім'я студента
    public String getName() {
        return name;
    }

    // Повернути суму сплачену за навчання
    public int getTuition() {
        return year * TUITION_PER_YEAR;
    }

    // Повернути рік навчання
    public int getYear() {
        return year;
    }

    // Метод main для демонстрації
    public static void main(String[] args) {
        // Створення студента
        Student student = new Student("Іван", 2);

        // Додавання дисциплін
        student.addCourse("Математика");
        student.addCourse("Фізика");
        student.addCourse("Програмування");

        // Виведення інформації
        System.out.println(student.getName() + ": кількість вивчаємих дисциплін - " + student.getCourseCount());
        System.out.println(student.getName() + ": рік навчання - " + student.getYear());
        System.out.println(student.getName() + ": заплатив за навчання - " + student.getTuition());
    }
}
