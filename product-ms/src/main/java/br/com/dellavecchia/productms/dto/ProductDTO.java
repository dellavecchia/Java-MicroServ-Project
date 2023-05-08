package br.com.dellavecchia.productms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDTO {
    
    @NotBlank
    private String name;

    @Size(min = 50)
    private String description;

    @Positive //Foces you to have a value different from zero Ex: $ 0,01
    private double price;
    
    private boolean available;
}
