package Ejercicio2_Playlist_Musical_Circular;

public class Playlist {
    static void main(String[] args) {
        PlaylistCircular miPlaylist = new PlaylistCircular();

        // Agregar canciones a la playlist
        miPlaylist.agregarCancion(new Cancion("Caguamas", "Under Side 821"));
        miPlaylist.agregarCancion(new Cancion("Hotel California", "Eagles"));
        miPlaylist.agregarCancion(new Cancion("Almohada", "José José"));

        // Mostrar la lista completa de canciones
        miPlaylist.mostrarTodas();

        // Reproducir siguiente "Hotel California"
        System.out.println("\n --- Siguiente canción ---");
        miPlaylist.reproducirSiguiente();

        // Reproducir siguiente "Almohada"
        System.out.println("\n --- Siguiente canción ---");
        miPlaylist.reproducirSiguiente();

        // Reproducir anterior
        System.out.println("\n --- Canción anterior ---");
        miPlaylist.reproducirAnterior();

        // Elimininar la canción actual
        System.out.println("\n --- Eliminando canción actual ---");
        miPlaylist.eliminarCancionActual();

        // Mostrar lista nuevamente
        miPlaylist.mostrarTodas();

        // Mostrar la canción actual
        System.out.println("\n --- Canción actual ---");
        miPlaylist.mostrarCancionActual();
    }
}
