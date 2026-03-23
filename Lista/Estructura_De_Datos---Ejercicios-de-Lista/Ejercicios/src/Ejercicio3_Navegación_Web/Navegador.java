package Ejercicio3_Navegación_Web;

public class Navegador {
    static void main(String[] args) {
        Pagina.HistorialNavegacion nav = new Pagina.HistorialNavegacion();

        // Agregar paginas
        nav.agregarNuevaPagina(new Pagina("Google.com", "Google"));
        nav.agregarNuevaPagina(new Pagina("Wikipedia.org", "Wikipedia"));
        nav.agregarNuevaPagina(new Pagina("Youtube.com", "Youtube"));

        // Mostrar historial
        nav.mostrarHistorialCompleto();

        // Navegar hacia atras
        nav.navegarAtras();
        nav.navegarAtras();

        // Navegar hacia adelante
        nav.navegarAdelante();

        // Agregar una nueva pagina
        System.out.println("\n --- Navegando a una nueva pagina ---");
        nav.agregarNuevaPagina(new Pagina("Github.com", "Github"));

        // Mostrar historial
        nav.mostrarHistorialCompleto();

        // Prueba del limite de paginas
        System.out.println("\n--- Probando límite de 10 ---");
        nav.agregarNuevaPagina(new Pagina("page1.com", "Página 1"));
        nav.agregarNuevaPagina(new Pagina("page2.com", "Página 2"));
        nav.agregarNuevaPagina(new Pagina("page3.com", "Página 3"));
        nav.agregarNuevaPagina(new Pagina("page4.com", "Página 4"));
        nav.agregarNuevaPagina(new Pagina("page5.com", "Página 5"));
        nav.agregarNuevaPagina(new Pagina("page6.com", "Página 6"));
        nav.agregarNuevaPagina(new Pagina("page7.com", "Página 7"));

        // La más antigua debe ser borrada
        nav.mostrarHistorialCompleto();

        // Buscar
        nav.buscarPagina("Wiki");
        nav.buscarPagina("Google");

        // Limpiar historial
        nav.limpiarHistorialCompleto();
        nav.mostrarHistorialCompleto();


    }
}
