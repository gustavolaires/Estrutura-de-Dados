import java.util.List;
import java.util.Scanner;
import classes.HeapArray;


public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HeapArray t = new HeapArray();
		String ans = "";
		int obj = 0;
		
		Object n=null, n2=null;
		
		while(ans != null) {
			menu();
			ans = sc.nextLine();
			System.out.println();
			switch (ans) {
				case "1": //insert No
					System.out.print("Digite um numero: ");
					n = Integer.parseInt( sc.nextLine());
					
					if( t.insert( n)) {
						System.out.println("Valor "+ String.valueOf( n) + " inserido!\n");
					}
				
					break;
				
				case "2": //remove
					if(t.removeMin()) {
						System.out.println("Elemento removido!\n");
					}
					else {
						System.out.println("Heap vazio!\n");
					}
					break;
				
				case "3": //drawBinaryTree
					System.out.println();
					t.drawHeap();
					System.out.println();
					break;
			
				case "4": //Size
					System.out.println("Size: " + String.valueOf( t.size()) + "\n");
					break;
					
				case "5": //isEmpty
					if(t.isEmpty()) {
						System.out.println("A Heap esta vazia!\n");
					}
					else {
						System.out.println("A Heap nao esta vazia!\n");
					}
					break;
					
				case "6": //swapElements
					//t.swapElements(n, n2);
					System.out.println("Nos N e N2 trocados");
					break;
				
				case "0": //Sair
					ans = null;
					break;
					
				default:
					ans = "";
					break;
			}
		}
		
	}
	
	public static void menu() {
		System.out.println("------ MENU -------");
		System.out.println("[1] - insert Object"); 		//DONE
		System.out.println("[2] - removeMin"); 			//DONE
		System.out.println("[3] - drawHeap");			//DONE
		System.out.println("[4] - Size"); 				//DONE
		System.out.println("[5] - isEmpty"); 			//DONE
		System.out.println("[6] - swapElements");		//DONE
		System.out.println("[0] - Sair\n"); 			//DONE
		System.out.print("Escolha a opcao desejada: ");
	}
}
