package com.karakatalmasova.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductResponse {

    @Id
    private String id;
    private String name;
    private String description;
    private BigInteger price;
}
