package br.rn.natal.ifrn.classes;

import br.rn.natal.ifrn.classes.VectorArray;
import br.rn.natal.ifrn.exceptions.VectorArrayException;

public class main {

	public static void main(String[] args) {
		VectorArray meuVetor = new VectorArray();
		String a = "a";
		String b = "b";
		String c = "c";
		String d = "d";
		String e = "e";
		String f = "f";
		String g = "g";
		
		Object el=null;
		
		try {
			el = meuVetor.elemAtRank(0);
		}catch(VectorArrayException exception){
			System.out.println( exception.getMessage() );
			el = null;
		}
		
		if(el != null) {
			System.out.print("Elemento [0]: ");
			System.out.print(el);
			System.out.println(meuVetor.size());
			System.out.println();
		}
		
		// Verificar vector vazio
		//----------------------------------------------------
		System.out.println();
		if(meuVetor.isEmpty()) {
			System.out.println("Vector esta vazio!");
		}
		else {
			System.out.println("Vector nao esta vazio!");
			
			try {
				el = meuVetor.elemAtRank(0);
			}catch(VectorArrayException exception){
				System.out.println( exception.getMessage() );
				System.out.println();
				el = null;
			}
			
			if(el != null) {
				System.out.print("Elemento [0]: ");
				System.out.print(el);
				System.out.println(meuVetor.size());
				System.out.println();
			}
			
		}
		System.out.println();
		//-----------------------------------------------------
		
		try {
			meuVetor.insertAtRank(0, a);
			System.out.println("Elemento Inserido!\n");
		}catch(VectorArrayException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		try {
			meuVetor.insertAtRank(1, b);
			System.out.println("Elemento Inserido!\n");
		}catch(VectorArrayException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		try {
			meuVetor.insertAtRank(2, c);
			System.out.println("Elemento Inserido!\n");
		}catch(VectorArrayException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		
		try {
			meuVetor.insertAtRank(1, d);
			System.out.println("Elemento Inserido!\n");
		}catch(VectorArrayException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		try {
			meuVetor.insertAtRank(1, e);
			System.out.println("Elemento Inserido!\n");
		}catch(VectorArrayException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		try {
			meuVetor.insertAtRank(7, g);
			System.out.println("Elemento Inserido!\n");
		}catch(VectorArrayException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		
		try {
			el = meuVetor.elemAtRank(0);
		}catch(VectorArrayException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		if(el != null) {
			System.out.print("Elemento [0]: ");
			System.out.print(el);
			System.out.println(meuVetor.size());
			System.out.println();
		}
		
		try {
			el = meuVetor.elemAtRank(2);
		}catch(VectorArrayException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		if(el != null) {
			System.out.print("Elemento [2]: ");
			System.out.print(el);
			System.out.println(meuVetor.size());
			System.out.println();
		}
		
		try {
			el = meuVetor.elemAtRank(4);
		}catch(VectorArrayException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		if(el != null) {
			System.out.print("Elemento [4]: ");
			System.out.print(el);
			System.out.println(meuVetor.size());
			System.out.println();
		}
		
		try {
			el = meuVetor.elemAtRank(5);
		}catch(VectorArrayException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		if(el != null) {
			System.out.print("Elemento [5]: ");
			System.out.print(el);
			System.out.println(meuVetor.size());
			System.out.println();
		}
		
		try {
			el = meuVetor.replaceAtRank(1, f);
		}catch(VectorArrayException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		try {
			el = meuVetor.elemAtRank(1);
		}catch(VectorArrayException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		if(el != null) {
			System.out.print("Elemento [1]: ");
			System.out.print(el);
			System.out.println(meuVetor.size());
			System.out.println();
		}
		
		try {
		el = meuVetor.removeAtRank(0);
		}catch(VectorArrayException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.print(" foi removido - Elementos restantes: ");
			System.out.println(meuVetor.size());
			System.out.println();
		}
		
		// Verificar vector vazio
		//----------------------------------------------------
		System.out.println();
		if(meuVetor.isEmpty()) {
			System.out.println("Vector esta vazio!");
		}
		else {
			System.out.println("Vector nao esta vazio!");
			
			try {
				el = meuVetor.elemAtRank(0);
			}catch(VectorArrayException exception){
				System.out.println( exception.getMessage() );
				System.out.println();
				el = null;
			}
			
			if(el != null) {
				System.out.print("Elemento [0]: ");
				System.out.print(el);
				System.out.println(meuVetor.size());
				System.out.println();
			}
			
		}
		System.out.println();
		//-----------------------------------------------------
		
		try {
			el = meuVetor.removeAtRank(1);
		}catch(VectorArrayException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.print(" foi removido - Elementos restantes: ");
			System.out.println(meuVetor.size());
			System.out.println();
		}
		
		try {
			el = meuVetor.removeAtRank(1);
		}catch(VectorArrayException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.print(" foi removido - Elementos restantes: ");
			System.out.println(meuVetor.size());
			System.out.println();
		}
		
		try {
			el = meuVetor.removeAtRank(1);
		}catch(VectorArrayException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.print(" foi removido - Elementos restantes: ");
			System.out.println(meuVetor.size());
			System.out.println();
		}
		
		try {
			el = meuVetor.removeAtRank(1);
		}catch(VectorArrayException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.print(" foi removido - Elementos restantes: ");
			System.out.println(meuVetor.size());
			System.out.println();
		}
		
		try {
			el = meuVetor.removeAtRank(0);
		}catch(VectorArrayException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.print(" foi removido - Elementos restantes: ");
			System.out.println(meuVetor.size());
			System.out.println();
		}
		
		// Verificar vector vazio
		//----------------------------------------------------
		System.out.println();
		if(meuVetor.isEmpty()) {
			System.out.println("Vector esta vazio!");
		}
		else {
			System.out.println("Vector nao esta vazio!");
			
			try {
				el = meuVetor.elemAtRank(0);
			}catch(VectorArrayException exception){
				System.out.println( exception.getMessage() );
				System.out.println();
				el = null;
			}
			
			if(el != null) {
				System.out.print("Elemento [0]: ");
				System.out.print(el);
				System.out.println(meuVetor.size());
				System.out.println();
			}
			
		}
		System.out.println();
		//-----------------------------------------------------

	}

}
