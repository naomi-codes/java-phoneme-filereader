package main;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import helper.PhonemeRecord;
import helper.Printer;
import phonemes.Phoneme;
import phonemes.TypeAffricative;
import phonemes.TypeClosure;
import phonemes.TypeFricative;
import phonemes.TypeNasal;
import phonemes.TypeOthers;
import phonemes.TypeSemivowel;
import phonemes.TypeStop;

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
    private static PhonemeRecord myPhonemes = new PhonemeRecord();
    
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
        if (checkFileType(args[0])) {
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

        if (checkFileType(args[2])) {
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

    private static boolean checkFileType(String filename) {
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

        if (in != null) {
            while (in.hasNextLine()){
                String line = in.nextLine(); 
                System.out.println("Line read in: " + line); 
                String delims = " ";
                String[] tokens = line.split(delims); // start sample no, end sample no, phoneme held in tokens
                for (String s : tokens) {
                    System.out.println(s);
                }
                System.out.println("Token length: " + tokens.length);
                if (tokens.length  == 3) {
                    boolean validLine = false;

                    boolean validStartEnd = validateStartEnd(tokens[0], tokens[1]);
                    boolean validPho = validatePho(tokens[2]);
                    System.out.println("Booleans: " + validStartEnd + " " + validPho);
                    if (validStartEnd && validPho){ validLine = true;}

                    if (validLine){

                        int startSampleNo = Integer.parseInt(tokens[0].trim());
                        int endSampleNo = Integer.parseInt(tokens[1].trim() );
                        String ph = tokens[2];
                        String type = PhonemeRecord.findType(ph);
                        
                        /** CONTINUE FROM HERE WHEN TURNING BACK ON */
                        //
                        //
                        //
                        //
                        //
                        //
                        //
                        
                        
                        
                        switch(type) {
                        case "affricative":
                        	break;
                        case "closure"
                        }
                        if (type.equals("affricative")){
                            Phoneme p = new TypeAffricative(startSampleNo, endSampleNo, ph, type);
                            myPhonemes.addPhoneme(p);}
                        else if (type.equals("closure")) { 
                            Phoneme p = new TypeClosure(startSampleNo, endSampleNo, ph, type);
                            myPhonemes.addPhoneme(p);}
                        else if (type.equals("stop")) { 
                            Phoneme p = new TypeStop(startSampleNo, endSampleNo, ph, type);
                            myPhonemes.addPhoneme(p);}
                        else if (type.equals("nasal")) {
                            Phoneme p = new TypeNasal(startSampleNo, endSampleNo, ph, type);
                            myPhonemes.addPhoneme(p);}
                        else if (type.equals("fricative")) {
                            Phoneme p = new TypeFricative(startSampleNo, endSampleNo, ph, type);
                            myPhonemes.addPhoneme(p);}
                        else if (type.equals("semivowel")) {
                            Phoneme p = new TypeSemivowel(startSampleNo, endSampleNo, ph, type);
                            myPhonemes.addPhoneme(p);}
                        else if (type.equals("vowel")) {
                            Phoneme p = new TypeOthers(startSampleNo, endSampleNo, ph, type);
                            myPhonemes.addPhoneme(p);} 
                        else {
                            System.out.println("Data invalid. Line skipped.");
                        }

                    }
                } else {
                    System.out.println("Data invalid. Line skipped.");
                }
            }
            in.close();

        }
    }

    private static boolean isValidStartEnd(String st, String end) {

        boolean validInput = false;

        try {
            Integer.valueOf(st);
            Integer.valueOf(end);
            
            validInput = true;
        } catch (NumberFormatException e) {
            System.out.println("Data invalid. Line skipped.");
        }

        return validInput;
    }

    private static boolean isValidPhoneme(String testph) {
        boolean typeFound = false;

        if (testph.matches("^[a-z]+$")){
            String t = PhonemeRecord.findType(testph);
            if (!(t.equals("not found"))) typeFound = true;  
        }
        return typeFound;
    }

    public static void usage(){
        System.out.println("Usage: java Command [-s samplerate] input_file output_file_stem");
    }//usage
}

