import java.util.Scanner;
import java.util.List;

import classes.Aresta;
import classes.GrafoMA;


public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		GrafoMA gf = new GrafoMA();
		
		String op, a1, a2, v1, v2;
		Aresta tmpAresta;
		List<Object> tmpList;
		List<Aresta> tmpListAresta;
		boolean loop = true;
		
		while(loop) {
			menu();
			op = sc.nextLine();
			System.out.println();
			
			switch(op) {
				case "1":	// ("01 - Inserir Vertice")
					System.out.print("Digite o ID do vertice: ");
					v1 = sc.nextLine();
					gf.inserirVertice(v1);
					break;
				case "2":	// ("02 - Inserir Aresta")
					System.out.print("Digite o ID da aresta: ");
					a1 = sc.nextLine();
					System.out.print("Digite o 1 vertice: ");
					v1 = sc.nextLine();
					System.out.print("Digite o 2 vertice: ");
					v2 = sc.nextLine();
					gf.inserirAresta( v1, v2, a1);
					break;
				case "3":	// ("03 - Inserir Aresta Direcionada")
					System.out.print("Digite o ID da aresta direcionada: ");
					a1 = sc.nextLine();
					System.out.print("Digite o 1 vertice: ");
					v1 = sc.nextLine();
					System.out.print("Digite o 2 vertice: ");
					v2 = sc.nextLine();
					gf.inserirArestaDirecionada( v1, v2, a1);
					break;
				case "4":	// ("04 - Remover Vertice")
					System.out.print("Digite um vertice: ");
					v1 = sc.nextLine();
					gf.removeVertice(v1);
					break;
				case "5":	// ("05 - Remover Aresta")
					System.out.print("Digite uma aresta: ");
					a1 = sc.nextLine();
					tmpAresta = new Aresta(a1);
					gf.removeAresta(tmpAresta);
					break;
					
					
				case "6": 	//("06 - Substituir Vertice")
					System.out.print("Digite um vertice: ");
					v1 = sc.nextLine();
					System.out.print("Digite o novo vertice: ");
					v2 = sc.nextLine();
					
					if( gf.substituir(v1, v2) ) System.out.println("\nVertice substituido!");
					else System.out.println("\nVertice nao encontrado!");
					break;
				case "7": 	//("07 - Substituir Aresta")
					System.out.print("Digite uma aresta: ");
					a1 = sc.nextLine();
					System.out.print("Digite o novo ID da aresta: ");
					a2 = sc.nextLine();
					tmpAresta = new Aresta(a1);
					
					if( gf.substituir(tmpAresta, a2) ) System.out.println("\nAresta substituida!");
					else System.out.println("\nAresta nao encontrada!");
					break;
				case "8": 	//("08 - Vertices")
					tmpList = gf.vertices();
					for( int i=0; i<tmpList.size(); i++) {
						System.out.print(String.valueOf(tmpList.get(i)) + " ");
					}
					System.out.println("\n");
					break;
				case "9": 	//("09 - Vertices Finais")
					System.out.print("Digite uma aresta: ");
					a1 = sc.nextLine();
					tmpAresta = new Aresta(a1);
					tmpList = gf.finalVertices(tmpAresta);
					
					for(int i=0; i<tmpList.size(); i++) {
						System.out.print( String.valueOf(tmpList.get(i)) + ' ' );
					}
					System.out.println();
					break;
				case "10": 	//("10 - Vertice Oposto")
					System.out.print("Digite um vertice: ");
					v1 = sc.nextLine();
					System.out.print("Digite uma aresta: ");
					a1 = sc.nextLine();
					tmpAresta = new Aresta(a1);
					tmpList = gf.oposto(v1, tmpAresta);
					
					if(tmpList != null) {
						for( int i=0; i<tmpList.size(); i++) {
							System.out.print(String.valueOf(tmpList.get(i)) + " ");
						}
						System.out.println();
					}
					else {
						System.out.println("Esse vertice nao possui essa aresta");
					}
					
					break;
				case "11": 	//("11 - Arestas")
					tmpListAresta = gf.arestas();
					for( int i=0; i<tmpListAresta.size(); i++) {
						System.out.print(String.valueOf(tmpListAresta.get(i).getElement()) + " ");
					}
					System.out.println("\n");
					break;
				case "12": 	//("12 - Arestas Incidentes")
					System.out.print("Digite um vertice: ");
					v1 = sc.nextLine();
					
					tmpListAresta = gf.arestasIncidentes(v1);
					for( int i=0; i<tmpListAresta.size(); i++) {
						System.out.print(String.valueOf(tmpListAresta.get(i).getElement()) + " ");
					}
					System.out.println("\n");
					break;
				case "13": 	//("13 - Eh Adjacente")
					System.out.print("Digite o 1 vertice: ");
					v1 = sc.nextLine();
					System.out.print("Digite o 2 vertice: ");
					v2 = sc.nextLine();
					
					if( gf.ehAdjacente(v1, v2) ) {
						System.out.println("\nOs vertices sao adjacentes!\n");
					}
					else {
						System.out.println("\nOs vertices nao sao adjacentes!\n");
					}
					break;
				case "14": 	//("14 - Eh Direcionado")
					System.out.print("Digite uma aresta: ");
					a1 = sc.nextLine();
					tmpAresta = new Aresta(a1);
					if( gf.ehDirecionado(tmpAresta) ) {
						System.out.println("\nA aresta eh direcionada!\n");
					}
					else {
						System.out.println("\nA aresta nao eh direcionada!\n");
					}
					break;
		
					
				case "15":	//("15 - Imprimir Grafo")
					gf.printGrafo();
					break;
					
				case "0":	//("0 - Sair")
					loop = false;
					System.out.println("Bye bye!");
					sc.close();
					break;
			}
			System.out.println();
		}
	}
	
	private static void menu() {
		System.out.println("Escolha uma opcao:");
		System.out.println("-----------------------------");
		System.out.println("01 - Inserir Vertice");
		System.out.println("02 - Inserir Aresta");
		System.out.println("03 - Inserir Aresta Direcionada");
		System.out.println("04 - Remover Vertice");
		System.out.println("05 - Remover Aresta");
		System.out.println("-----------------------------");
		System.out.println("06 - Substituir Vertice");
		System.out.println("07 - Substituir Aresta");
		System.out.println("08 - Vertices");
		System.out.println("09 - Vertices Finais");
		System.out.println("10 - Vertice Oposto");
		System.out.println("11 - Arestas");
		System.out.println("12 - Arestas Incidentes");
		System.out.println("13 - Eh Adjacente");
		System.out.println("14 - Eh Direcionado");
		System.out.println("-----------------------------");
		System.out.println("15 - Imprimir Grafo");
		System.out.println("0 - Sair");
		System.out.print("\nOpcao: ");
	}
}
