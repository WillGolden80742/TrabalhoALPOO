/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DAO.disciplinasDAO;
import Model.DAO.professoresDAO;
import Model.bean.Disciplina;
import Model.bean.Professor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class editarCriarDisciplina extends javax.swing.JFrame implements ActionListener {

    professoresDAO pDAO = new professoresDAO();
    List<Professor> pList = pDAO.read();

    public editarCriarDisciplina() {
        initComponents();
        addGroup();
        setSaveButton();
        setLocation(400, 200);
        setProfessoresList();
    }

    void setProfessoresList() {
        for (Professor p : pList) {
            profComboBox.addItem(p.getNomeProf());
        }
    }

    disciplinasDAO dDAO = new disciplinasDAO();
    private Disciplina disciplina = new Disciplina();
    private boolean selectedDisciplina = false;

    private boolean isSelectedDisciplina() {
        return selectedDisciplina;
    }

    private void setSelectedDisciplina() {
        this.selectedDisciplina = true;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
        nomeD.setText(disciplina.getNomeDisc());
        cHoraria.setText(String.valueOf(disciplina.getCargaHoraria()));
        switch (disciplina.getAulasSemana()) {
            case 1:
                umCheckBox.setSelected(true);
                break;
            case 2:
                doisCheckBox.setSelected(true);
                break;
            case 3:
                tresCheckBox.setSelected(true);
                break;
            case 4:
                quatroCheckBox.setSelected(true);
                break;
            case 5:
                cincoCheckBox.setSelected(true);
                break;
            case 6:
                seisCheckBox.setSelected(true);
                break;
        }
        int i = 0;
        for (Professor p : pList) {
            if (p.getIdentProf() == disciplina.getIdentProf()) {
                profComboBox.setSelectedIndex(i + 1);
            }
            i++;
        }
        setSelectedDisciplina();
        setSaveButton();
    }

    void addGroup() {
        aulasSemanaisGroup.add(umCheckBox);
        umCheckBox.addActionListener(this);
        aulasSemanaisGroup.add(doisCheckBox);
        doisCheckBox.addActionListener(this);
        aulasSemanaisGroup.add(tresCheckBox);
        tresCheckBox.addActionListener(this);
        aulasSemanaisGroup.add(quatroCheckBox);
        quatroCheckBox.addActionListener(this);
        aulasSemanaisGroup.add(cincoCheckBox);
        cincoCheckBox.addActionListener(this);
        aulasSemanaisGroup.add(seisCheckBox);
        seisCheckBox.addActionListener(this);
        salvarButton.addActionListener(this);
        cancelarButton.addActionListener(this);
        //  --------------------------------------------------------             
    }

    void setSaveButton() {
        if (isSelectedDisciplina() == true) {
            salvarButton.setText("SALVAR");
        } else {
            salvarButton.setText("CRIAR");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salvarButton) {
            Salvar();
        }
        if (e.getSource() == cancelarButton) {
            dispose();
        }        
    }

    void Salvar() {
        Disciplina d = new Disciplina();
        d.setNomeDisc(nomeD.getText());
        boolean b = true;
        try {
            d.setCargaHoraria(Integer.parseInt(cHoraria.getText()));
        } catch (NumberFormatException ex) {
            b = false;
            JOptionPane.showMessageDialog(null, "Digite numero inteiro em carga horária");
        }
        try {
            d.setIdentProf(pList.get(profComboBox.getSelectedIndex() - 1).getIdentProf());
        } catch (Exception ex) {
            b = false;
            JOptionPane.showMessageDialog(null, "Selecione professor!"); 
        }
        // -----------------------------------       
        if (umCheckBox.isSelected() == true) {
            d.setAulasSemana(Integer.parseInt(umCheckBox.getText()));
        } else if (doisCheckBox.isSelected() == true) {
            d.setAulasSemana(Integer.parseInt(doisCheckBox.getText()));
        } else if (tresCheckBox.isSelected() == true) {
            d.setAulasSemana(Integer.parseInt(tresCheckBox.getText()));
        } else if (quatroCheckBox.isSelected() == true) {
            d.setAulasSemana(Integer.parseInt(quatroCheckBox.getText()));
        } else if (cincoCheckBox.isSelected() == true) {
            d.setAulasSemana(Integer.parseInt(cincoCheckBox.getText()));
        } else if (seisCheckBox.isSelected() == true) {
            d.setAulasSemana(Integer.parseInt(seisCheckBox.getText()));
        } else {
            b = false;
            JOptionPane.showMessageDialog(null, "Selecione a quantidade aulas semanais");
        }
        if (b) {
            if (isSelectedDisciplina()) {
                d.setCodDisc(getDisciplina().getCodDisc());
                dDAO.update(d);
            } else {
                dDAO.create(d);
            }
            statusDisc.setText(dDAO.getDisciplinasStatus());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aulasSemanaisGroup = new javax.swing.ButtonGroup();
        nomeD = new javax.swing.JTextField();
        umCheckBox = new javax.swing.JCheckBox();
        doisCheckBox = new javax.swing.JCheckBox();
        tresCheckBox = new javax.swing.JCheckBox();
        quatroCheckBox = new javax.swing.JCheckBox();
        cincoCheckBox = new javax.swing.JCheckBox();
        seisCheckBox = new javax.swing.JCheckBox();
        salvarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        cHorariaLabel = new javax.swing.JLabel();
        cHoraria = new javax.swing.JTextField();
        aulaLabel1 = new javax.swing.JLabel();
        cHorariaLabel1 = new javax.swing.JLabel();
        profComboBox = new javax.swing.JComboBox<>();
        profLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        statusDisc = new javax.swing.JLabel();

        setTitle("Disciplina");
        setResizable(false);

        umCheckBox.setText("1");

        doisCheckBox.setText("2");

        tresCheckBox.setText("3");

        quatroCheckBox.setText("4");

        cincoCheckBox.setText("5");

        seisCheckBox.setText("6");

        salvarButton.setText("SALVAR");

        cancelarButton.setText("CANCELAR");

        cHorariaLabel.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        cHorariaLabel.setText("Carga Horaria :");

        aulaLabel1.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        aulaLabel1.setText("Aulas Semanais :");

        cHorariaLabel1.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        cHorariaLabel1.setText("Nome :");

        profComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "selecione professor" }));

        profLabel.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        profLabel.setText("Professor :");

        jLabel3.setBackground(new java.awt.Color(51, 153, 0));
        jLabel3.setFont(new java.awt.Font("Arial", 3, 10)); // NOI18N

        statusDisc.setBackground(new java.awt.Color(51, 153, 0));
        statusDisc.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        statusDisc.setForeground(new java.awt.Color(51, 153, 0));
        statusDisc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(statusDisc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(salvarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cHorariaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(nomeD, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(aulaLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(umCheckBox)
                                        .addGap(0, 0, 0)
                                        .addComponent(doisCheckBox)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tresCheckBox)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quatroCheckBox)
                                        .addGap(0, 0, 0)
                                        .addComponent(cincoCheckBox))
                                    .addComponent(cHorariaLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cHoraria)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(seisCheckBox)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(profLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(96, 96, 96)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(97, 97, 97)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cHorariaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cHorariaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(umCheckBox)
                    .addComponent(doisCheckBox)
                    .addComponent(tresCheckBox)
                    .addComponent(quatroCheckBox)
                    .addComponent(cincoCheckBox)
                    .addComponent(seisCheckBox)
                    .addComponent(aulaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statusDisc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvarButton)
                    .addComponent(cancelarButton)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(88, 88, 88)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(88, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cHoraria, nomeD});

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aulaLabel1;
    private javax.swing.ButtonGroup aulasSemanaisGroup;
    private javax.swing.JTextField cHoraria;
    private javax.swing.JLabel cHorariaLabel;
    private javax.swing.JLabel cHorariaLabel1;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JCheckBox cincoCheckBox;
    private javax.swing.JCheckBox doisCheckBox;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nomeD;
    private javax.swing.JComboBox<String> profComboBox;
    private javax.swing.JLabel profLabel;
    private javax.swing.JCheckBox quatroCheckBox;
    private javax.swing.JButton salvarButton;
    private javax.swing.JCheckBox seisCheckBox;
    private javax.swing.JLabel statusDisc;
    private javax.swing.JCheckBox tresCheckBox;
    private javax.swing.JCheckBox umCheckBox;
    // End of variables declaration//GEN-END:variables

}
