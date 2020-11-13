package dam2.m6.UF1.Activitat1;


import java.io.*;

public class VeureInfo {
    public static void main(String[] args) {
        
     File f = new File(args[0]);
     String[] arxius = f.list();
     System.out.println("Fet per Yangshun Du");
      if(f.exists()){
         if(f.isDirectory()){
            for (int i = 0; i<arxius.length; i++){
                System.out.println(arxius[i]);
             }
      }
         if (f.isFile()){
                 System.out.println("Nom del fitxer : "+f.getName());
		 System.out.println("Ruta           : "+f.getPath());
		 System.out.println("Ruta absoluta  : "+f.getAbsolutePath());
		 System.out.println("Es pot escriure: "+f.canRead());
		 System.out.println("Es pot llegir  : "+f.canWrite());
		 System.out.println("Grandaria      : "+f.length());
		 System.out.println("Es un directori: "+f.isDirectory());
		 System.out.println("Es un fitxer   : "+f.isFile());

        }
    
    }else{
          System.out.println("No existeix directori ni arxius");
      }
      if(f.isHidden()){
          System.out.println("Directori o arxiu ocult");
      }else{
          System.out.println("Res ocult");
      }
      System.out.println("Ultima modificació fa: "+ (((((f.lastModified() / 1000)/60)/60)/24)-17030) +" dies");
      if ((((((f.lastModified()/1000) /60) /60) /24 )-17030) <3 ){
            System.out.println("Ha sigut modificat els derrers 3 dies");
        }
    }
}
