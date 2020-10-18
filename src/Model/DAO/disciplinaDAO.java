/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.bean.Disciplina;
import connectionfactory.ConnectionFactory;
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
public class disciplinaDAO {
    
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
            Logger.getLogger(disciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }      
        return Disciplinas;
   }
}
