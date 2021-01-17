import java.io.Serializable;

/**
 * Classe que define o objeto Funcionário.
 * @author Luan
 */
public class Funcionario extends Pessoa implements Serializable{

    /**
     * @return a senha do funcionário
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @return o login do funcionário
     */
    public String getLogin() {
        return login;
    }
   
   private String senha;
   private String login;
      
   /**
    * Construtor da classe Funcionario
    * @param nome o nome do funcionario
    * @param telefone o telefone do funcionario
    * @param documento o número de CPF do funcionário
    * @param dataNasc a data de nascimento do funcionário
    * @param sexo o sexo do funcionário (masculino ou feminino)
    * @param login o login do funcionário para acessar o sistema
    * @param senha a senha do funcionário para acessar o sistema
    */
   public Funcionario(String nome, String telefone, String documento, String dataNasc, String sexo, String login, String senha)
   {
       super(nome,  telefone, documento, dataNasc, sexo);
       this.login = login;
       this.senha = senha;
   }        
}
