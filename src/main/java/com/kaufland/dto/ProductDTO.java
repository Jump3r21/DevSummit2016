package com.kaufland.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductDTO {
    public int quality;
    public int costs;
    public int time;

    public ProductDTO() {
    }

    public ProductDTO(int pQuality, int pCosts, int pTime) {
        quality = pQuality;
        costs = pCosts;
        time = pTime;
    }

    public int differenceToOther(ProductDTO other) {
        int result = Math.abs(quality - other.quality) + Math.abs(costs - other.costs) +
                Math.abs(time - other.time);
        return result;
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