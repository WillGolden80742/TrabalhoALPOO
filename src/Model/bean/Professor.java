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
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone;
    private String telefoneRes;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefoneRes() {
        return telefoneRes;
    }

    public void setTelefoneRes(String telefoneRes) {
        this.telefoneRes = telefoneRes;
    }
    
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
