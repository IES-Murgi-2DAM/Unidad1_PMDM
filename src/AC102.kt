// Función de diagnóstico
fun evaluarTemperatura(temperatura: Double, umbralAlerta: Double = 35.0): String =
    if (temperatura > umbralAlerta) {
        "ALERTA ($temperatura ºC)"
    } else {
        "NORMAL ($temperatura ºC)"
    }

// Función de resumen de sector
fun imprimirInformeSector(sector: String, temperaturas: List<Double>, umbralAlerta: Double = 35.0) {
    for (temperatura in temperaturas) {
        println("Sector: $sector | ${evaluarTemperatura(temperatura, umbralAlerta)}")
    }
}

fun main() {
    val lecturasSectorB = listOf(32.0, 36.5, 29.8, 38.0, 34.2)
    val lecturasSectorC = listOf(28.5, 30.0, 31.2, 29.9, 33.1)
    imprimirInformeSector("Sector B - Invernadero Norte", lecturasSectorB)
    imprimirInformeSector("Sector C - Invernadero Sur", lecturasSectorC, 30.0)
}