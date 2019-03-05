package fr.miage.m1.cours;

import java.lang.reflect.*;

public class AnalyseurDeClasse{
    Class<?> c;
    
    public AnalyseurDeClasse(String nomClasse) throws ClassNotFoundException{
        c = Class.forName(nomClasse);
    }
    
    private void afficheEnTeteClasse() throws ClassNotFoundException{
        int modifier = c.getModifiers();
        // affiche le nom de la classe 
        System.out.print(java.lang.reflect.Modifier.toString(modifier)+" class "+c.getName()+" ");
        if(c.getSuperclass()!=null && c.getSuperclass()!=Object.class){
            System.out.print("extends "+c.getSuperclass()+" "); // si classe parent exist affiche la classe
        }

        if(c.getInterfaces().length!=0) {
            int testindice = c.getInterfaces().length-1;
            System.out.print("implements ");
            for(int i=0; i<c.getInterfaces().length; i++) {
                System.out.print(c.getInterfaces()[i].getName());
                if(i<testindice) {
                    System.out.print(",");
                }
            }
        }
        System.out.println("{");
    }
    
    private void afficheAttributs() throws ClassNotFoundException{
        System.out.println("// Champs");
        Field[] champs = c.getDeclaredFields();
        for(Field field: champs){
            int modif = field.getModifiers();
            System.out.println("  "+java.lang.reflect.Modifier.toString(modif)+" "+field.getType()+" "+field.getName()+";");
        }
    }

    private void afficheConstructeurs() throws ClassNotFoundException{
        System.out.println("\n// Constructeurs");
        Constructor<?>[] constructeurs = c.getDeclaredConstructors();
        for(Constructor<?> cons: constructeurs) {
            int modif = cons.getModifiers();
            System.out.print("  "+java.lang.reflect.Modifier.toString(modif)+" "+cons.getName()+" (");
            Class<?>[] parameters = cons.getParameterTypes();
            for(int i=0; i<parameters.length; i++) {
                System.out.print(parameters[i]);
                if(i<parameters.length-1) {
                    System.out.print(",");
                }
            }
            System.out.println(");");		
        }
    }

    public void analyseClasse() throws ClassNotFoundException{
        afficheEnTeteClasse();
        afficheAttributs();
        afficheConstructeurs();
    }

    public static void main(String[] args) throws ClassNotFoundException{
        AnalyseurDeClasse ac = new AnalyseurDeClasse("java.awt.Point");
        ac.analyseClasse();
    }
}