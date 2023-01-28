package com.squareroot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDto {
    private HttpStatusCode code;
    private String message;
}
