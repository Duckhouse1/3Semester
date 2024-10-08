package AP.Hashing.afleveringstuderende;

public class App {
    public static void main(String[] args) {
        DictionaryDoubleHashing doubleHashing = new DictionaryDoubleHashing<>(10);
        doubleHashing.put(4,"Dennis");
        doubleHashing.put(1,"Alex");
        doubleHashing.put(8,"Clemen");
        doubleHashing.put(5,"Ras");
        System.out.println("Før reHash");
        doubleHashing.writeOut();
        doubleHashing.put(3,"Mint");
        doubleHashing.put(4,"Mikkel");
        doubleHashing.put(9,"Taus");
        doubleHashing.put(8,"Kasper");
        System.out.println("Efter reHash");
        doubleHashing.writeOut();

        System.out.println("Sletter elementerne 8 , 3 og 4");
        doubleHashing.remove(8);
        doubleHashing.remove(3);
        doubleHashing.remove(4);
        doubleHashing.writeOut();
//        doubleHashing.remove(8);
//        System.out.println("Clemen fjernet");
//        doubleHashing.writeOut();
    }
}
