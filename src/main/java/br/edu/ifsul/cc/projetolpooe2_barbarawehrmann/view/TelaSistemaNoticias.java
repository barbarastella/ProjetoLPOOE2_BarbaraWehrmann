package br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.view;

import br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.dao.PersistenciaJPA;
import br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.model.Midias;
import br.edu.ifsul.cc.projetolpooe2_barbarawehrmann.model.Noticias;
import java.util.List;
import javax.swing.DefaultListModel;

public class TelaSistemaNoticias extends javax.swing.JFrame {

    private PersistenciaJPA jpa;
    private List<Noticias> noticiasList;

    public TelaSistemaNoticias() {
        initComponents();
        listarNoticias(); // mostra as notícias logo após inicializar os componentes

        lstNoticias.addListSelectionListener(e -> { // método para verificar seleção de um item da lista
            if (!e.getValueIsAdjusting()) { // verifica se uma notícia foi selecionada
                mostrarDetalhesNoticia();
            }
        });

        lstMidias.setEnabled(false); // desabilita edição do lstMidias
    }

    private void listarNoticias() {
        PersistenciaJPA persistencia = new PersistenciaJPA();

        noticiasList = persistencia.getNoticias();
        DefaultListModel<Noticias> modelNoticiasList = new DefaultListModel<Noticias>();

        for (Noticias noticia : noticiasList) {
            modelNoticiasList.addElement(noticia);
        }

        lstNoticias.setModel(modelNoticiasList); // seta as notícias no list
    }

    private void mostrarDetalhesNoticia() {
        int noticiaSelecionada = lstNoticias.getSelectedIndex();

        if (noticiaSelecionada != -1) { // -1 = nenhuma notícia selecionada

            jpa = new PersistenciaJPA();
            noticiasList = jpa.getNoticias();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSistemaNoticias.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSistemaNoticias.setText("SISTEMA DE NOTÍCIAS");

        lblNoticias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNoticias.setText("Notícias");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(lblSistemaNoticias))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
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
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdicionar))
                            .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblSistemaNoticias)
                .addGap(10, 10, 10)
                .addComponent(lblNoticias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spNoticias, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionar)
                    .addComponent(btnEditar))
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
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        TelaCadastroNoticia telaCadastroNoticia = new TelaCadastroNoticia(); // gera uma nova TelaCadastroNoticia
        telaCadastroNoticia.setVisible(true); // mostra a tela
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Noticias noticiaSelecionada = lstNoticias.getSelectedValue();
        
        if (noticiaSelecionada != null) {
            TelaCadastroNoticia telaCadastroNoticia = new TelaCadastroNoticia(); // gera uma nova TelaCadastroNoticia

            telaCadastroNoticia.setNoticia(noticiaSelecionada);
            telaCadastroNoticia.setVisible(true); // seta a noticia

            listarNoticias();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

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
