// Author: Jose A. González

fun main() {
    val nombreDelTecnico = "Jose A. González"
    var revisiones: Int = 3
    val temperaturaTexto = "38.5";
    val temperatura = temperaturaTexto.toDouble()
    val estadoInvernadero = fun(temperatura: Double): String {
        if (temperatura > 35.0) {
            return "ALERTA: Activar ventilación lateral e irrigación."
        } else {
            return "ESTADO NORMAL: Parámetros óptimos."
        }
    }(temperatura)

    var observacionesTecnico: String? = null

    revisiones++

    println("Técnico: $nombreDelTecnico | Revisiones hoy: $revisiones")

    println("Estado del invernadero: $estadoInvernadero")

    println("Ahora mismo las observaciones del técnico miden: ${observacionesTecnico?.length}")

    observacionesTecnico = "Sensor 04 con acumulación de humedad"

    println("Ahora mismo las observaciones del técnico miden: ${observacionesTecnico.length ?: 0 }")
}