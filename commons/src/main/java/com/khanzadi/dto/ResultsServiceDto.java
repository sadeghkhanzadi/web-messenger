package com.khanzadi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultsServiceDto implements Serializable {
    private String referenceNumber;
    private Long messageId;
    private Long durationTime;
    private boolean hasError;
    private int errorCode;
    private String message;
    private Object result;

    @JsonIgnore
    private HttpStatus status;

    @JsonIgnore
    private transient Throwable throwable;

    public ResultsServiceDto(Object ob){
        result = ob;
    }

    //TODO Builder
}
