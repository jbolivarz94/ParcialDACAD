package principal;

import java.util.Scanner;

public class Menu {

    private final Almacen almacen = new Almacen();
    private final Scanner sc = new Scanner(System.in);
    private int opcion;
    private boolean bandera = true;

    public Menu() {
        this.menu();
    }

    public void menu() {
        String nombre, cedula, sexo, fechaNacimiento, registro;
        String codigoMotocicleta, marca, cilindraje;
        do {
            System.out.println(""
                    + "1) Registrar Mecanico \n"
                    + "2) Registrar Motocicleta \n"
                    + "3) Listar Mecanicos\n"
                    + "4) Listar Motos \n"
                    + "5) Ingresar Motocicleta De Bodega \n"
                    + "6) Retirar Motocicleta A Bodega \n"
                    + "7) Ingresar Motocicleta A Taller \n"
                    + "8) Retirar Motocicleta A Taller \n"
                    + "9) Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingresa La Cedula Del Mecanico:");
                    cedula = sc.next();
                    if (almacen.buscarMecanicoPorCedula(cedula).equalsIgnoreCase("")) {
                        System.out.println("Ingrese El Nombre Del Mecanico");
                        nombre = sc.next();
                        System.out.println("Ingrese El Sexo Del Mecanico");
                        sexo = sc.next();
                        System.out.println("Ingrese La Fecha De Nacimiento");
                        fechaNacimiento = sc.next();
                        registro = nombre + ";" + cedula + ";" + sexo + ";" + fechaNacimiento + ";";
                        if (almacen.registrarMecanico(registro)) {
                            System.out.println("Mecanico Registrado");
                        } else {
                            System.out.println("Se Presento Un Error Al Intentar Registrar El Mecanico");
                        }
                    } else {
                        System.out.println("Esta Cedula Ya Existe En La Base De Datos");
                    }
                    break;
                case 2:
                    System.out.println("Ingresa El Codigo De La Motocicleta:");
                    codigoMotocicleta = sc.next();
                    if (almacen.buscarMotocicletaPorCodigo(codigoMotocicleta).equalsIgnoreCase("")) {
                        System.out.println("Ingrese La Marca De La Motocicleta");
                        marca = sc.next();
                        System.out.println("Ingrese El Cilindraje De La Motocicleta");
                        cilindraje = sc.next();
                        registro = codigoMotocicleta + ";" + marca + ";" + cilindraje + ";";
                        almacen.registrarMotocicleta(registro);
                    } else {
                        System.out.println("Este Codigo Ya Existe En La Base De Datos");
                    }
                    break;
                case 3:
                    almacen.listarMecanicos();
                    break;

                case 4:
                    System.out.println("¿Como Desea Listar La Informacion? \n"
                            + "1) Por Marca Y Cilindraje \n"
                            + "2) En Bodega \n"
                            + "3) En Taller \n");
                    opcion = sc.nextInt();
                    switch (opcion) {
                        case 1:
                            almacen.listarMotosPorMarcaCilindraje();
                            break;
                        case 2:
                            almacen.listarMotosEnBodega();
                            break;
                        case 3:
                            almacen.listarMotosEnTaller();
                            break;
                        default:
                            System.out.println("Opcion Incorrecta");
                    }
                    break;
                case 5:
                    System.out.println("Ingrese El Codigo De La Motocicleta");
                    codigoMotocicleta = sc.next();
                    System.out.println("Ingrese La Cedula Del Mecanico");
                    cedula = sc.next();
                    if (almacen.retirarMotoDeBodega(codigoMotocicleta, cedula)) {
                        System.out.println("Se Ha Retirado La Motocicleta De La Bodega");
                    } else {
                        System.out.println("No Se Encontraron Registros Basados En Estos Criterios");
                    }
                    break;
                case 6:
                    System.out.println("Ingrese El Codigo De La Motocicleta");
                    codigoMotocicleta = sc.next();
                    System.out.println("Ingrese La Cedula Del Mecanico");
                    cedula = sc.next();
                    if (almacen.ingresarMotoABodega(codigoMotocicleta, cedula)) {
                        System.out.println("Se Ha Ingresado La Motocicleta A Bodega");
                    } else {
                        System.out.println("No Se Encontraron Registros Basados En Estos Criterios");
                    }
                    break;
                case 7:
                    System.out.println("Ingrese El Codigo De La Motocicleta");
                    codigoMotocicleta = sc.next();
                    System.out.println("Ingrese La Cedula Del Mecanico");
                    cedula = sc.next();
                    if (almacen.retirarMotoDeBodega(codigoMotocicleta, cedula)) {
                        System.out.println("Se Ha Retirado La Motocicleta Del Taller");
                    } else {
                        System.out.println("No Se Encontraron Registros Basados En Estos Criterios");
                    }
                    break;
                case 8:
                    System.out.println("Ingrese El Codigo De La Motocicleta");
                    codigoMotocicleta = sc.next();
                    System.out.println("Ingrese La Cedula Del Mecanico");
                    cedula = sc.next();
                    if (almacen.ingresarMotoABodega(codigoMotocicleta, cedula)) {
                        System.out.println("Se Ha Ingresado La Motocicleta Al Taller");
                    } else {
                        System.out.println("No Se Encontraron Registros Basados En Estos Criterios");
                    }
                    break;
                case 9:
                    bandera = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (bandera);
    }
}
