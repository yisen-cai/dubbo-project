package com.qunar.training.entity;

import java.io.Serializable;

/**
 * @author YISHEN CAI
 */
public class DemoEntity implements Serializable {
    private String name;

    public DemoEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DemoEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
