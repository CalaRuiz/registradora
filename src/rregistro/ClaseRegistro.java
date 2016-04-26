/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 */
package rregistro;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rregistro.Asociado;
import rregistro.Registradora;
    
    
  
public class ClaseRegistro {
    
    private static EntityManagerFactory emf ;
    private static EntityManager em ;
    private static String dato;
    
    public static Asociado crearAsociado(String asociado){
        Asociado As = new Asociado();
        As.setNombre(asociado);
        em.persist(As);
        return As;
   
    }
 
    public Asociado buscarAsociado( String nombre){
        Asociado As=new Asociado();
        System.out.println("Ingrese su nombre a buscar ");
        As=em.find(Asociado.class,As.getNombre());
        return As;
    }
    
    public static Registradora crearRegistro(String fecha ,String nombre){
        Registradora Re = new Registradora();
        Asociado Ass = new Asociado();
        Ass.setNombre(nombre);
        Ass=em.find(Asociado.class,Ass.getNombre());
        Re.setIdAsociado(Ass);
        em.persist(Re);
        //Re.setAsociado(Ass);
        return Re;
        
       
      
      
    }
    public  Registradora actualizarRegistro( Registradora registradora ,Date fechaNew )
    {
        Registradora Re = new Registradora();
       Asociado As1 = new Asociado();
        Scanner v = new Scanner(System.in);
        
        
        System.out.println("Ingrese el nombre del Asociado");
        As1.setNombre(v.nextLine());
        As1 = em.find(Asociado.class, As1.getNombre());
        registradora.setAsociado(As1);
       // registradora = em.merge(registradora)
        System.out.println("Introduzca la fecha con formato dd/mm/yyyy");
        registradora.setfecha(v.nextLine());
        registradora = em.merge(registradora);
        return registradora;
     
                 
    }
        
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("RregistroPU");
         em = emf.createEntityManager();
         
        
         Scanner in = new Scanner(System.in);
         Scanner s = new Scanner(System.in);
         Scanner b = new Scanner(System.in);
         Scanner r=new Scanner(System.in);
          
          Asociado As=new Asociado();
          Registradora re =new Registradora();
      
          em.getTransaction().begin();
      //crear Asociado
        System.out.println("Ingrese Asociado");
        crearAsociado(in.nextLine());
            
     //Buscar Asociado
        System.out.println("Ingrese su nombre a buscar ");
        As.setNombre(b.nextLine());
        
        System.out.println("Asociado buscado  = "+As.getNombre( ));
       
       //Crear registro 
       
      System.out.println("Ingrese nombre registro "); 
         //Ass.setNombre(r.nextLine());
     As.setNombre(r.nextLine());
       
         
         
         
         
         
         
         
         
         
         

 
        em.getTransaction().commit();

        em.close();
        emf.close();
        
        
    
    } }