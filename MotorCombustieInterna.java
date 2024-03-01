package Motoare;

public class MotorCombustieInterna extends Motor{
    private int turatieMaxima; //max speed
    public MotorCombustieInterna(String nume, int putere, int turatieMaxima) {
        super(nume, putere);
        this.turatieMaxima = turatieMaxima;
    }

    public MotorCombustieInterna() {
        this("Necunoscut", 0, 0);
    }

    @Override
    public String getTipMotor() {
        return "Combustie Interna";
    }

    public int getTuratieMaxima() {
        return turatieMaxima;
    }

    public void setTuratieMaxima(int turatieMaxima) {
        this.turatieMaxima = turatieMaxima;
    }

    @Override
    public String toString() {
        return super.toString() + ", Turatie Maxima: " + turatieMaxima;
    }
}
