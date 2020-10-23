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
        setSaveButton();
        setLocation(400, 200);
        toggleEnd();
    }

    private professoresDAO pDAO = new professoresDAO();
    private Professor professor = new Professor();
    private boolean selectedProfessor = false;

    boolean hideEndStatus = true;

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
        // Endereço Inicio     
        logradouro.setText(professor.getLogradouro());
        bairro.setText(professor.getBairro());
        cidade.setText(professor.getCidade());
        num.setText(professor.getNumero());
        uf.setText(professor.getEstado());
        telefone.setText(professor.getTelefone());
        telRes.setText(professor.getTelefoneRes());
        // Endereço Fim     
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
        addEnd.addActionListener(this);
    }

    void setSaveButton() {
        if (isSelectedProfessor() == true) {
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
        if (e.getSource() == addEnd) {
            toggleEnd();
        }
    }

    void toggleEnd() {
        if (hideEndStatus) {
            this.hideEndStatus = false;
            setSize(500, 230);
        } else {
            this.hideEndStatus = true;
            setSize(500, 315);
        }
        logradouroLabel.setVisible(hideEndStatus);
        logradouro.setVisible(hideEndStatus);
        bairroLabel.setVisible(hideEndStatus);
        bairro.setVisible(hideEndStatus);
        cidadeLabel.setVisible(hideEndStatus);
        cidade.setVisible(hideEndStatus);
        numLabel.setVisible(hideEndStatus);
        num.setVisible(hideEndStatus);
        ufLabel.setVisible(hideEndStatus);
        uf.setVisible(hideEndStatus);
        telefoneLabel.setVisible(hideEndStatus);
        telefone.setVisible(hideEndStatus);
        telefoneResLabel.setVisible(hideEndStatus);
        telRes.setVisible(hideEndStatus);
        addEnd.setVisible(!hideEndStatus);
    }

    void Salvar() {
        Professor p = new Professor();
        p.setNomeProf(nomeP.getText());
        p.setDataNasc(dataNascP.getText());
        boolean b = true;
        // Endereço Inicio     
        p.setLogradouro(logradouro.getText());
        p.setBairro(bairro.getText());
        p.setCidade(cidade.getText());
        p.setNumero(num.getText());
        p.setEstado(uf.getText());
        p.setTelefone(telefone.getText());
        p.setTelefoneRes(telRes.getText());
        // Endereço Fim          
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
        addEnd = new javax.swing.JButton();
        cidade = new javax.swing.JTextField();
        telefone = new javax.swing.JFormattedTextField();
        telefoneLabel = new javax.swing.JLabel();
        cidadeLabel = new javax.swing.JLabel();
        logradouroLabel = new javax.swing.JLabel();
        bairroLabel = new javax.swing.JLabel();
        logradouro = new javax.swing.JTextField();
        telefoneResLabel = new javax.swing.JLabel();
        numLabel = new javax.swing.JLabel();
        ufLabel = new javax.swing.JLabel();
        telRes = new javax.swing.JFormattedTextField();
        uf = new javax.swing.JTextField();
        num = new javax.swing.JTextField();
        bairro = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

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

        addEnd.setText("Endereço");

        try {
            telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        telefoneLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        telefoneLabel.setForeground(new java.awt.Color(102, 102, 102));
        telefoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        telefoneLabel.setText("Telefone : ");

        cidadeLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        cidadeLabel.setForeground(new java.awt.Color(102, 102, 102));
        cidadeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cidadeLabel.setText("Cidade : ");

        logradouroLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        logradouroLabel.setForeground(new java.awt.Color(102, 102, 102));
        logradouroLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        logradouroLabel.setText("Lograd. :");

        bairroLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        bairroLabel.setForeground(new java.awt.Color(102, 102, 102));
        bairroLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bairroLabel.setText("Bairro :");

        telefoneResLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        telefoneResLabel.setForeground(new java.awt.Color(102, 102, 102));
        telefoneResLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        telefoneResLabel.setText("Tel. Res. : ");

        numLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        numLabel.setForeground(new java.awt.Color(102, 102, 102));
        numLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        numLabel.setText("nº : ");

        ufLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        ufLabel.setForeground(new java.awt.Color(102, 102, 102));
        ufLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ufLabel.setText("UF : ");

        try {
            telRes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cidadeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(telefoneLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(logradouroLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cidade, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(telefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                                    .addComponent(logradouro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telefoneResLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(numLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bairroLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(telRes, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ufLabel)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(bairro, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(salvarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(statusProf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DoutoradoCheckBox)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BacharelCheckBox)
                                        .addGap(139, 139, 139)
                                        .addComponent(InformaticaCheckBox))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(EspecialistaLatoSensuCheckBox)
                                        .addGap(67, 67, 67)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(PsicologiaCheckBox)
                                            .addComponent(FarmacologiaCheckBox)))
                                    .addComponent(MestradoCheckBox))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RecursosHumanosCheckBox)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(MatematicaCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(OdontologiaCheckBox)
                                                .addGap(1, 1, 1)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(DireitoCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(MedicinaCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(nomeP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(94, 94, 94)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dataNascP, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataNascP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InformaticaCheckBox)
                            .addComponent(BacharelCheckBox)
                            .addComponent(MatematicaCheckBox)
                            .addComponent(MedicinaCheckBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EspecialistaLatoSensuCheckBox)
                            .addComponent(FarmacologiaCheckBox)
                            .addComponent(OdontologiaCheckBox)
                            .addComponent(DireitoCheckBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PsicologiaCheckBox)
                            .addComponent(RecursosHumanosCheckBox)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(MestradoCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DoutoradoCheckBox)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logradouroLabel)
                    .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bairroLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cidadeLabel)
                    .addComponent(ufLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefoneResLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(salvarButton)
                        .addComponent(statusProf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cancelarButton))
                .addGap(5, 5, 5))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bairro, cidade, logradouro, num, telRes, telefone, uf});

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
    private javax.swing.JButton addEnd;
    private javax.swing.JTextField bairro;
    private javax.swing.JLabel bairroLabel;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JTextField cidade;
    private javax.swing.JLabel cidadeLabel;
    private javax.swing.JFormattedTextField dataNascP;
    private javax.swing.ButtonGroup especProfGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField logradouro;
    private javax.swing.JLabel logradouroLabel;
    private javax.swing.JTextField nomeP;
    private javax.swing.JTextField num;
    private javax.swing.JLabel numLabel;
    private javax.swing.JButton salvarButton;
    private javax.swing.JLabel statusProf;
    private javax.swing.JFormattedTextField telRes;
    private javax.swing.JFormattedTextField telefone;
    private javax.swing.JLabel telefoneLabel;
    private javax.swing.JLabel telefoneResLabel;
    private javax.swing.ButtonGroup tituloProfGroup;
    private javax.swing.JTextField uf;
    private javax.swing.JLabel ufLabel;
    // End of variables declaration//GEN-END:variables

}
