public class Camion extends Vehiculo{
    private float cargaMax;
    private float longi;

    public Camion(String matricula, String modelo, String marca, float km, float precio, String tipoMotor, float cargaMax, float longi) {
        super(matricula, modelo, marca, km, precio, tipoMotor);
        this.cargaMax = cargaMax;
        this.longi = longi;
    }

    public float getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(float cargaMax) {
        this.cargaMax = cargaMax;
    }

    public float getLongi() {
        return longi;
    }

    public void setLongi(float longi) {
        this.longi = longi;
    }
}
