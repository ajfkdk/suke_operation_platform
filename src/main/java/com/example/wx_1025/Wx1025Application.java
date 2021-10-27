package com.example.wx_1025;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * The type Wx 1025 application.
 */
@SpringBootApplication
@MapperScan("com.example.wx_1025.mapper")
public class Wx1025Application {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Wx1025Application.class, args);
    }

}
