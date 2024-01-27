package org.example;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProductRequest {
    private String title;
    private int price;
    private String images;
    private String category;
    private List<String> sizes;
    private String color;
    private LocalDate dateOfCreation;
}
