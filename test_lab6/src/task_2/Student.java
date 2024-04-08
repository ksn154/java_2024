package task_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

class Student {

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
    public String toString() {
        return "[" + nume + ", " + medie + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Student) {
            Student other = (Student) obj;
            return this.nume.equals(other.nume) && this.medie == other.medie;
        }
        return false;
    }

      //task 3
      //важно!!!!
//    @Override
//    public boolean equals(Object obj) {
//        return false;
//    }
//
//    public boolean equals(Student other) {
//        return this.nume.equals(other.nume) && this.medie == other.medie;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, medie);
    }
}

class Test {

    public static void main(String[] args) {
        System.out.println("--------------");
        // HashMap
        HashMap<String, Student> studentiHashMap = new HashMap<>();
        studentiHashMap.put("Matei", new Student("Matei", 4.90F));
        studentiHashMap.put("Andrei", new Student("Andrei", 6.80F));
        studentiHashMap.put("Mihai", new Student("Mihai", 9.90F));

        //Добавление элемента с тем же ключем
        System.out.println(studentiHashMap.put("Andrei", new Student("Andrei", 0.0F))); // Afișează [Andrei, 6.8]

        //Переопределение существующего элемента
        System.out.println(studentiHashMap.get("Andrei")); // Afișează [Andrei, 0.0]

        //Удаление элемента
        System.out.println(studentiHashMap.remove("Matei")); // Afișează [Matei, 4.9]

        //Вывод структуры данных
        System.out.println(studentiHashMap);

        System.out.println("--------------");
        // HashSet
        HashSet<Student> studentiHashSet = new HashSet<>();
        studentiHashSet.add(new Student("Matei", 4.90F));
        studentiHashSet.add(new Student("Andrei", 6.80F));
        studentiHashSet.add(new Student("Mihai", 9.90F));

        //Добавляет дубликат
        studentiHashSet.add(new Student("Andrei", 6.80F)); // Nu se adaugă elementul duplicat

        //Проверка существующего элемента
        System.out.println(studentiHashSet.contains(new Student("Andrei", 6.80F))); // Afișează true

        //Вывод структуры
        System.out.println(studentiHashSet);

        //Итерация
        for (Student student : studentiHashSet) {
            System.out.println(student.equals(student)); // Afișează mereu false
            System.out.println(((Object) student).equals(student)); // Afișează true
        }
    }
}