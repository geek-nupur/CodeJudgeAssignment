package org.codejudge.sb;

import org.codejudge.sb.Exceptions.FailureException;
import org.codejudge.sb.Exceptions.RecordNotFoundException;
import org.codejudge.sb.output.FailureResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandler {

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(FailureException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public FailureResponse recordDoesNotExistException(FailureException ex) {
        FailureResponse failureResponse = new FailureResponse();
        failureResponse.setStatus("failure");
        failureResponse.setReason(ex.getReason());
        return failureResponse;
    }

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public FailureResponse invalidInputException(Exception ex) {
        FailureResponse failureResponse = new FailureResponse();
        failureResponse.setStatus("failure");
        failureResponse.setReason("invalid input");
        return failureResponse;
    }

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public FailureResponse recordDoesNotExistGetQuizApiException(RecordNotFoundException ex) {
        FailureResponse failureResponse = new FailureResponse();
        failureResponse.setStatus("failure");
        failureResponse.setReason(ex.getReason());
        return failureResponse;
    }
}


