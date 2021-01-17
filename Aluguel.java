import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 * Classe que cria a tela para a efetuação do aluguel. Nela, serão selecionados o cliente e a data de devolução.
 * 
 * @author Matheo
 */
public class Aluguel extends javax.swing.JFrame  {

    private DefaultTableModel model;
    private int contador = 1;
    protected static int index;  
    protected static int indexCliente;

    Cliente cl;
    Carro carro;
    /**
     * Método que carrega a tabela, com os clientes e suas respectivas informações (Nome, documento, telefone, email e
     * estado de aluguel).
     */        
    private void carregarTabela()
    {
        DefaultTableModel localModel = (DefaultTableModel) tabelaClientes.getModel();
        
        for (Cliente objC : ListaClientes.listaClientes)
        {
            Object[] row = new Object[6];
            row[0] = String.valueOf(contador);
            row[1] = String.valueOf(objC.getNome());
            row[2] = String.valueOf(objC.getDocumento());
            row[3] = String.valueOf(objC.getTelefone());
            row[4] = String.valueOf(objC.getEmail());
            row[5] = String.valueOf(objC.getAluguel());
            localModel.addRow(row);
            contador++;
        }
    }
    
    /**
     * Método que preenche os campos referentes ao carro (marca, modelo, cor, renavam e o preço diario)
     * selecionado e ao dia atual, com base no dia atual informado pelo computador
     * @param index index do carro na lista de carros
     */
    public void defineDataECarro(int index){
        carro = ListaCarros.listaCarros.get(index);
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");  
        Date date = new Date();
        DecimalFormat d = new DecimalFormat("#,##0.00");
        
        jTextFieldData.setText(formatador.format(date));
        jTextFieldVeiculo.setText(carro.getMarca()+"/"+carro.getModelo());
        jTextFieldCor.setText(carro.getCor());
        jTextFieldRenavam.setText(carro.getRenavam());
        jTextFieldPreco.setText(d.format(carro.getPrecoDiario()));
    }
    
    /**
     * Construtor da classe Aluguel, que carrega a tabela de clientes e preenche as informações do carro e da data
     * atual.
     */
    public Aluguel() {
        model = new DefaultTableModel();
        tabelaClientes = new JTable(model); 
        
        initComponents();
        carregarTabela();
    }
    
    /**
     * Método que inicializa o filtro de clientes a partir de seu CPF.
     * @param cpf o CPF do cliente.
     */
    public void filtro(String cpf){
        TableRowSorter<TableModel> busca = new TableRowSorter<>(tabelaClientes.getModel());
        tabelaClientes.setRowSorter(busca);
        busca.setRowFilter(RowFilter.regexFilter(cpf, 2));
    }
    
