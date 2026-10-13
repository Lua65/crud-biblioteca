package br.com.senai.teste.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class ValidacaoExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidacao(
        MethodArgumentNotValidException erro) {

        map<String, String> erros = new HashMap<>();
        
        erro.getBindingResult().getFieldErrors().forEach(campo -> 
            mensagens.put(campo.getField(),
             campo.getDefaultMessage()));
            erros.put(campo.getField(), campo.getDefaultMessage()
        );
        
        return ResponseEntity.badRequest().body(mensagens);
    }
}
