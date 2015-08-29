package exception;

public class ServicesException extends Exception{


    private static final long serialVersionUID = 5025449671334483245L;

    private Integer codigoErro;

    public ServicesException( String message) {
		super(message);
	}
    
	public ServicesException(Integer codigoErro, String message) {
		super(message);
		this.setCodigoErro(codigoErro);
	}

	public ServicesException(Throwable cause) {
		super(cause);
	}

	public ServicesException(String message, Throwable cause) {
		super(message, cause);
	}

	public Integer getCodigoErro() {
		return codigoErro;
	}

	public void setCodigoErro(Integer codigoErro) {
		this.codigoErro = codigoErro;
	}

}
