import br.ifrn.classes.ListaLDE;
import br.ifrn.classes.NoDE;

public class main {
	
	public static void main(String[] args) {
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		ListaLDE lista = new ListaLDE();
		NoDE n = null;
		NoDE q = null;
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
					"[8]  first\n"+
					"[9]  last\n"+
					"[10]  after\n"+
					"[11]  before\n"+
					"[12]  isFirst\n"+
					"[13]  isLast\n"+
					"[14]  size\n"+
					"[15]  isEmpty\n"+
					"[16]  MONTAR LISTA\n"+
					"[17]  INFORMAR OBJETO\n"+
					"[18]  first q\n"+
					"[19]  last q\n"+
					"[20]  after q\n"+
					"[21]  before q\n"+
					"[0]  Sair\n"+
					"Menu: "
					);
			r = sc.nextLine();
			System.out.println();
			
			switch (r){
				case "1":
					if(lista.replaceElement(n, o)) {
						System.out.println("Elemento substituido!\n");
					}
					else {
						System.out.println("Erro no replaceElement\n");
					}
					break;
				case "2":
					if(lista.swapElements(n, q)) {
						System.out.println("Elementos trocados!\n");
					}
					else {
						System.out.println("Erro no swapElements\n");
					}
					break;
				case "3":
					if(lista.insertAfter(n, o)) {
						System.out.println("No n inserido!\n");
					}
					else {
						System.out.println("Erro no insertAfter\n");
					}
					break;
				case "4":
					if(lista.insertBefore(n, o)) {
						System.out.println("No n inserido!\n");
					}
					else {
						System.out.println("Erro no insertBefore\n");
					}
					break;
				case "5":
					lista.insertFirst(o);
					System.out.println("Elemento inserido!\n");
					break;
				case "6":
					lista.insertLast(o);
					System.out.println("Elemento inserido!\n");
					break;
				case "7":
					n = lista.remove(n);
					if(n != null) {
						System.out.println("Elemento " + n.getElement() + " removido");
					}
					else {
						System.out.println("Erro no remove\n");
					}
					break;
				case "8":
					n = lista.first();
					if(n == null) {
						System.out.println("Lista vazia\n");
					}
					break;
				case "9":
					n = lista.last();
					if(n == null) {
						System.out.println("Lista vazia\n");
					}
					break;
				case "10":
					n = lista.after(n);
					if(n == null) {
						System.out.println("n vazio\n");
					}
					break;
				case "11":
					n = lista.before(n);
					if(n == null) {
						System.out.println("n vazio\n");
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
					n = lista.first();
					if(n != null) {
						while(n.getElement() != null) {
							System.out.print(n.getElement()+" ");
							n = n.getNxtNo();
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
					if(n == null) {
						System.out.println("Lista vazia\n");
					}
					break;
				case "19":
					q = lista.last();
					if(n == null) {
						System.out.println("Lista vazia\n");
					}
					break;
				case "20":
					q = lista.after(q);
					if(n == null) {
						System.out.println("n vazio\n");
					}
					break;
				case "21":
					q = lista.before(q);
					if(n == null) {
						System.out.println("n vazio\n");
					}
					break;
				default:
					break;
			}
		}
		
		
	}
	
}
