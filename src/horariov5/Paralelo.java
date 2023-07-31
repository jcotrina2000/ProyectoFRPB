/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package horariov5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Paralelo {
    private String codigoMateria;
    private int numeroParalelo;
    private int cantEstudiantes;
    private Materia materia;
    private List<Horario> horarios;

    public Paralelo(String codigoMateria, int numeroParalelo, int cantEstudiantes, Materia materia, List<Horario> horarios) {
        this.codigoMateria = codigoMateria;
        this.numeroParalelo = numeroParalelo;
        this.cantEstudiantes = cantEstudiantes;
        this.materia = materia;
        this.horarios = horarios;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public int getNumeroParalelo() {
        return numeroParalelo;
    }

    public void setNumeroParalelo(int numeroParalelo) {
        this.numeroParalelo = numeroParalelo;
    }

    public int getCantEstudiantes() {
        return cantEstudiantes;
    }

    public void setCantEstudiantes(int cantEstudiantes) {
        this.cantEstudiantes = cantEstudiantes;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
    
     // Método para agregar horarios
    public void agregarEstudiante(Horario horario) {
        horarios.add(horario);
    }

    @Override
    public String toString() {
        return "Paralelo{" + "codigoMateria=" + codigoMateria + ", numeroParalelo=" + numeroParalelo + ", cantEstudiantes=" + cantEstudiantes + ", materia=" + materia + ", horarios=" + horarios + '}';
    }
    
    

    
}
