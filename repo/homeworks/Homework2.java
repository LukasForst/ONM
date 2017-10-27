import java.util.*;

interface OMOSetView {
    boolean contains(int element); // testuje na přítomnost prvku v množině

    int[] toArray(); //vrátí kopii prvků množiny v poli (na pořadí prvků nezáleží)

    OMOSetView copy(); //vrátí kopii množiny
}

class OMOSet implements OMOSetView {
    private Set<Integer> data;

    OMOSet() {
        data = new HashSet<>();
    }

    OMOSet(Set<Integer> data) {
        this.data = new HashSet<>(data);
    }

    void add(int element) {
        data.add(element);
    }

    void remove(int element) {
        data.remove(element);
    }

    @Override
    public boolean contains(int element) {
        return data.contains(element);
    }

    @Override
    public int[] toArray() {
        return data.stream().mapToInt(Integer::intValue).toArray();
    }

    @Override
    public OMOSetView copy() {
        return new OMOSet(data);
    }
}

class OMOSetUnion implements OMOSetView {
    private OMOSetView setA;
    private OMOSetView setB;

    OMOSetUnion(OMOSetView setA, OMOSetView setB) {
        this.setA = setA;
        this.setB = setB;
    }

    @Override
    public boolean contains(int element) {
        return setA.contains(element) || setB.contains(element);
    }

    @Override
    public int[] toArray() {
        Set<Integer> data = new HashSet<>();
        Arrays.stream(setA.toArray()).forEach(data::add);
        Arrays.stream(setB.toArray()).forEach(data::add);

        return data.stream().mapToInt(Integer::intValue).toArray();
    }

    @Override
    public OMOSetView copy() {
        Set<Integer> data = new HashSet<>();
        Arrays.stream(setA.toArray()).forEach(data::add);
        Arrays.stream(setB.toArray()).forEach(data::add);

        return new OMOSet(data);
    }
}

class OMOSetIntersection implements OMOSetView {
    private OMOSetView setA;
    private OMOSetView setB;

    OMOSetIntersection(OMOSetView setA, OMOSetView setB) {
        this.setA = setA;
        this.setB = setB;
    }

    @Override
    public boolean contains(int element) {
        return setA.contains(element) && setB.contains(element);
    }

    @Override
    public int[] toArray() {
        return Arrays.stream(setA.toArray()).filter(setB::contains).toArray();
    }

    @Override
    public OMOSetView copy() {
        Set<Integer> data = new HashSet<>();
        Arrays.stream(setA.toArray()).filter(setB::contains).forEach(data::add);
        return new OMOSet(data);
    }
}

class OMOSetComplement implements OMOSetView {
    private OMOSetView setA;
    private OMOSetView setB;

    OMOSetComplement(OMOSetView setA, OMOSetView setB) {
        this.setA = setA;
        this.setB = setB;
    }


    @Override
    public boolean contains(int element) {
        return setA.contains(element) && !setB.contains(element);
    }

    @Override
    public int[] toArray() {
        return Arrays.stream(setA.toArray()).filter(number -> !setB.contains(number)).toArray();
    }

    @Override
    public OMOSetView copy() {
        Set<Integer> data = new HashSet<>();
        Arrays.stream(setA.toArray()).filter(number -> !setB.contains(number)).forEach(data::add);
        return new OMOSet(data);
    }
}

class OMOSetEven implements OMOSetView {
    private OMOSetView setA;

    OMOSetEven(OMOSetView setA) {
        this.setA = setA;
    }

    @Override
    public boolean contains(int element) {
        return setA.contains(element) && (element % 2 == 0);
    }

    @Override
    public int[] toArray() {
        return Arrays.stream(setA.toArray()).filter(number -> number % 2 == 0).toArray();
    }

    @Override
    public OMOSetView copy() {
        Set<Integer> data = new HashSet<>();
        Arrays.stream(setA.toArray()).filter(number -> number % 2 == 0).forEach(data::add);
        return new OMOSet(data);
    }
}