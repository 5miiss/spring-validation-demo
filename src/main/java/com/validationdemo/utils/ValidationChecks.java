package com.validationdemo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ValidationChecks {
    @Value("${errorsFile}" )
    String filePath;
    private final Map<String,ValidationErrors> errorsMap = new HashMap<>();

    public List<ValidationErrors> getErrors(List<String> errorsList){
        readFromFile();
       return errorsList.stream().map(errorsMap::get).collect(Collectors.toList());
    }

    public Integer readFromFile()  {
        ClassPathResource classPathResource = new ClassPathResource(filePath);
        try {
            File file = classPathResource.getFile();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String error = scanner.nextLine();
                String []parts = error.split(":");
                errorsMap.put(parts[1],new ValidationErrors(Integer.parseInt(parts[0]),parts[1]));

            }
            log.info("errors map {}", errorsMap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return errorsMap.size();
    }

    public Boolean writeToFile(List<ValidationErrors> errorsList){
        try ( PrintWriter printWriter = new PrintWriter(new FileWriter(filePath))){

            log.info("{}",errorsList);
            for (ValidationErrors validationErrors : errorsList) {
                printWriter.println(validationErrors.getErrorCode() + ":" + validationErrors.getErrorMessage());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }



}
