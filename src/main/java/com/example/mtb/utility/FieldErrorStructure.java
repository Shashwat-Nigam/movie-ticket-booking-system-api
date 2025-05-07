package com.example.mtb.utility;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FieldErrorStructure<T> {
    private int statusCode;

    @JsonProperty("error_message")
    private String errorMessage;

    T data;
}
