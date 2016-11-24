package com.kaufland;

import com.kaufland.dto.ManufacturerDTO;
import com.kaufland.dto.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@CrossOrigin(origins = "*")
@Service
public class ManufacturerInitializer {

    private static Logger LOGGER = Logger.getLogger(ManufacturerInitializer.class);

    //static String registerUrl = "https://kproductor-register.herokuapp.com/api/manufacturer";
    @Value("${registerUrl}")
    String registerUrl;

    static String YOUR_URL = "http://127.0.0.1:8081";
    static String YOUR_NAME = "Achtelik";
    static ProductDTO YOUR_PRODUCT = new ProductDTO(50, 30, 20);

    @Scheduled(fixedRate = 5000)
    @PostConstruct
    public void init() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(registerUrl, new ManufacturerDTO(YOUR_URL, YOUR_NAME, YOUR_PRODUCT), ResponseEntity.class);
        LOGGER.info("ManufacturerInitializer initialized!");
    }
}