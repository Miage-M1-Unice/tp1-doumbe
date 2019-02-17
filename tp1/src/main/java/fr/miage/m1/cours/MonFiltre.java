package fr.miage.m1.cours;
import java.io.File;
import java.io.FilenameFilter;

public class MonFiltre implements FilenameFilter{
    String filtre;

    public MonFiltre(String f){
        filtre=f;
    }

    //apply a filter
    @Override
    public boolean accept(File dir, String name){
        boolean result;
        return name.contains(filtre);
    }

    public void ListerRepertoire(File f){
		if(f.isDirectory()){
			for(String s: f.list()){
				if(s.contains(filtre)) System.out.println(f.getName()+" -> "+s);
			}
		}else{
			System.err.println();
		}
	}
}