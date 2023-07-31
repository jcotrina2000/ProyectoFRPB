/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package horariov5;

import java.util.List;

/**
 *
 * @author User
 */
public class Clase {
    private int idHorario;
    private String fecha;
    private List<Actividad> actividades;

    public Clase(int idHorario, String fecha, List<Actividad> actividades) {
        this.idHorario = idHorario;
        this.fecha = fecha;
        this.actividades = actividades;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
    
    // Método para agregar actividades
    public void agregarEstudiante(Actividad estudiante) {
        actividades.add(estudiante);
    }

    @Override
    public String toString() {
        return "Clase{" + "idHorario=" + idHorario + ", fecha=" + fecha + ", actividades=" + actividades + '}';
    }
    
    
}
