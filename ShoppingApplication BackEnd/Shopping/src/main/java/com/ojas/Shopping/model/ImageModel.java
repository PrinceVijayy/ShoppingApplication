package com.ojas.Shopping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageModel {
    private String fileName;
    private String fileType;
    private String imageInBase64;
    // getters and setters

}
