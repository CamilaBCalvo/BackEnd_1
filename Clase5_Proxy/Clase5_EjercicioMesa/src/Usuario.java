public class Usuario implements ServicioDescarga {
    private Integer id;
    private String nivel;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Usuario(Integer id, String nivel) {
        this.id = id;
        this.nivel = nivel;
    }

    @Override
    public void descargar(String nivel, Integer id) {

    }
}
