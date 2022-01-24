package com.example.springbootguestbook.service;

import com.example.springbootguestbook.dto.GuestbookDTO;

public interface GuestbookService {
    Long register(GuestbookDTO dto);
}
