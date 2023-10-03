public class Usuario implements I_Documento{
    private Integer id;
    private String mail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Usuario(Integer id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    @Override
    public void mostrarDoc(String url, String mail) {

    }
}
