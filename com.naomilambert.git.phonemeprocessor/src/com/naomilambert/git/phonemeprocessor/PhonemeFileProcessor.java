package com.naomilambert.git.phonemeprocessor;
import java.io.*;
import java.util.*;

import helper.PhonemeRecord;
import helper.Printer;

import phonemes.TypeAffricative;
import phonemes.TypeClosure;
import phonemes.TypeFricative;
import phonemes.TypeNasal;
import phonemes.TypeOthers;
import phonemes.TypeSemivowel;
import phonemes.TypeStop;
import phonemes.TypeVowel;

/**
 * PhonemeFileProcessor is responsible for the running of the program
 * this involves reading the command line arguments and determines 
 * whether or not a sample rate has been given and proceeds to read
 * the file at that rate. 
 * The results of reading each line of the file are saved in the Phoneme
 * record class which is then used to print the found phonemes.
 * 
 * @author Naomi Lambert
 * @version 15 May 2020
 */
/**
 * @author zee
 *
 */
public class PhonemeFileProcessor
{

	// CONSTANTS
	private static final int DEFAULT_SAMPLE_RATE = 16000;	// default sample rate if none given with args
	private static final String INPUT_FILE_SUFFIX = ".phn";	// reads files of type phn as per project description

	//program arguments variables
	private static int sampleRate = DEFAULT_SAMPLE_RATE; 

	//file reading helper objects
	private static Scanner in = null;

	/**
	 * 
	 * main method responsible for executing the program
	 * the args are read from the command line input and used 
	 * to provide a sample rate (optional), the output filename stem.
	 * Each phoneme is then printed by type to its respective file and
	 * the found insances of each phoneme are printed to the file
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args)  throws FileNotFoundException
	{

		String outputFilenameStem = null; 
		
		// if argument length is not acceptable...
		if (args.length < 2 || args.length > 4) {
			System.out.println("2 or 4 arguments expected");

			doShutdown();

		} else if (args.length == 2) {	//if 2 arguments are given...

			// check the suffix to check file type
			if (isSuitableFile(args[0])) {
				try {
					// initialise a scanner to read the file
					in = new Scanner(new File(args[0]));
				} catch(IOException e){
					System.out.println("IOException: File not found - " + e.getMessage());
					doShutdown();
				}
				
				outputFilenameStem = args[1];

			} else {
				doShutdown();
			}

		} else if (args.length == 4) {

			// continue the program with a sample rate	
			// check if the flag for a sample rate is given..
			if ((args[0].charAt(0) == '-') && (args[1].charAt(1) == 's')) {
				// ... if so assign the sample rate
				sampleRate = Integer.parseInt(args[1]);
			} else {
				// invalid flag
				System.out.println("Invalid flag provided");
				doShutdown();
			}

			// if the input file is readable...
			if (isSuitableFile(args[2])) {
				try {
					// initialise a scanner to read the file
					in = new Scanner(new File(args[2]));
					//System.out.println("Input filename: " + inputFileName);
				} catch(IOException e){

					System.out.println("IOException: No such input file -  " + e.getMessage());
					doShutdown();
				}

				outputFilenameStem = args[3];
			}

		} else {

			// invalid arguments entered, end the program without reading any files
			System.out.println("No valid arguments found");
			doShutdown();
		}

		// read the specified input file
		readFile();

		// set output files for printers
		Printer.setPrinters(outputFilenameStem);
		// print the found phonemes
		Printer.print(sampleRate);

	}//main


	/**
	 * 
	 * Checks whether or not the input file is suitable
	 * @param filename
	 * @return boolean
	 */
	private static boolean isSuitableFile(String filename) {

		// extract expected 3 character suffix (after .) of filename
		String tempSuffix = (filename.substring(filename.length() - 4));

		if (tempSuffix.equals(INPUT_FILE_SUFFIX))
			return true;

		return false;
	}

	/**
	 * Safely terminates all processes and outputs usage
	 */
	private static void doShutdown() {
		usage();
		System.exit(0);
	}

	/**
	 * 
	 * Executes main function of the program
	 * 
	 * Reads in phonemes to the scanner initiliased with the the input
	 * file as a parameter. For each phoneme read in a new object is created 
	 * which stores the start and end sample numbers and the phoneme name.
	 */
	private static void readFile () {

		// if the scanner has been initialised...
		if (in != null) {

			// whilst there are more lines in the file...
			while (in.hasNextLine()){

				//read in the next line
				String line = in.nextLine(); 
				//System.out.println("Line read in: " + line); 

				// phonemes in the file are delimted by spaces
				String delims = " ";

				// an array to hold the tokenised line of the file in the format
				// [start sample no] [end sample no] [phoneme]
				String[] tokens = line.split(delims);

				// the file should consist of three strings per line
				if (tokens.length  == 3) {


					// if the sample numbers given are valid...
					if (isValidStartEnd(tokens[0], tokens[1])) {
						// ...retrieve the start and end sample nos from the tokens
						int startSampleNo = Integer.parseInt(tokens[0].trim());
						int endSampleNo = Integer.parseInt(tokens[1].trim() );
						
						// retrieve the phoneme from the tokens and find its type
						String type = PhonemeRecord.findType(tokens[2]);

						// ...and it is a recognised phoneme...
						if (isValidPhoneme(tokens[2])) {

							switch(type) {
							case "affricative": 
								PhonemeRecord.addPhoneme(new TypeAffricative(startSampleNo, endSampleNo, type));
								break;
							case "closure":
								PhonemeRecord.addPhoneme(new TypeClosure(startSampleNo, endSampleNo, type));
								break;
							case "stop":
								PhonemeRecord.addPhoneme(new TypeStop(startSampleNo, endSampleNo, type));
								break;
							case "nasal":
								PhonemeRecord.addPhoneme(new TypeNasal(startSampleNo, endSampleNo, type));
								break;
							case "fricative":
								PhonemeRecord.addPhoneme(new TypeFricative(startSampleNo, endSampleNo, type));
								break;
							case "semivowel":
								PhonemeRecord.addPhoneme(new TypeSemivowel(startSampleNo, endSampleNo, type));
								break;
							case "vowel":
								PhonemeRecord.addPhoneme(new TypeVowel(startSampleNo, endSampleNo, type));
								break;
							case "others":
								PhonemeRecord.addPhoneme(new TypeOthers(startSampleNo, endSampleNo, type));
								break;
							default: 
								System.out.println("No such type: " + type + " Line skipped.");
							}
						} else { // if the sample nos are invalid
							System.out.println("Invalid sample nos: " + startSampleNo + ", " + endSampleNo);

						}

					} else {
						System.out.println("Invalid phoneme: " + tokens[2]);
					}
				} else {
					System.out.println("Invalid number of tokens. Line skipped.");
				}   		
			}

			// close the scanner
			in.close();
		} else { // ... 
			System.out.println("Scanner has not been initialised.");
			doShutdown();
		}
	}

	private static boolean isValidStartEnd(String st, String end) {

		try {
			Integer.valueOf(st);
			Integer.valueOf(end);
			return true;

		} catch (NumberFormatException e) {
			System.out.println("Invalid sample nos. Line skipped.");
		}

		return false;
	}

	private static boolean isValidPhoneme(String type) {
		if (!(PhonemeRecord.findType(type).equals("not found"))) return true;  
		return false;
	}

	public static void usage(){
		System.out.println("Usage: java Command [-s samplerate] input_file output_file_stem");
	}//usage
}

