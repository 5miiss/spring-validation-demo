package com.validationdemo.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
class validationChecksTest {

    @Autowired
    private ValidationChecks validationChecks;
    List<ValidationErrors>errorsList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        errorsList.add(new ValidationErrors(2010,"email must be unique"));
        errorsList.add(new ValidationErrors(2011,"email must be not null"));
        errorsList.add(new ValidationErrors(2012,"user name must be unique"));
        errorsList.add(new ValidationErrors(2013,"user name must be not null"));


    }

    @Test
    void getErrors() {
    }
    @Test
    void writeToFile() {
        Assertions.assertTrue(validationChecks.writeToFile(errorsList));
    }
    @Test
    void readFromFile() {
        Assertions.assertEquals(4,validationChecks.readFromFile());
    }


}