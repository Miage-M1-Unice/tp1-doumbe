package fr.miage.m1.cours;
import java.io.File;
import java.io.FilenameFilter;

public class App {

// Q1:Lister le contenu d'un repertoire

    public void ListerRepertoire1(File f) {
		if(f.isDirectory()) {
			for(String s: f.list()) {
				System.out.println("-> "+s);
			}
		}else{
			System.err.println();
		}
	}
	
// Q2: Parcourir en profondeur de repertoire

	public void ListerRepertoire2(File f) {
		if(f.exists() && f.isDirectory()) {
			for(int i=0; i<f.listFiles().length; i++) {
				if(f.listFiles()[i].isFile()) {
					System.out.println("fichier: "+f.listFiles()[i].getName());
				}else{
					System.out.println("répertoire: "+f.listFiles()[i].getName());
					for(int j=0; j<f.listFiles()[i].listFiles().length; j++) {
						if(f.listFiles()[i].listFiles()[j].isFile()) {
							System.out.println("fichier: "+f.listFiles()[i].listFiles()[j].getName());
						}else{
							System.out.println("-> répertoire: "+f.listFiles()[i].listFiles()[j].getName());
							ListerRepertoire1(f.listFiles()[i].listFiles()[j]);
						}
					}
				}
			}
		}else{
			System.err.println();
		}
	}
	
	// Q3: Creation de filtre dans une classe interne anonyme (anonymous inner class)

	public void ListerRepertoire3(File f,FilenameFilter ff) {
		if(f.exists() && f.isDirectory()) {
			for(int i=0; i<f.listFiles(ff).length; i++) {
				if(f.listFiles(ff)[i].isFile()) {
					System.out.println("fichier: "+f.listFiles(ff)[i].getName());
				}else{
					System.out.println("répertoire: "+f.listFiles(ff)[i].getName());
					for(int j=0; j<f.listFiles(ff)[i].listFiles(ff).length; j++) {
						if(f.listFiles(ff)[i].listFiles(ff)[j].isFile()) {
							System.out.println("fichier: "+f.listFiles(ff)[i].listFiles(ff)[j].getName());
						}else{
							System.out.println("-> répertoire: "+f.listFiles(ff)[i].listFiles(ff)[j].getName());
							ListerRepertoire1(f.listFiles(ff)[i].listFiles(ff)[j]);
						}
					}
				}
			}
		}else{
			System.err.println();
		}
	}

    public static void main( String[] args ){
		App a = new App();
		File f = new File("C:\\Users\\deptinfo\\Documents\\Master_Miage_S2");
		FilenameFilter ff = new FilenameFilter() {
				//apply a filter
				@Override
				public boolean accept(File dir, String name) {
					boolean result;
					return name.contains("IOT");
				}
			};
		//a.ListerRepertoire1(f);
		//a.ListerRepertoire2(f);
		a.ListerRepertoire3(f,ff);
    }
}
