package com.example.web_project1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2DTest {
    private static Vector2D v;

    @BeforeAll
    public static void createNewVector() {

        v = new Vector2D();
    }

    @Test
    void newVectorShouldHaveZeroLength() {

        Assertions.assertEquals(0, v.length());
    }

    @Test
    void newVectorShouldHaveZeroPointX() {

        Assertions.assertEquals(0, v.getX());
    }

    @Test
    void newVectorShouldHaveZeroPointY() {

        Assertions.assertEquals(0, v.getX());
    }
}