package com.ojas.Shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {
    private String fileName;
    private String fileType;
    private byte[] imageData;
    // getters and setters
}
