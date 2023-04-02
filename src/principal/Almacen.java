package principal;

import archivos.AccionesMecanico;
import archivos.AccionesMoto;

public class Almacen {

    private AccionesMecanico archivoMec = new AccionesMecanico();
    private AccionesMoto archivoMoto = new AccionesMoto();

    public Almacen() {
    }

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

    public void registrarMotocicleta(String motocicleta) {
        archivoMoto.registrarMoto(motocicleta);
    }

    public void listarMecanicos() {
        System.out.println("Listado De Mecanicos");
        archivoMec.listarUsuarios();
    }

    public void listarMotosPorMarcaCilindraje() {
        System.out.println("Listado De Motos Por Marca Y Cilindraje");
        archivoMoto.listarMotos();
    }

    public void listarMotosEnBodega() {
        System.out.println("Listado De Motos En Bodega");
    }

    public void listarMotosEnTaller() {
        System.out.println("Listado De Motos En Taller");
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
