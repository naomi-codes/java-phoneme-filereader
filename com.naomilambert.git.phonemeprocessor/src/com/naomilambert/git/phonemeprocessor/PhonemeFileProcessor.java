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
 * Write a description of class PhonemeFileProcessor  here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhonemeFileProcessor
{

	// CONSTANTS
    private static final int DEFAULT_SAMPLE_RATE = 16000;	// default sample rate if none given with args
    private static final String INPUT_FILE_SUFFIX = ".phn";	// reads files of type phn as per project description
    
    //program arguments variables
    private static int sampleRate = DEFAULT_SAMPLE_RATE; 
    private static String inputFileName = null;
    private static String outputFileNameStem = null; 

    //file reading helper objects
    private static File inputFile = null;
    private static Scanner in = null;
    
    public static void main(String[] args)  throws FileNotFoundException
    {

        // if argument length is not acceptable...
        if (args.length < 2 || args.length > 4) {
            System.out.println("2 or 4 arguments expected");
            
        // ...output usage... 
            usage();
        // ... and terminate program
            System.exit(0);
            
        } else if (args.length == 2) {	//if 2 arguments are given...

        	continueNoSampleRate(args);
        	
        } else if (args.length == 4) {
        	
        	continueSampleRate(args);
        	
        } else {
            System.out.println("No valid arguments found");
            doShutdown();
        }

        readFile();
        Printer.print(sampleRate);

    }//main
    
    private static void continueNoSampleRate(String[] args) {
    	
     // check the suffix to check file type
        if (isSuitableFile(args[0])) {
            try {
                inputFileName = args[0];
                inputFile = new File(inputFileName);
                in = new Scanner(inputFile);
            } catch(IOException e){
                System.out.println("IOException: File not found - " + e.getMessage());
                doShutdown();
            }

            outputFileNameStem = args[1];
			new Printer(outputFileNameStem);
			System.out.println("Output filename stem: " + outputFileNameStem);
        } else {
            doShutdown();
        }
    }
    
    private static void continueSampleRate(String[] args ) {
    	
    	// whether or not a sample rate has been specified
        boolean sflag = false; 
        
    	String arg = args[0];

        if (arg.charAt(0) == '-') sflag = true;

        if (sflag) {
            sampleRate = Integer.parseInt(args[1]);
        } 

        ;

        if (isSuitableFile(args[2])) {
            try {
                inputFileName = args[2];
                inputFile = new File(inputFileName);
                in = new Scanner(inputFile);
                System.out.println("Input filename: " + inputFileName);
            } catch(IOException e){
                System.out.println("IOException: " + e.getMessage() + " not found");
                doShutdown();
            }
            outputFileNameStem = args[3];
			new Printer(outputFileNameStem);
			System.out.println("Output filename stem: " + outputFileNameStem);
        }
    }

    private static boolean isSuitableFile(String filename) {
    	// extract expected 3 character suffix (after .) of filename
        String tempSuffix = (filename.substring(filename.length() - 4));
        
        
    	if (tempSuffix.equals(INPUT_FILE_SUFFIX))
    		return true;
    	
    	return false;
    }
    
    private static void doShutdown() {
    	usage();
        System.exit(0);
    }
    
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
                
                
                //for (String s : tokens) {
                //    System.out.println(s);
                //}
                
                //System.out.println("Token length: " + tokens.length);
                
                // the file should consist of three strings per line
                if (tokens.length  == 3) {

                    //boolean validStartEnd = isValidStartEnd(tokens[0], tokens[1]);
                    //boolean validPho = isValidPhoneme(tokens[2]);
                    //System.out.println("Booleans: " + validStartEnd + " " + validPho);
                    
                    
                	// if the sample numbers given are valid and it is a recognisable phoneme
                    if (isValidStartEnd(tokens[0], tokens[1])) {
                    	
                    	if (isValidPhoneme(tokens[2])) {
                    	
                    		//retrieve the start and end sample nos from the tokens
                            int startSampleNo = Integer.parseInt(tokens[0].trim());
                            int endSampleNo = Integer.parseInt(tokens[1].trim() );
                            
                            // retrieve the phoneme from the tokens and find its type
                            String type = PhonemeRecord.findType(tokens[2]);
                            
                            
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
                        } else {
                        	System.out.println("Invalid line of data. Line skipped.");
                        }
                    	
                    	} else {
                    		System.out.println("Invalid phoneme: " + tokens[2]);
                    	}
                    } else {
                    	System.out.println("Invalid sample nos: " + tokens[0] + ", " + tokens[1]);
                    }   		
                }

            in.close();
        } else {
        	System.out.println("No such file.");
        	doShutdown();
        }
    }

    private static boolean isValidStartEnd(String st, String end) {

        try {
            Integer.valueOf(st);
            Integer.valueOf(end);
            
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Data invalid. Line skipped.");
        }

        return false;
    }

    private static boolean isValidPhoneme(String testph) {

        if (testph.matches("^[a-z]+$")){
            String t = PhonemeRecord.findType(testph);
            if (!(t.equals("not found"))) return true;  
        }
        return false;
    }

    public static void usage(){
        System.out.println("Usage: java Command [-s samplerate] input_file output_file_stem");
    }//usage
}

