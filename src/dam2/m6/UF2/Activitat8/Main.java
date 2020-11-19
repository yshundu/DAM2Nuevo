package dam2.m6.UF2.Activitat8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        Scanner sc = new Scanner(System.in);
        int acabado=0;
        int opcio=0;
        String nom;
        String fechaComText;
        Date fechaBaseDeDades;
        int anys;
        boolean cotxePersonal;
        String modelCotxes;
        Date dataIngres;
        int anyMatriculacio;
        boolean averiat;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/act8.odb");
        EntityManager em = emf.createEntityManager();

        // Store 1000 Point objects in the database:
        em.getTransaction().begin();
        while (acabado!=1){
            System.out.println("1. Introduir propietari.");
            System.out.println("2. Introduir cotxes.");
            System.out.println("3. Sortir.");
            System.out.println("Introdueix opcio: ");
            opcio = sc.nextInt();
            if(opcio==1){
               System.out.println("Introdueix nom:"); 
               nom = sc.next();
               System.out.println("Introdueix data en la base de dades:"); 
               fechaComText = sc.next();
               fechaBaseDeDades = sdf.parse(fechaComText);
               System.out.println("Introdueix any:"); 
               anys = sc.nextInt();
               System.out.println("Es cotxe personal: "); 
               cotxePersonal = sc.nextBoolean();
               
                Propietaris p = new Propietaris(nom, fechaBaseDeDades, anys, cotxePersonal);
                em.persist(p);
                }else if(opcio==2){
               System.out.println("Introdueix model cotxes:"); 
               modelCotxes = sc.next();
               System.out.println("Introdueix data d'ingres del cotxe:"); 
               fechaComText = sc.next();
               dataIngres = sdf.parse(fechaComText);
               System.out.println("Introdueix any matriculacio:"); 
               anyMatriculacio = sc.nextInt();
               System.out.println("El cotxe esta averiat? "); 
               averiat = sc.nextBoolean();
               
                Cotxes c = new Cotxes(modelCotxes, dataIngres, anyMatriculacio, averiat);
                em.persist(c);
                }else if(opcio==3){
                    acabado = 1;
                }else {
                System.out.println("Opcio no valida, torna a intentar."); 
                }
        }
        em.getTransaction().commit();

        // Retrieve all the Point objects from the database:
        TypedQuery<Propietaris> query =
            em.createQuery("SELECT p FROM Propietaris p", Propietaris.class);
        List<Propietaris> results = query.getResultList();
        for (Propietaris p : results) {
            System.out.println(p);
        }
        
          TypedQuery<Cotxes> query2 =
            em.createQuery("SELECT c FROM Cotxes c", Cotxes.class);
        List<Cotxes> results2 = query2.getResultList();
        for (Cotxes c : results2) {
            System.out.println(c);
        }

        // Close the database connection:
        em.close();
        emf.close();
    }
}