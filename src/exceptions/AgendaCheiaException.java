package exceptions;

public class AgendaCheiaException extends Exception{

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "A agenda já está cheia";
	}
	
}
