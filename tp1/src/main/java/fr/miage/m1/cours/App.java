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

	public void ListerRepertoire3(File f, MonFiltre ff){
		if(f.exists() && f.isDirectory()){
			for(File fi: f.listFiles(ff)){
				if(fi.isFile()){
					System.out.println("fichier: "+fi.getName());
				}else{
					System.out.println("répertoire: "+fi.getName());
				}
			}
			for(File fi: f.listFiles()){
				try{
					if(fi.isDirectory()){
						ff.ListerRepertoire(fi);
					}
				}catch(Exception e){
					//TODO: handle exception
					//e.printStackTrace();
				}
			}
		}else{
			System.err.println();
		}
	}

	public static void main( String[] args ){
	App a = new App();
	File f = new File("C:\\Users\\deptinfo\\Documents\\Master_Miage_S2");
	MonFiltre ff = new MonFiltre("Cours");// Cours
	//a.ListerRepertoire1(f);
	//a.ListerRepertoire2(f);
	a.ListerRepertoire3(f,ff);
	}
}
