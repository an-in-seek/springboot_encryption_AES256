package com.example.encrypt.response;

import com.example.encrypt.model.Diary;
import com.example.encrypt.util.EncryptionUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;

@Builder
@JsonInclude(Include.NON_NULL)
public record DiaryResponse(
    String id,
    String title,
    String content
) {

    public static DiaryResponse of(Diary diary) throws Exception {
        return DiaryResponse.builder()
            .id(diary.id())
            .title(EncryptionUtil.decrypt(diary.title()))
            .content(EncryptionUtil.decrypt(diary.content()))
            .build();
    }
}
