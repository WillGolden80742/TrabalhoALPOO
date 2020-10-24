/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DAO.cursosDAO;
import Model.bean.Curso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class editarCriarCurso extends javax.swing.JFrame implements ActionListener {

    private Curso curso = new Curso();
    private cursosDAO cDAO = new cursosDAO();

    public editarCriarCurso() {
        initComponents();
        addGroup();
        setSaveButton();
        setLocation(400, 200);
        setCursosList();
    }

    void setCursosList() {
        String[] cursoArr = {"Analise e desenvolvimento de sistemas", "Administração", "Administração pública", "Arquitetura e urbanismo", "Artes visuais", "Banco de dados", "Biomedicina", "Ciência de dados", "Ciências biológicas", "Ciências contábeis", "Ciências da computação", "Ciências da natureza", "Ciências econômicas", "Ciências exatas", "Ciências humanas", "Comércio exterior", "Computação", "Comunicação institucional", "Cozinha contemporânea", "Defesa cibernética", "Design de moda", "Design gráfico", "Direito", "Educação física", "Enfermagem", "Engenharia ambiental e sanitária", "Engenharia civil", "Engenharia de controle e automação", "Engenharia de petróleo", "Engenharia de produção", "Engenharia de software", "Engenharia elétrica", "Engenharia mecânica", "Estética e cosmética", "Farmácia", "Filosofia", "Física", "Fisioterapia", "Formacão pedagógica", "Gastronomia", "Geografia", "Gerontologia - bem estar e educação", "Gestão ambiental", "Gestão comercial", "Gestão da produção industrial", "Gestão da qualidade", "Gestão da tecnologia da informação", "Gestão de recursos humanos", "Gestão de segurança privada", "Gestão de turismo", "Gestão e empreendedorismo", "Gestão financeira", "Gestão hospitalar", "Gestão pública", "História", "Investigação forense e perícia criminal", "Jogos digitais", "Jornalismo", "Letras - espanhol", "Letras - espanhol", "Letras - espanhol", "Letras - inglês", "Letras - inglês", "Letras - inglês", "Letras - libras - língua portuguesa", "Letras - língua portuguesa", "Letras - língua portuguesa e libras", "Letras - português", "Logística", "Marketing", "Matemática", "Mediação", "Negócios imobiliários", "Nutrição", "Odontologia cirurgião dentista", "Pedagogia", "Pedagogia", "Processos escolares", "Processos gerenciais", "Psicologia", "Publicidade e propaganda", "Química", "Radiologia", "Redes de computadores", "Relações internacionais", "Secretariado executivo", "Segurança no trabalho", "Segurança pública", "Serviço social", "Sistemas de informação", "Sistemas para internet", "Sociologia", "Tecnologias educacionais", "Teologia", "Turismo"};
        for (String cursoArr1 : cursoArr) {
            cursoComboBox.addItem(cursoArr1);
        }
    }

    private boolean selectedCurso = false;

    private boolean isSelectedCurso() {
        return selectedCurso;
    }

    private void setSelectedCurso() {
        this.selectedCurso = true;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
        cHoraria.setText(String.valueOf(curso.getCargaHoraria()));
        cInst.setText(String.valueOf(curso.getCodInstituto()));
        switch (curso.getTipoCurso()) {
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
            case "Curso Superior":
                CursoSuperiorCheckBox.setSelected(true);
                break;
        }
        idCurso.setText("Id : "+curso.getCodCurso());
        cursoComboBox.setSelectedIndex(0);
        setSelectedCurso();
        setSaveButton();
    }

    void addGroup() {
        tipoCursoGroup.add(BacharelCheckBox);
        BacharelCheckBox.addActionListener(this);
        tipoCursoGroup.add(EspecialistaLatoSensuCheckBox);
        EspecialistaLatoSensuCheckBox.addActionListener(this);
        tipoCursoGroup.add(MestradoCheckBox);
        MestradoCheckBox.addActionListener(this);
        tipoCursoGroup.add(DoutoradoCheckBox);
        DoutoradoCheckBox.addActionListener(this);
        salvarButton.addActionListener(this);
        tipoCursoGroup.add(CursoSuperiorCheckBox);
        CursoSuperiorCheckBox.addActionListener(this);
        cancelarButton.addActionListener(this);
        //  --------------------------------------------------------             
    }

    void setSaveButton() {
        if (isSelectedCurso() == true) {
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
        Curso d = new Curso();
        boolean b = true;
        if (cursoComboBox.getSelectedIndex()!=0) {
            d.setNomeCurso((String) cursoComboBox.getSelectedItem());
        } else if (!isSelectedCurso()) {
            b = false;
            JOptionPane.showMessageDialog(null, "Selecione um curso"); 
        } else {
            d.setNomeCurso(curso.getNomeCurso());
        }
        try {
            d.setCargaHoraria(Integer.parseInt(cHoraria.getText()));
            d.setCodInstituto(Integer.parseInt(cInst.getText()));
        } catch (NumberFormatException ex) {
            b = false;
            JOptionPane.showMessageDialog(null, "Digite numero inteiro");
        }
        // -----------------------------------       
        if (BacharelCheckBox.isSelected() == true) {
            d.setTipoCurso(BacharelCheckBox.getText());
        } else if (EspecialistaLatoSensuCheckBox.isSelected() == true) {
            d.setTipoCurso(EspecialistaLatoSensuCheckBox.getText());
        } else if (MestradoCheckBox.isSelected() == true) {
            d.setTipoCurso(MestradoCheckBox.getText());
        } else if (DoutoradoCheckBox.isSelected() == true) {
            d.setTipoCurso(DoutoradoCheckBox.getText());
        } else if (CursoSuperiorCheckBox.isSelected() == true) {
            d.setTipoCurso(CursoSuperiorCheckBox.getText());
        } else {
            b = false;
            JOptionPane.showMessageDialog(null, "Selecione o tipo do curso");
        }
        if (b) {
            if (isSelectedCurso()) {
                d.setCodCurso(curso.getCodCurso());
                cDAO.update(d);
            } else {
                cDAO.create(d);
            }
            statusCurso.setText(cDAO.getCursosStatus());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoCursoGroup = new javax.swing.ButtonGroup();
        salvarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        cInstLabel = new javax.swing.JLabel();
        cHoraria = new javax.swing.JTextField();
        aulaLabel1 = new javax.swing.JLabel();
        cursoComboBox = new javax.swing.JComboBox<>();
        statusCurso = new javax.swing.JLabel();
        BacharelCheckBox = new javax.swing.JCheckBox();
        EspecialistaLatoSensuCheckBox = new javax.swing.JCheckBox();
        MestradoCheckBox = new javax.swing.JCheckBox();
        DoutoradoCheckBox = new javax.swing.JCheckBox();
        cHorariaLabel = new javax.swing.JLabel();
        cInst = new javax.swing.JTextField();
        CursoSuperiorCheckBox = new javax.swing.JCheckBox();
        idCurso = new javax.swing.JLabel();

        setTitle("Curso");
        setResizable(false);

        salvarButton.setText("SALVAR");

        cancelarButton.setText("CANCELAR");

        cInstLabel.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        cInstLabel.setText("Cod Instituto :");

        aulaLabel1.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        aulaLabel1.setText("Tipo Curso :");

        cursoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "selecione curso" }));

        statusCurso.setBackground(new java.awt.Color(51, 153, 0));
        statusCurso.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        statusCurso.setForeground(new java.awt.Color(51, 153, 0));
        statusCurso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        BacharelCheckBox.setText("Bacharel");

        EspecialistaLatoSensuCheckBox.setText("Especialista Lato Sensu");

        MestradoCheckBox.setText("Mestrado");

        DoutoradoCheckBox.setText("Doutorado");

        cHorariaLabel.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        cHorariaLabel.setText("Carga Horaria : ");

        CursoSuperiorCheckBox.setText("Curso Superior");

        idCurso.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EspecialistaLatoSensuCheckBox)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cursoComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(salvarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(statusCurso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(aulaLabel1)
                                    .addComponent(BacharelCheckBox))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CursoSuperiorCheckBox)
                                    .addComponent(MestradoCheckBox)
                                    .addComponent(DoutoradoCheckBox))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(cHorariaLabel)
                                        .addGap(9, 9, 9))
                                    .addComponent(cInstLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cInst, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(cHoraria)
                            .addComponent(idCurso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(idCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aulaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BacharelCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EspecialistaLatoSensuCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cInstLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cInst, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MestradoCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DoutoradoCheckBox)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cHorariaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CursoSuperiorCheckBox)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(cursoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvarButton)
                    .addComponent(cancelarButton))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {DoutoradoCheckBox, MestradoCheckBox});

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox BacharelCheckBox;
    private javax.swing.JCheckBox CursoSuperiorCheckBox;
    private javax.swing.JCheckBox DoutoradoCheckBox;
    private javax.swing.JCheckBox EspecialistaLatoSensuCheckBox;
    private javax.swing.JCheckBox MestradoCheckBox;
    private javax.swing.JLabel aulaLabel1;
    private javax.swing.JTextField cHoraria;
    private javax.swing.JLabel cHorariaLabel;
    private javax.swing.JTextField cInst;
    private javax.swing.JLabel cInstLabel;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JComboBox<String> cursoComboBox;
    private javax.swing.JLabel idCurso;
    private javax.swing.JButton salvarButton;
    private javax.swing.JLabel statusCurso;
    private javax.swing.ButtonGroup tipoCursoGroup;
    // End of variables declaration//GEN-END:variables

}
