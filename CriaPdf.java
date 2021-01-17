import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


/**
 * Classe que cria o arquivo .PDF denominado "aluguel.pdf", contendo as informações do locatório, do carro alugado
 * e a data do aluguel.
 * 
 * @author Matheo
 */
public class CriaPdf {
    PDDocument pdDoc;
    String nome;
    String cpf;
    String telefone;
    String email;
    String veiculo;
    String cor;
    String renavam;
    String preco;
    String data;
    String devol;
    
    /**
     * Construtor da Classe CriaPDF.
     * @param nome nome do locatório
     * @param cpf CPF do locatório
     * @param telefone número de telefone do locatório
     * @param email email do locatório
     * @param veiculo veículo alugado
     * @param cor cor do veículo
     * @param renavam renavam do veículo
     * @param preco preço do veículo
     * @param data data da realização do aluguel
     * @param dataDevol data estipulada para a devolução do aluguel.
     */
    public CriaPdf(String nome, String cpf, String telefone, String email, String veiculo, String cor, String renavam,String preco,String data, String dataDevol){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.veiculo = veiculo;
        this.cor = cor;
        this.renavam = renavam;
        this.preco = preco;
        this.data = data;
        this.devol = dataDevol;
        assinatura();
    }
    
    /**
     *  Método que cria uma página em arquivo PDF, contendo informações sobre o locatório e sobre o aluguel realizado
     */
    public void assinatura(){
        try{
            pdDoc = new PDDocument();
            PDPage pagina = new PDPage();
            pdDoc.addPage(pagina);
                       
            PDPageContentStream pcs = new PDPageContentStream(pdDoc, pagina);
            pcs.beginText();
            pcs.setFont(PDType1Font.HELVETICA, 26);
            pcs.moveTextPositionByAmount(250, 750);
            pcs.drawString("Aluguel");
            pcs.endText();
            
            pcs.beginText();
            pcs.setFont(PDType1Font.HELVETICA, 17);
            pcs.moveTextPositionByAmount(40, 700);
            pcs.drawString("Dados do locatário" );
            pcs.endText();
            
            pcs.beginText();
            pcs.setFont(PDType1Font.HELVETICA, 14);
            pcs.moveTextPositionByAmount(40, 680);
            pcs.drawString("Locatário: "+ nome);
            pcs.endText();
            
            pcs.beginText();
            pcs.setFont(PDType1Font.HELVETICA, 14);
            pcs.moveTextPositionByAmount(40, 660);
            pcs.drawString("CPF: "+ cpf);
            pcs.endText();
            
            pcs.beginText();
            pcs.setFont(PDType1Font.HELVETICA, 14);
            pcs.moveTextPositionByAmount(40, 640);
            pcs.drawString("Telefone: "+ telefone);
            pcs.endText();
            
            pcs.beginText();
            pcs.setFont(PDType1Font.HELVETICA, 14);
            pcs.moveTextPositionByAmount(40, 620);
            pcs.drawString("E-mail: "+email );
            pcs.endText();
            
            pcs.beginText();
            pcs.setFont(PDType1Font.HELVETICA, 14);
            pcs.moveTextPositionByAmount(40, 590);
            pcs.drawString("Veículo: "+ veiculo+ " de cor " +cor+ "e renavam " + renavam);
            pcs.endText();
            
            pcs.beginText();
            pcs.setFont(PDType1Font.HELVETICA, 14);
            pcs.moveTextPositionByAmount(40, 570);
            pcs.drawString("Devolução deve ser feita até o dia: "+ devol);
            pcs.endText();
            
            pcs.beginText();
            pcs.setFont(PDType1Font.HELVETICA, 17);
            pcs.moveTextPositionByAmount(183, 160);
            pcs.drawString("__________________________" );
            pcs.endText();
            
            pcs.beginText();
            pcs.setFont(PDType1Font.HELVETICA, 17);
            pcs.moveTextPositionByAmount(190, 140);
            pcs.drawString("São Paulo, dia " + data );
            pcs.endText();
            
            pcs.close();
            pdDoc.save("aluguel.pdf");
            pdDoc.close();
        } catch(IOException ioe) {
            System.err.println(ioe);
        } 
    }
}
