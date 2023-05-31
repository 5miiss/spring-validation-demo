package com.validationdemo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ValidationErrors {
    private int errorCode;
    private String errorMessage;

}
