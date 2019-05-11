import classes.*;
import exceptions.NoSuchKeyException;

import java.util.List;
import java.util.Scanner;


public class main {
	public static void main(String[] args) {
		
		HashMap hm = null;
		HashMapLSE hmlse = null;
		
		Scanner sc = new Scanner(System.in);
		String ans;
		
		int op = 0;
		
		boolean lpmain = true;
		boolean lp1 = true;
		boolean lp2 = true;
		
		//main loop menus
		while(lpmain) {
			
			//loop menu 1 - modo de operacao
			while(lp1) {
				menu1();
				ans = sc.nextLine();
				System.out.println();
				
				switch (ans) {
					case "1":
						// Linear probing
						hm = new HashMap();
						hmlse = null;
						op = 1;
						
						hm.setOp(0);
						lp1 = false;
						lp2 = true;
						break;
					case "2":
						// Hash Duplo
						hm = new HashMap();
						hmlse = null;
						op = 2;
						
						hm.setOp(1);
						lp1 = false;
						lp2 = true;
						break;
					case "3":
						// Encadeamento
						hm = null;
						hmlse = new HashMapLSE();
						op = 3;
						
						lp1 = false;
						lp2 = true;
						break;
					case "0":
						System.out.println("Bye bye!");
						lp1 = false;
						lp2 = false;
						lpmain = false;
						break;
					default:
						System.out.println("Opcao invalida! Por favor escolha uma opcao valida.\n");
						break;
				}
			}
			
			while(lp2) {
				menu2();
				ans = sc.nextLine();
				System.out.println();
				
				switch (ans) {
					case "1":
						// Inserir
						System.out.print("Digite um numero inteiro: ");
						int nInsert = Integer.parseInt( sc.nextLine());
						System.out.println();
						
						if(op == 3) {
							hmlse.insertItem(nInsert, nInsert);
						}
						else {
							hm.insertItem(nInsert, nInsert);
						}
						
						System.out.println("O valor " + nInsert + " foi inserido!\n");
						break;
					case "2":
						// Buscar
						No srch = null;
						System.out.print("Digite um numero inteiro que deseja buscar: ");
						int nBusca = Integer.parseInt( sc.nextLine());
						System.out.println();
						
						if(op == 3) {
							try {
								srch = hmlse.findElement(nBusca);
								System.out.println( "Chave " + srch.getKey() + " localizada!\n");
							}catch(NoSuchKeyException e){
								System.out.println(e.getMessage() + "\n");
							}
						}
						else {
							try {
								srch = hm.findElement(nBusca);
								System.out.println( "Chave " + srch.getKey() + " localizada!\n");
							}catch(NoSuchKeyException e){
								System.out.println(e.getMessage() + "\n");
							}
						}
						break;
					case "3":
						// Remover
						No rmv = null;
						System.out.print("Digite um numero inteiro que deseja remover: ");
						int nRemover = Integer.parseInt( sc.nextLine());
						System.out.println();
						
						if(op == 3) {
							try {
								rmv = hmlse.removeElement(nRemover);
								System.out.println( "Chave " + rmv.getKey() + " removida!\n");
							}catch(NoSuchKeyException e){
								System.out.println(e.getMessage() + "\n");
							}
						}
						else {
							try {
								rmv = hm.removeElement(nRemover);
								System.out.println( "Chave " + rmv.getKey() + " removida!\n");
							}catch(NoSuchKeyException e){
								System.out.println(e.getMessage() + "\n");
							}							
						}
						break;
					case "4":
						// Numero de elementos
						if(op == 3) {
							System.out.println("O Hash Map possui " + hmlse.size() + " elementos.\n");
						}
						else {
							System.out.println("O Hash Map possui " + hm.size() + " elementos.\n");
						}
						break;
					case "5":
						// Esta vazio?
						if(op == 3) {
							if(hmlse.isEmpty()) {
								System.out.println("O Hash Map esta vazio!\n");
							}
							else {
								System.out.println("O Hash Map nao esta vazio!\n");
							}
						}
						else {
							if(hm.isEmpty()) {
								System.out.println("O Hash Map esta vazio!\n");
							}
							else {
								System.out.println("O Hash Map nao esta vazio!\n");
							}
						}
						break;
					case "6":
						// Chaves (keys)
						List<Integer> keys = null;
						if(op == 3) {
							keys = hmlse.keys();
						}
						else {
							keys = hm.keys();
						}
						
						for(int i=0; i<keys.size(); i++) {
							System.out.print(keys.get(i)+" ");
						}
						System.out.println("\n");
						break;
					case "7":
						// Elementos
						List<Object> elements = null;
						if(op == 3) {
							elements = hmlse.elements();
						}
						else {
							elements = hm.elements();
						}
						
						for(int i=0; i<elements.size(); i++) {
							System.out.print(elements.get(i)+" ");
						}
						System.out.println("\n");
						break;
					case "8":
						No nos[] = null;
						if(op == 3) {
							nos = hmlse.getVetor();
							No tmp = null;
							
							for(int s=0; s<nos.length; s++) {
								if(nos[s] == null) {
									System.out.println(s + " - " + "NULL");
								}
								else {
									tmp = nos[s];
									System.out.print(s);
									while(tmp != null) {
										System.out.print(" - " + tmp.getKey());
										tmp = tmp.getNxt();
									}
									System.out.println();
								}
							}
						}
						else {
							nos = hm.getVetor();
							
							for(int s=0; s<nos.length; s++) {
								if(nos[s] == null) {
									System.out.println(s + " - " + "NULL");
								}
								else if(nos[s].isAvailable()) {
									System.out.println(s + " - " + "Disponivel");
								}
								else {
									System.out.println(s + " - " + nos[s].getKey());
								}
							}
						}
						System.out.println();
						break;
					case "0":
						lp2 = false;
						lp1 = true;
						break;
					default:
						System.out.println("Opcao invalida! Por favor escolha uma opcao valida.\n");
						break;
				}
			}
		}
		
		/*
		
		No nos[] = hm.getVetor();
		
		for(int s=0; s<nos.length; s++) {
			if(nos[s] == null) {
				System.out.print("NULL ");
			}
			else if(nos[s].isAvailable()) {
				System.out.print("Avail ");
			}
			else {
				System.out.print(nos[s].getKey() + " ");
			}
		}
		
		
		nos = hm.getVetor();
		
		for(int s=0; s<nos.length; s++) {
			if(nos[s] == null) {
				System.out.print("NULL ");
			}
			else if(nos[s].isAvailable()) {
				System.out.print("Avail ");
			}
			else {
				System.out.print(nos[s].getKey() + " ");
			}
		}
		*/
	}
	
	public static void menu1() {
		System.out.print(
				"---- Defina o modo de operacao ----\n" +
				"[1] - Linear Probing\n" +
				"[2] - Hash Duplo\n" +
				"[3] - Encademaneto\n" +
				"\n[0] - Sair\n" +
				"Modo de operacao: "
				);
	}
	
	public static void menu2() {
		System.out.print(
				"---- Escolha uma operacao ----\n" +
				"[1] - Inserir\n" +
				"[2] - Buscar\n" +
				"[3] - Remover\n" +
				"[4] - Numero de elementos\n" +
				"[5] - Esta vazio?\n" +
				"[6] - Chaves (keys)\n"+
				"[7] - Elementos\n" +
				"[8] - Imprimir HashMap" +
				"\n[0] - Voltar\n" +
				"Operacao: "
				);
	}
}
