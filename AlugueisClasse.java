import java.io.Serializable;
import java.util.Date;

/**
 * Classe para definir e armazenar os dados do aluguel, junto com seus métodos get.
 * 
 * @author Matheo
 */
public class AlugueisClasse implements Serializable {
    
    Carro carro;
    Cliente cliente;
    Date diaAluguel;
    Date devolucao;
    
    /**
     * Construtor da classe AlugueisClasse
     * @param carro o carro que foi alugado
     * @param cliente o cliente que efetuou o aluguel
     * @param diaAluguel o dia em que o aluguel foi efetuado
     * @param devolucao o dia estipulado para a devolução
     */
    public AlugueisClasse(Carro carro, Cliente cliente, Date diaAluguel, Date devolucao){
        this.carro = carro;
        this.cliente = cliente;
        this.diaAluguel = diaAluguel;
        this.devolucao = devolucao;
    }
    
    /**
     * Método que retorna a marca do carro escolhido para o aluguel
     * @return a marca do carro
     */
    public String getMarca(){
        return carro.getMarca();
    }
    /**
     * Método que retorna o modelo do carro escolhido para o aluguel
     * @return o modelo do carro
     */
    public String getModelo(){
        return carro.getModelo();
    }
    /**
     * Método que retorna a cor do carro escolhido para o aluguel
     * @return a cor do carro
     */
    public String getCor(){
        return carro.getCor();
    }   
    /**
     * Método que retorna o Renavam do carro escolhido para o aluguel
     * @return o Renavam do carro
     */
    public String getRenavam(){
        return carro.getRenavam();
    }
    /**
     * Método que retorna os dias mínimos que o carro escolhido pode ser alugado.
     * @return o número mínimo de dias que o carro poderá ser alugado 
     */
    public int getDiasMinimos(){
        return carro.getDiasMinimos();
    }
    /**
     * Método que retorna o preço do aluguel diário do carro alugado
     * @return o preço do aluguel diário do carro
     */
    public double getPreco(){
        return carro.getPrecoDiario();
    }
    /**
     * Método que retorna a multa diária por atrasar na devolução do carro alugado
     * @return a multa por dia de atraso na devolução
     */
    public double getMulta(){
        return carro.getMultaDiaria();
    }
    
    /**
     * Método que retorna o nome do cliente que efetuou o aluguel
     * @return o nome do locatório
     */
    public String getNome(){
        return cliente.getNome();
    }
    /**
     * Método que retorna o número de documento do cliente que efetuou o aluguel
     * @return o número de CPF do cliente 
     */
    public String getDocumento(){
        return cliente.getDocumento();
    }
    /**
     * Método que retorna a data do aluguel do carro
     * @return o dia em que o aluguel foi efetuado
     */
    
    public Date getData(){
        
        return diaAluguel;
    }
    /**
     * Método que retorna a data de devolução do carro.
     * @return o dia estipulado para a devolução
     */
    public Date getDevolucao(){
        
        return devolucao;
    }
    
    
}