    /**
     * Método que confere se a data entre o dia da efetuação do aluguel e o dia de devolução
     * obedece à duração mínima do aluguel
     * @param data data de efetuação do aluguel.
     * @param devol data de devolução.
     * @return se a duração mínima é obedecida ou não.
     */
    public boolean confereDias(Date data, Date devol ){
        
        long dias = ChronoUnit.DAYS.between(data.toInstant(), devol.toInstant());
        if((dias + 1) >= ListaCarros.listaCarros.get(index).getDiasMinimos()){
            return true;
        } else {
            return false;
        }
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldBusca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldData = new javax.swing.JTextField();
        try{     javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##/##/####");     jTextFieldData = new javax.swing.JFormattedTextField(data);  }     catch (Exception e){  }
        jLabelLocatario = new javax.swing.JLabel();
        jLabelCPF = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldLocatario = new javax.swing.JTextField();
        jTextFieldCPF = new javax.swing.JTextField();
        jTextFieldTelefone = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldDevol = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##/##/####");
            jTextFieldDevol= new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        jLabel5 = new javax.swing.JLabel();
        jTextFieldVeiculo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldRenavam = new javax.swing.JTextField();
        jLabelAviso = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        jScrollPane2.setBackground(new java.awt.Color(102, 102, 102));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setMinimumSize(new java.awt.Dimension(710, 450));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(710, 450));
        jPanel2.setLayout(null);

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Telefone", "E-mail", "Aluguel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaClientes);
        if (tabelaClientes.getColumnModel().getColumnCount() > 0) {
            tabelaClientes.getColumnModel().getColumn(0).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(1).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(2).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(3).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(4).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(240, 50, 452, 122);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("CPF:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(40, 120, 32, 17);

        jTextFieldBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscaKeyReleased(evt);
            }
        });
        jPanel2.add(jTextFieldBusca);
        jTextFieldBusca.setBounds(80, 110, 128, 30);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Selecione um cliente:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(40, 70, 140, 17);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Data:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 150, 32, 15);
        jPanel1.add(jTextFieldData);
        jTextFieldData.setBounds(60, 140, 90, 30);

        jLabelLocatario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLocatario.setText("Locatário:");
        jPanel1.add(jLabelLocatario);
        jLabelLocatario.setBounds(20, 20, 53, 15);

        jLabelCPF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelCPF.setText("CPF:");
        jPanel1.add(jLabelCPF);
        jLabelCPF.setBounds(280, 20, 24, 15);

        jLabelTelefone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTelefone.setText("Telefone:");
        jPanel1.add(jLabelTelefone);
        jLabelTelefone.setBounds(450, 20, 53, 15);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("E-mail:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 60, 60, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Data de devolução: ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(160, 150, 110, 15);
        jPanel1.add(jTextFieldLocatario);
        jTextFieldLocatario.setBounds(80, 10, 149, 30);

        jTextFieldCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCPFActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldCPF);
        jTextFieldCPF.setBounds(320, 10, 110, 30);

        jTextFieldTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelefoneActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldTelefone);
        jTextFieldTelefone.setBounds(520, 10, 112, 30);

        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldEmail);
        jTextFieldEmail.setBounds(80, 50, 150, 30);

        jTextFieldDevol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDevolActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldDevol);
        jTextFieldDevol.setBounds(270, 140, 90, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Veículo:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 100, 43, 15);
        jPanel1.add(jTextFieldVeiculo);
        jTextFieldVeiculo.setBounds(70, 90, 141, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Cor:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(230, 100, 22, 15);
        jPanel1.add(jTextFieldCor);
        jTextFieldCor.setBounds(270, 90, 85, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Preço:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(540, 100, 35, 15);
        jPanel1.add(jTextFieldPreco);
        jTextFieldPreco.setBounds(580, 90, 70, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Confirmar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(170, 190, 90, 30);

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCancelarMouseClicked(evt);
            }
        });
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancelar);
        jButtonCancelar.setBounds(410, 190, 80, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Renavam:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(380, 100, 53, 15);

        jTextFieldRenavam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRenavamActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldRenavam);
        jTextFieldRenavam.setBounds(440, 90, 76, 30);

        jLabelAviso.setVisible(false);
        jLabelAviso.setForeground(new java.awt.Color(255, 0, 10));
        jLabelAviso.setText("Data inválida");
        jPanel1.add(jLabelAviso);
        jLabelAviso.setBounds(380, 150, 94, 14);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(30, 190, 660, 240);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Aluguel");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(320, 0, 70, 30);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 710, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 710, 450);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Método que insere nos campos relacionados ao cliente as informações do cliente selecionado
     * na tabela
     * @param evt execução quando há a seleção de um cliente na tabela. 
     */
    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked
        indexCliente = tabelaClientes.getSelectedRow();

        cl = ListaClientes.listaClientes.get(indexCliente);
        jTextFieldLocatario.setText(cl.getNome());
        jTextFieldCPF.setText(cl.getDocumento());
        jTextFieldTelefone.setText(cl.getTelefone());
        jTextFieldEmail.setText(cl.getEmail());    
        
    }//GEN-LAST:event_tabelaClientesMouseClicked

    /**
     * Método que filtra os clientes pelo CPF.
     * @param evt filtra os clientes a partir do ato de digitar no campo de texto.
     */
    private void jTextFieldBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscaKeyReleased
        String cpf = jTextFieldBusca.getText();
        filtro(cpf);
    }//GEN-LAST:event_jTextFieldBuscaKeyReleased

    /**
     * Método que fecha a tela.
     * @param evt fecha a tela ao clicar no botão de cancelar
     */
    private void jButtonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelarMouseClicked
        dispose();
    }//GEN-LAST:event_jButtonCancelarMouseClicked

    private void jTextFieldRenavamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRenavamActionPerformed

    }//GEN-LAST:event_jTextFieldRenavamActionPerformed

    /**
     * Método que efetua o aluguel, caso os dias de aluguel e devolução obedeçam o requisito de 
     * dias mínimos, caso o cliente não possua aluguel em aberto ou o carro não esteja alugado.
     * @param evt a seleção do botão de Confirmar.
     */
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try{
            int flag1 = 0;
            for (int i = 0; i < ListaClientes.listaClientes.size(); i++) {
            if (jTextFieldCPF.getText().equals(ListaClientes.listaClientes.get(i).getDocumento())){
                    flag1++;
                }
            }
            if (flag1 == 1) {
            boolean flag = this.confereDias(new Date(), new SimpleDateFormat("dd/MM/yyyy").parse(jTextFieldDevol.getText()));
            if (ListaClientes.listaClientes.get(indexCliente).getAluguel().equals("Nenhum")) {
            if (!ListaCarros.listaCarros.get(index).isAlugado()){
                if(flag) {
                    if(jTextFieldDevol.getText().equals("")){
                        jLabelAviso.setVisible(true);
                    } else {
                        CriaPdf cria = new CriaPdf(jTextFieldLocatario.getText(), jTextFieldCPF.getText(), jTextFieldTelefone.getText(), jTextFieldEmail.getText(), 
                                jTextFieldVeiculo.getText(), jTextFieldCor.getText(), jTextFieldRenavam.getText(), jTextFieldPreco.getText(), jTextFieldData.getText(), jTextFieldDevol.getText());
                        ListaCarros.listaCarros.get(index).setIsAlugado();
                        ListaClientes.listaClientes.get(indexCliente).setAluguel();

                        AlugueisClasse lda = new AlugueisClasse(ListaCarros.listaCarros.get(index), ListaClientes.listaClientes.get(indexCliente), 
                                new Date(), new SimpleDateFormat("dd/MM/yyyy").parse(jTextFieldDevol.getText()));
                        ListaAlugueis.listaAlugueis.add(lda);
                        JOptionPane.showMessageDialog(this, "Aluguel realizado com sucesso!");
                        dispose();
                    }
                } else {
                    jLabelAviso.setVisible(true);
                }
        } else {
                JOptionPane.showMessageDialog(null,"Carro já alugado.","Aviso",JOptionPane.WARNING_MESSAGE);
            }
            } else {
                JOptionPane.showMessageDialog(null,"O cliente já possui aluguel pendente.","Aviso",JOptionPane.WARNING_MESSAGE);
            }
            } else {
                JOptionPane.showMessageDialog(null,"O cliente inserido não se encontra cadastrado no sistema","Aviso",JOptionPane.WARNING_MESSAGE);
            }
        } catch(ParseException pe){
            JOptionPane.showMessageDialog(null,"Data inválida.","Aviso",JOptionPane.WARNING_MESSAGE);
            jTextFieldDevol.setText("");
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTextFieldDevolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDevolActionPerformed

    }//GEN-LAST:event_jTextFieldDevolActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCPFActionPerformed

    }//GEN-LAST:event_jTextFieldCPFActionPerformed

    private void jTextFieldTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelefoneActionPerformed

    }//GEN-LAST:event_jTextFieldTelefoneActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailActionPerformed

    /**
     * Método principal da classe Aluguel
     * @param args argumentos da linha de comando 
     */
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
            java.util.logging.Logger.getLogger(Aluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aluguel().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAviso;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelLocatario;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldBusca;
    private javax.swing.JTextField jTextFieldCPF;
    public javax.swing.JTextField jTextFieldCor;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldDevol;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldLocatario;
    public javax.swing.JTextField jTextFieldPreco;
    public javax.swing.JTextField jTextFieldRenavam;
    private javax.swing.JTextField jTextFieldTelefone;
    public javax.swing.JTextField jTextFieldVeiculo;
    private javax.swing.JTable tabelaClientes;
    // End of variables declaration//GEN-END:variables

}
