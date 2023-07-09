package com.faizan.ProductCatalog;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_id_Sequence",
            sequenceName = "product_id_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_id_Sequence"
    )
    private Integer id;
    private String name;

    private String description;

    private Integer price;

    private Boolean availability;

    public Product(Integer id, String name, String description, Integer price, Boolean availability) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.availability = availability;
    }

    public Product() {

    }
}
