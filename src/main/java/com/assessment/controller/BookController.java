package com.assessment.controller;

import com.assessment.service.ProcessService;
import com.assessment.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    ProcessService processService;
    @GetMapping("/getBookName/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getDetailsFromkey(@PathVariable String id){
        System.out.println("Searching by id :" + id);
        Book book = processService.get(id);
        return book;
    }

    @PutMapping("/updateBookName/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBookName(@PathVariable String id,@RequestBody Book book){
        processService.put(id,book);
    }
}
