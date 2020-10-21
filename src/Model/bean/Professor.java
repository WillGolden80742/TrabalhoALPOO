/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;
/**
 *
 * @author William
 */
public class Professor extends Disciplina {
    
    private String DataNasc;
    private String EspecProf;
    private String TituloProf;

    public String getTituloProf() {
        return TituloProf;
    }

    public void setTituloProf(String TituloProf) {
        this.TituloProf = TituloProf;
    }

    public String getDataNasc() {
        return DataNasc;
    }

    public void setDataNasc(String DataNasc) {
        this.DataNasc = DataNasc;
    }

    public String getEspecProf() {
        return EspecProf;
    }

    public void setEspecProf(String EspecProf) {
        this.EspecProf = EspecProf;
    }
}
