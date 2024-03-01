package Motoare;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        List<Motor> motoare = Arrays.asList(
                new MotorDiesel("Mercedes", 250, 2000),
                new MotorCombustieInterna("Honda", 150, 7000),
                new MotorReactie("Ariane", 3000, MotorReactie.TipCombustibil.LICHID),
                new MotorDiesel("Volvo", 180, 1800),
                new MotorCombustieInterna("Toyota", 120, 6000),
                new MotorReactie("SpaceX", 4500, MotorReactie.TipCombustibil.SOLID)
        );

        System.out.println("Datele initiale:");
        for (Motor motor : motoare) {
            System.out.println(motor);
        }

//        System.out.println("Lista motoarelor:");
//        System.out.println(Arrays.toString(motoare.toArray()));

        System.out.println();
        Scanner scanner = new Scanner(System.in);
        //filtrare dupe un parametru
        System.out.print("Introduceti parametrul de filtrare (putere, cilindree, turatie maxima, tip combustibil): ");
        String parametru = scanner.nextLine();

        List<Motor> motoareFiltrate = Motor.filtrare(motoare, motor -> {
            switch (parametru) {
                case "putere":
                    return motor.putere > 200;
                case "cilindree":
                    return motor instanceof MotorDiesel && ((MotorDiesel) motor).getCilindree() > 1800;
                case "turatie maxima":
                    return motor instanceof MotorCombustieInterna && ((MotorCombustieInterna) motor).getTuratieMaxima() > 7000;
                case "tip combustibil":
                    return motor instanceof MotorReactie && ((MotorReactie) motor).getTipCombustibil() == MotorReactie.TipCombustibil.LICHID;
                default:
                    return false;
            }
        });

        System.out.println("\nMotoare filtrate dupa " + parametru + ":");
        for (Motor motor : motoareFiltrate) {
            System.out.println(motor);
        }

        System.out.println();

        //filtrare dupa doua parametre
        System.out.print("Introduceti primul parametru de filtrare (putere, cilindree, turatie maxima, tip combustibil): ");
        String parametru1 = scanner.nextLine();

        System.out.print("Introduceti al doilea parametru de filtrare (putere, cilindree, turatie maxima, tip combustibil): ");
        String parametru2 = scanner.nextLine();

        List<Motor> motoareFiltrate2 = Motor.filtrare(motoare, motor -> {
            boolean conditie1 = false;
            boolean conditie2 = false;

            switch (parametru1) {
                case "putere":
                    conditie1 = motor.putere > 200;
                    break;
                case "cilindree":
                    conditie1 = motor instanceof MotorDiesel && ((MotorDiesel) motor).getCilindree() > 1800;
                    break;
                case "turatie maxima":
                    conditie1 = motor instanceof MotorCombustieInterna && ((MotorCombustieInterna) motor).getTuratieMaxima() > 7000;
                    break;
                case "tip combustibil":
                    conditie1 = motor instanceof MotorReactie && ((MotorReactie) motor).getTipCombustibil() == MotorReactie.TipCombustibil.LICHID;
                    break;
            }

            switch (parametru2) {
                case "putere":
                    conditie2 = motor.putere > 200;
                    break;
                case "cilindree":
                    conditie2 = motor instanceof MotorDiesel && ((MotorDiesel) motor).getCilindree() > 1800;
                    break;
                case "turatie maxima":
                    conditie2 = motor instanceof MotorCombustieInterna && ((MotorCombustieInterna) motor).getTuratieMaxima() > 7000;
                    break;
                case "tip combustibil":
                    conditie2 = motor instanceof MotorReactie && ((MotorReactie) motor).getTipCombustibil() == MotorReactie.TipCombustibil.LICHID;
                    break;
            } return conditie1 && conditie2;
        });

        System.out.println("\nMotoare filtrate dupa " + parametru1 + " si " + parametru2 + ":");
        for (Motor motor : motoareFiltrate2) {
            System.out.println(motor);
        }

        System.out.println();
        Motor nouMotor = new MotorDiesel("Mercedes", 250, 2000);

        System.out.println(nouMotor);
        for (Motor motor : motoare) {
            if (motor.equals(nouMotor)) {
                System.out.println("Coincide");
            } else {
                System.out.println("Nu coincide");
            }
        }
    }
}
