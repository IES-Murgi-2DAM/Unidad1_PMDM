data class SensorKt(val idSensor: String, val tipo: String, var ultimaLectura: Double, var estado: String? = null) {
    /* Si sobreescribo el toString puedo emular el comportamiento de la clase Java que estoy refactorizando,
        * pero en Kotlin no es necesario, ya que el data class genera automáticamente un toString() que muestra
        * los valores de los atributos de la clase. Lo dejo comentado */
//    override fun toString(): String {
//        return "SensorKt{id='$idSensor', lectura=$ultimaLectura}"
//    }

    /* Podría tambier usar el equals nativo de Kotlin, pero para emular el comportamiento de la clase Java que estoy
     * refactorizando tendría que poner algunos atributos en el constructor principal y otros en el cuerpo de la clase
     * lo que modificaría el comportamiento del método copy nativo y del método toString nativo */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false
        return super.equals(other)
    }

    /* Aunque la tarea no lo pide, redefino también hashCode para que sea consistente con equals,
     * ya que si redefino equals debería redefinir hashCode */
    override fun hashCode(): Int {
        var result = ultimaLectura.hashCode()
        result = 31 * result + idSensor.hashCode()
        result = 31 * result + tipo.hashCode()
        result = 31 * result + estado.hashCode()
        return result
    }
}

// Función de extensión
fun SensorKt.esCritico(): Boolean {
    return this.tipo == "TEMPERATURA" && this.ultimaLectura > 35.0
}

fun main() {
    val sensor1 = SensorKt("S1", "TEMPERATURA", 33.5, "ACTIVO")
    val sensor2 = SensorKt("S2", "HUMEDAD", 50.0, "INACTIVO")
    val sensor3 = SensorKt("S3", "TEMPERATURA", 36.0)

    println(sensor1) // Muestra: SensorKt(idSensor=S1, tipo=TEMPERATURA, ultimaLectura=33.5, estado=null)
    println(sensor2) // Muestra: SensorKt(idSensor=S2, tipo=HUMEDAD, ultimaLectura=50.0, estado=null)
    println(sensor3) // Muestra: SensorKt(idSensor=S3, tipo=TEMPERATURA, ultimaLectura=36.0, estado=null)

    println("Sensor 1 es crítico: ${sensor1.esCritico()}") // Muestra: Sensor 1 es crítico: false
    println("Sensor 2 es crítico: ${sensor2.esCritico()}") // Muestra: Sensor 2 es crítico: false
    println("Sensor 3 es crítico: ${sensor3.esCritico()}") // Muestra: Sensor 3 es crítico: true
}