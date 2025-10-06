package ua.opnu;

public class TimeSpan {

    private int hours;
    private int minutes;

    // Конструктор
    TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Некоректні години або хвилини");
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    // Повертає кількість годин
    int getHours() {
        return hours;
    }

    // Повертає кількість хвилин
    int getMinutes() {
        return minutes;
    }

    // Додавання годин і хвилин до інтервалу
    void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Некоректні години або хвилини");
        }

        int totalMinutes = this.minutes + minutes;
        int totalHours = this.hours + hours + totalMinutes / 60;
        totalMinutes %= 60;

        this.hours = totalHours;
        this.minutes = totalMinutes;
    }

    // Додавання іншого TimeSpan
    void addTimeSpan(TimeSpan timespan) {
        add(timespan.getHours(), timespan.getMinutes());
    }

    // Загальна кількість годин (у вигляді дробового числа)
    double getTotalHours() {
        return hours + minutes / 60.0;
    }

    // Загальна кількість хвилин
    int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    // Віднімання іншого інтервалу
    void subtract(TimeSpan span) {
        int totalThis = getTotalMinutes();
        int totalOther = span.getTotalMinutes();

        if (totalOther > totalThis) {
            throw new IllegalArgumentException("Неможливо відняти більший інтервал від меншого");
        }

        int result = totalThis - totalOther;
        this.hours = result / 60;
        this.minutes = result % 60;
    }

    // Масштабування інтервалу
    void scale(int factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Множник має бути більше 0");
        }

        int totalMinutes = getTotalMinutes() * factor;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }
}
