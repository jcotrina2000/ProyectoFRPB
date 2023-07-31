/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package horariov5;

/**
 *
 * @author User
 */
public class Materia {
    private String codigoMateria;
    private String nombreMateria;
    private int horasMaximas;

    public Materia(String codigoMateria, String nombreMateria, int horasMaximas) {
        this.codigoMateria = codigoMateria;
        this.nombreMateria = nombreMateria;
        this.horasMaximas = horasMaximas;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getHorasMaximas() {
        return horasMaximas;
    }

    public void setHorasMaximas(int horasMaximas) {
        this.horasMaximas = horasMaximas;
    }

    @Override
    public String toString() {
        return "Materia{" + "codigoMateria=" + codigoMateria + ", nombreMateria=" + nombreMateria + ", horasMaximas=" + horasMaximas + '}';
    }
    
    
}
