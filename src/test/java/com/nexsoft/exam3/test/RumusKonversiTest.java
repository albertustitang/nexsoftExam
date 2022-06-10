package com.nexsoft.exam3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.nexsoft.exam3.Konversi;


public class RumusKonversiTest {

	@ParameterizedTest
	@CsvFileSource(resources = "/Data-F-ke-C.csv", delimiter = ',', numLinesToSkip = 1)
	public void konversi_suhu(int no, float f, float expected) {
		// arrange

		Konversi konversiSuhu = new Konversi();

		// act
		float result = konversiSuhu.konversi(f);

		// assert
		assertEquals(expected, result);
	}

}
