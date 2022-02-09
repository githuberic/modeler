package com.lgq.jpool.chapter01;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author lgq
 */
@Getter
@Setter
@NoArgsConstructor
public class TestObject {
    private String name;
    private boolean isActive;

    public TestObject(String name) {
        this.name = name;
    }

    public void destroy() {
    }
}
