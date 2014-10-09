package everdaft.exceptions;

public class CombatServiceException extends EverdaftException {
	
	private Throwable exception;

	public CombatServiceException(Throwable ex) {
		exception = ex;
	}
	
	public String getMessage() {
		return exception.getMessage();
	}
	
}
