package com.kaufland.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ManufacturerDTO {
    public String address;
    public String name;
    public ProductDTO product;

    public ManufacturerDTO() {
    }

    public ManufacturerDTO(String address, String name, ProductDTO product) {
        this.address = address;
        this.name = name;
        this.product = product;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException pE) {
            pE.printStackTrace();
        }
        return super.toString();
    }
}