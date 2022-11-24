package az.company.msbanking.dto.response;

import java.io.Serializable;

public class Status implements Serializable {
    static final long serialVersionUID = -7034897190745766939L;

    private String code;
    private String message;

    public Status() {
    }

    public Status(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Status successStatus() {
        return new Status("1", "successfully completed");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Status{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
