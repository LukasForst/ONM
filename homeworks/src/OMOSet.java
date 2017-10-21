import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lukas Forst
 * @date 10/18/17
 */
public class OMOSet implements OMOSetView {
    private ArrayList<Integer> data;

    public OMOSet() {
        data = new ArrayList<>();
    }

    public OMOSet(List<Integer> data) {
        this.data = new ArrayList<>(data);
    }

    public void add(int element) {
        data.add(element);
    }

    public void remove(int element) {
        data.remove(element);
    }

    @Override
    public boolean contains(int element) {
        return data.contains(element);
    }

    @Override
    public int[] toArray() {
        return Arrays.stream(data.toArray(new Integer[data.size()])).mapToInt(Integer::intValue).toArray();
    }

    @Override
    public OMOSetView copy() {
        return new OMOSet(data);
    }
}
