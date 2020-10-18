package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aula extends javax.swing.JFrame implements ActionListener {

    
    Mostrar m = new Mostrar();
    
    public Aula() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        cadastrarMenu = new javax.swing.JMenu();
        cadCursoItem = new javax.swing.JMenuItem();
        cadDisciplinaItem = new javax.swing.JMenuItem();
        cadAlunoItem = new javax.swing.JMenuItem();
        cadProfessorItem = new javax.swing.JMenuItem();
        mostrarMenu = new javax.swing.JMenu();
        mostrarCursosItem = new javax.swing.JMenuItem();
        mostrarDisciplinasItem = new javax.swing.JMenuItem();
        mostrarAlunosItem = new javax.swing.JMenuItem();
        mostrarProfessoresItem = new javax.swing.JMenuItem();
        mostrarSeparador = new javax.swing.JPopupMenu.Separator();
        mostrarCursosProfessoresItem = new javax.swing.JMenuItem();
        mostrarCursosDisciplinasItem = new javax.swing.JMenuItem();
        mostrarProfessoresDisciplinas = new javax.swing.JMenuItem();
        sairMenu = new javax.swing.JMenu();
        sairItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cadastrarMenu.setText("Cadastrar");

        cadCursoItem.setText("Curso");
        cadastrarMenu.add(cadCursoItem);

        cadDisciplinaItem.setText("Disciplina");
        cadastrarMenu.add(cadDisciplinaItem);

        cadAlunoItem.setText("Aluno");
        cadastrarMenu.add(cadAlunoItem);

        cadProfessorItem.setText("Professor");
        cadastrarMenu.add(cadProfessorItem);

        menuBar.add(cadastrarMenu);

        mostrarMenu.setText("Mostrar");

        mostrarCursosItem.setText("Cursos");
        mostrarMenu.add(mostrarCursosItem);

        mostrarDisciplinasItem.setText("Disciplinas");
        mostrarMenu.add(mostrarDisciplinasItem);

        mostrarAlunosItem.setText("Alunos");
        mostrarMenu.add(mostrarAlunosItem);

        mostrarProfessoresItem.setText("Professores");
        mostrarMenu.add(mostrarProfessoresItem);
        mostrarMenu.add(mostrarSeparador);

        mostrarCursosProfessoresItem.setText("Cursos/Professores");
        mostrarMenu.add(mostrarCursosProfessoresItem);

        mostrarCursosDisciplinasItem.setText("Cursos/Disciplinas");
        mostrarMenu.add(mostrarCursosDisciplinasItem);

        mostrarProfessoresDisciplinas.setText("Professores/Disciplinas");
        mostrarMenu.add(mostrarProfessoresDisciplinas);

        menuBar.add(mostrarMenu);

        sairMenu.setText("SAIR");

        sairItem.setText("SAIR");
        sairMenu.add(sairItem);

        menuBar.add(sairMenu);

        cadCursoItem.addActionListener(this);   
        cadDisciplinaItem.addActionListener(this);  
        cadAlunoItem.addActionListener(this);
        cadProfessorItem.addActionListener(this);  
        mostrarCursosItem.addActionListener(this);  
        mostrarDisciplinasItem.addActionListener(this); 
        mostrarProfessoresItem.addActionListener(this);    
        mostrarCursosProfessoresItem.addActionListener(this);     
        mostrarCursosDisciplinasItem.addActionListener(this);         
        mostrarAlunosItem.addActionListener(this);
        mostrarProfessoresDisciplinas.addActionListener(this); 
        sairItem.addActionListener(this);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sairItem) {
            System.exit(0);
        }
        if (e.getSource() == mostrarCursosItem) {
            m.setVisible(true);
            m.readCursoTable();
        }        
        if (e.getSource() == mostrarAlunosItem) {
            m.setVisible(true);
            m.readAlunoTable();
        }
        if (e.getSource() == mostrarDisciplinasItem) {
            m.setVisible(true);
            m.readDisciplinaTable();
        }        
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Aula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cadAlunoItem;
    private javax.swing.JMenuItem cadCursoItem;
    private javax.swing.JMenuItem cadDisciplinaItem;
    private javax.swing.JMenuItem cadProfessorItem;
    private javax.swing.JMenu cadastrarMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mostrarAlunosItem;
    private javax.swing.JMenuItem mostrarCursosDisciplinasItem;
    private javax.swing.JMenuItem mostrarCursosItem;
    private javax.swing.JMenuItem mostrarCursosProfessoresItem;
    private javax.swing.JMenuItem mostrarDisciplinasItem;
    private javax.swing.JMenu mostrarMenu;
    private javax.swing.JMenuItem mostrarProfessoresDisciplinas;
    private javax.swing.JMenuItem mostrarProfessoresItem;
    private javax.swing.JPopupMenu.Separator mostrarSeparador;
    private javax.swing.JMenuItem sairItem;
    private javax.swing.JMenu sairMenu;
    // End of variables declaration//GEN-END:variables
}
