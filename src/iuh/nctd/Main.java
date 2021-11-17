package iuh.nctd;

public class Main {

    public static void main(String[] args) {
        EagerInitializedSingleton eagerInitializedSingleton = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton eagerInitializedSingleton1 = EagerInitializedSingleton.getInstance();

        System.out.println("=======eager=========");
        System.out.println(eagerInitializedSingleton.hashCode());
        System.out.println(eagerInitializedSingleton1.hashCode());


        LazyInitializedSingleton lazyInitializedSingleton = LazyInitializedSingleton.getInstance();
        LazyInitializedSingleton lazyInitializedSingleton1 = LazyInitializedSingleton.getInstance();

        System.out.println("=======lazy=========");
        System.out.println(lazyInitializedSingleton.hashCode());
        System.out.println(lazyInitializedSingleton1.hashCode());

        System.out.println("=======thread safe=========");
        new Thread(() -> {
            ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
            System.out.println(threadSafeSingleton.hashCode());
        } ).start();
        new Thread(() -> {
            ThreadSafeSingleton threadSafeSingleton1 = ThreadSafeSingleton.getInstance();
            System.out.println(threadSafeSingleton1.hashCode());
        } ).start();

        new Thread(() -> {
            ThreadSafeSingleton threadSafeSingleton3 = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
            System.out.println(threadSafeSingleton3.hashCode());
        } ).start();
        new Thread(() -> {
            ThreadSafeSingleton threadSafeSingleton4 = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
            System.out.println(threadSafeSingleton4.hashCode());
        } ).start();
    }
}
