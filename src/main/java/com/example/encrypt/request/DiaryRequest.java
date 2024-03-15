package com.example.encrypt.request;

import lombok.Builder;

@Builder
public record DiaryRequest(
    String title,
    String content
) {

}
