package com.andy.learning;

interface Outer {
    
    static Outer create() {
        return new DefaultInterfaceMethodExample1();
    }
    private String className() {
        return Outer.class.getSimpleName();
    }
    default String method() {
        return className();
    }

    interface Inner {
        static Inner create() {
            return new DefaultInterfaceMethodExample3();
        }

        default String method() {
            return "Inner";
        }
    }
}