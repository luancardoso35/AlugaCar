import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 * Classe que cria um arquivo PDF denominado "recibo.pdf", contendo os dados do locatório,
 * dados do veículo alugado, data de aluguel e devolução, além do valor total a ser pago
 * 
 * @author Matheo
 */
public class ReciboPdf {
    
    private PDDocument pdDoc;
    private String nome;
    private String cpf;
    private String marca;
    private String modelo;
    private String cor;
    private String renavam;
    private String inicio;
    private String fim;
    private String preco;
    
    /**
     * Construtor da classe ReciboPDF
     * @param nome nome do locatório
     * @param cpf número de CPF do locatório
     * @param marca marca do veículo alugado
     * @param modelo modelo do veículo alugado
     * @param cor cor do veículo alugado
     * @param renavam renavam do veículo alugado
     * @param inicio data da efetuação do aluguel
     * @param fim data da devolução do veículo alugado
     * @param preco preço total do aluguel
     */
    public ReciboPdf(String nome, String cpf, String marca,String modelo, String cor, String renavam,Date inicio, Date fim, double preco){
        this.nome = nome;
        this.cpf = cpf;
        
        this.marca = marca;
        this.modelo = modelo;       
        this.cor = cor;
        this.renavam = renavam;
        this.inicio = new SimpleDateFormat("dd/MM/yyyy").format(inicio);
        this.fim = new SimpleDateFormat("dd/MM/yyyy").format(fim);
        this.preco = Double.toString(preco);
        escreveRecibo();
    }
       
    /**
     * Método que cria um arquivo PDF denominado "recibo.pdf" e insere 
     * os dados do locatório, do veículo alugado, as datas de efetuação e
     * devolução do aluguel e o preço a pagar pelo aluguel
     */
    public void escreveRecibo(){
        try{
            DecimalFormat d = new DecimalFormat("#,##0.00");
            pdDoc = new PDDocument();
            PDPage pagina = new PDPage();
            pdDoc.addPage(pagina);
            PDPageContentStream pcs = new PDPageContentStream(pdDoc, pagina);
            
            pcs.beginText();
            pcs.setFont(PDType1Font.HELVETICA, 26);
            pcs.moveTextPositionByAmount(250, 750);
            pcs.drawString("Recibo");
            pcs.endText();
            
            pcs.beginText();
            pcs.setFont(PDType1Font.HELVETICA, 14);
            pcs.moveTextPositionByAmount(40, 680);
            pcs.drawString("Data: " + fim);
            pcs.endText();
            
            pcs.beginText();
            pcs.setFont(PDType1Font.HELVETICA, 14);
            pcs.moveTextPositionByAmount(40, 660);
            pcs.drawString("Locatário: "+ nome +", CPF: "+ cpf);
            pcs.endText();
            
            pcs.beginText();
            pcs.setFont(PDType1Font.HELVETICA, 14);
            pcs.moveTextPositionByAmount(40, 640);
            pcs.drawString("Carro " + marca + " "+ modelo + " da cor "+ cor + " e renavam " + renavam + "."); 
            pcs.endText();
            
            pcs.beginText();
            pcs.setFont(PDType1Font.HELVETICA, 14);
            pcs.moveTextPositionByAmount(40, 620);
            pcs.drawString("Alugado pelo período de "+ inicio + " a "+ fim);
            pcs.endText();
            
            pcs.beginText();
            pcs.setFont(PDType1Font.HELVETICA, 14);
            pcs.moveTextPositionByAmount(40, 600);
            pcs.drawString("Total a pagar: R$"+ d.format(Double.parseDouble(preco) ));
            pcs.endText();
            
            pcs.close();
            pdDoc.save("recibo.pdf");
            pdDoc.close();
        } catch(IOException ioe) {
            System.err.println(ioe);
        }
    }
}
