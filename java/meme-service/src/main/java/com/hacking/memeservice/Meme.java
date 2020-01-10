package com.hacking.memeservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // This generates Getters, a useful toString, hashCodes and equals
@AllArgsConstructor
public class Meme {

    private String id;
    private String title;
    private String author;
    private String link;
    private Integer points;

}