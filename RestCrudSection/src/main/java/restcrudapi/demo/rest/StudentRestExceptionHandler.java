package restcrudapi.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){

        StudentErrorResponse response=new StudentErrorResponse();
        response.setTimeStamp(System.currentTimeMillis());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage("You made an incorrect request. Please try again. Error:  "+ exc.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse>handleException(StudentNotFoundException exc){

        StudentErrorResponse response=new StudentErrorResponse();
        response.setStatus(404);
        response.setMessage(exc.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
