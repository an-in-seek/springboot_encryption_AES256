package com.example.encrypt.controller;

import com.example.encrypt.model.Diary;
import com.example.encrypt.request.DiaryRequest;
import com.example.encrypt.response.DiaryResponse;
import com.example.encrypt.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/diaries")
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping
    public ResponseEntity<DiaryResponse> createDiary(@RequestBody DiaryRequest diaryRequest) throws Exception {
        Diary diary = Diary.of(diaryRequest);
        Diary createdDiary = diaryService.createDiary(diary);
        DiaryResponse diaryResponse = DiaryResponse.of(createdDiary);
        return ResponseEntity.status(HttpStatus.CREATED).body(diaryResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiaryResponse> findDiary(@PathVariable String id) throws Exception {
        Diary diary = diaryService.findDiary(id);
        DiaryResponse diaryResponse = DiaryResponse.of(diary);
        return ResponseEntity.ok(diaryResponse);
    }
}
