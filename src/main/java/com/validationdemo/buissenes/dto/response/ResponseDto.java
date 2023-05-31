package com.validationdemo.buissenes.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ResponseDto {
    private String message;
    private boolean status;
    private int code;
    private Object data;
    private LocalDateTime dateCreated = LocalDateTime.now();
}
