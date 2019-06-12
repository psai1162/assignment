package com.assessment.service;

import com.assessment.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class ProcessServiceTest {

    @InjectMocks
    ProcessService processService;

    @Test
    public void getTest() {
        Book actualOutput = processService.get("101");
        assertNotNull(actualOutput);
    }
}
