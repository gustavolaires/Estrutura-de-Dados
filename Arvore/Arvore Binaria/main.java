import java.util.List;
import java.util.Scanner;
import classes.ArvoreBinaria;
import classes.No;

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArvoreBinaria t = new ArvoreBinaria();
		String ans = "";
		int obj = 0;
		
		No n = null;
		No n2 = null;
		
		while(ans != null) {
			menu();
			ans = sc.nextLine();
			System.out.println();
			switch (ans) {
				case "1": //Size
					System.out.println("Size: " + String.valueOf( t.size()) + "\n");
					break;
					
				case "2": //Height
					if(n != null) {
						System.out.println("Height: " + String.valueOf( t.height(n)) + "\n");
					}
					else {
						System.out.println("No vazio! primeiro escolha um no da arvore\n");
					}
					break;
					
				case "3": //Depth
					if(n != null) {
						System.out.println("Depth: " + String.valueOf( t.depth(n)) + "\n");
					}
					else {
						System.out.println("No vazio! primeiro escolha um no da arvore\n");
					}
					break;
					
				case "4": //isEmpty
					if(t.isEmpty()) {
						System.out.println("A arvore esta vazia!\n");
					}
					else {
						System.out.println("A arvore nao esta vazia!\n");
					}
					break;
					
				case "5": //elements
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
					
				case "6": //nos
					System.out.println("Escolha ordem de acesso aos nos:");
					System.out.println("[0] preOrder");
					System.out.println("[1] inOrder");
					System.out.println("[2] posOrder");
					System.out.print("Ordem de acesso: ");
					int orderNo = Integer.parseInt(sc.nextLine());
					System.out.println();
					
					List<No> tmpNo = null;
					
					switch (orderNo) {
						case 0:
							tmpNo = t.nos(-1);
							break;
						case 1:
							tmpNo = t.nos(0);
							break;
						case 2:
							tmpNo = t.nos(1);
							break;
					}
					
					if(tmpNo != null) {
						int size = tmpNo.size();
						for(int i=0; i<size; i++) {
							System.out.print( String.valueOf(tmpNo.get(i).getElemento()) + " ");
						}
						System.out.println("\n");
					}
					
					break;
				
				case "7": //root
					n = t.root();
					if(n != null) {
						System.out.println("Raiz recuperada: " + String.valueOf( n.getElemento()));
					}
					else {
						System.out.println("A raiz eh nula!\n");
					}
					
					break;
					
				case "8": //parent
					if( n != null) {
						if( t.parent(n) == null) {
							System.out.println("O pai de N eh vazio!\n");
						}
						else {
							System.out.println("O pai de N eh: " + String.valueOf(t.parent(n).getElemento()) + "\n");
						}
					}
					else {
						System.out.println("No vazio! primeiro escolha um no da arvore\n");
					}
					
					break;
					
				case "10": //leftChild
					if(n != null) {
						if(t.hasLeftChild(n)) {
							System.out.println("O valor do filho esquerdo: " + String.valueOf(t.leftChild(n).getElemento()) + "\n");
						}
						else {
							System.out.println("O no nao possui filho esquerdo!\n");
						}
					}
					else {
						System.out.println("No vazio! primeiro escolha um no da arvore\n");
					}
					break;
					
				case "11": //rightChild
					if(n != null) {
						if(t.hasRightChild(n)) {
							System.out.println("O valor do filho direito: " + String.valueOf(t.rightChild(n).getElemento()) + "\n");
						}
						else {
							System.out.println("O no nao possui filho direito!\n");
						}
					}
					else {
						System.out.println("No vazio! primeiro escolha um no da arvore\n");
					}
					break;
					
				case "12": //hasRightChild
					if(t.hasLeftChild(n)) {
						System.out.println("O no possui filho esquerdo!\n");
					}
					else {
						System.out.println("O no nao possui filho esquerdo!\n");
					}
					break;
					
				case "13": //hasLeftChild
					if(t.hasRightChild(n)) {
						System.out.println("O no possui filho direito!\n");
					}
					else {
						System.out.println("O no nao possui filho direito!\n");
					}
					break;
				
				case "14": //isInternal
					if(t.isInternal(n)) {
						System.out.println("O no N eh interno!\n");
					}
					else {
						System.out.println("O no N nao eh interno!\n");
					}
					break;
					
				case "15": //isExternal
					if(t.isExternal(n)) {
						System.out.println("O no N eh externo!\n");
					}
					else {
						System.out.println("O no N nao eh externo!\n");
					}
					break;
					
				case "16": //isRoot
					if(t.isRoot(n)) {
						System.out.println("O no N eh raiz!\n");
					}
					else {
						System.out.println("O no N nao eh raiz!\n");
					}
					break;
					
				case "20": //drawBinaryTree
					System.out.println();
					t.drawBinaryTree();
					System.out.println();
					break;
				
				case "21": //replace
					System.out.print("Informe um número: ");
					obj = Integer.parseInt( sc.nextLine());
					t.replace(n, obj);
					System.out.println("O no N teve o elemento substituido por " + String.valueOf(obj) + "\n");
					break;
				
				case "22": //swapElements
					t.swapElements(n, n2);
					System.out.println("Nos N e N2 trocados");
					break;
				
				case "23": //insert Object
					System.out.print("Informe um número: ");
					obj = Integer.parseInt( sc.nextLine());
					if( t.insert( obj)) {
						System.out.println("Valor "+ String.valueOf(obj) + " inserido!\n");
					}
					else {
						System.out.println("Valor "+ String.valueOf(obj) + " ja existe!\n");
					}
					
					break;
					
				case "24": //insert No
					if(n != null) {
						if( t.insert( obj)) {
							System.out.println("Valor "+ String.valueOf(obj) + " inserido!\n");
						}
						else {
							System.out.println("Valor "+ String.valueOf(obj) + " ja existe!\n");
						}
					}
					else {
						System.out.println("No vazio! primeiro escolha um no da arvore\n");
					}
					break;
					
				case "25": //remove
					if(n != null) {
						n = t.remove(n);
						System.out.println("Valor "+ String.valueOf( n.getElemento()) + " removido!\n");
					}
					else {
						System.out.println("No vazio! primeiro escolha um no da arvore\n");
					}
					break;
					
				case "26": //search N1
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
					
				case "27": //search N2
					System.out.print("Informe um número: ");
					obj = Integer.parseInt( sc.nextLine());
					n2 = t.search(obj);
					if( n2 != null) {
						System.out.println("No2 "+ String.valueOf( n2.getElemento()) + " encontrado!\n");
					}
					else {
						System.out.println("Valor "+ String.valueOf(obj) + " nao encontrado!\n");
					}
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
		System.out.println("[1] - Size"); 				//DONE
		System.out.println("[2] - Height"); 			//DONE
		System.out.println("[3] - Depth"); 				//DONE
		System.out.println("[4] - isEmpty"); 			//DONE
		System.out.println("[5] - elements");			//DONE
		System.out.println("[6] - nos");				//DONE
		System.out.println("[7] - root"); 				//DONE
		System.out.println("[8] - parent");				//DONE
		System.out.println("[9] - children");
		System.out.println("[10] - leftChild");			//DONE
		System.out.println("[11] - rightChild");		//DONE
		System.out.println("[12] - hasRightChild");		//DONE
		System.out.println("[13] - hasLeftChild");		//DONE
		System.out.println("[14] - isInternal");		//DONE
		System.out.println("[15] - isExternal");		//DONE
		System.out.println("[16] - isRoot"); 			//DONE
		//System.out.println("[17] - preOrder");			//NOT DISPLAYED (ACCESS BY NOS)
		//System.out.println("[18] - inOrder");				//NOT DISPLAYED (ACCESS BY NOS)
		//System.out.println("[19] - posOrder");			//NOT DISPLAYED (ACCESS BY NOS)
		System.out.println("[20] - drawBinaryTree");	//DONE
		System.out.println("[21] - replace");			//DONEs
		System.out.println("[22] - swapElements");		//DONE
		System.out.println("[23] - insert Object"); 	//DONE
		System.out.println("[24] - insert No"); 		//DONE
		System.out.println("[25] - remove"); 			//DONE
		System.out.println("[26] - search N1"); 		//DONE
		System.out.println("[27] - search N2"); 		//DONE
		System.out.println("[0] - Sair\n"); 			//DONE
		System.out.print("Escolha a opcao desejada: ");
	}
}
