/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package horariov5;

/**
 *
 * @author User
 */
public class Tema {
    private String nombreTema;
    private int horasTema;
    private String nombreMateria;

    public Tema(String nombreTema, int horasTema, String nombreMateria) {
        this.nombreTema = nombreTema;
        this.horasTema = horasTema;
        this.nombreMateria = nombreMateria;
    }
    

    public String getNombreTema() {
        return nombreTema;
    }

    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }

    public int getHorasTema() {
        return horasTema;
    }

    public void setHorasTema(int horasTema) {
        this.horasTema = horasTema;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    @Override
    public String toString() {
        return "Tema{" + "nombreTema=" + nombreTema + ", horasTema=" + horasTema + ", nombreMateria=" + nombreMateria + '}';
    }
    
    
}
