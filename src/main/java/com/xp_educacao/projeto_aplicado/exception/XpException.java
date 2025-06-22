package com.xp_educacao.projeto_aplicado.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatusCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class XpException extends RuntimeException {
    private final HttpStatusCode code;
    private final String message;

    public XpException(HttpStatusCode code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "AttusException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}