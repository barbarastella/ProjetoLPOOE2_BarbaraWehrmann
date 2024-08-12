package br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.view;

import br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.dao.PersistenciaJPA;
import br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.model.Midias;
import br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.model.Noticias;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class TelaSistemaNoticias extends javax.swing.JFrame {

    private PersistenciaJPA jpa = new PersistenciaJPA();
    private List<Noticias> noticiasList;

    public TelaSistemaNoticias() {
        initComponents();
        noticiasList = new ArrayList<>();
        listarNoticias(); // mostra as notícias logo após inicializar os componentes

        lstNoticias.addListSelectionListener(e -> { // método para verificar seleção de um item da lista
            if (!e.getValueIsAdjusting()) { // verifica se uma notícia foi selecionada
                mostrarDetalhesNoticia();
            }
        });
        lstMidias.setEnabled(false); // desabilita edição do lstMidias
    }

    public void listarNoticias() {

        lstNoticias.clearSelection();
        jpa.conexaoAberta();
        noticiasList = jpa.getNoticias();
        jpa.fecharConexao();

        System.out.println("Noticias: " + noticiasList);
        DefaultListModel<Noticias> modelNoticiasList = new DefaultListModel<>();

        modelNoticiasList.clear();
        for (Noticias noticia : noticiasList) {
            modelNoticiasList.addElement(noticia);
        }

        lstNoticias.setModel(modelNoticiasList); // seta as notícias no list
    }

    private void mostrarDetalhesNoticia() {
        int noticiaSelecionada = lstNoticias.getSelectedIndex();

        if (noticiaSelecionada != -1) { // -1 = nenhuma notícia selecionada
            
            jpa.conexaoAberta();
            noticiasList = jpa.getNoticias();
            jpa.fecharConexao();

            Noticias noticia = noticiasList.get(noticiaSelecionada);
            lblTipo.setText(noticia.getTipo_noticia().getDescricao()); // seta o tipo da notícia no label

            DefaultListModel midiasModel = new DefaultListModel<>();

            for (Midias midia : noticia.getMidias()) {
                midiasModel.addElement(midia);
            }

            lstMidias.setModel(midiasModel); // seta as mídias da notícia no list
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSistemaNoticias = new javax.swing.JLabel();
        lblNoticias = new javax.swing.JLabel();
        spNoticias = new javax.swing.JScrollPane();
        lstNoticias = new javax.swing.JList<>();
        btnEditar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        lblTipoNoticia = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblMidiasNoticia = new javax.swing.JLabel();
        spMidias = new javax.swing.JScrollPane();
        lstMidias = new javax.swing.JList<>();
        btnSair = new javax.swing.JButton();
        btnRemoverNoticia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSistemaNoticias.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSistemaNoticias.setText("SISTEMA DE NOTÍCIAS");

        lblNoticias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNoticias.setText("Notícias");

        lstNoticias.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstNoticiasValueChanged(evt);
            }
        });
        spNoticias.setViewportView(lstNoticias);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar nova");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        lblTipoNoticia.setText("Tipo da notícia selecionada:");

        lblTipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(0, 51, 255));

        lblMidiasNoticia.setText("Mídias da notícia selecionada:");

        spMidias.setViewportView(lstMidias);

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnRemoverNoticia.setText("Excluir");
        btnRemoverNoticia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverNoticiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblMidiasNoticia)
                            .addComponent(lblNoticias)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTipoNoticia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(spMidias, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                            .addComponent(spNoticias, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRemoverNoticia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdicionar))
                            .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(lblSistemaNoticias)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblSistemaNoticias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNoticias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spNoticias, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverNoticia, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoNoticia)
                    .addComponent(lblTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMidiasNoticia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spMidias, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSair)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        TelaCadastroNoticia telaCadastroNoticia = new TelaCadastroNoticia(); // gera uma nova TelaCadastroNoticia

        telaCadastroNoticia.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                listarNoticias(); // Atualiza a lista de notícias após a janela ser fechada
            }
        });

        telaCadastroNoticia.setVisible(true); // mostra a tela
        listarNoticias();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        Noticias noticiaSelecionada = lstNoticias.getSelectedValue();

        if (noticiaSelecionada != null) {
            TelaCadastroNoticia telaCadastroNoticia = new TelaCadastroNoticia(); // gera uma nova TelaCadastroNoticia

            telaCadastroNoticia.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    listarNoticias(); // Atualiza a lista de notícias após a janela ser fechada
                }
            });

            telaCadastroNoticia.setNoticia(noticiaSelecionada); // seta a notícia
            telaCadastroNoticia.setVisible(true); // mostra a tela

            listarNoticias();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnRemoverNoticiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverNoticiaActionPerformed
        Noticias noticiaSelecionada = lstNoticias.getSelectedValue();

        if (noticiaSelecionada != null) {

            int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja remover a notícia '" + noticiaSelecionada.getTitulo().trim() + "'?");

            if (confirmacao == JOptionPane.YES_OPTION) {
                try {
                    jpa.conexaoAberta();
                    jpa.remover(noticiaSelecionada);
                } catch (Exception e) {
                    System.out.println("ERRO: Não foi possível excluir esta notícia!");
                } finally {
                    jpa.fecharConexao();
                    listarNoticias();
                }
            }
            listarNoticias();
        }
    }//GEN-LAST:event_btnRemoverNoticiaActionPerformed

    private void lstNoticiasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstNoticiasValueChanged
//        if (!evt.getValueIsAdjusting()) { // verifica se uma notícia foi selecionada
//            mostrarDetalhesNoticia();
//        }
    }//GEN-LAST:event_lstNoticiasValueChanged

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaSistemaNoticias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRemoverNoticia;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel lblMidiasNoticia;
    private javax.swing.JLabel lblNoticias;
    private javax.swing.JLabel lblSistemaNoticias;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTipoNoticia;
    private javax.swing.JList<String> lstMidias;
    private javax.swing.JList<Noticias> lstNoticias;
    private javax.swing.JScrollPane spMidias;
    private javax.swing.JScrollPane spNoticias;
    // End of variables declaration//GEN-END:variables
}
