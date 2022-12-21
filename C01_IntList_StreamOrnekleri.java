package lambdaCodeChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class C01_IntList_StreamOrnekleri {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 6, 9, 15, 8));

        yazdir(list);
        negatifYazdir(list);
        pozitifliste(list);
        kareliste(list);
        karelistTekrarsiz(list);
        naturalSiralama(list);
        unnatualOrder(list);
        pozitifElemanSonBes(list);
        pozitifElemanSonBesHaric(list);
        listElemanlariToplami(list);
        System.out.println("negatif sayıların karesi: "+negatifKareleri(list));
        bestenbuyuksayi(list);
        tumElemanlarSifirdanKucukMu(list);
        yuzeEsitElemanVarligi(list);
        sifiraEsitElemanVarligi(list);
        ilkBesElemanToplami(list);
        sonBesElemani(list);

    }

    private static void yazdir(List<Integer> list) {

        // S1:listi aralarinda bosluk birakarak yazdiriniz


        list.stream().forEach(t -> System.out.print(t + " "));

    }

    /*
    peek () 'in Javadoc sayfası şöyle diyor: " Bu yöntem, temelde, öğeleri bir
   ardışık düzen içinde belirli bir noktadan geçerken görmek istediğiniz
   yerde hata ayıklamayı desteklemek için vardır . Ara islemdir.. yapilam islemi gormek icin kullanilir
    */
    private static void negatifYazdir(List<Integer> list) {
        System.out.println();
        // S2: sadece negatif olanlari yazdir
        list.stream().filter(t -> t < 0).forEach(t -> System.out.print(t + " "));


    }

    private static void pozitifliste(List<Integer> list) {
        System.out.println();
        // S3: pozitif olanlardan yeni bir liste olustur
        System.out.println(list.stream().filter(t -> t > 0).collect(Collectors.toList()));


    }

    private static void kareliste(List<Integer> list) {
        System.out.println();
        // S4: list in elemanlarin karelerinden yeni bir list olusturalim
        System.out.println("kare list= "+ list.stream().map(t -> t * t).collect(Collectors.toList()));

    }

    private static void karelistTekrarsiz(List<Integer> list) {
        System.out.println();
        // S5 : list in elemanlarin karelerinden tekrarsiz yeni bir list olusturalim

        System.out.println("tekrarsız list= "+list.stream().map(t -> t * t).distinct().collect(Collectors.toList()));

    }
    private static void naturalSiralama(List<Integer> list) {
        System.out.println();
        // S6: listin elemanlarini kucukten buyuge siralayalim

        System.out.println("natural sıralama= "+list.stream().sorted().collect(Collectors.toList()));
    }


    private static void unnatualOrder(List<Integer> list) {
        System.out.println();
        // S7: listin elemanlarini buyukten kucuge siralayalim


        System.out.println("büyükten küçüğe sıralama= "+list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    }

    private static void pozitifElemanSonBes(List<Integer> list) {
        System.out.println();
        // S8: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim


        System.out.println(list.stream().filter(t -> t > 0).map(t -> t * t * t).filter(t -> t % 10 == 5).collect(Collectors.toList()));
    }


    private static void pozitifElemanSonBesHaric(List<Integer> list) {
        System.out.println();
        // S9: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim


        System.out.println(list.stream().filter(t -> t > 0).map(t -> t * t * t).filter(t -> t % 10 != 5).collect(Collectors.toList()));
    }


    private static void listElemanlariToplami(List<Integer> list) {
        System.out.println();
        // S10 :list elemanlarini toplamini bulalim

        System.out.println(list.stream().reduce(0,(x,y)->(x+y)));
    }

    private static List<Integer> negatifKareleri(List<Integer> list) {
        System.out.println();
        // S11 : peek ornegi cozelim - negatiflerin karelerinden list olusturalim

return list.stream().filter(t->t<0).peek(t-> System.out.println("negatif sayıları: "+t)).map(t->t*t).
        peek(t-> System.out.println("kareleri: "+t)).collect(Collectors.toList());

    }

    private static void bestenbuyuksayi(List<Integer> list) {
        System.out.println();
        // S12 : listede 5 den buyuk  sayi var mi? -anyMatch

        System.out.println(list.stream().anyMatch(t -> t > 5));
    }

    private static void tumElemanlarSifirdanKucukMu(List<Integer> list) {
        System.out.println();
        // S13 : listenin tum elemanlari sifirdan kucuk mu? -allMatch

        System.out.println(list.stream().allMatch(t -> t <0));
    }

    private static void yuzeEsitElemanVarligi(List<Integer> list) {
        System.out.println();
        // S14: listenin 100 e esit elemani yok mu ? -noneMatch

        System.out.println(list.stream().noneMatch(t -> t ==100));
    }

    private static void sifiraEsitElemanVarligi(List<Integer> list) {
        System.out.println();
        // S15: listenin sifira esit elemani yok mu? - noneMatch

        System.out.println(list.stream().noneMatch(t -> t ==0));
    }

    private static void ilkBesElemanToplami(List<Integer> list) {
        System.out.println();
        // S16:  listenin ilk 5 elemanini topla? - limit(5)

        System.out.println(list.stream().limit(5).reduce(0, (x, y) -> (x + y)));
    }

    private static void sonBesElemani(List<Integer> list) {
        System.out.println();
        // S17: listenin son bes elemaninin  listele -skip long

        System.out.println(list.stream().skip(7).collect(Collectors.toList()));
    }

















}
