package principal;

import archivos.AccionesMecanico;
import archivos.AccionesMoto;

public class Almacen {

    private final AccionesMecanico archivoMec = new AccionesMecanico();
    private final AccionesMoto archivoMoto = new AccionesMoto();

    public Almacen() {
        
    }

    //Probado
    public Boolean registrarMecanico(String mecanico) {
        return archivoMec.registrarMecanico(mecanico);
    }

    public String buscarMecanicoPorCedula(String cedula) {
        return archivoMec.buscarMecanicoPorId(cedula);
    }

    public String buscarMotocicletaPorCodigo(String cedula) {
        return archivoMec.buscarMecanicoPorId(cedula);
    }
    
    //Probado
    public void registrarMotocicleta(String motocicleta) {
        archivoMoto.registrarMoto(motocicleta);
    }

    //Probado
    public void listarMecanicos() {
        System.out.println("Listado De Mecanicos");
        archivoMec.listarUsuarios();
    }
    
    //Probado
    public void listarMotosPorMarca(String marca) {
        archivoMoto.listarMotosPorMarca(marca);
    }

    //Probado
    public void listarMotosPorCilindraje(String cilindraje) {
        archivoMoto.listarMotosPorCilindraje(cilindraje);
    }

    //Probado
    public void listarMotosEnBodega() {
        archivoMoto.listarMotoEnBodega();
    }

    //Probado
    public void listarMotosEnTaller() {
        archivoMoto.listarMotoEnTaller();
    }

    //Probado
    public void listarTodasLasMotos() {
        archivoMoto.listarMotos();
    }

    public void retirarMotoDeBodega(String codigoMoto) {
        String registro = archivoMoto.buscarMoto(codigoMoto);
        String aux[] = registro.split(";");
        if(aux.length == 4 && aux[3] != null){
            String auxiliar = String.join(";", aux[0], aux[1], aux[2], "");
            archivoMoto.modificarMoto(auxiliar);
        }else{
            System.out.println("La moto no se encuentra en bodega");
        }
    }

    public void ingresarMotoABodega(String codigoMoto) {        
        String registro = archivoMoto.buscarMoto(codigoMoto) + "bodega" + ";";
        archivoMoto.modificarMoto(registro);
        System.out.println("Moto ingresada a bodega");               
    }

    public Boolean retirarMotoDeTaller(String codigoMoto, String cedulaMecanico) {
        return false;
    }

    public Boolean ingresarMotoATaller(String codigoMoto, String cedulaMecanico) {
        return false;
    }

}
