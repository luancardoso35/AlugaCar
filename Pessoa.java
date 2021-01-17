import java.io.Serializable;

/**
 * Classe que define o objeto Pessoa, além de seus métodos get.
 * 
 * @author Luan
 */
public abstract class Pessoa implements Serializable{
    private String nome;
    private String telefone;
    private String documento;
    private String dataNascimento;
    private String sexo;
        
    /**
     * Construtor da classe Pessoa
     * @param nome nome
     * @param telefone número de telefone
     * @param documento número de CPF
     * @param dataNasc data de nascimento
     * @param sexo sexo (masculino ou feminino)
     */
    public Pessoa(String nome, String telefone, String documento, String dataNasc, String sexo)
    {
        this.nome = nome;
        this.telefone = telefone;
        this.documento = documento;
        this.dataNascimento = dataNasc;
        this.sexo = sexo;
    }
 
    /**
     * @return o nome 
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return o número de telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @return o número de CPF
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @return a data de nascimento
     */
    public String getDataNascimento() {
        return dataNascimento;
    }
}
