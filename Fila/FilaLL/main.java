import br.ifrn.classes.FilaLL;

import br.ifrn.exceptions.FilaVaziaException;

public class main {
	
	public static void main(String[] args) {
		
		FilaLL minhaFila = new FilaLL();
		String a = "a";
		String b = "b";
		String c = "c";
		String d = "d";
		String e = "e";
		Object el=null;
		
		try {
			el = minhaFila.desenfileirar();
		}catch(FilaVaziaException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.print(" foi removido - Elementos restantes: ");
			System.out.println(minhaFila.tamanho());
			System.out.println();
		}
		
		minhaFila.enfileirar(a);
		
		try {
			el = minhaFila.desenfileirar();
		}catch(FilaVaziaException exception){
			System.out.println();
			System.out.println( exception.getMessage() );
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.print(" foi removido - Elementos restantes: ");
			System.out.println(minhaFila.tamanho());
			System.out.println();
		}
		
		try {
			el = minhaFila.desenfileirar();
		}catch(FilaVaziaException exception){
			System.out.println( exception.getMessage() );
			System.out.println();
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.print(" foi removido - Elementos restantes: ");
			System.out.println(minhaFila.tamanho());
			System.out.println();
		}
		
		minhaFila.enfileirar(a);
		minhaFila.enfileirar(b);
		minhaFila.enfileirar(c);
		minhaFila.enfileirar(d);
		minhaFila.enfileirar(e);
		
		try {
			el = minhaFila.desenfileirar();
		}catch(FilaVaziaException exception){
			System.out.println();
			System.out.println( exception.getMessage() );
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.print(" foi removido - Elementos restantes: ");
			System.out.println(minhaFila.tamanho());
			System.out.println();
		}
		
		try {
			el = minhaFila.desenfileirar();
		}catch(FilaVaziaException exception){
			System.out.println();
			System.out.println( exception.getMessage() );
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.print(" foi removido - Elementos restantes: ");
			System.out.println(minhaFila.tamanho());
			System.out.println();
		}
		
		// Verificar pilha vazia
		//----------------------------------------------------
		System.out.println();
		try {
			el = minhaFila.inicio();
			System.out.println("Fila nao esta vazia!");
			System.out.println(el);
		}catch(FilaVaziaException exception){
			System.out.println("Fila esta vazia!");
		}
		System.out.println();
		//-----------------------------------------------------
		
		try {
			el = minhaFila.desenfileirar();
		}catch(FilaVaziaException exception){
			System.out.println();
			System.out.println( exception.getMessage() );
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.print(" foi removido - Elementos restantes: ");
			System.out.println(minhaFila.tamanho());
			System.out.println();
		}
		
		try {
			el = minhaFila.desenfileirar();
		}catch(FilaVaziaException exception){
			System.out.println();
			System.out.println( exception.getMessage() );
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.print(" foi removido - Elementos restantes: ");
			System.out.println(minhaFila.tamanho());
			System.out.println();
		}
		
		try {
			el = minhaFila.desenfileirar();
		}catch(FilaVaziaException exception){
			System.out.println();
			System.out.println( exception.getMessage() );
			el = null;
		}
		
		if(el != null) {
			System.out.print(el);
			System.out.print(" foi removido - Elementos restantes: ");
			System.out.println(minhaFila.tamanho());
			System.out.println();
		}
		
		// Verificar pilha vazia
		//----------------------------------------------------
		System.out.println();
		try {
			el = minhaFila.inicio();
			System.out.println("Fila nao esta vazia!");
			System.out.println(el);
		}catch(FilaVaziaException exception){
			System.out.println("Fila esta vazia!");
		}
		System.out.println();
		//----------------------------------------------------
	}
}
