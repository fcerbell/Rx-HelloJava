// From :
// https://www.youtube.com/watch?v=hzaq64zh0K4
// http://docs.couchbase.com/developer/java-2.0/observables.html
// http://blog.danlew.net/2014/09/15/grokking-rxjava-part-1/

package net.cerbelle.rxjava.demo;
import java.util.concurrent.CountDownLatch;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by fcerbell on 01/09/2015.
 * Observable example
 */
public class SimpleDemo {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        Observable
                .range(1, 500)
                .take(30)
                .filter(s -> (s % 2) == 0)
                .map(Object::toString)
                .map(s -> "Number : " + s + " (Mapped by " + Thread.currentThread().getName() + ", ")
                .observeOn(Schedulers.io())
                .map(s -> s + "then " + Thread.currentThread().getName() + ")")
                .doOnCompleted(latch::countDown)
                .subscribeOn(Schedulers.computation())
                .subscribe(new SimpleObserver());
        latch.await();
    }
}
