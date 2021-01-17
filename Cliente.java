import java.io.Serializable;

/**
 * Classe que define o objeto Cliente, assim como seus métodos get e set para manipulação de suas informações.
 * 
 * @author Luan
 * @author Matheo
 */
public class Cliente extends Pessoa implements Serializable{

    private String endereco;
    private int nroAlugueis;
    private String email;
    private boolean alugado;

    /**
     * Construtor da Classe Cliente.
     * @param nome nome do cliente
     * @param telefone telefone do cliente
     * @param documento CPF do cliente
     * @param dataNasc data de nascimento
     * @param sexo o sexo do cliente (masculino ou feminino).
     * @param email e-mail do cliente
     * @param endereco endereço do cliente.
     */
    public Cliente(String nome, String telefone, String documento, String dataNasc, String sexo, String email, String endereco) {
        super(nome, telefone, documento, dataNasc, sexo);
        this.endereco = endereco;
        this.email = email;
    }



    /**
     * @return o email do cliente
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * @return se o cliente possui um aluguel em aberto ou não. 
     */
    public String getAluguel(){
        if(alugado == false){
            return "Nenhum";
        }else{
            return "Em aberto";
        }
    }

    /**
     * Método que inverte a condição do cliente em relação ao aluguel (aluguel em aberto ou não). 
     */
    public void setAluguel() {
        if(alugado){
            alugado = false;
        }else{
            alugado = true;
        }
    }
}
