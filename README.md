# Unidad 1 PMDM

En este repositorio iré resolviendo los ejercicios de la Unidad 1 de PMDM

## AC101
He generado la versión más corta con el código que se ha dado en clase hasta ahora

## AC102
He generado una versión acortada del código que intenta probar varios casos posibles

## AC103
He generado la versión más cercana a lo que indican los apuntes añadiendo comentarios explicativos

### Requisito 1
La clase no es incompatible con Android por estar escrita en Java, pero tiene aspectos que pueden hacer que una aplicación móvil sea menos fiable:
1. El estado del sensor no está limitado a opciones válidas. estado es un String, así que se le puede asignar cualquier texto, incluso uno incorrecto o escrito de otra forma, como "OK" y "ok". La aplicación podría no reconocerlo y tratar mal la lectura. Un tipo con opciones definidas, como un enum, evitaría muchos de esos errores.
2. Los datos se pueden modificar sin validarlos. Aunque los campos son private, los métodos setEstado y setUltimaLectura son públicos y aceptan cualquier valor. Por ejemplo, se podría guardar un estado desconocido o una lectura que no tenga sentido para la aplicación. En una app móvil, esos datos incorrectos pueden provocar pantallas o resultados inesperados.
3. Un valor nulo podría causar un fallo en tiempo de ejecución. Java permite que idSensor sea null, y el método equals llama a idSensor.equals(...). Si se compara un sensor cuyo identificador es nulo, puede producirse una NullPointerException y cerrarse la operación que estaba realizando la app.
Los campos no tienen visibilidad pública: son privados. El problema relacionado con la visibilidad es que algunos métodos públicos permiten cambiar ciertos datos sin comprobar que sean válidos. La falta de gestión de excepciones no la presentaría como un inconveniente propio de esta clase, ya que su función principal es almacenar datos y no realiza operaciones que necesariamente deban lanzar excepciones.
