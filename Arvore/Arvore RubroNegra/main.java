import java.util.List;
import java.util.Scanner;
import classes.ArvoreRB;
import classes.NoRB;

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArvoreRB t = new ArvoreRB();
		String ans = "";
		int obj = 0;
		
		NoRB n = null;
		
		while(ans != null) {
			menu();
			ans = sc.nextLine();
			System.out.println();
			switch (ans) {
			
				case "1": //insert Object
					System.out.print("Informe um número: ");
					obj = Integer.parseInt( sc.nextLine());
					if( t.insert( obj)) {
						System.out.println("Valor "+ String.valueOf(obj) + " inserido!\n");
					}
					else {
						System.out.println("Valor "+ String.valueOf(obj) + " ja existe!\n");
					}
					
					t.drawBinaryTree();
					
					break;
					
				case "2": //remove Object
					System.out.print("Informe um número: ");
					obj = Integer.parseInt( sc.nextLine());
					
					n = t.search(obj);
					if( n == null) {
						System.out.println("Valor "+ String.valueOf(obj) + " nao encontrado!\n");
					}
					else {
						n = t.remove(n);
						System.out.println("Valor "+ String.valueOf( n.getElemento()) + " removido!\n");
					}
					break;
					
				case "3": //drawBinaryTree
					System.out.println();
					t.drawBinaryTree();
					System.out.println();
					break;
					
				case "4": //search Object
					System.out.print("Informe um número: ");
					obj = Integer.parseInt( sc.nextLine());
					n = t.search(obj);
					if( n != null) {
						System.out.println("No "+ String.valueOf( n.getElemento()) + " encontrado!\n");
					}
					else {
						System.out.println("Valor "+ String.valueOf(obj) + " nao encontrado!\n");
					}
					break;
			
				case "5": //isEmpty
					if(t.isEmpty()) {
						System.out.println("A arvore esta vazia!\n");
					}
					else {
						System.out.println("A arvore nao esta vazia!\n");
					}
					break;
					
				case "6": //elements
					System.out.println("Escolha ordem de acesso aos nos:");
					System.out.println("[0] preOrder");
					System.out.println("[1] inOrder");
					System.out.println("[2] posOrder");
					System.out.print("Ordem de acesso: ");
					int orderElements = Integer.parseInt(sc.nextLine());
					System.out.println();
					
					List<Object> tmpElements = null;
					
					switch (orderElements) {
						case 0:
							tmpElements = t.elements(-1);
							break;
						case 1:
							tmpElements = t.elements(0);
							break;
						case 2:
							tmpElements = t.elements(1);
							break;
					}
					
					if(tmpElements != null) {
						int size = tmpElements.size();
						for(int i=0; i<size; i++) {
							System.out.print( String.valueOf(tmpElements.get(i)) + " ");
						}
						System.out.println("\n");
					}
					break;
					
				case "0": //Sair
					ans = null;
					sc.close();
					break;
					
				default:
					ans = "";
					break;
			}
		}
		
	}
	
	public static void menu() {
		System.out.println("------ MENU -------");
		System.out.println("[1] - insert Object"); 	//DONE
		System.out.println("[2] - remove Object"); 	//DONE
		System.out.println("[3] - drawBinaryTree");	//DONE
		System.out.println("[4] - search Object");		//DONE
		System.out.println("[5] - isEmpty"); 			//DONE
		System.out.println("[6] - elements");			//DONE
		
		//System.out.println("[17] - preOrder");			//NOT DISPLAYED (ACCESS BY NOS)
		//System.out.println("[18] - inOrder");				//NOT DISPLAYED (ACCESS BY NOS)
		//System.out.println("[19] - posOrder");			//NOT DISPLAYED (ACCESS BY NOS)
		
		System.out.println("[0] - Sair\n"); 			//DONE
		System.out.print("Escolha a opcao desejada: ");
	}
}
