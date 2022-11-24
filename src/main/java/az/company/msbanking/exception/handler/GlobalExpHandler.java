package az.company.msbanking.exception.handler;

import az.company.msbanking.dto.response.ExceptionResponse;
import az.company.msbanking.exception.ObjectNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExpHandler {

    @ExceptionHandler(value = ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse objectNotFoundException(
            ObjectNotFoundException e
    ) {
        log.info("ObjectNotFoundException message: {}", e.getMessage());
        return new ExceptionResponse(e.getCode(), e.getMessage());
    }
}
