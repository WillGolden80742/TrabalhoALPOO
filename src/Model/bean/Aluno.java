/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

/**
 *
 * @author rafam
 */
public class Aluno extends Disciplina {
    private int matricula;
    private String nomeAluno;
    private String DataNascAluno;

    public String getDataNascAluno() {
        return DataNascAluno;
    }

    public void setDataNascAluno(String DataNascAluno) {
        this.DataNascAluno = DataNascAluno;
    }
    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
    
}
