package at.schuele.addessbookspringjava.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoContactFoundException extends ResponseStatusException {

    public NoContactFoundException(String message){
        super(HttpStatus.NOT_FOUND, message);
    }
}
