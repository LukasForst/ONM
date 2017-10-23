import java.util.*;

interface OMOSetView {
    boolean contains(int element); // testuje na přítomnost prvku v množině

    int[] toArray(); //vrátí kopii prvků množiny v poli (na pořadí prvků nezáleží)

    OMOSetView copy(); //vrátí kopii množiny
}

abstract class OMOSetViewAbstract implements OMOSetView{
    protected abstract List<Integer> performUpdate();

    @Override
    public boolean contains(int element) {
        return performUpdate().contains(element);
    }

    @Override
    public int[] toArray() {
        List<Integer> data = performUpdate();
        return data.stream().mapToInt(Integer::intValue).toArray();
    }

    @Override
    public OMOSetView copy() {
        return new OMOSet(performUpdate());
    }
}

class OMOSet extends OMOSetViewAbstract {
    private List<Integer> data;

    OMOSet() {
        data = new ArrayList<>();
    }

    OMOSet(List<Integer> data) {
        this.data = new ArrayList<>(data);
    }

    void add(int element) {
        data.add(element);
    }

    void remove(int element) {
        int idx = data.indexOf(element);
        if(idx != -1)
            data.remove(idx);
    }

    @Override
    protected List<Integer> performUpdate() {
        return data;
    }
}

class OMOSetUnion extends OMOSetViewAbstract  {
    private OMOSetView setA;
    private OMOSetView setB;

    OMOSetUnion(OMOSetView setA, OMOSetView setB) {
        this.setA = setA;
        this.setB = setB;
    }

    @Override
    protected List<Integer> performUpdate() {
        List<Integer> data = new ArrayList<>();
        Arrays.stream(setA.toArray()).forEach(data::add);
        Arrays.stream(setB.toArray()).forEach(data::add);
        return data;
    }
}

class OMOSetIntersection extends OMOSetViewAbstract {
    private OMOSetView setA;
    private OMOSetView setB;

    OMOSetIntersection(OMOSetView setA, OMOSetView setB) {
        this.setA = setA;
        this.setB = setB;
    }

    @Override
    protected List<Integer> performUpdate() {
        List<Integer> data = new ArrayList<>();
        Arrays.stream(setA.toArray()).filter(setB::contains).forEach(data::add);
        return data;
    }
}

class OMOSetComplement extends OMOSetViewAbstract {
    private OMOSetView setA;
    private OMOSetView setB;

    OMOSetComplement(OMOSetView setA, OMOSetView setB) {
        this.setA = setA;
        this.setB = setB;
    }

    @Override
    protected List<Integer> performUpdate() {
        List<Integer> data = new ArrayList<>();
        Arrays.stream(setA.toArray()).filter(number -> !setB.contains(number)).forEach(data::add);
        Arrays.stream(setB.toArray()).filter(number -> !setA.contains(number)).forEach(data::add);
        Arrays.stream(setB.toArray()).filter(number -> setA.contains(number)).forEach(data::add);
        return data;
    }
}

class OMOSetEven extends OMOSetViewAbstract {
    private OMOSetView setA;

    OMOSetEven(OMOSetView setA) {
        this.setA = setA;
    }

    @Override
    protected List<Integer> performUpdate() {
        List<Integer> data = new ArrayList<>();
        Arrays.stream(setA.toArray()).filter(number -> number % 2 == 0).forEach(data::add);
        return data;
    }
}