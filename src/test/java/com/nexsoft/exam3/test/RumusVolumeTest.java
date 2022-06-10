package com.nexsoft.exam3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;


import com.nexsoft.exam3.Volume;

public class RumusVolumeTest {

	@ParameterizedTest
	@CsvFileSource(resources = "/Data-Volume-Air-Kolam.csv", delimiter = ',', numLinesToSkip = 1)
	public void volume_kolam(int no, double p, double l, double t, double expected) {
		// arrange

		Volume volumeKolam = new Volume();

		// act
		double result = volumeKolam.volume(p, l, t);

		// assert
		assertEquals(expected, result);
	}
	
	@ParameterizedTest
	@DisplayName("Masukan bukan angka")
	@CsvSource("String")

	public void KelilingKolamBukanAngka_Test(String str) {
		
		Volume volumeKolam = new Volume();
		
		assertThrows(IllegalArgumentException.class, () -> {
			volumeKolam.volume(3, 5, Double.parseDouble(str));
		});
	}
	
	
	@DisplayName("Test Absolut Positif : Hitung volume kolam")
	@ParameterizedTest
	@CsvSource(value = {"-3;-4;-5;60",
						"-2;-2;-3;24",
						"-1;-2;-4;8"},
						delimiter = ';')
	public void testVolumeAbsolutPositif(double p, double l, double t, double expected) {
		
		Volume volumeKolam = new Volume();
		
		double result = volumeKolam.volume(p, l, t);
		assertEquals(expected, result);
		
	}
	
	
	@DisplayName("Test tidak dimasukkan angka(Volume kolam)")
    @ParameterizedTest
    @CsvSource(value = {",,,0",
                        ",,,0",
                        ",,,0"},
                        delimiter = ';')
    public void testKelilingTidakAngka(String a) {
		
		Volume volumeKolam = new Volume();
        String arrIsi[] = a.split(",");
        int panjangData = arrIsi.length;
        int arrResult[] = new int[panjangData];


        for (int i = 0; i < panjangData; i++) {
            if (arrIsi[i].isEmpty())
            {
                arrResult[i] = 0;
            }
            else {
                arrResult[i] = Integer.parseInt(arrIsi[i]);
            }
        }

        double result = volumeKolam.volume(arrResult[0], arrResult[1], arrResult[2]);
        assertEquals(arrResult[3], result);

    }

}
