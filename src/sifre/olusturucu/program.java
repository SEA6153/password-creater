package sifre.olusturucu;

import java.util.Random;
import java.util.Scanner;

public class program {

	public static String sifreOlusturucu(String ad, String soyad, String dogumTarihi) {
		String[] sifreKarakterleri = new String[10];

		String adSoyad = ad + soyad;

		String[] alfanumerikArr = { "!", ".", "*", "+", "&", "#", "?", "%" };
		String sifre = "";

		Random rastgeleSayiUretici = new Random();

		for (int i = 0; i < 2; i++) {

			int buyukHarfIcinRastegeleIndex = rastgeleSayiUretici.nextInt(0, adSoyad.length());
			Character buyukKarakter = adSoyad.charAt(buyukHarfIcinRastegeleIndex);
			String buyukHarf = buyukKarakter.toString().toUpperCase();

			int kucukHarfIcinRastegeleIndex = rastgeleSayiUretici.nextInt(0, adSoyad.length());
			Character kucukKarakter = adSoyad.charAt(kucukHarfIcinRastegeleIndex);
			String kucukHarf = kucukKarakter.toString().toUpperCase();

			Integer sayi = Integer.valueOf(dogumTarihi) * 23589;

			String strSayi = sayi.toString();

			int sayiIcınRastgeleIndex = rastgeleSayiUretici.nextInt(0, strSayi.length());

			int sifreSayisi = strSayi.charAt(sayiIcınRastgeleIndex); // dönüş değeri char olması ascii tablosundaki
																		// karşılığı

			int alfanumerikKarakterIcınRastgeleIndex = rastgeleSayiUretici.nextInt(0, alfanumerikArr.length);
			String alfanumerikKarakter = alfanumerikArr[alfanumerikKarakterIcınRastgeleIndex];

			sifre += buyukHarf + kucukHarf + sifreSayisi + alfanumerikKarakter;
		}
		return sifre;
	}

	public static void main(String[] args) {
		// adınızı soyadınızı isteyecek, ++
		// sonra doğum tarihinizi isteyecek ++
		// programın içerisinde alfanumerik karakterler içeren bir dizisi olaccak ++
		// bu veriler içindeki harf, rakam ve alfanumerik karakterler rastgele
		// kullanılarak
		// en az 8 karakterli ve içinde en az 1 büyük 1 küçük harf olacak, bir sayı ve
		// bir alfanumerik karakter olacak şekilde şifre oluştursun
		// kullanıcıdan veri isteme bölümü main metodu içinde, şifre oluşturma işi başka
		// metodda olacak ve çağırıldığında String olarak şifre geri dönecek.

		Scanner input = new Scanner(System.in);
		System.out.println("Lütfen adınızı girin: ");
		String ad = input.next();
		System.out.println("Lütfen Soyadınızı girin: ");
		ad = ad.trim();
		String soyad = input.next();
		System.out.println("Lütfen doğum tarihinizi (gg.aa.yy) girin: ");
		soyad = soyad.trim();
		String dogumTarihi = input.next();
		dogumTarihi = dogumTarihi.replace(".", "");// sadece sayılar kalsın diye
		String sifre = sifreOlusturucu(ad, soyad, dogumTarihi);
		System.out.println(sifre);
	}

}
