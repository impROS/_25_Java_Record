import java.lang.reflect.RecordComponent;
/*
*Record classlar immutable'dır. Yani değiştirilemezler.
* Record classlar final classlardır. Yani extend edilemezler.
* Record classlar abstract classlardır. Yani instance oluşturulamazlar.
* Record classlar abstract method içeremezler.
* Java 16 ile birlikte gelen bir özelliktir.
* Record classlar class keywordü yerine record keywordü ile tanımlanır.
*/
public class Main {
    public static void main(String[] args) {
        User user = new User(1, "test@gmail.com", "12345678");
        System.out.println(user);
        System.out.println(user.id());
        System.out.println(user.email());

        // user.id(2); // Error: Çünkü id değişkeni final olarak tanımlanmıştır.
        // user.email("test2@gmail"); // Error: Çünkü email değişkeni final olarak tanımlanmıştır.
        // user.password("123456789"); // Error: Çünkü password değişkeni final olarak tanımlanmıştır.
        System.out.println("*".repeat(50));


        //Reflection ile record componentlerine erişebiliriz.
        var components = user.getClass().getRecordComponents();//classın record componentlerini döndürür.
        for (RecordComponent recordComponent : components) {//record componentlerini döngü ile yazdırır.
            System.out.println(recordComponent);
        }
        System.out.println("*".repeat(50));


        //Fakat Reflection ile de final değişkenlere değer ataması yapılamaz.
        try {
            var idField = user.getClass().getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(user, 2);//can not set final long field User.id to java.lang.Integer
            System.out.println(user.id());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}