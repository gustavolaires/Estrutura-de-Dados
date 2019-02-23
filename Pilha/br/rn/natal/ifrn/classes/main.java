package br.rn.natal.ifrn.classes;

import br.rn.natal.ifrn.exceptions.PilhaCheiaException;
import br.rn.natal.ifrn.exceptions.PilhaVaziaException;

public class main {

	public static void main(String[] args) {
		pilha minhaPilha = new pilha();
		String a = "a";
		String b = "b";
		String c = "c";
		String d = "d";
		String e = "e";
		
		minhaPilha.push(a);
		
		try {
			minhaPilha.push_no_resizable(b);
		}catch(PilhaCheiaException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
		}
		
		minhaPilha.push(b);
		minhaPilha.push(c);
		
		try {
			minhaPilha.push_no_resizable(d);
		}catch(PilhaCheiaException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
		}
		
		try {
			minhaPilha.push_no_resizable(e);
		}catch(PilhaCheiaException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
		}
		
		Object el=null;
		
		try {
			el = minhaPilha.pop();
		}catch(PilhaVaziaException exception){
			System.out.println();
			System.out.println( exception.getMessage() );
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.println(minhaPilha.size());
		}
		
		try {
		el = minhaPilha.pop();
		}catch(PilhaVaziaException exception){
			System.out.println();
			System.out.println( exception.getMessage() );
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.println(minhaPilha.size());
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
		//-----------------------------------------------------
		
		try {
			el = minhaPilha.pop();
		}catch(PilhaVaziaException exception){
			System.out.println();
			System.out.println( exception.getMessage() );
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.println(minhaPilha.size());
		}
		
		try {
			el = minhaPilha.pop();
		}catch(PilhaVaziaException exception){
			System.out.println();
			System.out.println( exception.getMessage() );
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.println(minhaPilha.size());
		}
		
		try {
			el = minhaPilha.pop();
		}catch(PilhaVaziaException exception){
			System.out.println();
			System.out.println( exception.getMessage() );
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.println(minhaPilha.size());
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
