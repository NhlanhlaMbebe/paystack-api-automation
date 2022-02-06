package com.paystack.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Automation {

    private String name;
    private String completed;
}
