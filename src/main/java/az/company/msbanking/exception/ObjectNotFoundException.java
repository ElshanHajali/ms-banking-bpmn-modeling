package az.company.msbanking.exception;

public class ObjectNotFoundException extends RuntimeException{
    private String code;

    public ObjectNotFoundException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
