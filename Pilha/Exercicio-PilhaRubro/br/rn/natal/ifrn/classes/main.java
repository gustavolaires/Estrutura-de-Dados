package br.rn.natal.ifrn.classes;

import java.util.Scanner;

import br.rn.natal.ifrn.classes.PilhaRubro;
import br.rn.natal.ifrn.exceptions.PilhaVaziaException;

public class main {

	public static void main(String[] args) {
		PilhaRubro pilha = new PilhaRubro();
		Scanner sc = new Scanner(System.in);
		String entrada;
		Boolean lp = true;
		
		while(lp) {
			System.out.println("1 - PUSH_PRETA");
			System.out.println("2 - POP_PRETA");
			System.out.println("3 - TOP_PRETA");
			System.out.println("4 - SIZE_PRETA");
			System.out.println("5 - IS_EMPTY_PRETA\n");
			System.out.println("6 - PUSH_VERMELHA");
			System.out.println("7 - POP_VERMELHA");
			System.out.println("8 - TOP_VERMELHA");
			System.out.println("9 - SIZE_VERMELHA");
			System.out.println("10 - IS_EMPTY_VERMELHA\n");
			System.out.println("0 - SAIR\n");
			System.out.print("ESCOLHA UMA OPCAO: ");
			
			entrada = sc.nextLine();
			System.out.println();
			
			switch(entrada) {
				case "1": //PUSH_PRETA
					System.out.print("Digite um valor qualquer: ");
					entrada = sc.nextLine();
					pilha.pushPreta(entrada);
					System.out.println("\nO valor foi adicionado a pilha preta!\n");
					break;
					
				case "2": //POP_PRETA
					try {
						entrada = pilha.popPreta().toString();
						System.out.println("O valor '" + entrada + "' foi removido a pilha preta!\n");
					}catch(PilhaVaziaException exception){
						System.out.println(exception.getMessage());
					}
					break;
					
				case "3": //TOP_PRETA
					try {
						entrada = pilha.topPreta().toString();
						System.out.println("O valor '" + entrada + "' eh o topo da pilha preta!\n");
					}catch(PilhaVaziaException exception){
						System.out.println(exception.getMessage());
					}
					break;
					
				case "4": //SIZE_PRETA
					entrada = String.valueOf(pilha.sizePreta());
					System.out.println(entrada + "\n");
					break;
					
				case "5": //IS_EMPTY_PRETA
					if(pilha.isEmptyPreta()) {
						System.out.println("Verdadeiro\n");
					}
					else {
						System.out.println("False\n");
					}
					break;
					
				case "6": //PUSH_VERMELHA
					System.out.print("Digite um valor qualquer: ");
					entrada = sc.nextLine();
					pilha.pushVermelha(entrada);
					System.out.println("\nO valor foi adicionado a pilha vermelha!\n");
					break;
					
				case "7": //POP_VERMELHA
					try {
						entrada = pilha.popVermelha().toString();
						System.out.println("O valor '" + entrada + "' foi removido a pilha vermelha!\n");
					}catch(PilhaVaziaException exception){
						System.out.println(exception.getMessage());
					}
					break;
					
				case "8": //TOP_VERMELHA
					try {
						entrada = pilha.topVermelha().toString();
						System.out.println("O valor '" + entrada + "' eh o topo da pilha vermelha!\n");
					}catch(PilhaVaziaException exception){
						System.out.println(exception.getMessage());
					}
					break;
					
				case "9": //SIZE_VERMELHA
					entrada = String.valueOf(pilha.sizeVermelha());
					System.out.println(entrada + "\n");
					break;
					
				case "10": //IS_EMPTY_VERMELHA
					if(pilha.isEmptyVermelha()) {
						System.out.println("Verdadeiro\n");
					}
					else {
						System.out.println("False\n");
					}
					break;
					
				case "0": //SAIR
					lp = false;
					break;	
			}
		}
		
		sc.close();
	}
	
}