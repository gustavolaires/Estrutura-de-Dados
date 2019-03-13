package br.rn.natal.ifrn.classes;

import br.rn.natal.ifrn.classes.PilhaLL;
import br.rn.natal.ifrn.exceptions.PilhaVaziaException;

public class main {

	public static void main(String[] args) {
		PilhaLL minhaPilha = new PilhaLL();
		String a = "a";
		String b = "b";
		String c = "c";
		
		Object el=null;
		
		try {
			el = minhaPilha.pop();
		}catch(PilhaVaziaException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.print(" foi removido - Elementos restantes: ");
			System.out.println(minhaPilha.size());
			System.out.println();
		}
		
		minhaPilha.push(a);
		minhaPilha.push(b);
		minhaPilha.push(c);
		
		try {
			el = minhaPilha.pop();
		}catch(PilhaVaziaException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.print(" foi removido - Elementos restantes: ");
			System.out.println(minhaPilha.size());
			System.out.println();
		}
		
		try {
		el = minhaPilha.pop();
		}catch(PilhaVaziaException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.print(" foi removido - Elementos restantes: ");
			System.out.println(minhaPilha.size());
			System.out.println();
		}
		
		minhaPilha.push(c);
		
		// Verificar pilha vazia
		//----------------------------------------------------
		System.out.println();
		if(minhaPilha.isEmpty()) {
			System.out.println("Pilha esta vazia!");
		}
		else {
			System.out.println("Pilha nao esta vazia!");
			System.out.println(minhaPilha.top());
		}
		System.out.println();
		//-----------------------------------------------------
		
		try {
			el = minhaPilha.pop();
		}catch(PilhaVaziaException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.print(" foi removido - Elementos restantes: ");
			System.out.println(minhaPilha.size());
			System.out.println();
		}
		
		try {
			el = minhaPilha.pop();
		}catch(PilhaVaziaException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.print(" foi removido - Elementos restantes: ");
			System.out.println(minhaPilha.size());
			System.out.println();
		}
		
		// Verificar pilha vazia
		//----------------------------------------------------
		System.out.println();
		if(minhaPilha.isEmpty()) {
			System.out.println("Pilha esta vazia!");
		}
		else {
			System.out.println("Pilha nao esta vazia!");
			System.out.println(minhaPilha.top());
		}
		System.out.println();
		//----------------------------------------------------

	}

}
