package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String title;
    private int price;
    private String image;
    private String category;
    private List<String> sizes;
    private String color;
    private LocalDate dateOfCreation;

    public ProductResponse(Long id,
                           String title,
                           int price,
                           String image,
                           String category,
                           List<String> sizes,
                           String color,
                           LocalDate dateOfCreation) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.image = image;
        this.category = category;
        this.sizes = sizes;
        this.color = color;
        this.dateOfCreation = dateOfCreation;
    }
}
