public class SensorJava {
    private String idSensor;
    private String tipo;
    private double ultimaLectura;
    private String estado;

    public SensorJava(String idSensor, String tipo, double ultimaLectura, String estado) {
        this.idSensor = idSensor;
        this.tipo = tipo;
        this.ultimaLectura = ultimaLectura;
        this.estado = estado;
    }

    public String getIdSensor() { return idSensor; }
    public String getTipo() { return tipo; }
    public double getUltimaLectura() { return ultimaLectura; }
    public String getEstado() { return estado; }

    public void setUltimaLectura(double ultimaLectura) { this.ultimaLectura = ultimaLectura; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SensorJava that = (SensorJava) o;
        return Double.compare(that.ultimaLectura, ultimaLectura) == 0 && idSensor.equals(that.idSensor);
    }

    @Override
    public String toString() {
        return "SensorJava{" + "id='" + idSensor + '\'' + ", lectura=" + ultimaLectura + '}';
    }
}