package Ejercicio1_Lista_Tareas_Pendientes;

public class GestionTareas {
    static void main(String[] args) {
        ListaTareas miLista = new ListaTareas();

        // Agregar tareas a la lista
        miLista.agregarTarea(new Tarea("Comprar leche", "media"));
        miLista.agregarTarea(new Tarea("Hacer ejercicio", "alta"));
        miLista.agregarTarea(new Tarea("Limpiar la casa", "baja"));

        // Mostrar todas las tareas
        miLista.mostrarTodas();

        // Mostrar solo las de prioridad Alta
        miLista.mostrarAltaPrioridad();

        // Buscar una tarea
        miLista.buscarPorDescripcion("Hacer ejercicio");
        miLista.buscarPorDescripcion("Comprar leche");

        // Completar tareas
        miLista.completarTarea("Limpiar la casa");
        miLista.completarTarea("Terminar los diagramas"); // No existe esta tarea

        // Mostrar todas las tareas nuevamente
        miLista.mostrarTodas();
    }
}
