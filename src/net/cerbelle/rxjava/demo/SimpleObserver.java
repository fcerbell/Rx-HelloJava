package net.cerbelle.rxjava.demo;

import rx.Observer;

/**
 * Created by fcerbell on 01/09/2015.
 * Observer example
 */
public class SimpleObserver implements Observer<String> {
    @Override
    public void onCompleted() {
        System.out.println("Finished.");
    }

    @Override
    public void onError(Throwable exception) {
        System.out.println("Oops!");
    }

    @Override
    public void onNext(String string) {
        System.out.println(string +"(Observed by : "+ Thread.currentThread().getName() +")");

    }
}
