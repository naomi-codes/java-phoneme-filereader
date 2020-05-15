package helper;





import java.util.*;

import phonemes.Phoneme;
import phonemes.TypeAffricative;
import phonemes.TypeClosure;
import phonemes.TypeFricative;
import phonemes.TypeNasal;
import phonemes.TypeOthers;
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
    private static PrintWriter outAff = null; // Affricatives file output
    private static PrintWriter outClo = null; // Closures file output
    private static PrintWriter outFri = null; // Fricatives file output
    private static PrintWriter outSV = null; // Semivowels file output
    private static PrintWriter outVow = null; // Vowels file output
    private static PrintWriter outSto = null; // Stops file output
    private static PrintWriter outNas = null; // Nasals file output
    private static PrintWriter outOth = null; // Others fileoutput
    
    private static PrintWriter printer = null;
    
    private static String outputFilenameStem = null;

    /**
     * Constructor for objects of class Printer
     */

    public static void setPrinters(String stem) {

            try {
				outAff = new PrintWriter(stem + "Affricatives.txt");
			} catch (FileNotFoundException e0) {
				System.out.println("IOException: Affricatives.txt  not openable - " + e0.getMessage());
			}
				
            try {
				outClo = new PrintWriter(stem + "Closures.txt");
			} catch (FileNotFoundException e1) {
				System.out.println("IOException: Affricatives.txt  not openable - " + e1.getMessage());
				}
            
            
            try {
				outFri = new PrintWriter(stem + "Fricatives.txt");
			} catch (FileNotFoundException e2) {
				System.out.println("IOException: Affricatives.txt  not openable - " + e2.getMessage());
			}
            
            
            try {
				outNas = new PrintWriter(stem + "Nasals.txt");
			} catch (FileNotFoundException e3) {
				System.out.println("IOException: Affricatives.txt  not openable - " + e3.getMessage());
			}
            
            
            try {
				outVow = new PrintWriter(stem + "Vowels.txt");
			} catch (FileNotFoundException e4) {
				System.out.println("IOException: Affricatives.txt  not openable - " + e4.getMessage());
			}
            
            
            try {
				outSV = new PrintWriter(stem + "Semivowels.txt");
			} catch (FileNotFoundException e5) {
				System.out.println("IOException: Affricatives.txt  not openable - " + e5.getMessage());
			}
            
            
            try {
				outSto = new PrintWriter(stem + "Stops.txt");
			} catch (FileNotFoundException e6) {
				System.out.println("IOException: Affricatives.txt  not openable - " + e6.getMessage());
			}
            
            
            try {
				outOth = new PrintWriter(stem + "Others.txt");
			} catch (FileNotFoundException e7) {
				System.out.println("IOException: Affricatives.txt  not openable - " + e7.getMessage());
			} 
    }
    
    

    public static String getOutputFilenameStem() {
		return outputFilenameStem;
	}



	public static void setOutputFilenameStem(String outputFilenameStem) {
		Printer.outputFilenameStem = outputFilenameStem;
	}



	public static void print (int sr) {
        List<Phoneme> ps = PhonemeRecord.getPhonemes();
       
        ListIterator<Phoneme> iter = ps.listIterator();
        while(iter.hasNext())
        {
            Phoneme temp = iter.next();

            if ((temp.getType()).equals("affricative")){
                outAff.printf("%-10s%10s%10s", temp.getStartSampleNo()/sr + "s",
                    temp.getEndSampleNo()/sr+"s", temp.getName() + "\n");
                outAff.flush();
 
            } else if (temp.getType().equals("closure")){
                outClo.printf("%-10s%10s%10s", temp.getStartSampleNo()/sr+"s", 
                    temp.getEndSampleNo()/sr+"s", temp.getName() + "\n");
 
            } else if (temp.getType().equals("fricative")){
                outFri.printf("%-10s%10s%10s", temp.getStartSampleNo()/sr+"s", 
                    temp.getEndSampleNo()/sr+"s", temp.getName() + "\n");                
            } else if (temp.getType().equals("nasal")){
                outNas.printf("%-10s%10s%10s", temp.getStartSampleNo()/sr+"s", 
                    temp.getEndSampleNo()/sr+"s", temp.getName() + "\n");
                
            } else if (temp.getType().equals("vowel")){
                outVow.printf("%-10s%10s%10s", temp.getStartSampleNo()/sr+"s", 
                    temp.getEndSampleNo()/sr+"s", temp.getName() + "\n");
                
            } else if (temp.getType().equals("semivowel")){
                outSV.printf("%-10s%10s%10s", temp.getStartSampleNo()/sr+"s", 
                    temp.getEndSampleNo()/sr+"s", temp.getName() + "\n");
                
            } else if (temp.getType().equals("stop")){
                outSto.printf("%-10s%10s%10s", temp.getStartSampleNo()/sr+"s", 
                    temp.getEndSampleNo()/sr+"s", temp.getName() + "\n");
                
            } else {
                outOth.printf("%-10s%10s%10s", temp.getStartSampleNo()/sr +"s", 
                    temp.getEndSampleNo()/sr+"s", temp.getName() + "\n");
                
            }
        }

        outAff.close();
        outClo.close();
        outFri.close();
        outNas.close();
        outVow.close();
        outSV.close();
        outSto.close();
        outOth.close();

        System.out.println("Total phonemes found: " + ps.size());
        System.out.println("Total count of Affricatives: " + TypeAffricative.getCount());
        System.out.println("Total count of Fricatives: " + TypeFricative.getCount());
        System.out.println("Total count of Closures: " + TypeClosure.getCount());
        System.out.println("Total count of Stops: " + TypeStop.getCount());
        System.out.println("Total count of Nasals: " + TypeNasal.getCount());
        System.out.println("Total count of Semivowels: " + TypeSemivowel.getCount());
        System.out.println("Total count of Vowels: " + TypeVowel.getCount());
        System.out.println("Total count of Others: " + TypeOthers.getCount());

    }
    
    public static void print2 (int sr) {
        List<Phoneme> ps = PhonemeRecord.getPhonemes();
       
        ListIterator<Phoneme> iter = ps.listIterator();
        while(iter.hasNext())
        {
            Phoneme phoneme = iter.next();

            switch (phoneme.getType()) {
            case "affricative":
            	try {
       				outAff = new PrintWriter(stem + "Affricatives.txt");
       			} catch (FileNotFoundException e0) {
       				System.out.println("IOException: Affricatives.txt  not openable - " + e0.getMessage());
       			}
            }
            
       				
                   try {
       				outClo = new PrintWriter(stem + "Closures.txt");
       			} catch (FileNotFoundException e1) {
       				System.out.println("IOException: Affricatives.txt  not openable - " + e1.getMessage());
       				}
                   
                   
                   try {
       				outFri = new PrintWriter(stem + "Fricatives.txt");
       			} catch (FileNotFoundException e2) {
       				System.out.println("IOException: Affricatives.txt  not openable - " + e2.getMessage());
       			}
                   
                   
                   try {
       				outNas = new PrintWriter(stem + "Nasals.txt");
       			} catch (FileNotFoundException e3) {
       				System.out.println("IOException: Affricatives.txt  not openable - " + e3.getMessage());
       			}
                   
                   
                   try {
       				outVow = new PrintWriter(stem + "Vowels.txt");
       			} catch (FileNotFoundException e4) {
       				System.out.println("IOException: Affricatives.txt  not openable - " + e4.getMessage());
       			}
                   
                   
                   try {
       				outSV = new PrintWriter(stem + "Semivowels.txt");
       			} catch (FileNotFoundException e5) {
       				System.out.println("IOException: Affricatives.txt  not openable - " + e5.getMessage());
       			}
                   
                   
                   try {
       				outSto = new PrintWriter(stem + "Stops.txt");
       			} catch (FileNotFoundException e6) {
       				System.out.println("IOException: Affricatives.txt  not openable - " + e6.getMessage());
       			}
                   
                   
                   try {
       				outOth = new PrintWriter(stem + "Others.txt");
       			} catch (FileNotFoundException e7) {
       				System.out.println("IOException: Affricatives.txt  not openable - " + e7.getMessage());
       			} 
            if ((temp.getType()).equals("affricative")){
                outAff.printf("%-10s%10s%10s", temp.getStartSampleNo()/sr + "s",
                    temp.getEndSampleNo()/sr+"s", temp.getName() + "\n");
                outAff.flush();
 
            } else if (temp.getType().equals("closure")){
                outClo.printf("%-10s%10s%10s", temp.getStartSampleNo()/sr+"s", 
                    temp.getEndSampleNo()/sr+"s", temp.getName() + "\n");
 
            } else if (temp.getType().equals("fricative")){
                outFri.printf("%-10s%10s%10s", temp.getStartSampleNo()/sr+"s", 
                    temp.getEndSampleNo()/sr+"s", temp.getName() + "\n");                
            } else if (temp.getType().equals("nasal")){
                outNas.printf("%-10s%10s%10s", temp.getStartSampleNo()/sr+"s", 
                    temp.getEndSampleNo()/sr+"s", temp.getName() + "\n");
                
            } else if (temp.getType().equals("vowel")){
                outVow.printf("%-10s%10s%10s", temp.getStartSampleNo()/sr+"s", 
                    temp.getEndSampleNo()/sr+"s", temp.getName() + "\n");
                
            } else if (temp.getType().equals("semivowel")){
                outSV.printf("%-10s%10s%10s", temp.getStartSampleNo()/sr+"s", 
                    temp.getEndSampleNo()/sr+"s", temp.getName() + "\n");
                
            } else if (temp.getType().equals("stop")){
                outSto.printf("%-10s%10s%10s", temp.getStartSampleNo()/sr+"s", 
                    temp.getEndSampleNo()/sr+"s", temp.getName() + "\n");
                
            } else {
                outOth.printf("%-10s%10s%10s", temp.getStartSampleNo()/sr +"s", 
                    temp.getEndSampleNo()/sr+"s", temp.getName() + "\n");
                
            }
        }

        outAff.close();
        outClo.close();
        outFri.close();
        outNas.close();
        outVow.close();
        outSV.close();
        outSto.close();
        outOth.close();

        System.out.println("Total phonemes found: " + ps.size());
        System.out.println("Total count of Affricatives: " + TypeAffricative.getCount());
        System.out.println("Total count of Fricatives: " + TypeFricative.getCount());
        System.out.println("Total count of Closures: " + TypeClosure.getCount());
        System.out.println("Total count of Stops: " + TypeStop.getCount());
        System.out.println("Total count of Nasals: " + TypeNasal.getCount());
        System.out.println("Total count of Semivowels: " + TypeSemivowel.getCount());
        System.out.println("Total count of Vowels: " + TypeVowel.getCount());
        System.out.println("Total count of Others: " + TypeOthers.getCount());

    }

}
