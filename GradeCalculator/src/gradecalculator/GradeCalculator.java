package gradecalculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GradeCalculator {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new FileReader("studentinfo.txt"));
                FileWriter writer = new FileWriter("calculated.txt")){
            String student ;
            
            while(scanner.hasNextLine()){
                student = scanner.nextLine();
                String[] splitted = student.split(",");
                writer.write(splitted[0]);
                writer.write(" " + CalculateGrade(Integer.parseInt(splitted[1]),Integer.parseInt(splitted[2]),Integer.parseInt(splitted[3])));
                System.out.println(Integer.parseInt(splitted[1]));
                System.out.println(Integer.parseInt(splitted[2]));
                System.out.println(Integer.parseInt(splitted[3]));
                        
                writer.write("\n");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GradeCalculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GradeCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String CalculateGrade(int a, int b , int c){
        int finalgrade = ((a*2)/10 + (b*2)/10 + (c*6)/10) ; 
        if (finalgrade >= 90)
            return "AA";
        else if (finalgrade >= 85)
            return "BA";
        else if (finalgrade >= 80)
            return "BB";
        else if (finalgrade >= 75)
            return "CA";
        else if (finalgrade >= 70)
            return "CC";
        else if (finalgrade >= 65)
            return "DD";
        else if (finalgrade >= 60)
            return "EE";
        else 
            return "FF";  
    }
    
}
