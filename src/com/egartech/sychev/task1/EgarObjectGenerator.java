/**
 * 
 */
package com.egartech.sychev.task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * The Class EgarObjectGenerator.
 *
 * @author Sychev Evgenii
 */
public class EgarObjectGenerator {

	/** The list egar 1. */
	static ArrayList<Egar> listEgar1 = new ArrayList<>(100_000);

	/** The list egar 2. */
	static ArrayList<Egar> listEgar2 = new ArrayList<>(100_000);

	/**
	 * Start project.
	 */

	public static void startProject() {
		Egar egar;
		for (int i = 0; i < 1000; i++) {
			egar = egarObjectRand();
			listEgar1.add(egar);
			listEgar2.add(egar);
		}

		for (int i = 1000; i < 100_000; i++) {
			listEgar1.add(egarObjectRand());
			listEgar2.add(egarObjectRand());
		}

		List<Egar> duplicatesColl = new ArrayList<>(findDuplicates(listEgar1, listEgar2));

		System.out.println("Всего дубликатов в коллекциях = " + duplicatesColl.size());

	}

	/**
	 * Gets the random string.
	 *
	 * @param length the length
	 * @return the random string
	 */
	public static String getRandomString(int length) {
		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRST".toCharArray();

		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String randomStr = sb.toString();

		return randomStr;
	}

	/**
	 * Gets the random string 1.
	 *
	 * @param length the length
	 * @return the random string 1
	 */
	public static String getRandomString1(int length) {
		char[] chars = "1234567890".toCharArray();

		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String randomStr = sb.toString();

		return randomStr;
	}

	/**
	 * Gets the random string 2.
	 *
	 * @param length the length
	 * @return the random string 2
	 */
	public static String getRandomString2(int length) {
		char[] chars = "995".toCharArray();

		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String randomStr = sb.toString();

		return randomStr;
	}

	/**
	 * Egar object rand.
	 *
	 * @return the egar
	 */
	private static Egar egarObjectRand() {

		Egar egar = new Egar();

		egar.setName(getRandomString(10));
		egar.setPhone("+796" + getRandomString1(9));
		egar.setSize(Integer.parseInt(getRandomString2(3)));

		return egar;
	}

	/**
	 * Find duplicates.
	 *
	 * @param arr1 the arr 1
	 * @param arr2 the arr 2
	 * @return the list
	 */
	public static List<Egar> findDuplicates(Collection<Egar> arr1, Collection<Egar> arr2) {

		HashSet<Egar> set1 = new HashSet<Egar>(arr1);
		HashSet<Egar> set2 = new HashSet<Egar>(arr2);

		long start = System.currentTimeMillis();

		// Удалились все элементы, которые есть в set2
		// удаляет элементы, не принадлежащие переданной коллекции

		set1.retainAll(set2);

		// окончание выполнения
		long finish = System.currentTimeMillis();

		// Время обработки
		long timeOfProcessing = finish - start;

		System.out.println("Время начала поиска дубликатов" + start + " миллисекунд");
		System.out.println("Время окончания поиска дубликатов" + finish + " миллисекунд");
		System.out.println("Время поиска дубликатов:" + timeOfProcessing + " миллисекунд ");

		return new ArrayList<>(set1);

	}

}
