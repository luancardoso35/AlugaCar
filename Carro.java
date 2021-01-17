import java.io.Serializable;

/**
 * Classe que define o objeto Carro, com os métodos get e set para manipulação de suas informações.
 * 
 * @author Luan
 * @author Matheo
 */
public class Carro implements Serializable{
    
    private String marca;
    private String modelo;
    private String cor;
    private String renavam;
    private int diasMinimos;
    private double precoDiario;
    private double multaDiaria;
    private boolean alugado = false;
    
    /**
     * Construtor para a Classe Carro
     * @param marca marca do carro
     * @param modelo modelo do carro
     * @param cor cor do carro
     * @param renavam renavam do carro
     * @param diasMinimos número mínimo de dias que o carro pode ser alugado.
     * @param precoDiario preço do aluguel diário do carro.
     * @param multaDiaria preço da multa diária por atraso na devolução do carro.
     */
    public Carro(String marca, String modelo, String cor, String renavam, int diasMinimos, double precoDiario, double multaDiaria)
    {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.renavam = renavam;
        this.precoDiario = precoDiario;
        this.diasMinimos = diasMinimos;
        this.multaDiaria = multaDiaria;
    }

    /**
     * @return marca do carro
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @return modelo do carro
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @return cor do carro
     */
    public String getCor() {
        return cor;
    }

    /**
     * @return o renavam do carro
     */
    public String getRenavam() {
        return renavam;
    }

    /**
     * @return o número de dias mínimos do aluguel do carro
     */
    public int getDiasMinimos() {
        return diasMinimos;
    }

    /**
     * @return o preço diário pelo aluguel do carro.
     */
    public double getPrecoDiario() {
        return precoDiario;
    }

    /**
     * @return o preço da multa diária pelo atraso na devolução
     */
    public double getMultaDiaria() {
        return multaDiaria;
    }

    /**
     * @return a indicação se o carro está alugado ou não
     */
    public boolean isAlugado() {
        return alugado;
    }

    /**
     * Define o número mínimo de dias do aluguel
     * @param dias número mínimo de dias
     */
    void setDiasMinimos(int dias) {
        this.diasMinimos = dias;
    }

    /**
     * Define o preço diário de aluguel do carro
     * @param preco preço diário de aluguel
     */
    void setPreco(double preco) {
        this.precoDiario = preco;
    }

    /**
     * Define a multa diária pelo atraso na devolução
     * @param multa a multa diária
     */
    void setMulta(double multa) {
        this.multaDiaria = multa;
    }
    
    /**
     * Método que altera a condição de alugado para seu oposto.
     */
    void setIsAlugado(){
        if(alugado){
            alugado = false;
        }else{
            alugado = true;
        }
    }
}
