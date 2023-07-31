/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author User
 */
public class LectorArchivo {
    public static void procesarArchivo(String rutaArchivo) {
        try (FileReader fileReader = new FileReader(rutaArchivo);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            // Leer la primera línea (cabecera) y omitirla, ya que no contiene datos a procesar
            String cabecera = bufferedReader.readLine();

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                // Procesar cada línea y dividirla en sus campos usando el delimitador ","
                String[] campos = linea.split(",");

                // Obtener los valores de cada campo
                String codigoMateria = campos[0];
                int numeroParalelo = Integer.parseInt(campos[1]);
                int cantidadEstudiantes = Integer.parseInt(campos[2]);
                int horasMaximas = Integer.parseInt(campos[3]);
                int dia = Integer.parseInt(campos[4]);
                String horaInicio = campos[5];
                String horaFin = campos[6];

                // Realizar las operaciones que necesites con los datos obtenidos de cada línea
                System.out.println("Código de Materia: " + codigoMateria);
                System.out.println("Número de Paralelo: " + numeroParalelo);
                System.out.println("Cantidad de Estudiantes: " + cantidadEstudiantes);
                System.out.println("Horas Máximas: " + horasMaximas);
                System.out.println("Día: " + dia);
                System.out.println("Hora de Inicio: " + horaInicio);
                System.out.println("Hora de Fin: " + horaFin);
                System.out.println("---------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
