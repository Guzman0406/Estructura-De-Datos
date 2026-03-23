package Gestor_Deshacer;

public class TestEditor {

    public static void main(String[] args) {
        EditorDeTexto editor = new EditorDeTexto();

        // Escribimos "Hola" posicion 0
        IComando cmdHola = new ComandoInsertar(editor.documento, "Hola", 0);
        editor.ejecutarAccion(cmdHola);

        // Escribimos " Mundo" posicion 4
        IComando cmdMundo = new ComandoInsertar(editor.documento, " Mundo", 4);
        editor.ejecutarAccion(cmdMundo);

        editor.mostrarDocumento(); // Muestra "Hola Mundo"

        // Deshacer
        editor.deshacer(); // Deshace " Mundo"
        editor.mostrarDocumento(); // Muestra "Hola"

        // Rehacer
        editor.rehacer(); // Rehace " Mundo"
        editor.mostrarDocumento(); // Muestra "Hola Mundo"


        // Deshacemos 2 veces
        editor.deshacer();
        editor.deshacer();
        editor.mostrarDocumento();

        // Realizamon una nueva accion
        IComando cmdAdios = new ComandoInsertar(editor.documento, "Adios", 0);
        editor.ejecutarAccion(cmdAdios);

        editor.mostrarDocumento(); // Muestra "Adios"


        // Intentamos rehacer
        editor.rehacer();

        editor.mostrarDocumento();
    }
}
