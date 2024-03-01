package Motoare;

public class MotorReactie extends Motor{
    private TipCombustibil tipCombustibil;

    public MotorReactie(String nume, int putere, TipCombustibil tipCombustibil) {
        super(nume, putere);
        this.tipCombustibil = tipCombustibil;
    }

    public MotorReactie() {
        this("Necunoscut", 0, TipCombustibil.LICHID);
    }

    @Override
    public String getTipMotor() {
        return "Reactie";
    }

    public TipCombustibil getTipCombustibil() {
        return tipCombustibil;
    }

    public void setTipCombustibil(TipCombustibil tipCombustibil) {
        this.tipCombustibil = tipCombustibil;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tip Combustibil: " + tipCombustibil;
    }

    public enum TipCombustibil {
        LICHID, SOLID
    } //Перечисление
}
