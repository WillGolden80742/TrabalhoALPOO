/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.bean.Curso;
import ConnectionFactory.ConnectionFactory;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
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
public class cursosDAO {

    private String CursosStatus = "";

    public String getCursosStatus() {
        return CursosStatus;
    }

    public void setCursosStatus(String CursosStatus) {
        this.CursosStatus = CursosStatus;
    }
    
    public Curso read(int id) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Curso curso = new Curso();
        try {
            stmt = con.prepareStatement("select * from Curso where codCurso = "+id+" ORDER by nomeCurso");
            rs = stmt.executeQuery();
            while (rs.next()) {
                curso.setCodCurso(rs.getInt("CodCurso"));
                curso.setNomeCurso(rs.getString("NomeCurso"));
                curso.setTipoCurso(rs.getString("tipoCurso"));
                curso.setCargaHoraria(rs.getInt("cargaHoraria"));
                curso.setCodInstituto(rs.getInt("codInstituto"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(cursosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return curso;
    }   

    public List<Curso> read() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Curso> Cursos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from Curso ORDER by nomeCurso");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setCodCurso(rs.getInt("CodCurso"));
                curso.setNomeCurso(rs.getString("NomeCurso"));
                Cursos.add(curso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(alunosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Cursos;
    }

    public void update(Curso c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        try {
            stmt = con.prepareStatement("update curso set nomeCurso = ?, tipoCurso = ?, cargaHoraria = ?, codInstituto = ? where CodCurso = ?");
            stmt.setString(1, c.getNomeCurso());
            stmt.setString(2, c.getTipoCurso());
            stmt.setInt(3, c.getCargaHoraria());
            stmt.setInt(4, c.getCodInstituto());
            stmt.setInt(5, c.getCodCurso());
            stmt.executeUpdate();
            setCursosStatus("Atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(professoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void create(Curso c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        try {
            stmt = con.prepareStatement("Insert into curso (nomeCurso,tipoCurso,cargaHoraria,codInstituto) value (?,?,?,?)");
            stmt.setString(1, c.getNomeCurso());
            stmt.setString(2, c.getTipoCurso());
            stmt.setInt(3, c.getCargaHoraria());
            stmt.setInt(4, c.getCodInstituto());
            stmt.executeUpdate();
            setCursosStatus("Criado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(professoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        try {
            stmt = con.prepareStatement("delete from curso where codCurso = " + id);
            stmt.executeUpdate();
            setCursosStatus("Deletado com sucesso!");
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex1) {
            setCursosStatus("Nâo é possivel apagar, pois há dependentes de curso");
        } catch (SQLException ex) {
            Logger.getLogger(cursosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
