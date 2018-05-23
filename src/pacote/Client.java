package pacote;



import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;



public class Client {
    
	
    public static void main(String[] args) {
    	try {
    		Interface controle = (Interface) Naming.lookup("rmi://localhost:2999/demontie");

    		Scanner leitura = new Scanner(System.in);
    		String nomeProduto;
    		String operacao ="1";
    		int id;
    		float valor;
    		while (!operacao.equals("0")) {
                    System.out.println("1 - Cadastrar");
                    System.out.println("2 - Atualizar"); 
                    System.out.println("3 - Deletar");
                    System.out.println("4 - Recuperar");
                    System.out.println("0 - Fechar");
                    System.out.println("Opção:");
    			operacao = leitura.next();
    			switch (operacao) {
    			case "1":
    				System.out.println("Cadastrar um produto");
    				System.out.print("Código do produto:");
    				id = leitura.nextInt();
    				System.out.print("Nome do produto:");
    				nomeProduto = leitura.next();
    				System.out.println("Valor do produto:");
    				valor = leitura.nextFloat();
    				if(controle.cadastoProduto(id, nomeProduto, valor)) {
    					System.out.println("Cadastrado com Sucesso");
    				}else {
    					System.err.println("Falha \n");
    				}
    				break;
    			case "2":
    				System.out.println("Alterar as informações \n Id:");
    				id=leitura.nextInt();
    				if(controle.pesquisa(id)) {
    					System.out.print("Nome do produto:");
    					nomeProduto = leitura.next();
    					System.out.println("Valor do produto:");
    					valor = leitura.nextFloat();
    					if(controle.atualizaProduto(id, nomeProduto, valor)) {
    						System.out.println("Alterado! \n");
    					}else {
    						System.err.println("Alteração Falhou.\n");
    					}
    				}else {
    					System.err.println("Não Cadastrado.\n");
    				}
    				break;
    			case "3":
    				System.out.println("Deletar:\n código do produto:");
    				id =leitura.nextInt();
    				if(controle.removerProduto(id)) {
    					System.out.println("Removido\n");
    				}else {
    					System.out.println("NÃO Cadastrado!\n");
    				}
    				break;
    			case "4":
    				System.out.println("Recuperar :\n Informe código do produto:");
    				id = leitura.nextInt();
    				System.out.println(controle.pesquisaInfo(id)+"\n");
    				break;
    			default:
    				break;
    			}
    		}
    	} catch (MalformedURLException | RemoteException | NotBoundException e) {
    		System.err.println("Erro:" + e.toString());
    	} catch (Exception e) {
    		
    		System.err.println(e.getMessage());
    		System.exit(-1);
    	}
    }
} 
