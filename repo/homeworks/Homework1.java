public class Homework1 {
    public boolean f() {
        return true;
    }

    public static boolean g() {
        return false;
    }

    private int instanceTimes = 0;

    public int h() {
        instanceTimes++;
        return instanceTimes;
    }

    private static int classTimes = 0;

    public int i() {
        classTimes++;
        return classTimes;
    }

}
