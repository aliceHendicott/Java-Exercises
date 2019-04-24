package junit.BioLibrary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

class BioLibraryTests {

    Sequence sequence;
    private Throwable thrown;

    @Test
    public void TestDNAValid(){
        thrown = assertThrows(SequenceException.class, () -> {
            sequence = new Sequence("BCCS", Type.DNA);
        });
        assertEquals("DNA must contain only the letters A, C, G, and T.", thrown.getMessage());
    }

    @Test
    public void TestRNAValid(){
        thrown = assertThrows(SequenceException.class, () -> {
            sequence = new Sequence("BCCS", Type.RNA);
        });
        assertEquals("RNA must contain only the letters A, U, G, and C.", thrown.getMessage());
    }

    @Test
    public void TestToStringDNA(){
        try {
            sequence = new Sequence("ACGT", Type.DNA);
        } catch (SequenceException e){
            System.out.println("You have entered an incorrect sequence");
        }
        String expected = "ACGT";
        String actual = sequence.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void TestToStringRNA(){
        try {
            sequence = new Sequence("ACGU", Type.RNA);
        } catch (SequenceException e){
            System.out.println("You have entered an incorrect sequence");
        }
        String expected = "ACGU";
        String actual = sequence.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void TestGetTypeDNA(){
        try {
            sequence = new Sequence("AGGT", Type.DNA);
        } catch (SequenceException e){
            System.out.println("You have entered an incorrect sequence");
        }
        Type expected = Type.DNA;
        Type actual = sequence.getType();
        assertEquals(expected, actual);
    }

    @Test
    public void TestGetTypeRNA(){
        try {
            sequence = new Sequence("AUGG", Type.RNA);
        } catch (SequenceException e){
            System.out.println("You have entered an incorrect sequence");
        }
        Type expected = Type.RNA;
        Type actual = sequence.getType();
        assertEquals(expected, actual);
    }

    @Test
    public void TestReverseComplimentDNA(){
        try {
            sequence = new Sequence("AGGT", Type.DNA);
        } catch (SequenceException e){
            System.out.println("You have entered an incorrect sequence");
        }
        String str = "AGGT";
        char[] rc = str.toCharArray();
        Map<Character, Character> table = Sequence.complementDNA;
        for (int i = 0; i < str.length(); i++) {
            rc[i] = table.get(rc[i]);
        }
        String expected = new String(rc);
        try {
            String actual = sequence.reverseComplement();
            assertEquals(expected, actual);
        } catch (SequenceException e){
            System.out.println("You have entered an incorrect type");
        }
    }

    @Test
    public void TestReverseComplimentRNA(){
        try {
            sequence = new Sequence("AGGU", Type.RNA);
        } catch (SequenceException e){
            System.out.println("You have entered an incorrect sequence");
        }
        String str = "AGGU";
        char[] rc = str.toCharArray();
        Map<Character, Character> table = Sequence.complementRNA;
        for (int i = 0; i < str.length(); i++) {
            rc[i] = table.get(rc[i]);
        }
        String expected = new String(rc);
        try {
            String actual = sequence.reverseComplement();
            assertEquals(expected, actual);
        } catch (SequenceException e){
            System.out.println("You have entered an incorrect type");
        }
    }

    @Test
    public void TestReverseComplimentInvalid(){
        try {
            sequence = new Sequence("AGGU", Type.Peptide);
        } catch (SequenceException e){
            System.out.println("You have entered an incorrect sequence");
        }
        thrown = assertThrows(SequenceException.class, () -> {
            sequence.reverseComplement();
        });
        assertEquals("Undefined sequence type for reverse complement.", thrown.getMessage());
    }

    @Test
    public void TestPalindromePeptide(){
        try {
            sequence = new Sequence("AGGU", Type.Peptide);
        } catch (SequenceException e){
            System.out.println("You have entered an incorrect sequence");
        }
        thrown = assertThrows(SequenceException.class, () -> {
            sequence.palindrome();
        });
        assertEquals("Undefined sequence type for reverse complement.", thrown.getMessage());
    }

    @Test
    public void TestPalindromeFalse(){
        try {
            sequence = new Sequence("AGGT", Type.DNA);
        } catch (SequenceException e){
            System.out.println("You have entered an incorrect sequence");
        }
        String str = "AGGT";
        String reverse = new StringBuilder(str).reverse().toString();
        char[] rc = reverse.toCharArray();
        Map<Character, Character> table = Sequence.complementDNA;
        for (int i = 0; i < str.length(); i++) {
            rc[i] = table.get(rc[i]);
        }
        String reverseCompliment = new String(rc);
        boolean expected = str.equals(reverseCompliment);
        boolean actual = true;
        try {
            actual = sequence.palindrome();
        } catch(SequenceException e){
            System.out.println("Invalid sequence for DNA");
        }
        assertEquals(expected, actual);
    }

    @Test
    public void TestPalindromeTrue(){
        try {
            sequence = new Sequence("ACCTAGGT", Type.DNA);
        } catch (SequenceException e){
            System.out.println("You have entered an incorrect sequence");
        }
        String str = "ACCTAGGT";
        String reverse = new StringBuilder(str).reverse().toString();
        char[] rc = reverse.toCharArray();
        Map<Character, Character> table = Sequence.complementDNA;
        for (int i = 0; i < str.length(); i++) {
            rc[i] = table.get(rc[i]);
        }
        String reverseCompliment = new String(rc);
        boolean expected = str.equals(reverseCompliment);
        boolean actual = false;
        try {
            actual = sequence.palindrome();
        } catch(SequenceException e){
            System.out.println("Invalid sequence for DNA - 2");
        }
        assertEquals(expected, actual);
    }

    @Test
    public void TestTranscribeDNA(){
        try {
            sequence = new Sequence("ACCTAGGT", Type.DNA);
        } catch (SequenceException e){
            System.out.println("You have entered an incorrect sequence");
        }
        Sequence expected;
        try{
            expected = new Sequence("ACCUAGGU", Type.RNA);
            try{
                sequence.transcribe();
            } catch(SequenceException e){
                System.out.println("Incorrent DNA sequence");
            }
            assertAll(
                    () -> assertEquals(expected.toString(), sequence.toString()),
                    () -> assertEquals(expected.getType(), sequence.getType())
            );
        } catch(SequenceException e){
            System.out.println("Incorrent RNA sequence");
        }
    }

    @Test
    public void TestTranscribeRNA(){
        try {
            sequence = new Sequence("ACGUCAGU", Type.RNA);
        } catch (SequenceException e){
            System.out.println("You have entered an incorrect sequence");
        }
        Sequence expected;
        try{
            expected = new Sequence("ACGTCAGT", Type.DNA);
            try{
                sequence.transcribe();
            } catch(SequenceException e){
                System.out.println("Incorrent RNA sequence");
            }
            assertAll(
                    () -> assertEquals(expected.toString(), sequence.toString()),
                    () -> assertEquals(expected.getType(), sequence.getType())
            );
        } catch(SequenceException e){
            System.out.println("Incorrent DNA sequence");
        }
    }

    @Test
    public void TestTranscribeNoUOrT(){
        try {
            sequence = new Sequence("ACCAG", Type.RNA);
        } catch (SequenceException e){
            System.out.println("You have entered an incorrect sequence");
        }
        Sequence expected;
        try{
            expected = new Sequence("ACCAG", Type.DNA);
            try{
                sequence.transcribe();
            } catch(SequenceException e){
                System.out.println("Incorrent RNA sequence");
            }
            assertAll(
                    () -> assertEquals(expected.toString(), sequence.toString()),
                    () -> assertEquals(expected.getType(), sequence.getType())
            );
        } catch(SequenceException e){
            System.out.println("Incorrent DNA sequence");
        }
    }

    @Test
    public void TestTranscribeInvalid(){
        try {
            sequence = new Sequence("ACGUCAGU", Type.Peptide);
        } catch (SequenceException e){
            System.out.println("You have entered an incorrect sequence");
        }
        thrown = assertThrows(SequenceException.class, () -> {
            sequence.transcribe();
        });
        assertEquals("Undefined sequence type for transcription.", thrown.getMessage());
    }

}