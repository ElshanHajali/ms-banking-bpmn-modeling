package az.company.msbanking.dto.response;

import java.io.Serializable;

public class CommonResponse<E> implements Serializable {
    static final long serialVersionUID = -7034897190745766939L;

    private Status exceptionResponse;
    private E response;

    public CommonResponse(Status exceptionResponse, E response) {
        this.exceptionResponse = exceptionResponse;
        this.response = response;
    }

    public Status getExceptionResponse() {
        return exceptionResponse;
    }

    public void setExceptionResponse(Status exceptionResponse) {
        this.exceptionResponse = exceptionResponse;
    }

    public E getResponse() {
        return response;
    }

    public void setResponse(E response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "exceptionResponse=" + exceptionResponse +
                ", response=" + response +
                '}';
    }
}
