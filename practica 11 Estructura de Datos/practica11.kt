//gestion de tareas
class CustomList<T>{
    private val elements = mutableListOf<T>()

    fun add(element: T): Boolean {
        return if (element !in elements){
            elements.add(element)
            println("tarea agregada exitositamente")
            true
        }else {
            println("la tarea ya existe")
            false
        }
    }

    fun remove(element: T): Boolean{
        return if (element in elements){
            elements.remove(element)
            println("Tarea eliminada")
            true
        } else {
            println("La tarea no se encuentra en la lista")
            false
        }
    }

    fun showAll(){
        if (elements.isEmpty()){
            println("La lista esta vacia")
        }else{
            println("La lista de tareas:")
            elements.forEach { println(" - $it")}

        }
    }

    fun size(): Int{
        return elements.size
    }
}

//main
fun main (args: Array<String>) {
    val listaTareas = CustomList<String>()
    var opcion: Int

    do{
        println("\nGestor de tareas")
        println("1. agregar tarea")
        println("2. eliminar tarea")
        println("3. ver lista de tarea")
        println("4. salir")
        println("selecciona una opcion: ")
        opcion = readLine()?.toIntOrNull()?:0

        when (opcion){
            1->{
                println("ingrese la nueva tarea: ")
                val nuevaTarea = readLine()?: ""
                listaTareas.add(nuevaTarea)
            }
            2->{
                if (listaTareas.size() > 0){
                    println("seleccione la tarea que desea eliminar:")
                    listaTareas.showAll()
                    println("ingrese el nombre exacto de la tarea: ")
                    val eliminarTareas = readLine()?: ""
                    listaTareas.remove(eliminarTareas)
                }else{
                    println("la tarea no esta en la lista")
                }
            }
            3->{
                listaTareas.showAll()
            }
            4-> println("saliendo del programa...")

            else -> println("Opcion no valida, ingrese una opcion valida. ")
        }
    } while (opcion != 4)
}