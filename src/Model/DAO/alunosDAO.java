/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.bean.Aluno;
import ConnectionFactory.ConnectionFactory;
import Model.bean.Curso;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafam
 */
public class alunosDAO {
    
    public List <Aluno> read(){
        Connection con = ConnectionFactory.getConnection();
     
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List <Aluno> Alunos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from aluno as a inner join curso as c on a.codCurso = c.codCurso ");
            rs = stmt.executeQuery();
            while(rs.next()){
                Aluno alu = new Aluno();
                alu.setMatricula(rs.getInt("matricula"));
                alu.setNomeAluno(rs.getString("nomeAluno"));
                alu.setNomeCurso(rs.getString("nomeCurso"));
                alu.setDataNascAluno(rs.getString("DataNascAluno"));
                Alunos.add(alu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(alunosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Alunos ;
    }

}
