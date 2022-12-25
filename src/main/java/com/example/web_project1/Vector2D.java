package com.example.web_project1;

import lombok.Getter;

@Getter
public class Vector2D {
    private double x;
    private double y;

    public double length() {
        return Math.sqrt(x*x + y*y);
    }
}
