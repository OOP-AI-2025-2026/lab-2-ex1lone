package ua.opnu;

import java.util.ArrayList;

public class Student {

  public static void main(String[] args) {

    ua.opnu.Student mark = new ua.opnu.Student("mark", 2);

    mark.addCourse("math");
    mark.addCourse("chemistry");
    mark.addCourse("physics");

    System.out.println(
        mark.getName() + ": кількість вивчаємих дисциплін - " + mark.getCourseCount());

    System.out.println(mark.getName() + ": рік навчання - " + mark.getYear());

    System.out.println(mark.getName() + ": заплатив за навчання - " + mark.getTuition());
  }

  int year;
  String name;
  ArrayList<String> courses = new ArrayList<>();

  Student(String name, int year) {
    if (year < 0) {
      return;
    }

    this.name = name;
    this.year = year;
  }

  String getName() {
    return this.name;
  }

  int getYear() {
    return this.year;
  }

  int getTuition() {
    return this.year * 20000;
  }

  void addCourse(String courseName) {
    courses.add(courseName);
  }

  void dropAll() {
    courses.clear();
  }

  int getCourseCount() {
    return courses.size();
  }
}
