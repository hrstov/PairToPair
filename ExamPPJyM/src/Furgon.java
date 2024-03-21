public class Furgon extends Vehiculo{
    private float cargaMax;
    private int plazas;

    public Furgon(String matricula, String modelo, String marca, float km, float precio, String tipoMotor, float cargaMax, int plazas) {
        super(matricula, modelo, marca, km, precio, tipoMotor);
        this.cargaMax = cargaMax;
        this.plazas = plazas;
    }

    public float getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(float cargaMax) {
        this.cargaMax = cargaMax;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }
}
