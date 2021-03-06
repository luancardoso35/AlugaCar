import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Classe que apresenta tela contendo uma tabela com todos os funcionários cadastrados no sistema.
 * 
 * @author Luan
 * @author Matheo
 */
public class ListaFuncionarios extends javax.swing.JFrame {
    
    protected static ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario> ();
    private DefaultTableModel model;
    private int contador = 1;
    
    /**
     * Método que carrega a tabela com todos os funcionários cadastrados no sistema,
     * juntamente com suas informações (nome, CPF e login do sistema)
     */
    private void carregarTabelaF()
    {
        DefaultTableModel localModel = (DefaultTableModel) tabelaFuncionarios.getModel();
        
        for (Funcionario objF : this.listaFuncionarios)
        {
            if (!String.valueOf(objF.getDocumento()).equals("padrao")) {
            Object[] row = new Object[4];
            row[0] = String.valueOf(contador);
            row[1] = String.valueOf(objF.getNome());
            row[2] = String.valueOf(objF.getDocumento());
            row[3] = String.valueOf(objF.getLogin());
            localModel.addRow(row);
            contador++;
            }
        }
    }

    /**
     * Construtor da classe ListaFuncionarios
     * Creates new form ListaFuncionarios
     */
    public ListaFuncionarios() {
        model = new DefaultTableModel();
        tabelaFuncionarios = new JTable(model);
        initComponents();
        carregarTabelaF();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaFuncionarios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(730, 452));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(730, 452));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(null);

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setText("Voltar");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(617, 410, 90, 30);

        tabelaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Login"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane2.setViewportView(tabelaFuncionarios);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 60, 690, 340);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Lista de Funcionários");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(270, 0, 170, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(2, 0, 730, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 730, 460);

        setSize(new java.awt.Dimension(730, 453));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que fecha a tela.
     * @param evt ato de selecionar o botão "Voltar"
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Método principal da classe ListaFuncionarios
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(ListaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaFuncionarios;
    // End of variables declaration//GEN-END:variables
}
