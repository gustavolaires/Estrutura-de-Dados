import java.util.Iterator;

public class main {

	public static void main(String[] args) {
		String s1 = "1";
		ArvoreSimples a = new ArvoreSimples(s1);
		
		String s2 = "2";
		a.addChild(a.root(), s2);
		
		String s3 = "3";
		Iterator i = a.children(a.root());
		
		if(i.hasNext()) {
			Position p = (Position) i.next();
			a.addChild(p, s3);
			System.out.println( a.height(p));
			
			Iterator i2 = a.children(p);
			if(i2.hasNext()) {
				Position p2 = (Position) i2.next();
				System.out.println(a.height(p2));
			}
		}
		
		Position r = (Position) a.raiz;
		System.out.println( a.height(r));
		
		
	}
}
