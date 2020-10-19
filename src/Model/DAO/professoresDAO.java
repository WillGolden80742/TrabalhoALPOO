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
                Professores.add(professor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(professoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Professores;
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
}
