package ua.opnu;

public class TimeSpan {

  // TODO: add class fields

  int hours, minutes;

  TimeSpan(int hours, int minutes) {

    if (hours < 0 || minutes < 0 || minutes > 59) {
      return;
    }

    this.hours = hours;
    this.minutes = minutes;
  }

  int getHours() {
    return hours;
  }

  int getMinutes() {
    // TODO: write method body
    return minutes;
  }

  void add(int hours, int minutes) {

    if (hours < 0 || minutes < 0 || minutes > 59) {
      return;
    }

    this.minutes += minutes;

    if (this.minutes > 59) {

      this.hours += (hours + this.minutes / 60);
      this.minutes = this.minutes - 60;

      return;
    }

    this.hours += hours;
    // TODO: write method body
  }

  void addTimeSpan(TimeSpan timespan) {

    this.minutes += timespan.getMinutes();

    if (this.minutes > 59) {

      this.hours += (timespan.getHours() + this.minutes / 60);
      this.minutes = this.minutes - 60;

      return;
    }

    this.hours += timespan.getHours();

    // TODO: write method body
  }

  double getTotalHours() {

    double min = this.minutes;

    // TODO: write method body
    return this.hours + (((min * 100) / 60)) / 100;
  }

  int getTotalMinutes() {

    return this.minutes + (this.hours * 60);
  }

  void subtract(TimeSpan span) {

    int a = this.hours * 60 + this.minutes;
    int b = span.hours * 60 + span.minutes;

    if (a < b) {
      return;
    }

    this.hours = (a - b) / 60;
    this.minutes = (a - b) % 60;

    // TODO: write method body
  }

  void scale(int factor) {

    if (factor <= 0) {
      return;
    }
    int a = this.hours * 60 + this.minutes;

    int b = a * factor;

    this.hours = (b) / 60;
    this.minutes = (b) % 60;

    // TODO: write method body
  }
}
