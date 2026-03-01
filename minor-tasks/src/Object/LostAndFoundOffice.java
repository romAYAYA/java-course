package Object;

import java.util.ArrayList;
import java.util.List;

public class LostAndFoundOffice<T> {
    private final List<T> things = new ArrayList<>();

    public void put(T thing) {
        things.add(thing);
    }

    public boolean check(T thing) {
        if (thing == null) {
            throw new IllegalArgumentException("null not supported");
        }
        return things.contains(thing);
    }
}
