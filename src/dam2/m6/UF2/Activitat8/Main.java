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
        boolean esManual;
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
               nom = sc.nextLine();
               System.out.println("Introdueix data en la base de dades:"); 
               fechaBaseDeDades = sdf.parse(fechaComText = sc.next());
               System.out.println("Introdueix any:"); 
               anys = sc.nextInt();
               System.out.println("Es cotxe personal: "); 
               cotxePersonal = sc.nextBoolean();
               
                Propietaris p = new Propietaris(nom, fechaBaseDeDades, anys, cotxePersonal);
                em.persist(p);
                }else if(opcio==2){
               System.out.println("Introdueix model cotxes:"); 
               modelCotxes = sc.nextLine();
               System.out.println("Introdueix data d'ingres del cotxe:"); 
               dataIngres = sdf.parse(fechaComText = sc.next());
               System.out.println("Introdueix any matriculacio:"); 
               anyMatriculacio = sc.nextInt();
               System.out.println("Es cotxe manual? "); 
               esManual = sc.nextBoolean();
               
                Cotxes c = new Cotxes(modelCotxes, dataIngres, anyMatriculacio, esManual);
                em.persist(c);
                }else if(opcio==3){
                    acabado = 1;
                }else {
                System.out.println("Opcio no valida, torna a intentar."); 
                }
        }
        em.getTransaction().commit();

        // Find the number of Point objects in the database:
        Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
        System.out.println("Total Points: " + q1.getSingleResult());

        // Find the average X value:
        Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
        System.out.println("Average X: " + q2.getSingleResult());

        // Retrieve all the Point objects from the database:
        TypedQuery<Point> query =
            em.createQuery("SELECT p FROM Point p", Point.class);
        List<Point> results = query.getResultList();
        for (Point p : results) {
            System.out.println(p);
        }

        // Close the database connection:
        em.close();
        emf.close();
    }
}