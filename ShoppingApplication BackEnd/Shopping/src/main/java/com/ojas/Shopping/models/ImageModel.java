package com.ojas.Shopping.models;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageModel {
    private int id;
    private String name;
    private String type;
    private byte[] image;
}
