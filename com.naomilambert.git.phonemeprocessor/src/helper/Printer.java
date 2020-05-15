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
 * Write a description of class Printer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Printer
{

	private static PrintWriter printer = null;


	/**
	 * Prints phonemes of each type from a list of all found phonemes
	 * to their respective files
	 * Prints a summary of phonemes found to the terminal
	 * @param sampleRate
	 * @param outputFilenameStem
	 */
	public static void print (int sampleRate, String outputFilenameStem) {
		List<Phoneme> ps = PhonemeRecord.getPhonemes();

		ListIterator<Phoneme> iter = ps.listIterator();
		while(iter.hasNext())
		{
			Phoneme phoneme = iter.next();

			switch (phoneme.getType()) {
			case "affricative":
				try {
					printer = new PrintWriter(outputFilenameStem + "Affricatives.txt");
				} catch (FileNotFoundException e0) {
					System.out.println("IOException: Affricatives.txt  not openable - " + e0.getMessage());
				}
				printer.printf("%-10s%10s%10s", phoneme.getStartSampleNo()/sampleRate + "s",
						phoneme.getEndSampleNo()/sampleRate+"s", phoneme.getName() + "\n");
				printer.flush();
				break;
			case "closure":
				try {
					printer = new PrintWriter(outputFilenameStem + "Closures.txt");
				} catch (FileNotFoundException e1) {
					System.out.println("IOException: Affricatives.txt  not openable - " + e1.getMessage());
				}
				printer.printf("%-10s%10s%10s", phoneme.getStartSampleNo() /sampleRate+"s", 
						phoneme.getEndSampleNo()/sampleRate+"s", phoneme.getName() + "\n");
				printer.flush();
				break;
			case "fricative":
				try {
					printer = new PrintWriter(outputFilenameStem + "Fricatives.txt");
				} catch (FileNotFoundException e2) {
					System.out.println("IOException: Affricatives.txt  not openable - " + e2.getMessage());
				}
				printer.printf("%-10s%10s%10s", phoneme.getStartSampleNo()/sampleRate+"s", 
						phoneme.getEndSampleNo()/sampleRate+"s", phoneme.getName() + "\n");  
				printer.flush();
				break;
			case "nasal":
				try {
					printer = new PrintWriter(outputFilenameStem + "Nasals.txt");
				} catch (FileNotFoundException e3) {
					System.out.println("IOException: Affricatives.txt  not openable - " + e3.getMessage());
				}
				printer.printf("%-10s%10s%10s", phoneme.getStartSampleNo()/sampleRate+"s", 
						phoneme.getEndSampleNo()/sampleRate+"s", phoneme.getName() + "\n");
				printer.flush();
				break;
			case "vowels":
				try {
					printer = new PrintWriter(outputFilenameStem + "Vowels.txt");
				} catch (FileNotFoundException e4) {
					System.out.println("IOException: Affricatives.txt  not openable - " + e4.getMessage());
				}
				printer.printf("%-10s%10s%10s", phoneme.getStartSampleNo()/sampleRate+"s", 
						phoneme.getEndSampleNo()/sampleRate+"s", phoneme.getName() + "\n");
				printer.flush();
				break;
			case "semivowel":
				try {
					printer = new PrintWriter(outputFilenameStem + "Semivowels.txt");
				} catch (FileNotFoundException e5) {
					System.out.println("IOException: Affricatives.txt  not openable - " + e5.getMessage());
				}
				printer.printf("%-10s%10s%10s", phoneme.getStartSampleNo()/sampleRate+"s", 
						phoneme.getEndSampleNo()/sampleRate+"s", phoneme.getName() + "\n");
				printer.flush();

				break;
			case "stop":
				try {
					printer = new PrintWriter(outputFilenameStem + "Stops.txt");
				} catch (FileNotFoundException e6) {
					System.out.println("IOException: Affricatives.txt  not openable - " + e6.getMessage());
				}
				printer.printf("%-10s%10s%10s", phoneme.getStartSampleNo()/sampleRate+"s", 
						phoneme.getEndSampleNo()/sampleRate+"s", phoneme.getName() + "\n");
				printer.flush();

				break;
			case "other":
				try {
					printer = new PrintWriter(outputFilenameStem + "Other.txt");
				} catch (FileNotFoundException e7) {
					System.out.println("IOException: Affricatives.txt  not openable - " + e7.getMessage());
				}
				printer.printf("%-10s%10s%10s", phoneme.getStartSampleNo()/sampleRate +"s", 
						phoneme.getEndSampleNo()/sampleRate+"s", phoneme.getName() + "\n");
				printer.flush();
				break;
			}

		}

		printer.close();

		System.out.println("Total phonemes found: " + ps.size());
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
