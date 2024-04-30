import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class Adder {
    private final AtomicReference<BigInteger> first;
    private final AtomicReference<BigInteger> second;

    public Adder(BigInteger f, BigInteger s) {
        first = new AtomicReference<>(f);
        second = new AtomicReference<>(s);
    }

    public synchronized void update(BigInteger f, BigInteger s) {
        first.set(f);
        second.set(s);
    }

    public synchronized BigInteger add() {
        return first.get().add(second.get());
    }
}
