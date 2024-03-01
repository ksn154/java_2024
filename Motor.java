package Motoare;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class Motor {
    protected String nume;
    protected int putere;
    private String tipMotor;

    public Motor(String nume, int putere) {
        this.nume = nume;
        this.putere = putere;
    } //cu parametri

    public Motor() {
        this("Necunoscut", 0);
    } //fara parametri

    public static List<Motor> filtrare(List<Motor> motoare, Predicate<Motor> predicat) {
        return motoare.stream().filter(predicat).collect(Collectors.toList());
    }

    public abstract String getTipMotor();

    @Override
    public String toString() {
        return String.format("Motor: %s, Putere: %d", nume, putere);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Motor)) {
            return false;
        }
        Motor other = (Motor) obj;
        return Objects.equals(tipMotor, other.tipMotor) && putere == other.putere;
    }
}
