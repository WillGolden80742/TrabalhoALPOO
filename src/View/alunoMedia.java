/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.bean.AlunoMedia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author William
 */
public class alunoMedia extends javax.swing.JFrame {

    private List<AlunoMedia> alunomediaList = new ArrayList<>();

    public alunoMedia(List<AlunoMedia> alunomediaList) {
        initComponents();
        this.alunomediaList = alunomediaList;            
        readNotaTable();
        setLocation(400,200);
    }

    public List<AlunoMedia> getAlunomediaList() {
        return alunomediaList;
    }

    void readNotaTable() {
        DefaultTableModel modelo = (DefaultTableModel) notas.getModel();
        modelo.setNumRows(0);
        getAlunomediaList().forEach((aM) -> {
            modelo.addRow(new Object[]{
                aM.getNomeDisc(),
                aM.getNp1(),
                aM.getNp2(),  
                aM.getMedia(),
                aM.getFaltas()
            });
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        notas = new javax.swing.JTable();

        setTitle("Notas");

        notas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        notas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Disciplina", "Np1", "Np2", "Media", "Faltas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        notas.setToolTipText("");
        jScrollPane1.setViewportView(notas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable notas;
    // End of variables declaration//GEN-END:variables
}
