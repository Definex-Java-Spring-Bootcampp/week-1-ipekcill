package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.ApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Application {
    private User user;
    private LocalDateTime localDateTime;
    private ApplicationStatus applicationStatus;
    private Product product;
}