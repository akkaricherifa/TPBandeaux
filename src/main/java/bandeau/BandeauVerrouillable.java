package bandeau;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BandeauVerrouillable extends Bandeau {
    // private final Lock lock = new ReentrantLock();
    private final Lock verrou = new ReentrantLock();

    public void verrouille() {
        verrou.lock();
    }

    public void deverrouille() {
        verrou.unlock();
    }
}