package fr.miage.m1.cours;
import java.io.File;

public class App {

    public void ListerRepertoire(File f) {
		if(!f.isDirectory()) {
			System.err.println();
		}
		else {
			for(String s: f.list()) {
				System.out.println(s);
			}
		}
	}
	
	public void ListerRepertoire1(File f) {
		if(!f.exists() || !f.isDirectory()) {
			System.err.println();
		}
		else {
			for(int i=0; i<f.listFiles().length; i++) {
				if(f.listFiles()[i].isFile()) {
					System.out.println("\t fichier: "+f.listFiles()[i].getName());
				}
				else {
					System.out.println("\t ==> répertoire: "+f.listFiles()[i].getName());
					for(int j=0; j<f.listFiles()[i].listFiles().length; j++) {
						if(f.listFiles()[i].listFiles()[j].isFile()) {
							System.out.println("\t \t fichier: "+f.listFiles()[i].listFiles()[j].getName());
						}
						else {
							ListerRepertoire1(f.listFiles()[i].listFiles()[j]);
						}
					}
				}
			}
		}
    }
     

      
    public static void main( String[] args ){

        File f = new File("C:\\Users\\deptinfo\\Documents\\Master_Miage_S2");
        System.out.println(f.getAbsolutePath());
        String[] liste=f.list();
        for (int i=0; i<liste.length; i++) {
            File ff=new File(liste[i]);
            if (ff.isDirectory()) System.out.println("Dossier \t"+liste[i]);
            else System.out.println(""+ff.length()+" \t"+liste[i]);
        }
    }
}
