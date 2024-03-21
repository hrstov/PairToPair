public class Coche extends Vehiculo{
    private int plazas;
    private int puertas;
    private float volumenM;
    private String tipoM;

    public Coche(String matricula, String modelo, String marca, float km, float precio, String tipoMotor, int plazas, int puertas, float volumenM, String tipoM) {
        super(matricula, modelo, marca, km, precio, tipoMotor);
        this.plazas = plazas;
        this.puertas = puertas;
        this.volumenM = volumenM;
        this.tipoM = tipoM;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public float getVolumenM() {
        return volumenM;
    }

    public void setVolumenM(float volumenM) {
        this.volumenM = volumenM;
    }

    public String getTipoM() {
        return tipoM;
    }

    public void setTipoM(String tipoM) {
        this.tipoM = tipoM;
    }
}
