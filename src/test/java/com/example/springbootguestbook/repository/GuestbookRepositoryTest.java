package com.example.springbootguestbook.repository;

import com.example.springbootguestbook.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuestbookRepositoryTest {

    @Autowired
    private GuestbookRepository guestbookRepository;

    @Test
    public void insertDummies(){

        IntStream.rangeClosed(1,300).forEach(i->{

            Guestbook guestbook = Guestbook.builder()
                    .title("title..." + i)
                    .content("Content.." +i)
                    .writer("user" + (i%10))
                    .build();
                    System.out.println(guestbookRepository.save(guestbook));
        });
    }

    @Test
    public void updateTest(){

        Optional<Guestbook> result = guestbookRepository.findById(300L);

        if(result.isPresent()){

            Guestbook guestbook = result.get();

            guestbook.changeTitle("Change Title...");
            guestbook.changeContent("Changed Content...");

            guestbookRepository.save(guestbook);
        }
    }
}