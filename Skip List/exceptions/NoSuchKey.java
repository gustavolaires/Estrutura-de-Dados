package exceptions;

import java.lang.Exception;

public class NoSuchKey extends Exception {
	public NoSuchKey() {
		super("Esta chave nao existe.");
	}
}
