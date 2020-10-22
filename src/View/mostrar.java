/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DAO.cursosDAO;
import Model.DAO.disciplinasDAO;
import javax.swing.table.DefaultTableModel;
import Model.DAO.alunosDAO;
import Model.DAO.professoresDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class mostrar extends javax.swing.JFrame implements ActionListener {

    alunosDAO aDAO = new alunosDAO();
    disciplinasDAO dDAO = new disciplinasDAO();
    cursosDAO cDAO = new cursosDAO();
    professoresDAO pDAO = new professoresDAO();
    private boolean selectedProfessor = false;
    private boolean selectedDisciplina = false;
    private boolean selectedCurso = false;
    
    public mostrar() {
        initComponents();
        listener();
        hideTools();
    }
    void hideTools () {
        editarButton.setVisible(false);
        atualizarButton.setVisible(false);
        deletarButton.setVisible(false);
    }    
    
    void listener() {
        editarButton.addActionListener(this);
        atualizarButton.addActionListener(this);
    }    
    
    public boolean isSelectedDisciplina() {
        return selectedDisciplina;
    }

    public void setSelectedDisciplina() {
        this.selectedDisciplina = true;
        editarButton.setVisible(true);
        atualizarButton.setVisible(true);
        deletarButton.setVisible(true);            
    }    
    
    public void setSelectedProfessor() {
        this.selectedProfessor = true;
        editarButton.setVisible(true);
        atualizarButton.setVisible(true);
        deletarButton.setVisible(true);       
    } 
 
    public boolean isSelectedProfessor() {
        return selectedProfessor;
    }

    public boolean isSelectedCurso() {
        return selectedCurso;
    }

    public void setSelectedCurso() {
        this.selectedCurso = true;
        editarButton.setVisible(true);
        atualizarButton.setVisible(true);
        deletarButton.setVisible(true);         
    }    
    
    void setTitulos(String t, String[] columns) {
        setTitle(t);
        mostrarTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, columns));
    }

    public void readAlunosTable() {
        String[] columns = {"Matricula", "Nome", "Data nasc", "Curso"};
        setTitulos("Alunos", columns);
        DefaultTableModel modelo = (DefaultTableModel) mostrarTable.getModel();
        modelo.setNumRows(0);
        aDAO.read().forEach((a) -> {
            modelo.addRow(new Object[]{
                a.getMatricula(),
                a.getNomeAluno(),
                a.getDataNascAluno(),
                a.getNomeCurso()
            });
        });
    }

    public void readDisciplinasTable() {
        String[] columns = {"Código", "Nome Disc."};
        setTitulos("Disciplinas", columns);
        DefaultTableModel modelo = (DefaultTableModel) mostrarTable.getModel();
        modelo.setNumRows(0);
        dDAO.read().forEach((d) -> {
            modelo.addRow(new Object[]{
                d.getCodDisc(),
                d.getNomeDisc()
            });
        });
    }

    public void readCursosTable() {
        String[] columns = {"Código", "Nome curso"};
        setTitulos("Cursos", columns);
        DefaultTableModel modelo = (DefaultTableModel) mostrarTable.getModel();
        modelo.setNumRows(0);
        cDAO.read().forEach((c) -> {
            modelo.addRow(new Object[]{
                c.getCodCurso(),
                c.getNomeCurso()
            });
        });
    }

    public void readProfessoresTable() {
        String[] columns = {"Profº Id", "Nome profº", "Graduação"};
        setTitulos("Professores", columns);
        DefaultTableModel modelo = (DefaultTableModel) mostrarTable.getModel();
        modelo.setNumRows(0);
        pDAO.read().forEach((c) -> {
            modelo.addRow(new Object[]{
                c.getIdentProf(),
                c.getNomeProf(),
                c.getEspecProf()
            });
        });
    }

    public void readCursosDisciplinasTable() {
        String[] columns = {"Nome Curso", "Nome Disc."};
        setTitulos("Cursos/Disciplinas", columns);
        DefaultTableModel modelo = (DefaultTableModel) mostrarTable.getModel();
        modelo.setNumRows(0);
        dDAO.readCurso().forEach((c) -> {
            modelo.addRow(new Object[]{
                c.getNomeCurso(),
                c.getNomeDisc()
            });
        });
    }

    public void readProfessoresDisciplinasTable() {
        String[] columns = {"Professor", "Nome Disc."};
        setTitulos("Professores/Disciplinas", columns);
        DefaultTableModel modelo = (DefaultTableModel) mostrarTable.getModel();
        modelo.setNumRows(0);
        pDAO.readDisciplinas().forEach((c) -> {
            modelo.addRow(new Object[]{
                c.getNomeProf(),
                c.getNomeDisc()
            });
        });
    }

    public void readCursosProfessoresTable() {
        String[] columns = {"Curso", "Professor"};
        setTitulos("Cursos/Professores", columns);
        DefaultTableModel modelo = (DefaultTableModel) mostrarTable.getModel();
        modelo.setNumRows(0);
        pDAO.readCursos().forEach((c) -> {
            modelo.addRow(new Object[]{
                c.getNomeCurso(),
                c.getNomeProf()
            });
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mostrarTable = new javax.swing.JTable();
        deletarButton = new javax.swing.JButton();
        editarButton = new javax.swing.JButton();
        atualizarButton = new javax.swing.JButton();

        mostrarTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mostrarTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(mostrarTable);
        if (mostrarTable.getColumnModel().getColumnCount() > 0) {
            mostrarTable.getColumnModel().getColumn(0).setResizable(false);
            mostrarTable.getColumnModel().getColumn(1).setResizable(false);
        }

        deletarButton.setText("DELETAR");

        editarButton.setText("EDITAR");

        atualizarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/images2.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(atualizarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deletarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deletarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atualizarButton)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {atualizarButton, deletarButton, editarButton});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == atualizarButton) {
            if (selectedProfessor) {
                readProfessoresTable();
            }
            if (selectedDisciplina) {
                readDisciplinasTable();
            }   
            if (selectedCurso) {
                readCursosTable();
            }              
        }
        if (e.getSource() == editarButton) {
            try {
                int id = (int) mostrarTable.getValueAt(mostrarTable.getSelectedRow(), 0);
                if (selectedProfessor) {
                    editarCriarProfessor c = new editarCriarProfessor();
                    c.setVisible(true);
                    c.setProfessor(pDAO.read(id));
                }
                if (selectedDisciplina) {
                    editarCriarDisciplina d = new editarCriarDisciplina();
                    d.setVisible(true);
                    d.setDisciplina(dDAO.read(id));
                } 
                if (selectedCurso) {
                    editarCriarCurso c = new editarCriarCurso();
                    c.setVisible(true);
                    c.setCurso(cDAO.read(id));
                }                    
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(null, "Selecione algum da lista");
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizarButton;
    private javax.swing.JButton deletarButton;
    private javax.swing.JButton editarButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mostrarTable;
    // End of variables declaration//GEN-END:variables

}
