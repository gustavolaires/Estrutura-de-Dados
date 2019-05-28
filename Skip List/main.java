import java.util.Scanner;
import classes.SkipList;
import exceptions.NoSuchKey;

public class main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SkipList sl = new SkipList();
		
		String ans = null;
		String value = null;
		
		boolean loop = true;
		while(loop) {
			
			System.out.print("Digite uma opcao\n"
						+"[1] - inserir elemento\n"
						+"[2] - buscar elemento\n"
						+"[3] - remover elemento\n"
						+"[4] - imprimir\n"
						+"[5] - size\n"
						+"[0] - sair\n\n"
							+"Opcao: ");
			ans = sc.nextLine();
			System.out.println();
			
			
			switch (ans) {
				case "1":
					System.out.print("Digite um valor inteiro: ");
					value = sc.nextLine();
					sl.inserir(Integer.parseInt(value));
					System.out.println("Valor " + value + " inserido!\n");
					break;
				case "2":
					System.out.print("Digite um valor inteiro: ");
					value = sc.nextLine();
					try {
						value = (String) sl.find(Integer.parseInt(value)).getElement();
						System.out.println("\nO valor " + value + " foi localizado!\n");
					}catch(NoSuchKey e) {
						System.out.println(e.getMessage());
						System.out.println();
					}
					break;
				case "3":
					System.out.print("Digite um valor inteiro: ");
					value = sc.nextLine();
					try {
						value = (String) sl.deletar(Integer.parseInt(value)).getElement();
						System.out.println("\nO valor " + value + " foi deletado!\n");
					}catch(NoSuchKey e) {
						System.out.println("Este valor nao esta na lista!");
						System.out.println();
					}
					break;
				case "4":
					System.out.println( sl.imprimir() );
					break;
				case "5":
					System.out.println( "Size: " + String.valueOf( sl.size() ) + "\n" );
					break;
				case "0":
					loop = false;
					sc.close();
					break;
				default:
					System.out.println("Opcao nao valida!\n");
					break;
			}
		}
	}
}
