import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        OMOSet set = new OMOSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        OMOSetView copy = set.copy();

        int[] a = set.toArray();
        a[0] = 10;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(set.toArray()));

    }
}
