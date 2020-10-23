/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import ConnectionFactory.ConnectionFactory;
import Model.bean.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William
 */
public class professoresDAO {

    private String professoresStatus = "";

    public String getProfessoresStatus() {
        return professoresStatus;
    }

    public void setProfessoresStatus(String professoresStatus) {
        this.professoresStatus = professoresStatus;
    }

    public void update(Professor p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        try {
            stmt = con.prepareStatement("update professor set NomeProf = ?, DataNasc = ?, EspecProf = ?, TituloProf = ?, logradouro = ?,bairro = ?, cidade = ?, num  = ?, uf = ?, telefone = ?, telRes = ? where IdentProf = ?");
            stmt.setString(1, p.getNomeProf());
            stmt.setString(2, p.getDataNasc());
            stmt.setString(3, p.getEspecProf());
            stmt.setString(4, p.getTituloProf());
            stmt.setString(5, p.getLogradouro());
            stmt.setString(6, p.getBairro());
            stmt.setString(7, p.getCidade());
            stmt.setString(8, p.getNumero());
            stmt.setString(9, p.getEstado());
            stmt.setString(10, p.getTelefone());
            stmt.setString(11, p.getTelefoneRes());            
            stmt.setInt(12, p.getIdentProf());
            stmt.executeUpdate();
            setProfessoresStatus("Atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(professoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void create(Professor p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        try {
            stmt = con.prepareStatement("Insert into professor (NomeProf,DataNasc,EspecProf,TituloProf,logradouro,bairro,cidade,num,uf,telefone,telRes) value (?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, p.getNomeProf());
            stmt.setString(2, p.getDataNasc());
            stmt.setString(3, p.getEspecProf());
            stmt.setString(4, p.getTituloProf());
            stmt.setString(5, p.getLogradouro());
            stmt.setString(6, p.getBairro());
            stmt.setString(7, p.getCidade());
            stmt.setString(8, p.getNumero());
            stmt.setString(9, p.getEstado());
            stmt.setString(10, p.getTelefone());
            stmt.setString(11, p.getTelefoneRes());
            stmt.executeUpdate();
            setProfessoresStatus("Criado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(professoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Professor> read() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Professor> Professores = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from professor");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Professor professor = new Professor();
                professor.setIdentProf(rs.getInt("IdentProf"));
                professor.setNomeProf(rs.getString("NomeProf"));
                professor.setEspecProf(rs.getString("EspecProf"));
                Professores.add(professor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(professoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Professores;
    }

    public Professor read(int id) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Professor professor = new Professor();
        try {
            stmt = con.prepareStatement("select * from professor where IdentProf = " + id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                professor.setIdentProf(rs.getInt("IdentProf"));
                professor.setNomeProf(rs.getString("NomeProf"));
                professor.setDataNasc(rs.getString("DataNasc"));
                professor.setEspecProf(rs.getString("EspecProf"));
                professor.setTituloProf(rs.getString("TituloProf"));
                professor.setLogradouro(rs.getString("logradouro"));
                professor.setEstado(rs.getString("bairro"));
                professor.setCidade(rs.getString("cidade"));
                professor.setBairro(rs.getString("bairro"));                
                professor.setNumero(rs.getString("num"));
                professor.setEstado(rs.getString("uf"));
                professor.setTelefone(rs.getString("telefone"));
                professor.setTelefoneRes(rs.getString("telRes"));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(professoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return professor;
    }

    public List<Professor> readDisciplinas() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Professor> Professores = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from professor as p INNER JOIN disciplina as d on d.IdentProf = p.IdentProf");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Professor professor = new Professor();
                professor.setNomeProf(rs.getString("p.NomeProf"));
                professor.setNomeDisc(rs.getString("d.nomeDisc"));
                Professores.add(professor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(professoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Professores;
    }

    public List<Professor> readCursos() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Professor> Professores = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select DISTINCT p.NomeProf, c.nomeCurso from professor as p INNER JOIN disciplina as d on d.IdentProf = p.IdentProf INNER JOIN cursodisc cd on d.CodDisc = cd.codDisc INNER JOIN curso c on cd.codCurso = c.codCurso");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Professor professor = new Professor();
                professor.setNomeProf(rs.getString("p.NomeProf"));
                professor.setNomeCurso(rs.getString("c.nomeCurso"));
                Professores.add(professor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(professoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Professores;
    }

    public void delete(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        try {
            stmt = con.prepareStatement("delete from professor where IdentProf  = " + id);
            stmt.executeUpdate();
            setProfessoresStatus("Deletado com sucesso!");
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex1) {
            setProfessoresStatus("Nâo é possivel apagar, pois há dependentes de professor");
        } catch (SQLException ex) {
            Logger.getLogger(professoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
