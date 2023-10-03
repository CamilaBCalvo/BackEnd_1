import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> usuariosAutorizados = new ArrayList<>();
        usuariosAutorizados.add("usuario1");
        usuariosAutorizados.add("usuario2");

        I_Documento proxy;

        proxy = new ProxyDocumento(usuariosAutorizados,ArrayList<String>(usuariosAutorizados));

        proxy.mostrarDoc();

    }
}
