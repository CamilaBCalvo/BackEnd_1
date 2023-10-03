import java.util.ArrayList;
import java.util.List;

public class ProxyDocumento implements I_Documento {

    private ArrayList<String> usuariosAutorizados;
    private

    ProxyDocumento(ArrayList<String> usuariosAutorizados) {
        this.usuariosAutorizados = usuariosAutorizados;

    }

    @Override
    public void mostrarDoc(String url, String mail) {
        if(this.usuariosAutorizados.contains(mail))
            System.out.println("El usuario esta autorizado");
    }else{
            System.out.println("No esta autorizado a ver el documento");
        }
}
