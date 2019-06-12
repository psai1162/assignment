package com.assessment.service;

import com.assessment.model.Book;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProcessService {
    @Cacheable(value = "mycache",key = "#id")
    //By using Cacheable annotation the subsequent calls will be cached
    //added a wait time to see difference
    public Book get(String id) {
        try {
            System.out.println("Going to sleep for 5secs...to simulate backed call.");
            Thread.sleep(1000*5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Book book = new Book();
        book.setKey(id);
        book.setValue("LittleStories");
        return book;
    }
//since we are registering the cache with "mycache" and using it for get and put,
// after an update is done if we call same ID with get it doesnt implement get method instead
// it return value from cache
    @CachePut(value = "mycache",key = "#id")
    public void put(String id, Book book) {
        System.out.println("executing update method");
        //mocking the implementation
    }
}
