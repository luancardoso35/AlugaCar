import java.io.*;

/**
 * Classe que gera arquivos com nomes "Alugueis", "Carros", "Funcionários" e "Clientes", que contém
 * todos os aluguéis, carros, funcionários e clientes presente no sistema, logo após o uso do 
 * botão Sair
 * 
 * @author Luan
 * @author Matheo
 */
public abstract class GeraArquivoBin {
    
    /**
     * Método que cria o arquivo binário denominado "Carros.bin" e insere todos os carros cadastrados no sistema,
     * com as respectivas informações
     */
    protected static void geraCarros()
    {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Carros.bin"));
            oos.writeInt(ListaCarros.listaCarros.size());
            
            for (int i = 0; i < ListaCarros.listaCarros.size(); i++)
            {
                oos.writeObject(ListaCarros.listaCarros.get(i));
            }
                
            oos.close();
        } catch (FileNotFoundException fnfe) {
        } catch (IOException ioe) {
        }
    }
    
    /**
     * Método que cria o arquivo binário denominado "Funcionarios.bin" e insere todos os funcionários
     * cadastrados no sistema, junto de suas informações
     */
    protected static void geraFuncionario()
    {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Funcionarios.bin"));
            oos.writeInt(1);
            oos.writeInt(ListaFuncionarios.listaFuncionarios.size());
            
            for (int i = 0; i < ListaFuncionarios.listaFuncionarios.size(); i++)
            {
                oos.writeObject(ListaFuncionarios.listaFuncionarios.get(i));
            }
                
            oos.close();
        } catch (FileNotFoundException fnfe) {
        } catch (IOException ioe) {
        }
    }
    
    /**
     * Método que cria o arquivo binário denominado "Clientes.bin" e insere todos os clientes cadastrados
     * no sistema, junto de suas respectivas informações
     */
    protected static void geraCliente()
    {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Clientes.bin"));
            oos.writeInt(ListaClientes.listaClientes.size());
            
            for (int i = 0; i < ListaClientes.listaClientes.size(); i++)
            {
                oos.writeObject(ListaClientes.listaClientes.get(i));
            }
                
            oos.close();
        } catch (FileNotFoundException fnfe) {
        } catch (IOException ioe) {
        }
    }
    
    /**
     * Método que cria o arquivo binário "Alugueis.bin" e insere todos os alugueis em aberto que 
     * estão presentes no sistema, junto de suas respectivas informações
     */
    protected static void geraAluguel()
    {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Alugueis.bin"));
            oos.writeInt(ListaAlugueis.listaAlugueis.size());
            
            for (int i = 0; i < ListaAlugueis.listaAlugueis.size(); i++)
            {
                oos.writeObject(ListaAlugueis.listaAlugueis.get(i));
            }  
            oos.close();
        } catch (FileNotFoundException fnfe) {
        } catch (IOException ioe) {
        }
    }   
}