/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv08;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author maresj29
 */
public class WhitespaceReplace { 
    private char[] buffer;
    
    public WhitespaceReplace() {
        buffer = new char[128];
        Arrays.fill(buffer, 'x');
    }
    
    public void replace(String filein, String fileout) {
        try (FileReader fr = new FileReader(filein)) {
            int i = 0;
            
            int c;
            while ((c = fr.read()) != -1) {
                if(Character.isWhitespace((char) c))
                    buffer[i] = ' ';
                else
                    buffer[i] = (char)c;
                i++;
            }
        } catch (IOException e) {
            System.out.println("File reading error!");
            System.out.println(e);
        }
        
        try (FileWriter fw = new FileWriter(fileout)) {
            fw.write(buffer);
            
        } catch (IOException e) {
            System.out.println("File writing error!");
            System.out.println(e);
        }
        
    }
    
    public void numberLine(String filein, String fileout) {
        try (FileReader fr = new FileReader(filein)) {
            int i = 2;
            char lineCount = '1';
            buffer[0] = lineCount;
            buffer[1] = ' ';
            lineCount++;
            
            int c;
            while ((c = fr.read()) != -1) {
                if((char) c == '\n') {
                    buffer[i++] = '\n';
                    buffer[i++] = lineCount;
                    buffer[i++] = ' ';
                    lineCount++;
                } else {
                    buffer[i++] = (char)c;
                }
            }
        } catch (IOException e) {
            System.out.println("File reading error!");
            System.out.println(e);
        }
        
        try (FileWriter fw = new FileWriter(fileout)) {
            fw.write(buffer);            
        } catch (IOException e) {
            System.out.println("File writing error!");
            System.out.println(e);
        }
    }
    
    public int wordCount(String file) {
        int wordCount = 0;
        
        try (Scanner s = new Scanner(new FileInputStream(file))) {           
            String ln;
            String[] words;
            while (s.hasNextLine()) {
                ln = s.nextLine();
                words = ln.split("\\s");
                wordCount += words.length;
            }
            
            return wordCount;
        } catch (IOException e) {
            System.out.println("File reading error!");
            System.out.println(e);
            return -1;
        }
    }
    
    public void textToBinary(String fileout) {
        Scanner s = new Scanner(System.in);
        
    }
}
