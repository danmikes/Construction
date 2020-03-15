enum SingletonEnum {
    INSTANCE;
    SingletonEnum() {
        System.out.println("Singleton");
    }
    static void singletonMethod() {
        System.out.println("singleton");
    }
}

class SingletonInstance {
    public static void main(String[] args) {
//        System.out.println(SingletonEnum.INSTANCE);
        SingletonEnum.singletonMethod();
        System.out.println(SingletonEnum.INSTANCE);
        System.out.print(SingletonEnum.INSTANCE);
        System.out.println();
        SingletonEnum.singletonMethod();
    }
}
