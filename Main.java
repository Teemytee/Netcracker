public class Main {
    public static void main(String[] args){
        doDemo();
    }

    public static void doDemo(){
        ZooCommandReader reader = new ZooCommandReader(new ZooClass());
        reader.start();
    }
}
