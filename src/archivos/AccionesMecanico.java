package archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class AccionesMecanico {

    private File fileMecanicos = new File("tb_mecanico.txt");
    private File fileBodega = new File("tb_bodega.txt");
    private File fileTaller = new File("tb_taller.txt");
    private File temp = new File("temp.txt");
    private BufferedWriter tempBufferedWriter;
    private BufferedReader fileBufferedReader;
    private BufferedWriter fileBufferedWriter;

    public AccionesMecanico() {

    }

    public String obtenerUsuarioId(String line) {
        int i = 0, j;
        while (!line.substring(i, i + 1).equals(";")) { //Lee la linea hasta encontrarte con ;
            i++;
        }
        j = i + 1;
        while (!line.substring(j, j + 1).equals(";")) { //Lee la linea hasta encontrarte con ;
            j++;
        }
        return line.substring(i + 1, j);
    }

    public String buscarMecanicoPorId(String id) {
        String registro = "";
        boolean sw = false;
        try {
            if (fileMecanicos.exists()) {
                fileBufferedReader = new BufferedReader(new FileReader(fileMecanicos));
                String linea, idLine;
                while ((linea = fileBufferedReader.readLine()) != null && !sw) {
                    idLine = obtenerUsuarioId(linea);
                    if (idLine.equals(id)) {
                        registro = linea;
                        sw = true;
                    }
                }
                fileBufferedReader.close();
            } else {
                JOptionPane.showMessageDialog(null, "Archivo vacio");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registro;
    }

    public void listarUsuarios() {
        try {
            if (fileMecanicos.exists()) {
                fileBufferedReader = new BufferedReader(new FileReader(fileMecanicos));
                String line;
                while ((line = fileBufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
                fileBufferedReader.close();
            } else {
                JOptionPane.showMessageDialog(null, "Archivo vacio");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarUsuario(String nombre, String id, int edad) {
        try {
            if (fileMecanicos.exists()) {
                fileBufferedReader = new BufferedReader(new FileReader(fileMecanicos));
                tempBufferedWriter = new BufferedWriter(new FileWriter(temp, false));
                String line, idLine;
                while ((line = fileBufferedReader.readLine()) != null) {
                    int i = 0, j;
                    while (!line.substring(i, i + 1).equals(";")) { //Lee la linea hasta encontrarte con ;
                        i++;
                    }
                    j = i + 1;
                    while (!line.substring(j, j + 1).equals(";")) {
                        j++;
                    }
                    idLine = line.substring(i + 1, j);
                    if (!idLine.equals(id)) {
                        tempBufferedWriter.write(line + "\r\n");
                    } else {
                        tempBufferedWriter.write(nombre + ";" + id + ";" + edad + ";" + "\r\n");
                    }
                }
                fileBufferedReader.close();
                fileMecanicos.delete();
                tempBufferedWriter.close();
                temp.renameTo(fileMecanicos);
            } else {
                System.out.println("Archivo Vacio");
            }
        } catch (IOException e) {
        }
    }

    public Boolean registrarMecanico(String registro) {
        try {
            if (!registro.equalsIgnoreCase("")) {
                fileBufferedWriter = new BufferedWriter(new FileWriter(fileMecanicos, true));
                fileBufferedWriter.write(registro + "\r\n");
                fileBufferedWriter.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
