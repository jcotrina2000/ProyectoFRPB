/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package horariov5;

/**
 *
 * @author User
 */
public class Actividad {
    private TipoActividad tipo;
    private int idTema; // Atributo adicional para el idTema, solo válido si el tipo es "TEMA"

    public Actividad(TipoActividad tipo) {
        this.tipo = tipo;
    }

    public Actividad(TipoActividad tipo, int idTema) {
        this.tipo = tipo;
        if (tipo == TipoActividad.TEMA) {
            this.idTema = idTema;
        } else {
            this.idTema = -1; // Valor por defecto cuando el tipo no es "TEMA"
        }
    }

    public TipoActividad getTipo() {
        return tipo;
    }

    public void setTipo(TipoActividad tipo) {
        this.tipo = tipo;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }
}
