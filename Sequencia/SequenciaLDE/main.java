import br.ifrn.classes.SequenceLDE;
import br.ifrn.classes.NoDE;
import br.ifrn.exceptions.SequenceLDEException;

public class main {
	
	public static void main(String[] args) {
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		SequenceLDE seq = new SequenceLDE();
		NoDE n = null;
		NoDE q = null;
		NoDE l = null;
		Object tmp = null;
		String r = "";
		String o = "";
		String rank = "";
		
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
					"-----------------\n\n"+
					"----- Vector ----\n"+
					"[22]  atRank\n"+
					"[23]  elemAtRank\n"+
					"[24]  rankOf\n"+
					"[25]  replaceAtRank\n"+
					"[26]  insertAtRank\n"+
					"[27]  removeAtRank\n"+
					"[0]  Sair\n"+
					"Menu: "
					);
			r = sc.nextLine();
			System.out.println();
			
			switch (r){
				case "1":
					seq.replaceElement(n, o);
					System.out.println("Elemento substituido!\n");
					break;
				case "2":
					seq.swapElements(n, q);
					System.out.println("Elementos trocados!\n");
					break;
				case "3":
					seq.insertAfter(n, o);
					System.out.println("Objeto O inserido depois do No N inserido!\n");
					break;
				case "4":
					seq.insertBefore(n, o);
					System.out.println("Objeto O inserido antes do No N inserido!\n");
					break;
				case "5":
					seq.insertFirst(o);
					System.out.println("Object O inserido no começo da lista!\n");
					break;
				case "6":
					seq.insertLast(o);
					System.out.println("Object O inserido no fim da lista!\n");
					break;
				case "7":
					tmp = seq.remove(n);
					System.out.println("Elemento " + tmp + " removido\n");
					break;
				case "8":
					n = seq.first();
					if(n == seq.last().getNxtNo()) {
						System.out.println("Lista vazia\n");
					}
					else {
						System.out.println("Elemento " + n.getElement() + " selecionado!\n");
					}
					break;
				case "9":
					n = seq.last();
					if(n == seq.first().getPrevNo()) {
						System.out.println("Lista vazia\n");
					}
					else {
						System.out.println("Elemento " + n.getElement() + " selecionado!\n");
					}
					break;
				case "10":
					n = seq.after(n);
					if(n == seq.last().getNxtNo()) {
						System.out.println("N eh Trailer\n");
					}
					break;
				case "11":
					n = seq.before(n);
					if(n == seq.first().getPrevNo()) {
						System.out.println("N eh Header\n");
					}
					break;
				case "12":
					if(seq.isFirst(n)) {
						System.out.println("SIM\n");
					}
					else {
						System.out.println("NAO\n");
					}
					break;
				case "13":
					if(seq.isLast(n)) {
						System.out.println("SIM\n");
					}
					else {
						System.out.println("NAO\n");
					}
					break;
				case "14":
					System.out.println(seq.size());
					System.out.println();
					break;
				case "15":
					if(seq.isEmpty()) {
						System.out.println("SIM\n");
					}
					else {
						System.out.println("NAO\n");
					}
					break;
				case "16":
					l = seq.first();
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
					q = seq.first();
					if(q == seq.last().getNxtNo()) {
						System.out.println("Lista vazia\n");
					}
					else {
						System.out.println("Elemento " + q.getElement() + " selecionado!\n");
					}
					break;
				case "19":
					q = seq.last();
					if(q == seq.first().getPrevNo()) {
						System.out.println("Lista vazia\n");
					}
					else {
						System.out.println("Elemento " + q.getElement() + " selecionado!\n");
					}
					break;
				case "20":
					q = seq.after(q);
					if(q == seq.last().getNxtNo()) {
						System.out.println("Q eh Trailer\n");
					}
					break;
				case "21":
					q = seq.before(q);
					if(q == seq.first().getPrevNo()) {
						System.out.println("Q eh Header\n");
					}
					break;
				case "22":
					System.out.print("Digite uma posicao: ");
					rank = sc.nextLine();
					try {
						n = seq.atRank(Integer.parseInt(rank));
						System.out.println("Elemento " + n.getElement() + " selecionado\n");
					}catch(SequenceLDEException e){
						System.out.println(e.getMessage());
					}
					
					break;
				case "23":
					System.out.print("Digite uma posicao: ");
					rank = sc.nextLine();
					try {
						tmp = seq.elemAtRank(Integer.parseInt(rank));
						System.out.println("Elemento " + tmp + " selecionado\n");
					}catch(SequenceLDEException e){
						System.out.println(e.getMessage());
					}
					
					break;
				case "24":
					rank = String.valueOf( seq.rankOf(n));
					System.out.println("Posicao " + rank + "\n");
					break;
				case "25":
					System.out.print("Digite uma posicao: ");
					rank = sc.nextLine();
					try {
						seq.replaceAtRank( Integer.parseInt(rank), o);
						System.out.println("Elemento " + o + " substituiu o elemento da posicao "+rank+"\n");
					}catch(SequenceLDEException e){
						System.out.println(e.getMessage());
					}
					break;
				case "26":
					System.out.print("Digite uma posicao: ");
					rank = sc.nextLine();
					try {
						seq.insertAtRank( Integer.parseInt(rank), o);
						System.out.println("Elemento inserido na posicao " + rank + "\n");
					}catch(SequenceLDEException e){
						System.out.println(e.getMessage());
					}
					break;
				case "27":
					System.out.print("Digite uma posicao: ");
					rank = sc.nextLine();
					try {
						seq.removeAtRank( Integer.parseInt(rank));
						System.out.println("Elemento da posicao " + rank + " removido\n");
					}catch(SequenceLDEException e){
						System.out.println(e.getMessage());
					}
					break;
				default:
					break;
			}
		}
		
		
	}
	
}