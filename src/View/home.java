package View;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class home extends javax.swing.JFrame implements ActionListener {

    public home() {
        initComponents();
        listeners();
        setLocation(400, 100);
    }

    void listeners() {
        cadCursoItem.addActionListener(this);
        cadDisciplinaItem.addActionListener(this);
        cadAlunoItem.addActionListener(this);
        cadProfessorItem.addActionListener(this);
        mostrarCursosItem.addActionListener(this);
        mostrarDisciplinasItem.addActionListener(this);
        mostrarAlunosItem.addActionListener(this);
        mostrarProfessoresItem.addActionListener(this);
        mostrarCursosProfessoresItem.addActionListener(this);
        mostrarCursosDisciplinasItem.addActionListener(this);
        mostrarProfessoresDisciplinasItem.addActionListener(this);
        sairItem.addActionListener(this);
        lightItem.addActionListener(this);
        darkItem.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem11 = new javax.swing.JMenuItem();
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
        mostrarProfessoresDisciplinasItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        lightItem = new javax.swing.JMenuItem();
        darkItem = new javax.swing.JMenuItem();
        sairMenu = new javax.swing.JMenu();
        sairItem = new javax.swing.JMenuItem();

        jMenuItem11.setText("jMenuItem11");

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

        mostrarProfessoresDisciplinasItem.setText("Professores/Disciplinas");
        mostrarMenu.add(mostrarProfessoresDisciplinasItem);

        menuBar.add(mostrarMenu);

        jMenu1.setText("Tema");

        lightItem.setText("Claro");
        jMenu1.add(lightItem);

        darkItem.setText("Escuro");
        jMenu1.add(darkItem);

        menuBar.add(jMenu1);

        sairMenu.setText("SAIR");

        sairItem.setText("SAIR");
        sairMenu.add(sairItem);

        menuBar.add(sairMenu);

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
            mostrar m = new mostrar();
            m.setVisible(true);
            m.readCursosTable();
            m.setSelectedCurso();
        }
        if (e.getSource() == mostrarAlunosItem) {
            mostrar m = new mostrar();
            m.setVisible(true);
            m.readAlunosTable();
            m.setSelectedAluno();
        }
        if (e.getSource() == mostrarDisciplinasItem) {
            mostrar m = new mostrar();
            m.setVisible(true);
            m.readDisciplinasTable();
            m.setSelectedDisciplina();
        }
        if (e.getSource() == mostrarProfessoresItem) {
            mostrar m = new mostrar();
            m.setVisible(true);
            m.readProfessoresTable();
            m.setSelectedProfessor();
        }
        
        if (e.getSource() == mostrarCursosDisciplinasItem) {
            mostrar m = new mostrar();
            m.setVisible(true);
            m.readCursosDisciplinasTable();
        }

        if (e.getSource() == mostrarProfessoresDisciplinasItem) {
            mostrar m = new mostrar();
            m.setVisible(true);
            m.readProfessoresDisciplinasTable();
        }
        if (e.getSource() == mostrarCursosProfessoresItem) {
            mostrar m = new mostrar();
            m.setVisible(true);
            m.readCursosProfessoresTable();
        }
        
        if (e.getSource() == cadCursoItem) {
            editarCriarCurso cC = new editarCriarCurso();
            cC.setVisible(true);
        } 
        
        if (e.getSource() == cadAlunoItem) {
            editarCriarAluno cA = new editarCriarAluno();
            cA.setVisible(true);
        } 
        
        if (e.getSource() == cadDisciplinaItem) {
            editarCriarDisciplina cD = new editarCriarDisciplina();
            cD.setVisible(true);
        }        
        
        if (e.getSource() == cadProfessorItem) {
            editarCriarProfessor cP = new editarCriarProfessor();
            cP.setVisible(true);
        }
        
//      Alterar Temas
        if (e.getSource() == lightItem) {
            try {                
                UIManager.setLookAndFeel(new FlatLightLaf());
                SwingUtilities.updateComponentTreeUI(this);                 
            } catch (Exception ex) {
                System.err.println("Failed to initialize LaF");
            }
        }
        if (e.getSource() == darkItem) {
            try {
                UIManager.setLookAndFeel(new FlatDarkLaf());
                SwingUtilities.updateComponentTreeUI(this);                
            } catch (Exception ex) {
                System.err.println("Failed to initialize LaF");
            } catch (Throwable ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cadAlunoItem;
    private javax.swing.JMenuItem cadCursoItem;
    private javax.swing.JMenuItem cadDisciplinaItem;
    private javax.swing.JMenuItem cadProfessorItem;
    private javax.swing.JMenu cadastrarMenu;
    private javax.swing.JMenuItem darkItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem lightItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mostrarAlunosItem;
    private javax.swing.JMenuItem mostrarCursosDisciplinasItem;
    private javax.swing.JMenuItem mostrarCursosItem;
    private javax.swing.JMenuItem mostrarCursosProfessoresItem;
    private javax.swing.JMenuItem mostrarDisciplinasItem;
    private javax.swing.JMenu mostrarMenu;
    private javax.swing.JMenuItem mostrarProfessoresDisciplinasItem;
    private javax.swing.JMenuItem mostrarProfessoresItem;
    private javax.swing.JPopupMenu.Separator mostrarSeparador;
    private javax.swing.JMenuItem sairItem;
    private javax.swing.JMenu sairMenu;
    // End of variables declaration//GEN-END:variables

}
