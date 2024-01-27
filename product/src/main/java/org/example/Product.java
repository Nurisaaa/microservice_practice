package org.example;

import lombok.*;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "products")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1, initialValue = 11)
    private Long id;
    private String title;
    private int price;
    private String image;
    private String category;
    @ElementCollection
    private List<String> sizes;
    private String color;
    private LocalDate dateOfCreation;

    public Product(ProductRequest productRequest) {
        this.title = productRequest.getTitle();
        this.price = productRequest.getPrice();
        this.category = productRequest.getCategory();
        this.sizes = productRequest.getSizes();
        this.color = productRequest.getColor();
        this.dateOfCreation = productRequest.getDateOfCreation();
        this.image = productRequest.getImages();
    }
}
