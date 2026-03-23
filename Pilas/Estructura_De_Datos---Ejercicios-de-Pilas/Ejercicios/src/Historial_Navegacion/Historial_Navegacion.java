package Historial_Navegacion;
import java.util.Stack;

class PaginaWeb {
    String url;

    // Constructor de la Página
    public PaginaWeb(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return url;
    }

    static class HistorialNavegador {
        private Stack<PaginaWeb> pilaAtras;
        private Stack<PaginaWeb> pilaAdelante;
        private PaginaWeb paginaActual;

        public HistorialNavegador() {
            pilaAtras = new Stack<>();
            pilaAdelante = new Stack<>();
            paginaActual = null; // Se empieza sin ver ninguna pagina
        }

        // nuevaPagina La nueva página a visitar
        public void nuevaPagina(PaginaWeb nuevaPagina) {
            System.out.println("Estamos visitando: " + nuevaPagina);

            if (paginaActual != null) {
                pilaAtras.push(paginaActual);
            }

            // la nueva pagina es ahora la actual
            paginaActual = nuevaPagina;

            // Si visitamos una nueva, la pila de adelante se borra.
            if (!pilaAdelante.isEmpty()) {
                System.out.println(" --- Borrando historial 'adelante' --- ");
                pilaAdelante.clear();
            }
        }
        public void navegarAtras() {
            if (!pilaAtras.isEmpty()) {
                System.out.println("<--- ATRAS: no hay mas páginas tilin");
                return;
            }

            // se guarda la actual en la de adelante
            pilaAdelante.push(paginaActual);

            // sacamos la de atras y se muestra
            paginaActual = pilaAtras.pop();

            System.out.println("<--- Atras: cargando " + paginaActual);
        }

        public void navegarAdelante() {
            if (pilaAdelante.isEmpty()){
                System.out.println("---> Adelante: No hay más paginas tilin");
                return;
            }

            // Se guarda la pagina actual en la pila Atras
            pilaAtras.push(paginaActual);

            // Se muestra la pila de adelante
            paginaActual = pilaAdelante.pop();

            System.out.println("---> Adelante: cargando " + paginaActual);
        }

        public void mostrarEstadoActual(){
            System.out.println("\n ---  Estado del Navegador  ---- ");
            System.out.println("Historial Atrás: " + pilaAtras);
            System.out.println("Página Actual: " + paginaActual);
            System.out.println("Historial Adelante: " + pilaAdelante);
            System.out.println("---------------------------------");
        }
    }
}
