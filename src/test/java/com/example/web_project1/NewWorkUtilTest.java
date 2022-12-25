package com.example.web_project1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class NewWorkUtilTest {

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void getConnect() {
        NewWorkUtil.getConnect();
    }
}