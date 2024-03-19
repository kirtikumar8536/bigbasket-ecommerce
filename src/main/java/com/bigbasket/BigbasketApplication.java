package com.bigbasket;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class BigbasketApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigbasketApplication.class, args);
    }

}
