public class Main {
    public static void main(String[] args) {
        ProxySpotify proxySpotify = new ProxySpotify();

        Usuario usuario1 = new Usuario(1,"free");
        Usuario usuario2 = new Usuario(2,"free");
        Usuario usuario3 = new Usuario(3,"premium");
        Usuario usuario4 = new Usuario(4,"premium");

        proxySpotify.descargar(usuario1.getNivel(),usuario1.getId());
        proxySpotify.descargar(usuario2.getNivel(),usuario2.getId());
        proxySpotify.descargar(usuario3.getNivel(),usuario3.getId());
        proxySpotify.descargar(usuario4.getNivel(),usuario4.getId());

    }
}
