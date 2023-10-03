public class ProxySpotify implements ServicioDescarga{

    private String nivel;
    private Integer id;

    @Override
    public void descargar(String nivel, Integer id) {
        if (nivel.equals("premium")){
            System.out.println("Para el usuario id: "+id+", se descarga la cancion por ser nivel premium.");
        }else{
            System.out.println("Para el usuario id: "+id+", no se descarga la cancion, por ser nivel free.");
        }
    }
}
