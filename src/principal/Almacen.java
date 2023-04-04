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
        System.out.println(archivoMec.buscarMecanicoPorId(cedula));
        return archivoMec.buscarMecanicoPorId(cedula);
    }

    public String buscarMotocicletaPorCodigo(String cedula) {
        System.out.println(archivoMec.buscarMecanicoPorId(cedula));
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

    public void listarMotosEnBodega() {
        System.out.println("Listado De Motos En Bodega");
    }

    public void listarMotosEnTaller() {
        System.out.println("Listado De Motos En Taller");
    }

    //Probado
    public void listarTodasLasMotos() {
        archivoMoto.listarMotos();
    }

    public Boolean retirarMotoDeBodega(String codigoMoto, String cedulaMecanico) {
        return false;
    }

    public Boolean ingresarMotoABodega(String codigoMoto, String cedulaMecanico) {
        return false;
    }

    public Boolean retirarMotoDeTaller(String codigoMoto, String cedulaMecanico) {
        return false;
    }

    public Boolean ingresarMotoATaller(String codigoMoto, String cedulaMecanico) {
        return false;
    }

}
