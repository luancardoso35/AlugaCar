import java.io.*;

/**
 * Classe que lê o conteúdo dos arquivos binários "Clientes.bin", "Funcionarios.bin", 
 * "Alugueis.bin" e "Carros.bin", e insere as informações contidas em cada um deles no sistema
 * 
 * @author Luan
 * @author Matheo
 */
public abstract class LeArquivoBin {
    
    /**
     * Método que abre o arquivo binário "Carros.bin", lê as informações sobre os carros
     * contidas no mesmo e as insere no sistema
     */
    protected static void leArquivoCarros()
    {
        try {
            int nro;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Carros.bin"));
            nro = ois.readInt();
          
            for (int i = 0; i < nro; i++)
            {
                Carro objC = (Carro)ois.readObject();
                ListaCarros.listaCarros.add(objC);
            }
            
            ois.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ioe) {
        } catch (ClassNotFoundException cnfe) {
        }
    }
    
    /**
     * Método que abre o arquivo binário "Funcionarios.bin", lê as informações sobre 
     * os funcionários contidas no mesmo e as insere no sistema
     * @return 1 se o arquivo de funcionários foi lido com sucesso ou 0 se não conseguiu ler o arquivo
     */
    protected static int leArquivoFuncionarios()
    {
        try {
            int retorno;
            int nro;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Funcionarios.bin"));
            retorno = ois.readInt();
            nro = ois.readInt();
            
            for (int i = 0; i < nro; i++)
            {
                Funcionario objF = (Funcionario)ois.readObject();
                ListaFuncionarios.listaFuncionarios.add(objF);
            }
            
            ois.close();
            return retorno;
        } catch (FileNotFoundException ex) {
            return 0;
        } catch (IOException ioe) {
            return 0;
        } catch (ClassNotFoundException cnfe) {
            return 0;
        }
    }
    
    /**
     * Método que abre o arquivo binário "Clientes.bin", lê as informações sobre os clientes
     * contidas no mesmo e as insere no sistema
     */
    protected static void leArquivoClientes()
    {
        try {
            int nro;
            int i = 0;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Clientes.bin"));
            nro = ois.readInt();
            
            while (i < nro) {
                
                Object obj = ois.readObject();
                Cliente objC = (Cliente) obj;
                ListaClientes.listaClientes.add(objC);
                i++;
            }
            
            ois.close();
        } catch (FileNotFoundException ex) {
            System.err.println("FileNotFoundException" + ex.toString());
        } catch (IOException ioe) {
            System.err.println("IOException" + ioe.toString());
        } catch (ClassNotFoundException cnfe) {
            System.err.println("ClassNotFoundException" + cnfe.toString());
        } catch (Exception exM) {
            System.err.println("Exception" + exM.toString());
        }
    }
    
    /**
     * Método que abre o arquivo binário "Alugueis.bin", lê as informações sobre 
     * os alugueis presentes no mesmo e as insere no sistema
     */
    protected static void leArquivoAluguel(){
        try{
            int nro;
            ObjectInputStream ois = new ObjectInputStream( new FileInputStream("Alugueis.bin"));
            nro = ois.readInt();
            for (int i = 0; i < nro; i++)
            {
                AlugueisClasse al = (AlugueisClasse)ois.readObject();
                ListaAlugueis.listaAlugueis.add(al);
            }
           
        }catch(FileNotFoundException fnfe){
            System.err.println(fnfe);
        }catch(IOException ioe){
            System.err.println(ioe);
        }catch(ClassNotFoundException cnfe){
            System.err.println(cnfe);
        }
        
    }
}
