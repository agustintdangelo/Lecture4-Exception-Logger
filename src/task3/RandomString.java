package task3;

import java.util.Arrays;
import java.util.Random;

public class RandomString {

	public static void main(String[] args) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		Random random = new Random();

		int length = 7;

		for (int i = 0; i < length; i++) {
			int index1 = random.nextInt(alphabet.length());
			int index2 = random.nextInt(alphabet.length());

			char randomChar1 = alphabet.charAt(index1);
			char randomChar2 = alphabet.charAt(index2);

			sb1.append(randomChar1);
			sb2.append(randomChar2);
		}

		String randomString1 = sb1.toString().toUpperCase();
		String randomString2 = sb2.toString().toUpperCase();

		System.out.println("Random String 1 with uppercase: " + randomString1);
		System.out.println("Random String 2 with uppercase: " + randomString2);

		randomString1 = randomString1.toLowerCase();
		randomString2 = randomString2.toLowerCase();

		System.out.println("Random String 1 with lowercase: " + randomString1);
		System.out.println("Random String 2 with lowercase: " + randomString2);

		char[] arrayRandomString1 = randomString1.toCharArray();
		char[] arrayRandomString2 = randomString2.toCharArray();

		System.out.println("Random String 1 with toCharArray method: " + Arrays.toString(arrayRandomString1));
		System.out.println("Random String 2 with toCharArray method: " + Arrays.toString(arrayRandomString2));

		int lengthRandomString1 = randomString1.length();
		int lengthRandomString2 = randomString2.length();
		System.out.println("The length of Random String 1 is: " + lengthRandomString1);
		System.out.println("The length of Random String 2 is: " + lengthRandomString2);

		randomString1 = randomString1.replace('a', '1');
		randomString2 = randomString2.replace('r', '2');
		System.out.println("Random String 1 with a replaced with 1: " + randomString1);
		System.out.println("Random String 2 with r replaced with 2: " + randomString2);
	}
}
