package com.api.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FruitsDto {
    @Size(max = 2, message = "Enter proper fruit name")
    private String fruit_name;
    @Email(message = "Enter proper fruit price")
    private String fruit_price;
    @Size(max = 5, min = 5, message = "Fruit quantity must be more then 50kg available in stock")
    private String fruit_quantity;

}
