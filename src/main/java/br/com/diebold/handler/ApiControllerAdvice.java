//package br.com.diebold.handler;
//
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import br.com.diebold.exceptions.ResourceException;
//import br.com.diebold.exceptions.ApiError;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class ApiControllerAdvice {
//    @ExceptionHandler(ResourceException.class)
//    @ResponseStatus(code = HttpStatus.NOT_FOUND)
//    public ApiError handlerCallEntryNotFound(ResourceException callEntryNotFoundException) {
//        return ApiError.builder().dataErro(LocalDateTime.now()).statucCode(HttpStatus.NOT_FOUND.value()+"")
//                .erros(Arrays.asList(callEntryNotFoundException.getMessage())).build();
//    }
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
//    public ApiError handlerValidationException(MethodArgumentNotValidException ex) {
//        List<String> erros = ex.getBindingResult().getAllErrors().stream().map(erro -> erro.getDefaultMessage()).collect(Collectors.toList());
//        return ApiError.builder().dataErro(LocalDateTime.now()).statucCode(HttpStatus.BAD_REQUEST.getReasonPhrase())
//                .erros(erros).build();
//    }
//    @ExceptionHandler(ResourceException.class)
//    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
//    public ApiError handlerUserLoginException(ResourceException userLoginException) {
//        return ApiError.builder().dataErro(LocalDateTime.now()).statucCode(HttpStatus.BAD_REQUEST.getReasonPhrase())
//                .erros(Arrays.asList(userLoginException.getMessage())).build();
//    }
////    @ExceptionHandler(ResourceNotFoundException.class)
////    @ResponseStatus(code = HttpStatus.NOT_FOUND)
////    public ApiError handlerCallEntryNotFound(ResourceNotFoundException grupoNotFound) {
////        return ApiError.builder().dataErro(LocalDateTime.now()).statucCode(HttpStatus.NOT_FOUND.value()+"")
////                .erros(Arrays.asList(grupoNotFound.getMessage())).build();
////    }
//}
