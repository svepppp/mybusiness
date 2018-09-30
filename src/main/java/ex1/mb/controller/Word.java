package ex1.mb.controller;

import org.springframework.stereotype.Component;

@Component
public class Word {
    private  String name;

    public Word() {
       }

    public Word(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
