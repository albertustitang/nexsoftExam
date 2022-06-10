package com.nexsoft.exam3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import com.nexsoft.exam3.Keliling;
import com.nexsoft.exam3.Volume;

public class RumusKelilingTest {

	@ParameterizedTest
	@DisplayName("Hitung keliling kolam")
	@CsvFileSource(resources = "/Data-Keliling-Kolam.csv", delimiter = ',', numLinesToSkip = 1)
	public void keliling_kolam(int no, double p, double l, double t, double expected) {
		// arrange

		Keliling kelilingKolam = new Keliling();

		// act
		double result = kelilingKolam.keliling(p, l, t);

		// assert
		assertEquals(expected, result);
	}

	@ParameterizedTest
	@DisplayName("Masukan bukan angka")
	@CsvSource("String")

	public void KelilingKolamBukanAngka_Test(String str) {
		
		Keliling kelilingKolam = new Keliling();
		
		assertThrows(IllegalArgumentException.class, () -> {
			kelilingKolam.keliling(3, 5, Double.parseDouble(str));
		});
	}
	
	@DisplayName("Test Absolut Positif : Hitung keliling kolam")
	@ParameterizedTest
	@CsvSource(value = {"-2;-2;-2;-24",
						"-3;-3;-3;-36",
						"-1;-2;-3;-24"},
						delimiter = ';')
	public void testVolumeAbsolutPositif(double p, double l, double t, double expected) {
		
		Volume volumeKolam = new Volume();
		
		double result = volumeKolam.volume(p, l, t);
		assertEquals(expected, result);
		
	}

	@DisplayName("Test tidak dimasukkan angka(Keliling kolam)")
	@ParameterizedTest
	@CsvSource(value = { ",,,0", ",,,0", ",,,0" }, delimiter = ';')
	public void testKelilingTidakAngka(String a) {

		Keliling kelilingKolam = new Keliling();
		String arrIsi[] = a.split(",");
		int panjangData = arrIsi.length;
		int arrResult[] = new int[panjangData];

		for (int i = 0; i < panjangData; i++) {
			if (arrIsi[i].isEmpty()) {
				arrResult[i] = 0;
			} else {
				arrResult[i] = Integer.parseInt(arrIsi[i]);
			}
		}

		double result = kelilingKolam.keliling(arrResult[0], arrResult[1], arrResult[2]);
		assertEquals(arrResult[3], result);

	}

}
