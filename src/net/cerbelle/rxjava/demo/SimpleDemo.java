// From https://www.youtube.com/watch?v=hzaq64zh0K4
package net.cerbelle.rxjava.demo;

import java.util.Arrays;
import java.util.List;
import rx.Observable;

/**
 * Created by fcerbell on 01/09/2015.
 * Observable example
 */
public class SimpleDemo {
    public static void main(String[] args) {
        List<String> shapeList = Arrays.asList("rectangle","triangle","circle","square");
        Observable.from(shapeList).subscribe(new SimpleObserver());
    }
}
