import br.ifrn.classes.ListaLDE;
import br.ifrn.classes.NoDE;

public class main {
	
	public static void main(String[] args) {
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		ListaLDE lista = new ListaLDE();
		NoDE n = null;
		NoDE q = null;
		NoDE l = null;
		Object tmp = null;
		String r = "";
		String o = "";
		
		while(r.compareTo("0") != 0) {
			System.out.print(
					"[1]  replaceElement\n"+
					"[2]  swapElements\n"+
					"[3]  insertAfter\n"+
					"[4]  insertBefore\n"+
					"[5]  insertFirst\n"+
					"[6]  insertLast\n"+
					"[7]  remove\n"+
					"------- N -------\n"+
					"[8]  first\n"+
					"[9]  last\n"+
					"[10]  after\n"+
					"[11]  before\n"+
					"-----------------\n"+
					"[12]  isFirst\n"+
					"[13]  isLast\n"+
					"[14]  size\n"+
					"[15]  isEmpty\n"+
					"[16]  MONTAR LISTA\n"+
					"[17]  INFORMAR OBJETO\n"+
					"------- Q -------\n"+
					"[18]  first\n"+
					"[19]  last\n"+
					"[20]  after\n"+
					"[21]  before\n"+
					"-----------------\n"+
					"[0]  Sair\n"+
					"Menu: "
					);
			r = sc.nextLine();
			System.out.println();
			
			switch (r){
				case "1":
					lista.replaceElement(n, o);
					System.out.println("Elemento substituido!\n");
					break;
				case "2":
					lista.swapElements(n, q);
					System.out.println("Elementos trocados!\n");
					break;
				case "3":
					lista.insertAfter(n, o);
					System.out.println("Objeto O inserido depois do No N inserido!\n");
					break;
				case "4":
					lista.insertBefore(n, o);
					System.out.println("Objeto O inserido antes do No N inserido!\n");
					break;
				case "5":
					lista.insertFirst(o);
					System.out.println("Object O inserido no começo da lista!\n");
					break;
				case "6":
					lista.insertLast(o);
					System.out.println("Object O inserido no fim da lista!\n");
					break;
				case "7":
					tmp = lista.remove(n);
					System.out.println("Elemento " + tmp + " removido\n");
					break;
				case "8":
					n = lista.first();
					if(n == lista.last().getNxtNo()) {
						System.out.println("Lista vazia\n");
					}
					else {
						System.out.println("Elemento " + n.getElement() + " selecionado!\n");
					}
					break;
				case "9":
					n = lista.last();
					if(n == lista.first().getPrevNo()) {
						System.out.println("Lista vazia\n");
					}
					else {
						System.out.println("Elemento " + n.getElement() + " selecionado!\n");
					}
					break;
				case "10":
					n = lista.after(n);
					if(n == lista.last().getNxtNo()) {
						System.out.println("N eh Trailer\n");
					}
					break;
				case "11":
					n = lista.before(n);
					if(n == lista.first().getPrevNo()) {
						System.out.println("N eh Header\n");
					}
					break;
				case "12":
					if(lista.isFirst(n)) {
						System.out.println("SIM\n");
					}
					else {
						System.out.println("NAO\n");
					}
					break;
				case "13":
					if(lista.isLast(n)) {
						System.out.println("SIM\n");
					}
					else {
						System.out.println("NAO\n");
					}
					break;
				case "14":
					System.out.println(lista.size());
					System.out.println();
					break;
				case "15":
					if(lista.isEmpty()) {
						System.out.println("SIM\n");
					}
					else {
						System.out.println("NAO\n");
					}
					break;
				case "16":
					l = lista.first();
					if(l != null) {
						while(l.getElement() != null) {
							System.out.print(l.getElement()+" ");
							l = l.getNxtNo();
						}
						System.out.println("\n");
					}
					break;
				case "17":
					System.out.print("o: ");
					o = sc.nextLine();
					System.out.println();
					break;
				case "18":
					q = lista.first();
					if(q == lista.last().getNxtNo()) {
						System.out.println("Lista vazia\n");
					}
					else {
						System.out.println("Elemento " + q.getElement() + " selecionado!\n");
					}
					break;
				case "19":
					q = lista.last();
					if(q == lista.first().getPrevNo()) {
						System.out.println("Lista vazia\n");
					}
					else {
						System.out.println("Elemento " + q.getElement() + " selecionado!\n");
					}
					break;
				case "20":
					q = lista.after(q);
					if(q == lista.last().getNxtNo()) {
						System.out.println("Q eh Trailer\n");
					}
					break;
				case "21":
					q = lista.before(q);
					if(q == lista.first().getPrevNo()) {
						System.out.println("Q eh Header\n");
					}
					break;
				default:
					break;
			}
		}
		
		
	}
	
}
