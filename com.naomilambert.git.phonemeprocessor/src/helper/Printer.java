package helper;





import java.util.*;

import phonemes.Phoneme;
import phonemes.TypeAffricative;
import phonemes.TypeClosure;
import phonemes.TypeFricative;
import phonemes.TypeNasal;
import phonemes.TypeOther;
import phonemes.TypeSemivowel;
import phonemes.TypeStop;
import phonemes.TypeVowel;

import java.io.*;

/**
 * Static printer used to print found phonemes to files grouping them by type
 * 
 * @author Naomi Lambert
 * @version 15 May 2020
 */
public class Printer
{

	private static PrintWriter affricativePrinter = null;
	private static PrintWriter fricativePrinter = null;
	private static PrintWriter closurePrinter = null;
	private static PrintWriter nasalPrinter = null;
	private static PrintWriter vowelPrinter = null;
	private static PrintWriter semivowelPrinter = null;
	private static PrintWriter stopPrinter = null;
	private static PrintWriter otherPrinter = null;
	

	public static void setPrinters(String outputFilenameStem) {
		try {
			affricativePrinter = new PrintWriter(outputFilenameStem + "Affricatives.txt");
		} catch (FileNotFoundException e0) {
			System.out.println("IOException: Affricatives.txt  not openable - " + e0.getMessage());
		}
		try {
			closurePrinter = new PrintWriter(outputFilenameStem + "Closures.txt");
		} catch (FileNotFoundException e1) {
			System.out.println("IOException: Affricatives.txt  not openable - " + e1.getMessage());
		}
		try {
			fricativePrinter = new PrintWriter(outputFilenameStem + "Fricatives.txt");
		} catch (FileNotFoundException e2) {
			System.out.println("IOException: Affricatives.txt  not openable - " + e2.getMessage());
		}
		try {
			nasalPrinter = new PrintWriter(outputFilenameStem + "Nasals.txt");
		} catch (FileNotFoundException e3) {
			System.out.println("IOException: Affricatives.txt  not openable - " + e3.getMessage());
		}
		try {
			vowelPrinter = new PrintWriter(outputFilenameStem + "Vowels.txt");
		} catch (FileNotFoundException e4) {
			System.out.println("IOException: Affricatives.txt  not openable - " + e4.getMessage());
		}
		try {
			semivowelPrinter = new PrintWriter(outputFilenameStem + "Semivowels.txt");
		} catch (FileNotFoundException e5) {
			System.out.println("IOException: Affricatives.txt  not openable - " + e5.getMessage());
		}
		try {
			stopPrinter = new PrintWriter(outputFilenameStem + "Stops.txt");
		} catch (FileNotFoundException e6) {
			System.out.println("IOException: Affricatives.txt  not openable - " + e6.getMessage());
		}
		try {
			otherPrinter = new PrintWriter(outputFilenameStem + "Other.txt");
		} catch (FileNotFoundException e7) {
			System.out.println("IOException: Affricatives.txt  not openable - " + e7.getMessage());
		}
	}
	/**
	 * Prints phonemes of each type from a list of all found phonemes
	 * to their respective files
	 * Prints a summary of phonemes found to the terminal
	 * @param sampleRate
	 * @param outputFilenameStem
	 */
	public static void print (int sampleRate) {
		List<Phoneme> phonemes = PhonemeRecord.getPhonemes();

		ListIterator<Phoneme> iter = phonemes.listIterator();
		while(iter.hasNext())
		{
			Phoneme phoneme = iter.next();

			switch (phoneme.getType()) {
			case "affricative":
				
				affricativePrinter.printf("%-10s%10s%10s", phoneme.getStartSampleNo()/sampleRate + "s",
						phoneme.getEndSampleNo()/sampleRate+"s", phoneme.getName() + "\n");
				affricativePrinter.flush();
				break;
			case "closure":
				
				closurePrinter.printf("%-10s%10s%10s", phoneme.getStartSampleNo() /sampleRate+"s", 
						phoneme.getEndSampleNo()/sampleRate+"s", phoneme.getName() + "\n");
				closurePrinter.flush();
				break;
			case "fricative":
				
				fricativePrinter.printf("%-10s%10s%10s", phoneme.getStartSampleNo()/sampleRate+"s", 
						phoneme.getEndSampleNo()/sampleRate+"s", phoneme.getName() + "\n");  
				fricativePrinter.flush();
				break;
			case "nasal":
				
				nasalPrinter.printf("%-10s%10s%10s", phoneme.getStartSampleNo()/sampleRate+"s", 
						phoneme.getEndSampleNo()/sampleRate+"s", phoneme.getName() + "\n");
				nasalPrinter.flush();
				break;
			case "vowels":
				
				vowelPrinter.printf("%-10s%10s%10s", phoneme.getStartSampleNo()/sampleRate+"s", 
						phoneme.getEndSampleNo()/sampleRate+"s", phoneme.getName() + "\n");
				vowelPrinter.flush();
				break;
			case "semivowel":
				
				semivowelPrinter.printf("%-10s%10s%10s", phoneme.getStartSampleNo()/sampleRate+"s", 
						phoneme.getEndSampleNo()/sampleRate+"s", phoneme.getName() + "\n");
				semivowelPrinter.flush();

				break;
			case "stop":
				
				stopPrinter.printf("%-10s%10s%10s", phoneme.getStartSampleNo()/sampleRate+"s", 
						phoneme.getEndSampleNo()/sampleRate+"s", phoneme.getName() + "\n");
				stopPrinter.flush();

				break;
			case "other":
				
				otherPrinter.printf("%-10s%10s%10s", phoneme.getStartSampleNo()/sampleRate +"s", 
						phoneme.getEndSampleNo()/sampleRate+"s", phoneme.getName() + "\n");
				otherPrinter.flush();
				break;
			}

		}

		if (fricativePrinter != null) fricativePrinter.close();
		if (nasalPrinter != null) nasalPrinter.close();
		if (semivowelPrinter != null) semivowelPrinter.close();
		if (vowelPrinter != null) vowelPrinter.close();
		if (stopPrinter != null) stopPrinter.close();
		if (closurePrinter != null) closurePrinter.close();
		if (otherPrinter != null) otherPrinter.close();

		
		System.out.println("Total phonemes found: " + phonemes.size());
		System.out.println("Total count of Affricatives: " + TypeAffricative.getCount());
		System.out.println("Total count of Fricatives: " + TypeFricative.getCount());
		System.out.println("Total count of Closures: " + TypeClosure.getCount());
		System.out.println("Total count of Stops: " + TypeStop.getCount());
		System.out.println("Total count of Nasals: " + TypeNasal.getCount());
		System.out.println("Total count of Semivowels: " + TypeSemivowel.getCount());
		System.out.println("Total count of Vowels: " + TypeVowel.getCount());
		System.out.println("Total count of Others: " + TypeOther.getCount());

	}

}
