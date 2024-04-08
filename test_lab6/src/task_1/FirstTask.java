package task_1;

import java.util.HashSet;
//HashSet не допускает существование дубликатов.
//Класс HashSet является реализацией интерфейса Set и использует внутреннюю hashmap для хранения элементов.
//Hashmap обеспечивает быстрый и эффективный поиск, что делает операции добавления и проверки повторяющихся элементов очень быстрыми.
import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Объявление коллекции типа HashSet с параметром string
        HashSet<String> cuvinte = new HashSet<>();

        //Ввод с клавиатуры набора слов
        System.out.println("Введите число слов:");
        int n = scanner.nextInt();
        scanner.nextLine();

        //Добавление чисел в коллекцию
        System.out.println("Введите слова:");
        for (int i = 0; i < n; i++) {
            String cuvant = scanner.nextLine();

            //Проверка на наличие слов
            if (cuvinte.contains(cuvant)) {
                System.err.println("Erorr: Слово \"" + cuvant + "\" уже было введено!");
            } else {
                //Добавление слова
                cuvinte.add(cuvant);
            }
        }

        //Вывод содержимого
        System.out.println("Коллекция содержит следующие слова:");
        for (String cuvant : cuvinte) {
            System.out.println(cuvant);
        }
    }
}
