package com.example.encrypt.model;

import com.example.encrypt.request.DiaryRequest;
import com.example.encrypt.util.EncryptionUtil;
import java.util.UUID;
import lombok.Builder;

@Builder
public record Diary(
    String id,
    String title,
    String content
) {

    public static Diary of(DiaryRequest diaryRequest) throws Exception {
        return Diary.builder()
            .id(UUID.randomUUID().toString())
            .title(EncryptionUtil.encrypt(diaryRequest.title()))
            .content(EncryptionUtil.encrypt(diaryRequest.content()))
            .build();
    }
}
