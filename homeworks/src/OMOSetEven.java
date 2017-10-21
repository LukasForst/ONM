import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lukas Forst
 * @date 10/18/17
 */
public class OMOSetEven implements OMOSetView {
    private OMOSetView setA;

    OMOSetEven(OMOSetView setA) {
        this.setA = setA;
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
        Arrays.stream(setA.toArray()).filter(number -> number % 2 == 0).forEach(data::add);
        return data;
    }
}
