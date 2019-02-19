package fr.miage.m1.cours;
import java.io.File;  
import java.io.FileNotFoundException;   
import java.util.Scanner;   
    
public class SeLit{  
    void lecture(Scanner source){
        while(source.hasNextLine()){  
            String s = source.nextLine();          
            System.out.println(s);
            // A modifier
        }
        source.close();
    }  
    
    static public void main(String[] args){
        SeLit sl = new SeLit();
        try {
            File f=new File("C:\\Users\\deptinfo\\Documents\\Master_Miage_S2\\Programmation Avancée\\TP1\\tp1-doumbe\\tp1\\src\\main\\java\\fr\\miage\\m1\\cours\\SeLit.java");
            Scanner sc=new Scanner(f);
            sl.lecture(sc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}