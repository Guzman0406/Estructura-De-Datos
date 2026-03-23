package Historial_Navegacion;

public class Test {
    public static void main(String[] args) {
        PaginaWeb.HistorialNavegador nav = new PaginaWeb.HistorialNavegador();

        // Instanciar paginas
        nav.nuevaPagina(new PaginaWeb("Google.com"));
        nav.nuevaPagina(new PaginaWeb("Youtube.com"));
        nav.nuevaPagina(new PaginaWeb("Github.com"));

        // Mostrar estado actual
        nav.mostrarEstadoActual();

        // Navegar atras
        nav.navegarAtras();

        // Mostrar estado actual nuevamente
        nav.mostrarEstadoActual();

        // Navegar adelante
        nav.navegarAdelante();

        // Visitamos una nueva pagina
        nav.nuevaPagina(new PaginaWeb("Platinum.com"));

        // Verificamos que adelante este vacio
        nav.navegarAdelante();
    }
}
