package com.andy.learning.jdk20;

//import jdk.internal.vm.ContinuationScope;
//import jdk.internal.vm.Continuation;
//
//public class ContinuationScopeExample {
//
//    public static void main(String[] args) {
//        var scope = new ContinuationScope("Andy");
//        var continuation = new Continuation(scope, () -> {
//            System.out.println("1st point");
//            Continuation.yield(scope);
//            System.out.println("2nd point");
//        });
//
//        while (!continuation.isDone()) {
//            System.out.println(String.format("\nBefore run() method in \"%s\" Scope", continuation.getScope().getName()));
//            continuation.run();
//            System.out.println(String.format("After run() method in  \"%s\" Scope", continuation.getScope().getName()));
//        }
//    }
//}
