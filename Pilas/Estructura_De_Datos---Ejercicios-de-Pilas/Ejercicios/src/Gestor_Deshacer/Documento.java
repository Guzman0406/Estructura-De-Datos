package Gestor_Deshacer;

import java.util.Stack;


class DocumentoTexto {
    public StringBuilder texto;

    public DocumentoTexto() {
        this.texto = new StringBuilder();
    }

    public void insertar(int posicion, String contenido) {
        texto.insert(posicion, contenido);
    }

    public void borrar(int posicion, int longitud) {
        texto.delete(posicion, posicion + longitud);
    }

    @Override
    public String toString() {
        return texto.toString();
    }
}


interface IComando {
    void ejecutar();
    void deshacer();
}


class ComandoInsertar implements IComando {
    private DocumentoTexto documento;
    private String textoAInsertar;
    private int posicion;

    public ComandoInsertar(DocumentoTexto doc, String texto, int pos) {
        this.documento = doc;
        this.textoAInsertar = texto;
        this.posicion = pos;
    }

    @Override
    public void ejecutar() {
        // Ejecutar es insertar el texto
        documento.insertar(posicion, textoAInsertar);
    }

    @Override
    public void deshacer() {
        // Deshacer una inserción es borrar ese mismo texto
        documento.borrar(posicion, textoAInsertar.length());
    }
}


class ComandoBorrar implements IComando {
    private DocumentoTexto documento;
    private String textoBorrado;
    private int posicion;
    private int longitud;

    public ComandoBorrar(DocumentoTexto doc, int pos, int len) {
        this.documento = doc;
        this.posicion = pos;
        this.longitud = len;
    }

    @Override
    public void ejecutar() {
        // Antes de borrar, guarda el texto que va a ser eliminado
        this.textoBorrado = documento.texto.substring(posicion, posicion + longitud);
        // Ejecutar es borrar el texto
        documento.borrar(posicion, longitud);
    }

    @Override
    public void deshacer() {
        // Deshacer un borrado es insertar el texto que guardamos
        documento.insertar(posicion, textoBorrado);
    }
}


class EditorDeTexto {
    DocumentoTexto documento;
    private Stack<IComando> pilaDeshacer;
    private Stack<IComando> pilaRehacer;

    public EditorDeTexto() {
        this.documento = new DocumentoTexto();
        this.pilaDeshacer = new Stack<>();
        this.pilaRehacer = new Stack<>();
    }


    public void ejecutarAccion(IComando comando) {
        System.out.println("Ejecutando acción...");
        comando.ejecutar();

        // La acción se apila en "Deshacer"
        pilaDeshacer.push(comando);


        if (!pilaRehacer.isEmpty()) {
            System.out.println("   (Borrando historial 'rehacer'...)");
            pilaRehacer.clear();
        }
    }

    public void deshacer() {
        if (pilaDeshacer.isEmpty()) {
            System.out.println("DESHACER: Nada que deshacer.");
            return;
        }


        IComando comando = pilaDeshacer.pop();

        comando.deshacer();
        System.out.println("DESHACER: Acción revertida.");

        pilaRehacer.push(comando);
    }


    public void rehacer() {
        if (pilaRehacer.isEmpty()) {
            System.out.println("REHACER: Nada que rehacer.");
            return;
        }

        IComando comando = pilaRehacer.pop();

        comando.ejecutar();
        System.out.println("REHACER: Acción restaurada.");

        pilaDeshacer.push(comando);
    }

    public void mostrarDocumento() {
        System.out.println("\n--- DOCUMENTO ---");
        System.out.println(documento.toString());
        System.out.println("-----------------");
        System.out.println("Pila Deshacer: " + pilaDeshacer.size() + " acciones");
        System.out.println("Pila Rehacer:  " + pilaRehacer.size() + " acciones\n");
    }
}



