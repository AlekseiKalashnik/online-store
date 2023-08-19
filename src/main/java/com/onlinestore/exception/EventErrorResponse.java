package com.onlinestore.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EventErrorResponse {
    private String name;
    private long timestamp;
}
