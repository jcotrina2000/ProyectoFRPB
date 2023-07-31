/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package writer;

import horariov5.Actividad;
import horariov5.Clase;
import horariov5.Horario;
import horariov5.Materia;
import horariov5.Paralelo;
import horariov5.Tema;
import horariov5.TipoActividad;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author User
 */
public class EscritorArchivo {
    public void escribirMateriasEnArchivo(List<Materia> materias, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribir encabezados
            writer.write("codigoMateria,nombreMateria,horasMaximas");
            writer.newLine();

            // Escribir información de las actividades
            for (Materia materia : materias) {
                String codigoMateria = materia.getCodigoMateria();
                String nombreMateria = materia.getNombreMateria();
                String horasMaximas = Integer.toString(materia.getHorasMaximas());
                writer.write(codigoMateria + "," + nombreMateria + "," + horasMaximas);
                writer.newLine();
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void escribirParalelosEnArchivo(List<Paralelo> paralelos, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribir encabezados
            writer.write("codigoMateria,numeroParalelo,cantidadEstudiantes,horasMaximas,dia,hora-inicio,hora-fin,fecha,TipoActividad,idTema");
            writer.newLine();

            // Escribir información de las clases
            for (Paralelo paralelo : paralelos) {
                String codigoMateria = paralelo.getCodigoMateria();
                String numeroParalelo = Integer.toString(paralelo.getNumeroParalelo());
                String cantidadEstudiantes = Integer.toString(paralelo.getCantEstudiantes());
                
                String horasMaximas = Integer.toString(paralelo.getMateria().getHorasMaximas());
                
                for(Horario horario: paralelo.getHorarios()){
                    String dia = Integer.toString(horario.getDia()); 
                    String horaInicio = horario.getHoraInicio();
                    String horaFin = horario.getHoraFin();
                    String claseFecha = horario.getClase().getFecha();
                    for(Actividad actividad: horario.getClase().getActividades()){
                        TipoActividad tipo = actividad.getTipo();
                        int idTema = actividad.getIdTema();
                        
                        writer.write(codigoMateria + "," + numeroParalelo + "," + cantidadEstudiantes + "," + horasMaximas + ","+dia+","+horaInicio+","+horaFin+","+ claseFecha +","+tipo+","+idTema);
                        writer.newLine();
                        
                    
                    }
                    
                    
                    //writer.write(codigoMateria + "," + numeroParalelo + "," + cantidadEstudiantes + "," + horasMaximas + ","+dia+","+horaInicio+","+horaFin);
                    //writer.newLine();
                }  
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void escribirHorariosEnArchivo(List<Horario> horarios, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribir encabezados
            writer.write("codigoMateria,numeroParalelo,dia,hora-inicio,hora-fin");
            writer.newLine();

            // Escribir información de las clases
            for (Horario horario : horarios) {
                String codigoMateria = horario.getCodigoMateria();
                String numeroParalelo = Integer.toString(horario.getNumeroParalelo());
                String dia = Integer.toString(horario.getDia());
                String horaInicio = horario.getHoraInicio();
                String horaFin = horario.getHoraFin();
                    
                writer.write(codigoMateria + "," + numeroParalelo + "," + dia + "," + horaInicio + ","+ horaFin);
                writer.newLine();
          
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void escribirTemasEnArchivo(List<Tema> temas, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribir encabezados
            writer.write("nombreTema,numeroHoras,nombreMateria");
            writer.newLine();

            // Escribir información de las clases
            for (Tema tema : temas) {
                String nombreTema = tema.getNombreTema();
                String numeroHoras = Integer.toString(tema.getHorasTema());
                String nombreMateria = tema.getNombreMateria();
                
                    
                writer.write(nombreTema + "," + numeroHoras + "," + nombreMateria);
                writer.newLine();
          
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
