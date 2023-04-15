package com.andy.learning;

class DefaultInterfaceMethodExamples {
    
    public static void main(String[] args) {
        Outer outter = Outer.create(); 
        System.out.format("\n%s in %s\n", outter.method(), outter.toString());

        ChildOuter childOutter = ChildOuter.create();
        System.out.format("\n%s in %s\n", childOutter.method(), childOutter.toString());

        Outer.Inner inner = Outer.Inner.create();
        System.out.format("\n%s in %s\n\n", inner.method(), inner.toString());
    }
}

