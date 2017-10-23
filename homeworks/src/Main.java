import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        OMOSet set = new OMOSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        OMOSetView copy = set.copy();

        System.out.println(Arrays.toString(set.toArray()));
        System.out.println(Arrays.toString(copy.toArray()));

        set.remove(3);

        System.out.println(Arrays.toString(set.toArray()));
        System.out.println(Arrays.toString(copy.toArray()));

        OMOSetView complement = new OMOSetComplement(set, copy);
        System.out.println("Complement: " + Arrays.toString(complement.toArray()));

        OMOSetView inter = new OMOSetIntersection(set, copy);
        System.out.println("Inter: " + Arrays.toString(inter.toArray()));

    }
}
