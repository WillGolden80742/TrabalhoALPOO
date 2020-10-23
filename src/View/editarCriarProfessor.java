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

    private professoresDAO pDAO = new professoresDAO();
    private Professor professor = new Professor();
    private boolean selectedProfessor = false;
    private boolean hideEndStatus = true;
    
    public editarCriarProfessor() {
        initComponents();
        addGroup();
        setSaveButton();
        setLocation(400, 200);
        toggleEnd();
    }

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
        setSelectedProfessor();
        setSaveButton();
    }

    void addGroup() {
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
            setSize(520, 240);
            endSeparator.setVisible(hideEndStatus);
        } else {
            this.hideEndStatus = true;
            setSize(520, 335);
            endSeparator.setVisible(hideEndStatus);
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
        if (!nomeP.getText().equals("")) {
            p.setNomeProf(nomeP.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Inclua o nome do professor");
            b = false;
        }
        if (JListCurso.getSelectedValue() != null) {
            p.setEspecProf(JListCurso.getSelectedValue());
        } else {
            if (isSelectedProfessor()) {
                p.setEspecProf(professor.getEspecProf());
            } else {
                JOptionPane.showMessageDialog(null, "Selecione especialdade para professor");
                b = false;
            }
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

        tituloProfGroup = new javax.swing.ButtonGroup();
        nomeP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dataNascP = new javax.swing.JFormattedTextField();
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
        endSeparator = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        JListCurso = new javax.swing.JList<>();
        titulo = new javax.swing.JLabel();

        setTitle("Professor");
        setResizable(false);

        jLabel1.setText("Nome :");

        jLabel2.setText("Nasc : ");

        try {
            dataNascP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        BacharelCheckBox.setText("Bacharel");

        EspecialistaLatoSensuCheckBox.setText("Especialista Lato Sensu");

        MestradoCheckBox.setText("Mestrado");

        DoutoradoCheckBox.setText("Doutorado");

        salvarButton.setText("SALVAR");

        cancelarButton.setText("CANCELAR");

        statusProf.setBackground(new java.awt.Color(51, 153, 0));
        statusProf.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        statusProf.setForeground(new java.awt.Color(51, 153, 0));
        statusProf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        addEnd.setText("Endereço");

        try {
            telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        telefoneLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        telefoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        telefoneLabel.setText("Telefone : ");

        cidadeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cidadeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cidadeLabel.setText("Cidade : ");

        logradouroLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        logradouroLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        logradouroLabel.setText("Lograd. : ");

        bairroLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bairroLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bairroLabel.setText("Bairro : ");

        telefoneResLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        telefoneResLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        telefoneResLabel.setText("Tel. Res. : ");

        numLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        numLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        numLabel.setText("nº : ");

        ufLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ufLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ufLabel.setText("UF : ");

        try {
            telRes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        JListCurso.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Analise e desenvolvimento de sistemas", "Administração", "Administração pública", "Arquitetura e urbanismo", "Artes visuais", "Banco de dados", "Biomedicina", "Ciência de dados", "Ciências biológicas", "Ciências contábeis", "Ciências da computação", "Ciências da natureza", "Ciências econômicas", "Ciências exatas", "Ciências humanas", "Comércio exterior", "Computação", "Comunicação institucional", "Cozinha contemporânea", "Defesa cibernética", "Design de moda", "Design gráfico", "Direito", "Educação física", "Enfermagem", "Engenharia ambiental e sanitária", "Engenharia civil", "Engenharia de controle e automação", "Engenharia de petróleo", "Engenharia de produção", "Engenharia de software", "Engenharia elétrica", "Engenharia mecânica", "Estética e cosmética", "Farmácia", "Filosofia", "Física", "Fisioterapia", "Formacão pedagógica", "Gastronomia", "Geografia", "Gerontologia - bem estar e educação", "Gestão ambiental", "Gestão comercial", "Gestão da produção industrial", "Gestão da qualidade", "Gestão da tecnologia da informação", "Gestão de recursos humanos", "Gestão de segurança privada", "Gestão de turismo", "Gestão e empreendedorismo", "Gestão financeira", "Gestão hospitalar", "Gestão pública", "História", "Investigação forense e perícia criminal", "Jogos digitais", "Jornalismo", "Letras - espanhol", "Letras - espanhol", "Letras - espanhol", "Letras - inglês", "Letras - inglês", "Letras - inglês", "Letras - libras - língua portuguesa", "Letras - língua portuguesa", "Letras - língua portuguesa e libras", "Letras - português", "Logística", "Marketing", "Matemática", "Mediação", "Negócios imobiliários", "Nutrição", "Odontologia cirurgião dentista", "Pedagogia", "Pedagogia", "Processos escolares", "Processos gerenciais", "Psicologia", "Publicidade e propaganda", "Química", "Radiologia", "Redes de computadores", "Relações internacionais", "Secretariado executivo", "Segurança no trabalho", "Segurança pública", "Serviço social", "Sistemas de informação", "Sistemas para internet", "Sociologia", "Tecnologias educacionais", "Teologia", "Turismo" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(JListCurso);

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        titulo.setText("Titulo ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(endSeparator)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cidadeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(telefoneLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logradouroLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cidade, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(telefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(logradouro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(numLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bairroLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(telefoneResLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(telRes, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ufLabel)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bairro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(addEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(salvarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(statusProf, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(cancelarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(EspecialistaLatoSensuCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BacharelCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(MestradoCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DoutoradoCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titulo)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(nomeP, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataNascP, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dataNascP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nomeP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BacharelCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EspecialistaLatoSensuCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MestradoCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DoutoradoCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(endSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logradouroLabel))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cidadeLabel))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bairroLabel))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ufLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(numLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telefoneResLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addComponent(addEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusProf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(salvarButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(5, 5, 5))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bairro, cidade, logradouro, num, telRes, telefone, uf});

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox BacharelCheckBox;
    private javax.swing.JCheckBox DoutoradoCheckBox;
    private javax.swing.JCheckBox EspecialistaLatoSensuCheckBox;
    private javax.swing.JList<String> JListCurso;
    private javax.swing.JCheckBox MestradoCheckBox;
    private javax.swing.JButton addEnd;
    private javax.swing.JTextField bairro;
    private javax.swing.JLabel bairroLabel;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JTextField cidade;
    private javax.swing.JLabel cidadeLabel;
    private javax.swing.JFormattedTextField dataNascP;
    private javax.swing.JSeparator endSeparator;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
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
    private javax.swing.JLabel titulo;
    private javax.swing.ButtonGroup tituloProfGroup;
    private javax.swing.JTextField uf;
    private javax.swing.JLabel ufLabel;
    // End of variables declaration//GEN-END:variables

}
