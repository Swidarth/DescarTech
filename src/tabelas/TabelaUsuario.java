package tabelas;


import javax.swing.*;
import java.sql.*;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import dao.UsuarioDao;
import interfaces.BTelaLogin;
import interfaces.DTelaMenu;
import model.Usuario;
import jdbc.ConexaoBD;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Administrador;

public class TabelaUsuario extends javax.swing.JFrame {

    public TabelaUsuario() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuario = new javax.swing.JTable();
        btnAtualizar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        txtEmail = new javax.swing.JTextField();
        lblConfirme = new javax.swing.JLabel();
        txtConfirme = new javax.swing.JPasswordField();
        btnExcluir = new javax.swing.JButton();
        lblNome1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtProcurar = new javax.swing.JTextField();
        btnProcurar = new javax.swing.JButton();
        cbAdministrador = new javax.swing.JCheckBox();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabela de Usuários");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Celular", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaUsuario.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaUsuario);
        if (tabelaUsuario.getColumnModel().getColumnCount() > 0) {
            tabelaUsuario.getColumnModel().getColumn(0).setResizable(false);
            tabelaUsuario.getColumnModel().getColumn(1).setResizable(false);
            tabelaUsuario.getColumnModel().getColumn(2).setResizable(false);
            tabelaUsuario.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 828, 389));

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 190, 40));

        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 470, 190, 40));

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 470, 190, 40));
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 90, 180, 40));
        getContentPane().add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 160, 180, 40));

        lblSenha.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        lblSenha.setText("Senha:");
        getContentPane().add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 300, 80, 40));

        lblid.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        lblid.setText("ID");
        getContentPane().add(lblid, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 30, 40));

        lblCelular.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        lblCelular.setText("Celular:");
        getContentPane().add(lblCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 160, 90, 40));

        lblEmail.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        lblEmail.setText("E-mail:");
        getContentPane().add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 230, 80, 40));
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 300, 180, 40));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 230, 180, 40));

        lblConfirme.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        lblConfirme.setText("Confirme:");
        getContentPane().add(lblConfirme, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 360, 110, 40));
        getContentPane().add(txtConfirme, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 360, 180, 40));

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 420, 170, 40));

        lblNome1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        lblNome1.setText("Nome:");
        getContentPane().add(lblNome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 90, 80, 40));

        txtId.setEditable(false);
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtId.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 20, 60, 40));
        getContentPane().add(txtProcurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 290, 40));

        btnProcurar.setText("Procurar");
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });
        getContentPane().add(btnProcurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, 90, 40));

        cbAdministrador.setText("Administrador");
        cbAdministrador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cbAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAdministradorActionPerformed(evt);
            }
        });
        getContentPane().add(cbAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(816, 516, 140, 30));

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 490, 100, 30));

        setSize(new java.awt.Dimension(1249, 591));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
            txtId.setText("");
            txtNome.setText("");
            txtCelular.setText("");
            txtEmail.setText("");
            txtSenha.setText("");
            txtConfirme.setText("");
            txtProcurar.setText("");
            ListarValores();
    
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        UsuarioDao dao = new UsuarioDao();
        for (Usuario usuario : dao.pesquisarFuncionario()) {
            DefaultTableModel model = (DefaultTableModel) tabelaUsuario.getModel();
            Integer id = usuario.getId();
            String nome = usuario.getNome();
            String celular = usuario.getCelular();
            String email = usuario.getEmail();
            model.addRow(new Object[]{
                id, nome, celular, email
            });
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        conn = new ConexaoBD().getConnection();
        String id, nome, celular, email, senha, confirme;
        
        id = txtId.getText();
        nome = txtNome.getText();
        celular = txtCelular.getText();
        email = txtEmail.getText();
        senha = new String(txtSenha.getPassword());
        confirme = new String(txtConfirme.getPassword());

        if (nome.trim().equals("") || celular.trim().equals("") || email.trim().equals("")
                || senha.trim().equals("") || (confirme.trim().equals(""))) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        } else if (!senha.equals(confirme)) {
            JOptionPane.showMessageDialog(null, "Senha não confere.");
        } else {
            try {
                pstm = conn.prepareStatement("UPDATE usuario set nome = ?, celular = ?, email = ?, senha = ? where id = ?");
                pstm.setString(1, txtNome.getText());
                pstm.setString(2, txtCelular.getText());
                pstm.setString(3, txtEmail.getText());
                pstm.setString(4, senha);
                pstm.setString(5, txtId.getText());
                pstm.executeUpdate();
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

                txtNome.setText("");
                txtCelular.setText("");
                txtEmail.setText("");
                txtSenha.setText("");
                txtConfirme.setText("");
                ListarValores();
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro em modificacao.");
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed

        String nome, apelido, celular, email, senha, confirme, id;
        
            if (cbAdministrador.isSelected()) {
            
            Administrador administrador = new Administrador();  
        
        id = (txtId.getText());
        apelido = (txtNome.getText());
        celular = (txtCelular.getText());
        email = (txtEmail.getText());
        senha = new String(txtSenha.getPassword());
        confirme = new String (txtConfirme.getPassword());
            
        if (apelido.trim().equals("") || celular.trim().equals("")
        || email.trim().equals("") || senha.trim().equals("") || confirme.trim().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        else if(!senha.equals(confirme)){
        JOptionPane.showMessageDialog(rootPane, "A Senha não confere.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        else if (!id.trim().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Usuário já existe.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        else {
            
            Scanner sc = new Scanner(System.in);
            String contrasenha = "pimba";
            String tentativa = JOptionPane.showInputDialog(rootPane, "Digite a Senha de Segurança");

            if (tentativa.equals(contrasenha)) {
                JOptionPane.showMessageDialog(rootPane, "Senha Correta.");
            
            administrador.setApelido(txtNome.getText());
            administrador.setCelular(txtCelular.getText());
            administrador.setEmail(txtEmail.getText());
            administrador.setSenha(senha);
            UsuarioDao dao = new UsuarioDao();
            dao.adicionaAdministrador(administrador);
            JOptionPane.showMessageDialog(rootPane, "Administrador cadastrado com sucesso!");
            txtId.setText("");
            txtNome.setText("");
            txtCelular.setText("");
            txtEmail.setText("");
            txtSenha.setText("");
            txtConfirme.setText("");
            txtProcurar.setText("");
            ListarValores();
        }    
        else {
            JOptionPane.showMessageDialog(rootPane, "Senha de Segurança Incorreta.", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
        }
        
    }   
        else {
            
        // Se não for Administrador então segue a linha abaixo.
           
        Usuario usuario = new Usuario();
        
        id = (txtId.getText());
        nome = (txtNome.getText());
        celular = (txtCelular.getText());
        email = (txtEmail.getText());
        senha = new String(txtSenha.getPassword());
        confirme = new String(txtConfirme.getPassword());
        
        if (nome.trim().equals("") || celular.trim().equals("")
        || email.trim().equals("") || senha.trim().equals("") || confirme.trim().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        else if (!senha.equals(confirme)){
        JOptionPane.showMessageDialog(rootPane, "A Senha não confere.", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
        else if (!id.trim().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Usuário já existe.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        else {
            usuario.setNome(txtNome.getText());
            usuario.setCelular(txtCelular.getText());
            usuario.setEmail(txtEmail.getText());
            usuario.setSenha(senha);
            UsuarioDao dao = new UsuarioDao();
            dao.adicionaUsuario(usuario);
            JOptionPane.showMessageDialog(rootPane, "Usuario cadastrado com sucesso!");
            txtId.setText("");
            txtNome.setText("");
            txtCelular.setText("");
            txtEmail.setText("");
            txtSenha.setText("");
            txtConfirme.setText("");
            txtProcurar.setText("");
            ListarValores();
        }
    }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    Connection conn;
    PreparedStatement pstm;

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String id, nome, email, celular, senha;
        UsuarioDao dao = new UsuarioDao();
        nome = txtNome.getText();
        celular = txtCelular.getText();
        email = txtEmail.getText();
        id = txtId.getText();

        if (nome.trim().equals("") || celular.trim().equals("") || email.trim().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                pstm = conn.prepareStatement("DELETE FROM usuario WHERE id = ?");
                pstm.setString(1, id);
                pstm.executeUpdate();
                JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
                txtNome.setText("");
                txtCelular.setText("");
                txtEmail.setText("");
                ListarValores();
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Informacoes incorretas" + erro);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        try {
            conn = new ConexaoBD().getConnection();
            String procura = txtProcurar.getText();

            pstm = conn.prepareStatement("select * from usuario where id LIKE ? OR nome LIKE ? OR celular LIKE ? OR email LIKE ? ");
            pstm.setString(1, "%" + procura + "%");
            pstm.setString(2, "%" + procura + "%");
            pstm.setString(3, "%" + procura + "%");
            pstm.setString(4, "%" + procura + "%");
            ResultSet rs = pstm.executeQuery();

            if (rs.next() == true) {

                String id = rs.getString(1);
                String nome = rs.getString(2);
                String celular = rs.getString(3);
                String email = rs.getString(4);

                txtId.setText(id);
                txtNome.setText(nome);
                txtCelular.setText(celular);
                txtEmail.setText(email);
            } else {
                txtNome.setText("");
                txtCelular.setText("");
                txtEmail.setText("");
                JOptionPane.showMessageDialog(rootPane, "Não foi encontrado nenhum registro!", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao procurar.", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnProcurarActionPerformed

    private void cbAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAdministradorActionPerformed
        
    }//GEN-LAST:event_cbAdministradorActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TabelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabelaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JButton btnSair;
    private javax.swing.JCheckBox cbAdministrador;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblConfirme;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblid;
    private javax.swing.JTable tabelaUsuario;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JPasswordField txtConfirme;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtProcurar;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables

    public void ListarValores() {
        try {

            UsuarioDao dao = new UsuarioDao();
            DefaultTableModel model = (DefaultTableModel) tabelaUsuario.getModel();
            model.setNumRows(0);

            ArrayList<Usuario> lista = dao.pesquisarFuncionario();
            for (int num = 0; num < lista.size(); num++) {
                model.addRow(new Object[]{
                    lista.get(num).getId(),
                    lista.get(num).getNome(),
                    lista.get(num).getCelular(),
                    lista.get(num).getEmail()
                });
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Listar Valores: " + erro);
        }
    }

}
