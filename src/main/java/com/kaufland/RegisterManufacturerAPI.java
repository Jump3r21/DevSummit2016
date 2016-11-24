package com.kaufland;

import com.kaufland.dto.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController()
public class RegisterManufacturerAPI {

    private static Logger LOGGER = Logger.getLogger(RegisterManufacturerAPI.class);

    @PostMapping("/api/order")
    public ResponseEntity sendOrder(@RequestBody ProductDTO productDTO) {
        LOGGER.info("Get Order!" + productDTO.toString());
        return ResponseEntity.ok().build();
    }
}