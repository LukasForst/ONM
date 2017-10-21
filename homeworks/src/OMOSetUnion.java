import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lukas Forst
 * @date 10/18/17
 */
public class OMOSetUnion implements OMOSetView {
    private OMOSetView setA;
    private OMOSetView setB;

    OMOSetUnion(OMOSetView setA, OMOSetView setB) {
        this.setA = setA;
        this.setB = setB;
    }

    @Override
    public boolean contains(int element) {
        return performUpdate().contains(element);
    }

    @Override
    public int[] toArray() {
        List<Integer> data = performUpdate();
        return Arrays.stream(data.toArray(new Integer[data.size()])).mapToInt(Integer::intValue).toArray();
    }

    @Override
    public OMOSetView copy() {
        return new OMOSet(performUpdate());
    }

    private List<Integer> performUpdate() {
        ArrayList<Integer> data = new ArrayList<>();
        Arrays.stream(setA.toArray()).forEach(data::add);
        Arrays.stream(setB.toArray()).forEach(data::add);
        return data;
    }
}
