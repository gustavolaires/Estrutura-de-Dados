import classes.*;
import exceptions.NoSuchKeyException;


public class main {
	public static void main(String[] args) {
		HashMap hm = new HashMap();
		
		int key = 1;
		if(hm.isEmpty()){
			System.out.println("Vazio!\n");
		}
		else {
			System.out.println("Possui elementos!\n");
		}
		
		hm.insertItem(1, 1);
		hm.insertItem(2, 2);
		hm.insertItem(4, 4);
		hm.insertItem(5, 5);
		
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
		System.out.println("\n");
		
		if(hm.isEmpty()){
			System.out.println("Vazio!\n");
		}
		else {
			System.out.println("Possui elementos!\n");
		}
		
		try {
			No f = hm.findElement(1);
			System.out.println( f.getKey() + " localizada! \n");
		}catch(NoSuchKeyException e){
			System.out.println(e.getMessage() + "\n");
		}
		
		try {
			No f = hm.findElement(4);
			System.out.println( f.getKey() + " localizada! \n");
		}catch(NoSuchKeyException e){
			System.out.println(e.getMessage() + "\n");
		}
		
		try {
			No f = hm.findElement(2);
			System.out.println( f.getKey() + " localizada! \n");
		}catch(NoSuchKeyException e){
			System.out.println(e.getMessage() + "\n");
		}
		
		try {
			No f = hm.findElement(3);
			System.out.println( f.getKey() + " localizada! \n");
		}catch(NoSuchKeyException e){
			System.out.println(e.getMessage() + "\n");
		}
		
		try {
			No f = hm.removeElement(1);
			System.out.println( f.getKey() + " removida! \n");
		}catch(NoSuchKeyException e){
			System.out.println(e.getMessage() + "\n");
		}
		
		try {
			No f = hm.removeElement(3);
			System.out.println( f.getKey() + " removida! \n");
		}catch(NoSuchKeyException e){
			System.out.println(e.getMessage() + "\n");
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
		
	}	
}
