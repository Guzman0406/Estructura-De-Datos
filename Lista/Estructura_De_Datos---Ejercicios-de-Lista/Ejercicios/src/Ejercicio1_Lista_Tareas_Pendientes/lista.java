package Ejercicio1_Lista_Tareas_Pendientes;

import java.util.ArrayList;

// Clase Tarea
class Tarea {
    String descripcion;
    String prioridad; // alta, media o baja

    // Crear una nueva tarea
    public Tarea(String descripcion, String prioridad){
     this.descripcion = descripcion;
     this.prioridad = prioridad;
    }

    // Getters
    public String getDescripcion(){return descripcion;}
    public String getPrioridad() {return prioridad;}

    // Devuelve una representacion de la tarea en formato String
    @Override
    public String toString(){
        return "[" + this.prioridad.toUpperCase() + "] " + this.descripcion;
    }
}

// Clase ListaTareas
class ListaTareas{
    private ArrayList<Tarea> miLista;

    public ListaTareas(){
        miLista = new ArrayList<>();
    }

    // Agregar una nueva tarea a la lista
    public void agregarTarea(Tarea Tarea){
        miLista.add(Tarea);
        System.out.println("Tarea agregada: " + Tarea);
    }

    // Completar una tarea de la lista
    public void completarTarea(String descripcion){
        Tarea tareaParaBorrar = null;

        for (Tarea t: miLista){
            if (t.getDescripcion().equals(descripcion)){
                tareaParaBorrar = t;
                break;
            }
        }

        // Borrar la tarea si se encuentra
        if (tareaParaBorrar != null){
            miLista.remove(tareaParaBorrar);
            System.out.println("Tarea completada " + tareaParaBorrar);
            } else {
            System.out.println("Tarea no encontrada: " + descripcion);
        }

    }
    // Mostrar las tareas pendientes
    public void mostrarTodas(){
        System.out.println();
        System.out.println("--- Lista de tareas pendientes --- ");

        if (miLista.isEmpty()){
            System.out.println("La lista esta vacia");
        } else{
            int i = 1;
            for (Tarea t: miLista)
                System.out.println(i++ + ". " + t);
        }
        System.out.println("---------------------------------");
    }

    // Buscar una tarea por su descripcion
    public void buscarPorDescripcion(String descripcion) {
        System.out.println("\nBuscando tarea: " + descripcion + "...");

        for (Tarea t : miLista) {
            if (t.getDescripcion().equals(descripcion)) {
                System.out.println("Tarea encontrada: " + t);
                return;
            }
        }
        System.out.println("Tarea no encontrada");
    }

    // Buscar tareas con prioridad alta
    public void mostrarAltaPrioridad(){
        System.out.println("\n--- Tareas de alta prioridad ---");
        boolean encontradas = false;

        for (Tarea t: miLista){
            if (t.getPrioridad().equals("alta")){
                System.out.println("- " +  t);
                encontradas = true;
            } else {
                System.out.println("No se encontraron tareas de alta prioridad");
            }
        }
    }
}

