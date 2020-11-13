package exceptions;

public class ContatoNaoExisteException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String nomeContato;
	
	public ContatoNaoExisteException(String nomeContato) {
		this.nomeContato = nomeContato;
	}
	
	@Override
	public String getMessage() {
		return "O contato " + nomeContato + " não existe.";
	}

}
