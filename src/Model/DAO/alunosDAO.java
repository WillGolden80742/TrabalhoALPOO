/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.bean.Aluno;
import ConnectionFactory.ConnectionFactory;
import Model.bean.AlunoMedia;
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

    private String AlunosStatus = "";

    public String getAlunosStatus() {
        return AlunosStatus;
    }

    public void setAlunosStatus(String AlunosStatus) {
        this.AlunosStatus = AlunosStatus;
    }

    public List<Aluno> read() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt;
        ResultSet rs;
        List<Aluno> Alunos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from aluno as a inner join curso as c on a.codCurso = c.codCurso ");
            rs = stmt.executeQuery();
            while (rs.next()) {
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
        return Alunos;
    }

    public Aluno read(int id) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt;
        ResultSet rs;
        Aluno aluno = new Aluno();
        try {
            stmt = con.prepareStatement("select * from Aluno where Matricula = " + id + " ORDER by nomeAluno");
            rs = stmt.executeQuery();
            while (rs.next()) {
                aluno.setMatricula(rs.getInt("Matricula"));
                aluno.setNomeAluno(rs.getString("nomeAluno"));
                aluno.setDataNascAluno(rs.getString("DataNascAluno"));
                aluno.setCodCurso(rs.getInt("codcurso"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(alunosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aluno;
    }
    
    public List<AlunoMedia> readNotas (int id) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt;
        ResultSet rs;
        List<AlunoMedia> AlunoMedia = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select d.nomeDisc, aM.NP1,aM.NP2,((aM.NP1+aM.NP2)/2) as Media, aM.Faltas from Aluno a inner join alunomedia aM on a.Matricula = aM.Matricula INNER JOIN disciplina d on d.CodDisc = aM.codDisc where a.Matricula = "+id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                AlunoMedia alunoM = new AlunoMedia();                
                alunoM.setNomeDisc(rs.getString("d.nomeDisc"));
                alunoM.setNp1(rs.getFloat("aM.NP1"));
                alunoM.setNp2(rs.getFloat("aM.NP2"));
                alunoM.setNp2(rs.getFloat("aM.NP2"));
                alunoM.setMedia(rs.getFloat("Media"));
                alunoM.setFaltas(rs.getInt("aM.Faltas"));  
                AlunoMedia.add(alunoM);
            }
        } catch (SQLException ex) {
            Logger.getLogger(alunosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return AlunoMedia;
    }
    

    public void update(Aluno a) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        try {
            stmt = con.prepareStatement("update aluno set nomeAluno = ?, DataNascAluno = ?, codcurso = ? where Matricula = ?");
            stmt.setString(1, a.getNomeAluno());
            stmt.setString(2, a.getDataNascAluno());
            stmt.setInt(3, a.getCodCurso());
            stmt.setInt(4, a.getMatricula());
            stmt.executeUpdate();
            setAlunosStatus("Atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(professoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void create(Aluno a) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        try {
            stmt = con.prepareStatement("Insert into aluno (nomeAluno,DataNascAluno,codcurso) value (?,?,?)");
            stmt.setString(1, a.getNomeAluno());
            stmt.setString(2, a.getDataNascAluno());
            stmt.setInt(3, a.getCodCurso());
            stmt.executeUpdate();
            setAlunosStatus("Criado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(professoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        try {
            stmt = con.prepareStatement("delete from aluno where Matricula  = " + id);
            stmt.executeUpdate();
            setAlunosStatus("Deletado com sucesso!");
        } catch (SQLException ex) {
            setAlunosStatus("Erro : "+ex);
            Logger.getLogger(professoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
