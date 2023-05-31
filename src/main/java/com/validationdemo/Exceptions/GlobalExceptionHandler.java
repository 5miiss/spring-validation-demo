package com.validationdemo.Exceptions;

import com.validationdemo.buissenes.dto.response.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.validationdemo.utils.ValidationChecks;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final ValidationChecks validationChecks;
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseDto handleException(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        return ResponseDto.builder()
                .message("illeagal arguments")
                .status(false)
                .code(400)
                .data(validationChecks.getErrors(errors))
                .dateCreated(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(RuntimeException.class)
    ResponseDto handleException(RuntimeException ex){
        return ResponseDto.builder()
                .message("RuntimeException ")
                .status(false)
                .code(400)
                .data(ex.getMessage())
                .build();
    }
}
