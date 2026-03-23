package Ejercicio2_Playlist_Musical_Circular;

import javax.swing.*;

// Clase Cancion
class Cancion {
    String titulo;
    String artista;

    // Crear una nueva cancion
    public Cancion(String titulo, String artista){
        this.artista = artista;
        this.titulo = titulo;
    }

    // Devolver la representacion en String
    @Override
    public String toString(){
        return this.titulo + " por: " + this.artista;
    }
}

// Clase PlaylistCircular
class PlaylistCircular{

    // Clase Nodo para almacenar canciones en la lista
    class Nodo{
        Cancion cancion;
        Nodo siguiente;
        Nodo anterior;

        public Nodo(Cancion cancion){
            this.cancion = cancion;
            this.siguiente = null;
            this.anterior = null;
        }
    }

    private Nodo actual;

    public PlaylistCircular(){this.actual = null;}

    // Agregar una nueva canción a la lista
    public void agregarCancion(Cancion cancion){
        Nodo nuevo = new Nodo(cancion);

        // Si la playlist esta vacia
        if (actual == null){
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;
            actual = nuevo;
        }else {
            // Si la lista ya tiene canciones
            Nodo siguiente = actual.siguiente;

            nuevo.siguiente = actual.siguiente;
            nuevo.anterior = actual;

            actual.siguiente = nuevo;
            siguiente.anterior = nuevo;
        }
        System.out.println("Cancion agregada: " + cancion);
    }

    // Reproducir la siguiente canción
    public void reproducirSiguiente(){
        if (actual == null){
            System.out.println("La playlist está vacia");
            return;
        }
        actual = actual.siguiente;
        System.out.println("Reproduciendo: " + actual.cancion);
    }

    // Reproducir la canción anterior
    public void reproducirAnterior(){
        if (actual == null){
            System.out.println("La playlist está vacia");
            return;
        }
        actual = actual.anterior;
        System.out.println("Reproduciendo: " + actual.cancion);
    }

    // Eliminar canciones
    public void eliminarCancionActual(){
        if (actual == null){
            System.out.println("No hay nada que eliminar, la playlist está vacia");
            return;
        }
        System.out.println("Eliminando: " + actual.cancion);

        if (actual == actual.siguiente){
            // Caso: Es la única canción en la lista
            actual = null;
        } else {
            // Caso: Hay más canciones en la lista
            Nodo siguiente = actual.siguiente;
            Nodo anterior = actual.anterior;
            siguiente.anterior = anterior;
            anterior.siguiente = siguiente;
            actual = siguiente;
        }
    }

    // Mostrar la canción actual
    public void mostrarCancionActual(){
        System.out.println("Reproduciendo: ");

        if (actual == null){
            System.out.println("La playlist está vacia");
        } else {
            System.out.println(actual.cancion);
        }
    }

    // Mostrar todas las canciones
    public void mostrarTodas(){
        System.out.println("\n --- Playlist ---");
        if (actual == null){
            System.out.println("La playlist está vacia");
            System.out.println("---------------------------");
            return;
        }

        Nodo temp = actual; // se empieza en la canción actual
        do {
            String indicador = (temp == actual) ? "-->" : "   ";

            System.out.println(indicador + temp.cancion);

            temp = temp.siguiente;
        } while (temp != actual);
    }
}
