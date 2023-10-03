import java.util.ArrayList;

public class Documento implements I_Documento{

    private Integer id;
    private String url;
    private String contenido;
    private ArrayList<String> usuariosAutorizados;

    public Documento(Integer id, String url, String contenido, ArrayList<String> usuariosAutorizados) {
        this.id = id;
        this.url = url;
        this.contenido = contenido;
        this.usuariosAutorizados = usuariosAutorizados;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public ArrayList<String> getUsuariosAutorizados() {
        return usuariosAutorizados;
    }

    public void setUsuariosAutorizados(ArrayList<String> usuariosAutorizados) {
        this.usuariosAutorizados = usuariosAutorizados;
    }


    @Override
    public void mostrarDoc(String url, String mail) {

    }
}
