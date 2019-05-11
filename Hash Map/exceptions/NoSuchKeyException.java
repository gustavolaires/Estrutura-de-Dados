package exceptions;

import java.lang.Exception;

public class NoSuchKeyException extends Exception {

	public NoSuchKeyException() {
		super("Essa chave nao existe.\n");
	}
}
