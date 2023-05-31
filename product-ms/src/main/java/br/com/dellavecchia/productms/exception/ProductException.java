package br.com.dellavecchia.productms.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class ProductException {

    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

}
