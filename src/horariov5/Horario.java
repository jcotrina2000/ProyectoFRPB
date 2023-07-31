/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package horariov5;

/**
 *
 * @author User
 */
public class Horario {
    private String codigoMateria;
    private int numeroParalelo;
    private int dia;
    private String horaInicio;
    private String horaFin;
    private Clase clase;

    public Horario(String codigoMateria, int numeroParalelo, int dia, String horaInicio, String horaFin, Clase clase) {
        this.codigoMateria = codigoMateria;
        this.numeroParalelo = numeroParalelo;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.clase = clase;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
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

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public String toString() {
        return "Horario{" + "codigoMateria=" + codigoMateria + ", numeroParalelo=" + numeroParalelo + ", dia=" + dia + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", clase=" + clase + '}';
    }

    
    
    
}
