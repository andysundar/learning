package com.andy.learning;

interface ChildOuter extends Outer  {

    static ChildOuter create() {
        return new DefaultInterfaceMethodExample2();
    }

    default String method() {
        return "ChildOuter";
    }

}
