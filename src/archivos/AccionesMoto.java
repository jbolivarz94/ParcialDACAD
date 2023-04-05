package archivos;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class AccionesMoto {

    private File fileMotos = new File("tb_motocicleta.txt");
    private File temp = new File("temp.txt");
    private BufferedWriter tempBufferedWriter;
    private BufferedReader fileBufferedReader;
    private BufferedWriter fileBufferedWriter;

    public AccionesMoto() {
        
    }

    public void modificarMoto(String registro) {
        try {
            if (fileMotos.exists()) {
                String aux[] = registro.split(";");
                String codigo = aux[0];
                fileBufferedReader = new BufferedReader(new FileReader(fileMotos));
                tempBufferedWriter = new BufferedWriter(new FileWriter(temp, false));
                String line, idLine;
                while ((line = fileBufferedReader.readLine()) != null) {
                    String reg[] = line.split(";");
                    idLine = reg[0];
                    if (!idLine.equals(codigo)) {
                        tempBufferedWriter.write(line + "\r\n");
                    } else {
                        tempBufferedWriter.write(registro + "\r\n");
                    }
                }

                fileBufferedReader.close();
                fileMotos.delete();
                tempBufferedWriter.close();
                temp.renameTo(fileMotos);
            } else {
                JOptionPane.showMessageDialog(null, "Archivo vacio");
            }
        } catch (IOException e) {
        }
    }

    //Probado
    public void registrarMoto(String registro) {
        try {
            fileBufferedWriter = new BufferedWriter(new FileWriter(fileMotos, true));
            fileBufferedWriter.write(registro + "\r\n");
            fileBufferedWriter.close();
            System.out.println("Moto registrada con exito!");
        } catch (IOException e) {
            System.out.println("Se Presento Un Error Al Intentar Registrar La Motocicleta");
            e.printStackTrace();
        }
    }

    public String buscarMoto(String id) {
        String registro = "";
        boolean sw = false;
        try {
            if (fileMotos.exists()) {
                fileBufferedReader = new BufferedReader(new FileReader(fileMotos));
                String line, idLine;
                while ((line = fileBufferedReader.readLine()) != null && !sw) {
                    idLine = obtenerId(line);
                    if (idLine.equals(id)) {
                        registro = line;
                        sw = true;
                    }
                }
                fileBufferedReader.close();
            } else {
                JOptionPane.showMessageDialog(null, "Archivo vacio");
            }
        } catch (HeadlessException | IOException e) {
            e.printStackTrace();
        }
        return registro;
    }

    public String eliminarMoto(String id) {
        String registro = "";
        try {
            if (fileMotos.exists()) {
                fileBufferedReader = new BufferedReader(new FileReader(fileMotos));
                fileBufferedWriter = new BufferedWriter(new FileWriter(temp, false));
                String line, idLine;
                while ((line = fileBufferedReader.readLine()) != null) {
                    idLine = obtenerId(line);
                    if (!idLine.equals(id)) {
                        fileBufferedWriter.write(line + "\r\n");
                    }
                }

                fileBufferedReader.close();
                fileMotos.delete();
                fileBufferedWriter.close();
                temp.renameTo(fileMotos);
            } else {
                JOptionPane.showMessageDialog(null, "Archivo vacio");
            }
        } catch (HeadlessException | IOException e) {
            e.printStackTrace();
        }
        return registro;
    }

    //Probado
    public void listarMotosPorCilindraje(String cilindraje) {
        try {
            if (fileMotos.exists()) {
                fileBufferedReader = new BufferedReader(new FileReader(fileMotos));
                String line;
                while ((line = fileBufferedReader.readLine()) != null) {
                    String[] partes = line.split(";");
                    if (partes[2].equalsIgnoreCase(cilindraje)) {
                        System.out.println(line);
                    }
                }
                fileBufferedReader.close();
            } else {
                JOptionPane.showMessageDialog(null, "Archivo vacio");
            }
        } catch (HeadlessException | IOException e) {
            e.printStackTrace();
        }
    }

    //Probado
    public void listarMotosPorMarca(String marca) {
        try {
            if (fileMotos.exists()) {
                fileBufferedReader = new BufferedReader(new FileReader(fileMotos));
                String line;
                while ((line = fileBufferedReader.readLine()) != null) {
                    String[] partes = line.split(";");
                    if (partes[1].equalsIgnoreCase(marca)) {
                        System.out.println(line);
                    }
                }
                fileBufferedReader.close();
            } else {
                JOptionPane.showMessageDialog(null, "Archivo vacio");
            }
        } catch (HeadlessException | IOException e) {
            e.printStackTrace();
        }
    }

    //Probado
    public void listarMotoEnTaller() {
        try {
            if (fileMotos.exists()) {
                fileBufferedReader = new BufferedReader(new FileReader(fileMotos));
                String line;
                while ((line = fileBufferedReader.readLine()) != null) {
                    String[] partes = line.split(";");
                    if (partes[3].equalsIgnoreCase("Taller")) {
                        System.out.println(line);
                    }
                }
                fileBufferedReader.close();
            } else {
                JOptionPane.showMessageDialog(null, "Archivo vacio");
            }
        } catch (HeadlessException | IOException e) {
            e.printStackTrace();
        }
    }

    //Probado
    public void listarMotoEnBodega() {
        try {
            if (fileMotos.exists()) {
                fileBufferedReader = new BufferedReader(new FileReader(fileMotos));
                String line;
                while ((line = fileBufferedReader.readLine()) != null) {
                    String[] partes = line.split(";");
                    if (partes[3].equalsIgnoreCase("Bodega")) {
                        System.out.println(line);
                    }
                }
                fileBufferedReader.close();
            } else {
                JOptionPane.showMessageDialog(null, "Archivo vacio");
            }
        } catch (HeadlessException | IOException e) {
            e.printStackTrace();
        }
    }

    //Probado
    public void listarMotos() {
        try {
            if (fileMotos.exists()) {
                fileBufferedReader = new BufferedReader(new FileReader(fileMotos));
                String line;
                while ((line = fileBufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
                fileBufferedReader.close();
            } else {
                JOptionPane.showMessageDialog(null, "Archivo vacio");
            }
        } catch (HeadlessException | IOException e) {
            e.printStackTrace();
        }
    }

    //Probado
    public String obtenerId(String line) {
        String[] partes = line.split(";");
        return partes[0];
    }

}
