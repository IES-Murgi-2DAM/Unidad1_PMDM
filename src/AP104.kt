// Vamos a hacer una muestra de transición de la lógica imperativa a la lógica funcional en Kotlin.

val lecturasRaw = listOf(23.5, -99.0, 36.8, 41.2, -99.0, 18.0, 35.5)

// Descartar los valores erróneos
val lecturasValidas = lecturasRaw.filter { it >= 0 }

// Formatear cada lectura a un formato más claro usando una string template
val lecturasFormateadas = lecturasValidas.map { "Lectura: ${"%.2f".format(it)} ºC" }

// Calcular la media de las lecturas válidas
val media = if (lecturasValidas.isNotEmpty()) lecturasValidas.average() else 0.0

// Búsqueda segura de un valor específico quedándome con la primera coincidencia. Como la tarea habla de buscar
// el sensor mayor a 40ºC, voy a intentar mostrar la versión formateada de la información y dejo un mensaje con el
// operador Elvis, ya que usaré firstOrNUll. Hago esto porque pondré un String en el operador Elvis y no quiero que
// la variable pueda tener dos tipos de datos distintos.
val primeraLecturaCritica = lecturasValidas.firstOrNull { it > 40 }
    ?.let { "Lectura crítica: ${"%.2f".format(it)} ºC" }
    ?: "No hay lecturas críticas."

fun main() {
    println("Lecturas válidas: $lecturasValidas")
    println("Lecturas formateadas: $lecturasFormateadas")
    println("Media de lecturas válidas: ${"%.2f".format(media)} ºC")
    print("Lectura crítica: ")
    println(primeraLecturaCritica)
}