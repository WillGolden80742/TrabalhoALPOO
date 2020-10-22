/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.bean.Disciplina;
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
public class disciplinasDAO {
    private String disciplinasStatus = "";

    public String getDisciplinasStatus() {
        return disciplinasStatus;
    }

    public void setDisciplinasStatus(String disciplinasStatus) {
        this.disciplinasStatus = disciplinasStatus;
    }

    public void update(Disciplina d) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        try {
            stmt = con.prepareStatement("update Disciplina set NomeDisc = ?, CargaHoraria = ?, AulasSemana = ?, IdentProf = ? where CodDisc = ?");
            stmt.setString(1,d.getNomeDisc());
            stmt.setInt(2,d.getCargaHoraria());
            stmt.setInt(3,d.getAulasSemana());
            stmt.setInt(4,d.getIdentProf());   
            stmt.setInt(5, d.getCodDisc());
            stmt.executeUpdate();
            setDisciplinasStatus("Atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(disciplinasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void create (Disciplina d) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;    
        
        try {
            stmt = con.prepareStatement("Insert into Disciplina (nomeDisc,Cargahoraria,AulasSemana,IdentProf ) value (?,?,?,?)");
            stmt.setString(1,d.getNomeDisc());
            stmt.setInt(2,d.getCargaHoraria());
            stmt.setInt(3,d.getAulasSemana());
            stmt.setInt(4,d.getIdentProf());            
            stmt.executeUpdate();
            setDisciplinasStatus("Criado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(professoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    public List<Disciplina> read () {
      
        Connection con = ConnectionFactory.getConnection();
     
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Disciplina> Disciplinas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from disciplina ");
            rs = stmt.executeQuery();
            while(rs.next()){
                Disciplina disciplina = new Disciplina();
                disciplina.setCodDisc(rs.getInt("CodDisc"));
                disciplina.setNomeDisc(rs.getString("NomeDisc"));
                Disciplinas.add(disciplina);
            }
        } catch (SQLException ex) {
            Logger.getLogger(disciplinasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }      
        return Disciplinas;
   }
    
    public Disciplina read(int id) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Disciplina disciplina = new Disciplina();
        try {
            stmt = con.prepareStatement("select * from disciplina as d inner join professor as p on p.IdentProf = d.IdentProf where CodDisc = "+id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                disciplina.setCodDisc(rs.getInt("CodDisc"));
                disciplina.setNomeDisc(rs.getString("NomeDisc"));
                disciplina.setAulasSemana(rs.getInt("AulasSemana"));               
                disciplina.setCargaHoraria(rs.getInt("CargaHoraria"));
                disciplina.setIdentProf(rs.getInt("IdentProf"));     
            }
        } catch (SQLException ex) {
            Logger.getLogger(professoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return disciplina;
    }        
    
    public List<Disciplina> readCurso () {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Disciplina> Disciplinas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from Curso as c INNER JOIN cursodisc as cd on c.codCurso = cd.codCurso INNER JOIN disciplina as d on cd.codDisc = d.CodDisc");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setNomeCurso(rs.getString("c.NomeCurso"));
                disciplina.setNomeDisc(rs.getString("d.nomeDisc"));
                Disciplinas.add(disciplina);
            }
        } catch (SQLException ex) {
            Logger.getLogger(alunosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Disciplinas;
    }  
    
    public void delete(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        try {
            stmt = con.prepareStatement("delete from disciplina where codDisc   = " + id);
            stmt.executeUpdate();
            setDisciplinasStatus("Deletado com sucesso!");
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex1) {
            setDisciplinasStatus("Nâo é possivel apagar, pois há dependentes de disciplina");
        } catch (SQLException ex) {
            Logger.getLogger(disciplinasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
