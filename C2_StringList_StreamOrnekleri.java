package lambdaCodeChallenge;

import java.util.ArrayList;
import java.util.List;

public class C2_StringList_StreamOrnekleri {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("ogrenmek");
        list.add("cok");
        list.add("eglencelidi");
        list.add("lambda");
        list.add("gelince");
        list.add("Daha");
        list.add("da");
        list.add("Cok");
        list.add("Eglenceli");
        list.add("Oldu");


        ilkHarfiListeleme(list);
        basinaveSonunaYildizListeleme(list);
        alfabetikSiralama(list);
        lHarfiniSilme(list);
        eHarfiList(list);
        ilkHarfiUcKezTekrar(list);
        tumElemanlarinIlkHarfi(list);
        liste(list);

    }

    public static void ilkHarfiListeleme(List<String> list) {

        // S1: ilk harfi d ve ya c olanlari listeleyelim *** filter-startsWith()

        System.out.println("ilk harfi d ve ya c olanlari listeleme\n");

        list.stream().filter(t -> t.startsWith("d") || t.startsWith("c")).forEach(t -> System.out.println(t.toString()));

    }

    public static void basinaveSonunaYildizListeleme(List<String> list) {

        //S2: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim *** map(t-> "*" + t + "*")

        System.out.println("\nbaşına ve sonuna yıldız ekleme\n");

        list.stream().map(t -> "*" + t + "*").forEach(t -> System.out.println(t.toString()));

    }

    public static void alfabetikSiralama(List<String> list) {

        //S3: alfabetik  olarak siralayalim list olarak ***sorted()

        System.out.println("\nalfabetik  olarak siralama\n");

        list.stream().sorted().forEach(t -> System.out.println(t.toString()));

    }

    public static void lHarfiniSilme(List<String> list) {

        //S4: tum 'l' leri silelim yazdiralim ***map(replaceAll)

        System.out.println("\nl harflerini silelim\n");

        list.stream().map(t -> t.replaceAll("l", "")).forEach(t -> System.out.println(t.toString()));

    }

    public static void eHarfiList(List<String> list) {

        //S5 : icinde e olanlardan yeni bir list olusturunuz  *** filter(contains()) collect()

        System.out.println("\niçinde e harfi olan kelimeler \n");

        list.stream().filter(t -> t.contains("e")).forEach(t -> System.out.println(t.toString()));

    }


    public static void ilkHarfiUcKezTekrar(List<String> list) {

        // S6 : ilk harfini 3 kere tekrar edip yazalim ornek jjjava gibi

        // ***map(t-< t.substring(0,1) + t-< t.substring(0,1) + t) forEach()

        System.out.println("\nilk harfini 3 kere tekrar edip yazalim \n");

        list.stream().map(t -> t.substring(0, 1) + t.substring(0, 1) + t).forEach(t -> System.out.println(t.toString()));

    }


    public static void tumElemanlarinIlkHarfi(List<String> list) {

        // S7: tum elemanlarin ilk harfini buyuk digerlerini kucuk yaziniz

        // ***map(t-< t.substring(0,1).toUpperCase() + t.substring(1).toLowerCase() forEach

        System.out.println("\ntüm elemanların ilk harfini büyük diğerlerini küçük yazma \n");

        list.stream().map(t -> t.substring(0, 1).toUpperCase() + t.substring(1).toLowerCase()).forEach(t -> System.out.println(t.toString()));

    }


    public static void liste(List<String> list) {

        // S8: uzunlugu 4 ve 6 olanlar haric bir liste olusturunuz

        // ***filter(x-> x.length () !=4 && x.length () !=6)  collect

        System.out.println("\nuzunlugu 4 ve 6 olanlar haric bir listesi: \n");

        list.stream().filter(t -> (t.length()) != 4 && t.length() != 6).forEach(t -> System.out.println(t.toString()));

    }

}
