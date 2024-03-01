package Motoare;

public class MotorDiesel extends Motor{
    private int cilindree;
    public MotorDiesel(String nume, int putere, int cilindree) {
        super(nume, putere);
        this.cilindree = cilindree;
    }

    public MotorDiesel() {
        this("Necunoscut", 0, 0);
    }

    @Override
    public String getTipMotor() {
        return "Diesel";
    }

    public int getCilindree() {
        return cilindree;
    }

    public void setCilindree(int cilindree) {
        this.cilindree = cilindree;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cilindree: " + cilindree;
    }
}
