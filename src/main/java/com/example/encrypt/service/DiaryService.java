package com.example.encrypt.service;

import com.example.encrypt.model.Diary;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
public class DiaryService {

    private final List<Diary> diaryList = new ArrayList<>();

    public Diary createDiary(final Diary diary) {
        diaryList.add(diary);
        log.info("created diary: " + diary.toString());
        return diary;
    }

    public Diary findDiary(final String id) {
        if (diaryList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        List<Diary> resultList = diaryList.stream().filter(diary -> diary.id().equals(id)).toList();
        if (resultList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return resultList.get(0);
    }
}
