/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DAO.professoresDAO;
import Model.bean.Professor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class editarCriarProfessor extends javax.swing.JFrame implements ActionListener {

    
    public editarCriarProfessor() {
        initComponents();
        addGroup();
        setSaveButton ();
        setLocation(400,400);
    }
    
    professoresDAO pDAO = new professoresDAO();
    private Professor professor = new Professor();
    private boolean selectedProfessor = false;

    private boolean isSelectedProfessor() {
        return selectedProfessor;
    }

    private void setSelectedProfessor() {
        this.selectedProfessor = true;
    }
    
    public Professor getProfessor() {
        return professor;
    }
     
    public void setProfessor(Professor professor) {
        this.professor = professor;
        nomeP.setText(professor.getNomeProf());
        dataNascP.setText(professor.getDataNasc());
        switch (professor.getTituloProf()) {
            case "Bacharel":
                BacharelCheckBox.setSelected(true);
                break;
            case "Especialista Lato Sensu":
                EspecialistaLatoSensuCheckBox.setSelected(true);
                break;  
            case "Mestrado":
                MestradoCheckBox.setSelected(true);
                break; 
            case "Doutorado":
                DoutoradoCheckBox.setSelected(true);
                break;                                    
        }
        switch (professor.getEspecProf()) {
            case "Informática":
                InformaticaCheckBox.setSelected(true);
                break;
            case "Matemática":
                MatematicaCheckBox.setSelected(true);
                break;  
            case "Medicina":
                MedicinaCheckBox.setSelected(true);
                break; 
            case "Farmacologia":
                FarmacologiaCheckBox.setSelected(true);
                break;   
            case "Odontologia":
                OdontologiaCheckBox.setSelected(true);
                break;   
            case "Direito":
                DireitoCheckBox.setSelected(true);
                break;    
            case "Psicologia":
                PsicologiaCheckBox.setSelected(true);
                break;   
            case "Recursos Humanos":
                RecursosHumanosCheckBox.setSelected(true);
                break;                   
        }        
        setSelectedProfessor();
        setSaveButton();
    }


    void addGroup() {
        especProfGroup.add(InformaticaCheckBox);
        InformaticaCheckBox.addActionListener(this);
        especProfGroup.add(MatematicaCheckBox);
        MatematicaCheckBox.addActionListener(this);
        especProfGroup.add(MedicinaCheckBox);
        MedicinaCheckBox.addActionListener(this);
        especProfGroup.add(FarmacologiaCheckBox);
        FarmacologiaCheckBox.addActionListener(this);
        especProfGroup.add(OdontologiaCheckBox);
        OdontologiaCheckBox.addActionListener(this);
        especProfGroup.add(DireitoCheckBox);
        DireitoCheckBox.addActionListener(this);
        especProfGroup.add(PsicologiaCheckBox);
        PsicologiaCheckBox.addActionListener(this);
        especProfGroup.add(RecursosHumanosCheckBox);
        RecursosHumanosCheckBox.addActionListener(this);
        //  --------------------------------------------------------             
        tituloProfGroup.add(BacharelCheckBox);
        BacharelCheckBox.addActionListener(this);
        tituloProfGroup.add(EspecialistaLatoSensuCheckBox);
        EspecialistaLatoSensuCheckBox.addActionListener(this);
        tituloProfGroup.add(MestradoCheckBox);
        MestradoCheckBox.addActionListener(this);
        tituloProfGroup.add(DoutoradoCheckBox);
        DoutoradoCheckBox.addActionListener(this);
        salvarButton.addActionListener(this);
        cancelarButton.addActionListener(this);
    }  
    
    void setSaveButton () {
        if(isSelectedProfessor() == true) {
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
        Professor p = new Professor();
        p.setNomeProf(nomeP.getText());
        p.setDataNasc(dataNascP.getText());
        boolean b = true;
        // -------------------------------------------        
        if (BacharelCheckBox.isSelected() == true) {
            p.setTituloProf(BacharelCheckBox.getText());
        } else if (EspecialistaLatoSensuCheckBox.isSelected() == true) {
            p.setTituloProf(EspecialistaLatoSensuCheckBox.getText());
        } else if (MestradoCheckBox.isSelected() == true) {
            p.setTituloProf(MestradoCheckBox.getText());
        } else if (DoutoradoCheckBox.isSelected() == true) {
            p.setTituloProf(DoutoradoCheckBox.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um titulo para o professor");
            b = false;
        }
        // -----------------------------------       
        if (InformaticaCheckBox.isSelected() == true) {
            p.setEspecProf(InformaticaCheckBox.getText());
        } else if (MatematicaCheckBox.isSelected() == true) {
            p.setEspecProf(MatematicaCheckBox.getText());
        } else if (MedicinaCheckBox.isSelected() == true) {
            p.setEspecProf(MedicinaCheckBox.getText());
        } else if (FarmacologiaCheckBox.isSelected() == true) {
            p.setEspecProf(FarmacologiaCheckBox.getText());
        } else if (OdontologiaCheckBox.isSelected() == true) {
            p.setEspecProf(OdontologiaCheckBox.getText());
        } else if (DireitoCheckBox.isSelected() == true) {
            p.setEspecProf(DireitoCheckBox.getText());
        } else if (PsicologiaCheckBox.isSelected() == true) {
            p.setEspecProf(PsicologiaCheckBox.getText());
        } else if (RecursosHumanosCheckBox.isSelected() == true) {
            p.setEspecProf(RecursosHumanosCheckBox.getText());
        } else {
            b = false;
            JOptionPane.showMessageDialog(null, "Selecione uma especialidade para o professor");
        }
        if (b) {
            if (isSelectedProfessor()) {
                p.setIdentProf(getProfessor().getIdentProf());
                pDAO.update(p);
            } else {
                pDAO.create(p);                
            }
            statusProf.setText(pDAO.getProfessoresStatus());
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        especProfGroup = new javax.swing.ButtonGroup();
        tituloProfGroup = new javax.swing.ButtonGroup();
        nomeP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dataNascP = new javax.swing.JFormattedTextField();
        InformaticaCheckBox = new javax.swing.JCheckBox();
        MatematicaCheckBox = new javax.swing.JCheckBox();
        MedicinaCheckBox = new javax.swing.JCheckBox();
        FarmacologiaCheckBox = new javax.swing.JCheckBox();
        OdontologiaCheckBox = new javax.swing.JCheckBox();
        DireitoCheckBox = new javax.swing.JCheckBox();
        PsicologiaCheckBox = new javax.swing.JCheckBox();
        RecursosHumanosCheckBox = new javax.swing.JCheckBox();
        BacharelCheckBox = new javax.swing.JCheckBox();
        EspecialistaLatoSensuCheckBox = new javax.swing.JCheckBox();
        MestradoCheckBox = new javax.swing.JCheckBox();
        DoutoradoCheckBox = new javax.swing.JCheckBox();
        salvarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        statusProf = new javax.swing.JLabel();

        setTitle("Professor");
        setResizable(false);

        jLabel1.setText("Nome :");

        jLabel2.setText("Nasc : ");

        try {
            dataNascP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        InformaticaCheckBox.setText("Informática");

        MatematicaCheckBox.setText("Matemática");

        MedicinaCheckBox.setText("Medicina");

        FarmacologiaCheckBox.setText("Farmacologia");

        OdontologiaCheckBox.setText("Odontologia");

        DireitoCheckBox.setText("Direito");

        PsicologiaCheckBox.setText("Psicologia");

        RecursosHumanosCheckBox.setText("Recursos Humanos");

        BacharelCheckBox.setText("Bacharel");

        EspecialistaLatoSensuCheckBox.setText("Especialista Lato Sensu");

        MestradoCheckBox.setText("Mestrado");

        DoutoradoCheckBox.setText("Doutorado");

        salvarButton.setText("SALVAR");

        cancelarButton.setText("CANCELAR");

        statusProf.setBackground(new java.awt.Color(51, 153, 0));
        statusProf.setFont(new java.awt.Font("Arial", 3, 10)); // NOI18N
        statusProf.setForeground(new java.awt.Color(51, 153, 0));
        statusProf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nomeP, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addComponent(BacharelCheckBox)
                            .addComponent(EspecialistaLatoSensuCheckBox)
                            .addComponent(MestradoCheckBox)
                            .addComponent(DoutoradoCheckBox)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(salvarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusProf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RecursosHumanosCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PsicologiaCheckBox)
                    .addComponent(DireitoCheckBox)
                    .addComponent(OdontologiaCheckBox)
                    .addComponent(FarmacologiaCheckBox)
                    .addComponent(MedicinaCheckBox)
                    .addComponent(MatematicaCheckBox)
                    .addComponent(InformaticaCheckBox)
                    .addComponent(cancelarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(dataNascP))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataNascP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BacharelCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EspecialistaLatoSensuCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MestradoCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DoutoradoCheckBox))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(InformaticaCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MatematicaCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MedicinaCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FarmacologiaCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OdontologiaCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DireitoCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PsicologiaCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RecursosHumanosCheckBox)))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(salvarButton)
                        .addComponent(cancelarButton))
                    .addComponent(statusProf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox BacharelCheckBox;
    private javax.swing.JCheckBox DireitoCheckBox;
    private javax.swing.JCheckBox DoutoradoCheckBox;
    private javax.swing.JCheckBox EspecialistaLatoSensuCheckBox;
    private javax.swing.JCheckBox FarmacologiaCheckBox;
    private javax.swing.JCheckBox InformaticaCheckBox;
    private javax.swing.JCheckBox MatematicaCheckBox;
    private javax.swing.JCheckBox MedicinaCheckBox;
    private javax.swing.JCheckBox MestradoCheckBox;
    private javax.swing.JCheckBox OdontologiaCheckBox;
    private javax.swing.JCheckBox PsicologiaCheckBox;
    private javax.swing.JCheckBox RecursosHumanosCheckBox;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JFormattedTextField dataNascP;
    private javax.swing.ButtonGroup especProfGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nomeP;
    private javax.swing.JButton salvarButton;
    private javax.swing.JLabel statusProf;
    private javax.swing.ButtonGroup tituloProfGroup;
    // End of variables declaration//GEN-END:variables

}
