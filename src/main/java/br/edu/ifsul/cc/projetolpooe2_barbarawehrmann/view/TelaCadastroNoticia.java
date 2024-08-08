package br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.view;

import br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.dao.PersistenciaJPA;
import br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.model.TipoNoticia;
import br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.model.Midias;
import br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.model.Noticias;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class TelaCadastroNoticia extends javax.swing.JFrame {

    private PersistenciaJPA jpa;
    private Noticias noticiaAtual;

    public TelaCadastroNoticia() {
        initComponents();
        listarTiposDeNoticia(); // mostra os tipos de notícias logo após inicializar os componentes
        listarMidias(); // mostra as mídias logo após inicializar os componentes

        lstMidias.setModel(new DefaultListModel<Midias>());
    }

    public TelaCadastroNoticia(Noticias noticia) {
        this();
        this.noticiaAtual = noticia;
    }

    private void listarTiposDeNoticia() {
        jpa = new PersistenciaJPA();
        List<TipoNoticia> tiposNoticia = jpa.getTiposDeNoticia();

        if (tiposNoticia != null) {
            DefaultComboBoxModel<TipoNoticia> modelTipos = new DefaultComboBoxModel<>();

            for (TipoNoticia tipo : tiposNoticia) {
                modelTipos.addElement(tipo);
            }

            cbTipoNoticia.setModel(modelTipos); // seta os tipos no combo box
        } else {
            JOptionPane.showMessageDialog(this, "Houve um erro ao carregar tipos de notícia!");
        }
    }

    private void listarMidias() {
        jpa = new PersistenciaJPA();
        List<Midias> midiasList = jpa.getMidias();

        if (midiasList != null) {
            DefaultComboBoxModel<Midias> model = new DefaultComboBoxModel<>();

            for (Midias midia : midiasList) {
                model.addElement(midia);
            }

            cbSelecionarMidia.setModel(model); // seta as mídias no combo box
        } else {
            JOptionPane.showMessageDialog(this, "Houve um erro ao carregar as mídias!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCadastroNoticias = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        lblConteudo = new javax.swing.JLabel();
        jsConteudo = new javax.swing.JScrollPane();
        txtConteudo = new javax.swing.JTextArea();
        lblTipo = new javax.swing.JLabel();
        cbTipoNoticia = new javax.swing.JComboBox<>();
        lblAdicionarTipo = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        lblSelecioneMidia = new javax.swing.JLabel();
        cbSelecionarMidia = new javax.swing.JComboBox<>();
        lblMidiasNoticia = new javax.swing.JLabel();
        jsMidias = new javax.swing.JScrollPane();
        lstMidias = new javax.swing.JList<>();
        btnMais = new javax.swing.JButton();
        btnAdicionarMidia = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnMenos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCadastroNoticias.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCadastroNoticias.setText("CADASTRO E EDIÇÃO DE NOTÍCIAS");

        lblTitulo.setText("Título:");

        lblConteudo.setText("Conteúdo:");

        txtConteudo.setColumns(20);
        txtConteudo.setRows(5);
        jsConteudo.setViewportView(txtConteudo);

        lblTipo.setText("Tipo:");

        lblAdicionarTipo.setText("Adicionar novo");

        separador.setForeground(new java.awt.Color(153, 153, 153));

        lblSelecioneMidia.setText("Selecione uma mídia:");

        lblMidiasNoticia.setText("Mídias da notícia");

        jsMidias.setViewportView(lstMidias);

        btnMais.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMais.setText("+");
        btnMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaisActionPerformed(evt);
            }
        });

        btnAdicionarMidia.setText("Adicionar nova");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnMenos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMenos.setText("-");
        btnMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTitulo)
                            .addComponent(lblConteudo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMidiasNoticia)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblSelecioneMidia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbSelecionarMidia, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(8, 8, 8)
                                .addComponent(btnMais))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTitulo)
                            .addComponent(jsConteudo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTipo)
                                    .addComponent(cbTipoNoticia, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lblAdicionarTipo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMenos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdicionarMidia))
                            .addComponent(jsMidias, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(separador)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(lblCadastroNoticias)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblCadastroNoticias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblConteudo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsConteudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipoNoticia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdicionarTipo))
                .addGap(20, 20, 20)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSelecioneMidia)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbSelecionarMidia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMais, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMidiasNoticia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsMidias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(btnAdicionarMidia))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaisActionPerformed
        Midias midiaSelecionada = (Midias) cbSelecionarMidia.getSelectedItem(); // pega a imagem selecionada no combo box

        if (midiaSelecionada != null) {
            DefaultListModel<Midias> modelMidiasSelecionadas = (DefaultListModel<Midias>) lstMidias.getModel();
            modelMidiasSelecionadas.addElement(midiaSelecionada);

            lstMidias.setModel(modelMidiasSelecionadas); // seta a imagem no list
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma mídia para adicionar.");
        }
    }//GEN-LAST:event_btnMaisActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose(); // fecha a tela
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosActionPerformed
        int midiaSelecionada = lstMidias.getSelectedIndex();

        if (midiaSelecionada != -1) { // -1 = nenhuma mídia selecionada
            DefaultListModel<Midias> model = (DefaultListModel<Midias>) lstMidias.getModel();
            model.remove(midiaSelecionada); // remove a imagem da list
        }
    }//GEN-LAST:event_btnMenosActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        jpa = new PersistenciaJPA();
        jpa.conexaoAberta();

        List<Midias> midiasSelecionadas = new ArrayList<>();
        DefaultListModel<Midias> modelMidiasSelecionadas = (DefaultListModel<Midias>) lstMidias.getModel();

        try {
            if (noticiaAtual == null) { // situação 1: adicionar nova notícia

                noticiaAtual = new Noticias();

                for (int i = 0; i < modelMidiasSelecionadas.getSize(); i++) {
                    midiasSelecionadas.add(modelMidiasSelecionadas.getElementAt(i)); // adiciona ao model as mídias do list
                }

            } else { // situação 2: editar notícia existente

                noticiaAtual = (Noticias) jpa.find(Noticias.class, noticiaAtual.getId()); // pega a notícia existente no banco

                if (midiasSelecionadas.isEmpty()) {
                    for (int i = 0; i < modelMidiasSelecionadas.getSize(); i++) {
                        midiasSelecionadas.add(modelMidiasSelecionadas.getElementAt(i)); // adiciona ao model as mídias do list
                    }
                } else {
                    for (Midias midia : noticiaAtual.getMidias()) { // seta as mídais existentes da notícia ao model
                        System.out.println("mídia: " + midia + "\n");
                        modelMidiasSelecionadas.addElement(midia);
                    }
                }
            }

            // validação
            if (txtTitulo.getText().isEmpty() || txtConteudo.getText().isEmpty() || cbTipoNoticia.getSelectedItem() == null || midiasSelecionadas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "ATENÇÃO! Todos os campos devem ser preenchidos e pelo menos uma mídia deve ser adicionada!");
                return;
            }

            noticiaAtual.setTitulo(txtTitulo.getText());
            noticiaAtual.setConteudo(txtConteudo.getText());
            noticiaAtual.setTipo_noticia((TipoNoticia) cbTipoNoticia.getSelectedItem());
            noticiaAtual.setMidias(midiasSelecionadas);

            jpa.persist(noticiaAtual);

            JOptionPane.showMessageDialog(this, "Notícia salva com sucesso!");
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao salvar a notícia: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroNoticia().setVisible(true);
            }
        });
    }

    public Noticias getNoticia() {
        return noticiaAtual;
    }

    public void setNoticia(Noticias noticia) {
        this.noticiaAtual = noticia;
        txtTitulo.setText(noticiaAtual.getTitulo());
        txtConteudo.setText(noticiaAtual.getConteudo());
        cbTipoNoticia.setSelectedItem(noticiaAtual.getTipo_noticia());

        DefaultListModel<Midias> listModel = new DefaultListModel<>();

        for (Midias midia : noticiaAtual.getMidias()) { // seta as mídais existentes da notícia ao model
            listModel.addElement(midia);
        }

        lstMidias.setModel(listModel); // seta as mídias à list
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarMidia;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnMais;
    private javax.swing.JButton btnMenos;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Midias> cbSelecionarMidia;
    private javax.swing.JComboBox<TipoNoticia> cbTipoNoticia;
    private javax.swing.JScrollPane jsConteudo;
    private javax.swing.JScrollPane jsMidias;
    private javax.swing.JButton lblAdicionarTipo;
    private javax.swing.JLabel lblCadastroNoticias;
    private javax.swing.JLabel lblConteudo;
    private javax.swing.JLabel lblMidiasNoticia;
    private javax.swing.JLabel lblSelecioneMidia;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<Midias> lstMidias;
    private javax.swing.JSeparator separador;
    private javax.swing.JTextArea txtConteudo;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
