package com.assessment.controller;

import com.assessment.model.Book;
import com.assessment.service.ProcessService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProcessService processService;

    private String GET_URL = "/getBookName/101";
    private String PUT_URL = "/updateBookName/101";

    private Book book;

    @Before
    public void setup(){
        book = new Book();
        book.setKey("101");
        book.setValue("LittleStories");
    }

    @Test
    public void getBookTest() throws Exception {
        given(processService.get(anyString())).willReturn(book);

        mockMvc.perform(get(GET_URL).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
