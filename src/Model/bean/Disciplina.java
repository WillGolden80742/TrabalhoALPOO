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
public class Disciplina extends Curso {
    
    private String NomeProf;
    private int IdentProf; 
    int CodDisc;
    String NomeDisc;
    int CargaHoraria;	
    int AulasSemana;    

    public int getIdentProf() {
        return IdentProf;
    }

    public void setIdentProf(int IdentProf) {
        this.IdentProf = IdentProf;
    }

    public String getNomeProf() {
        return NomeProf;
    }

    public void setNomeProf(String NomeProf) {
        this.NomeProf = NomeProf;
    }
    
    public int getCodDisc() {
        return CodDisc;
    }

    public void setCodDisc(int CodDisc) {
        this.CodDisc = CodDisc;
    }

    public String getNomeDisc() {
        return NomeDisc;
    }

    public void setNomeDisc(String NomeDisc) {
        this.NomeDisc = NomeDisc;
    }

    public int getCargaHoraria() {
        return CargaHoraria;
    }

    public void setCargaHoraria(int CargaHoraria) {
        this.CargaHoraria = CargaHoraria;
    }

    public int getAulasSemana() {
        return AulasSemana;
    }

    public void setAulasSemana(int AulasSemana) {
        this.AulasSemana = AulasSemana;
    }

}
