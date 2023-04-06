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

    //Probado
    public String buscarMecanicoPorCedula(String cedula) {
        return archivoMec.buscarMecanicoPorId(cedula);
    }

    //Probado
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

    //Probado
    public void retirarMotoDeBodega(String codigoMoto) {
        String registro = archivoMoto.buscarMoto(codigoMoto);
        String aux[] = registro.split(";");
        if (!aux[3].equalsIgnoreCase(" ") && aux[3].equalsIgnoreCase("BODEGA")) {
            String auxiliar = aux[0] + ";" + aux[1] + ";" + aux[2] + "; ;";
            archivoMoto.modificarMoto(auxiliar.toUpperCase());
            System.out.println("Moto Retirada De Bodega");
        } else {
            System.out.println("No Se Puede Realizar Esta Operacion Basado En Estos Criterios");
        }
    }

    //Probado
    public void ingresarMotoABodega(String codigoMoto) {
        String registro = archivoMoto.buscarMoto(codigoMoto);
        String aux[] = registro.split(";");
        if (aux[3].equalsIgnoreCase(" ") && !aux[3].equalsIgnoreCase("BODEGA")) {
            registro = aux[0] + ";" + aux[1] + ";" + aux[2] + ";BOdeGa;";
            archivoMoto.modificarMoto(registro.toUpperCase());
            System.out.println("Moto Ingresada A Bodega");
        } else {
            System.out.println("No Se Puede Realizar Esta Operacion Basado En Estos Criterios");
        }
    }

    //Probado
    public void retirarMotoDeTaller(String codigoMoto) {
        String registro = archivoMoto.buscarMoto(codigoMoto);
        String aux[] = registro.split(";");
        if (!aux[3].equalsIgnoreCase(" ") && aux[3].equalsIgnoreCase("TALLER")) {
            String auxiliar = aux[0] + ";" + aux[1] + ";" + aux[2] + "; ;";
            archivoMoto.modificarMoto(auxiliar.toUpperCase());
            System.out.println("Moto Retirada Del Taller");
        } else {
            System.out.println("No Se Puede Realizar Esta Operacion Basado En Estos Criterios");
        }
    }

    //Probado
    public void ingresarMotoATaller(String codigoMoto) {
        String registro = archivoMoto.buscarMoto(codigoMoto);
        String aux[] = registro.split(";");
        if (aux[3].equalsIgnoreCase(" ") && !aux[3].equalsIgnoreCase("TALLER")) {
            registro = aux[0] + ";" + aux[1] + ";" + aux[2] + ";TALLER;";
            archivoMoto.modificarMoto(registro.toUpperCase());
            System.out.println("Moto Ingresada Al Taller");
        } else {
            System.out.println("No Se Puede Realizar Esta Operacion Basado En Estos Criterios");
        }
    }

}
