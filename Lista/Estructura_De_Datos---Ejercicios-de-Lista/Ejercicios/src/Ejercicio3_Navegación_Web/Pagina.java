package Ejercicio3_Navegación_Web;

class Pagina {
    String titulo;
    String url;

    // Crear una nueva pagina
    public Pagina(String url, String titulo){
        this.titulo = titulo;
        this.url = url;
    }

    // Devolver la representacion en String
    @Override
    public String toString(){
        return "Titulo: " + this.titulo + "con: " + this.url;
    }

    // Administrador del historial
    static class HistorialNavegacion {

        class Nodo {
            Pagina pagina;
            Nodo siguiente;
            Nodo anterior;

            public Nodo(Pagina pagina) {
                this.pagina = pagina;
                this.siguiente = null;
                this.anterior = null;
            }
        }

        private Nodo cabeza; // Pagina más antigua
        private Nodo cola; // Pagina más reciente
        private Nodo actual; // Pagina que se esta mostrando
        private int tamano;
        private final int MAX_HISTORIAL = 10;

        public HistorialNavegacion() {
            this.cabeza = null;
            this.cola = null;
            this.actual = null;
            this.tamano = 0;
        }

        // Devolver la página actual
        public Pagina getPaginaActual() {
            if (actual == null) {
                return new Pagina("about:blank", "Pagina vacia");
            }
            return actual.pagina;
        }

        // Agregar nueva pagina
        public void agregarNuevaPagina(Pagina pagina) {
            System.out.println("Visitando: " + pagina.titulo);
            Nodo nuevoNodo = new Nodo(pagina);
            tamano++;

            if (actual == null) {
                // Caso: El historial esta vacio
                cabeza = nuevoNodo;
                cola = nuevoNodo;
                actual = nuevoNodo;
            } else {
                // Caso: El historial ya tiene registros
                actual.siguiente = nuevoNodo;
                nuevoNodo.anterior = actual;

                cola = nuevoNodo;

                actual = nuevoNodo;
            }
            aplicarLimiteHistorial();
        }

        // Limitar historial a 10
        public void aplicarLimiteHistorial() {
            while (tamano > MAX_HISTORIAL) {
                if (cabeza == null) { // Chequeo de seguridad
                    tamano = 0;
                    break;
                }
                cabeza = cabeza.siguiente;
                tamano--;
                if (cabeza != null) {
                    cabeza.anterior = null;
                } else {
                    // La lista se vació
                    cola = null;
                    actual = null;
                }
            }
        }

        // Navegar hacia atras
        public void navegarAtras(){
            if (actual != null && actual.anterior != null){
                actual = actual.anterior;
                System.out.println("<- Atrás: " + actual.pagina.titulo);
            } else{
                System.out.println("<- No hay página anterior");
            }

        }
        // Navegar hacia adelante
        public void navegarAdelante(){
            if (actual != null && actual.siguiente != null) {
                actual = actual.siguiente;
                System.out.println("-> Adelante: " + actual.pagina.titulo);
                } else {
                System.out.println("-> No hay página siguiente");

            }
        }

        // Mostrar historial
        public void mostrarHistorialCompleto(){
            System.out.println("\n --- Historial ---");

            if (cabeza == null){
                System.out.println("Historial vacio");
                return;
            }

            Nodo temp = cabeza;
            int i = 1;

            while (temp != null){
                String indicador = (temp == actual) ? "--> " : "  ";
                System.out.println(indicador + i + ". " + temp.pagina);
                temp = temp.siguiente;
                i++;
            }
            System.out.println("-------------");
        }
        //Buscar una pagina en esppecifico del historial
        public void buscarPagina(String termino){
            System.out.println("Buscando termino: " +  termino + "...");
            if (cabeza == null){
                System.out.println("El historial está vacio");
                return;
            }

            boolean encontrado = false;
            Nodo temp = cabeza;
            while (temp != null){
                if (temp.pagina.titulo.toLowerCase().contains(termino.toLowerCase()) ||
                        temp.pagina.url.toLowerCase().contains(termino.toLowerCase())) {
                    System.out.println("Encontrado: " + temp.pagina);
                    encontrado = true;
                }
                temp = temp.siguiente;
            }

            if (!encontrado){
                System.out.println("No se encontraron coincidencias");
            }
        }

        // Limpiar el historial
        public void limpiarHistorialCompleto(){
            cabeza = null;
            cola = null;
            actual = null;
            tamano = 0;
            System.out.println("\n --- Historial Borrado ---");
        }
    }
}
