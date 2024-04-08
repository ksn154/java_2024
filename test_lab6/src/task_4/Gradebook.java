package task_4;

import java.util.*;

public class Gradebook extends TreeMap<Float, List<Student>> {

    private Comparator<Float> comparator;

    public Gradebook(Comparator<Float> comparator) {
        super(comparator);
        this.comparator = comparator;
    }

    public void add(Student student) {
        float roundedGrade = Math.round(student.getMedie() * 10) / 10f;

        if (roundedGrade < 0 || roundedGrade > 10) {
            throw new IllegalArgumentException("Media studentului trebuie sa fie intre 0 si 10!");
        }

        List<Student> students = get(roundedGrade);
        if (students == null) {
            students = new ArrayList<>();
            put(roundedGrade, students);
        }

        students.add(student);
    }

    public void print() {
        for (Map.Entry<Float, List<Student>> entry : entrySet()) {
            System.out.println("Nota: " + entry.getKey());
            Collections.sort(entry.getValue());
            for (Student student : entry.getValue()) {
                System.out.println(" - " + student);
            }
        }
    }
}

class Student implements Comparable<Student> {

    private String nume;
    private float medie;

    public Student(String nume, float medie) {
        this.nume = nume;
        this.medie = medie;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public float getMedie() {
        return medie;
    }

    public void setMedie(float medie) {
        this.medie = medie;
    }

    @Override
    public int compareTo(Student other) {
        return this.nume.compareTo(other.nume);
    }

    @Override
    public String toString() {
        return nume + " (" + medie + ")";
    }
}

class Main {
    public static void main(String[] args) {

        //Сравнение для сортировки средней в порядке убывания
        Comparator<Float> comparator = Collections.reverseOrder();

        //Создание Gradebook
        Gradebook gradebook = new Gradebook(comparator);

        //Добавление студентов
        gradebook.add(new Student("Ana", 8.20f));
        gradebook.add(new Student("Mihai", 9.50f));
        gradebook.add(new Student("Andrei", 7.80f));
        gradebook.add(new Student("Ioana", 6.90f));
        gradebook.add(new Student("Matei", 10.0f));

        //Вывод Gradebook
        gradebook.print();
    }
}