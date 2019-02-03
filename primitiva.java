/**
 * Primitiva
 * 
 * @author Jesús Téllez Serrano 
 * @version 0.0.5
 */

import java.util.*;

public class primitiva
{ 
   static Scanner input = new Scanner(System.in);
   public static void main (String [] args){
       int prim[], premio[], rep;
       char menu;
       prim = new int [6];
       premio = new int [6];
       
       System.out.println("BIENVENIDO A LA CALCULADORA \n");
       
       
       do{
           System.out.println("Menú");
           System.out.println("Introduzca a para introducir los números de la primitiva");
           System.out.println("Introduzca b para generar aleatoriamente los números de la primitiva");
           System.out.println("Introduzca x para salir \n");
           menu = input.next().charAt(0);
           switch (menu){
               case 'x':
                    System.out.println("Adios");  
                    break;
                    
               case 'a':
                    prim = pedirnum();
                    mostrar(prim);
                    System.out.println(" ");
                    break;
               case 'b':
                    prim = aleatorio();
                    mostrar(prim);
                    System.out.println(" ");
                    break;
               default:
                    System.out.println("La entrada del menú no es correcta");
                    
                    break;
           }
		   if (menu != 'x'){
				premio = aleatorio();
				mostrar(premio);
				System.out.println(" ");
				prim = burbuja (prim);
				premio = burbuja (premio);
				mostrar (prim);
				System.out.println(" ");
				mostrar(premio);
				System.out.println(" ");
				rep = busquedabinaria(prim, premio);
				System.out.println("Han coincidido "+rep+" de 6");
		   }
       }while (menu != 'x');
   }
   static int[] pedirnum (){
       int cont =0, n, vector[];
       vector = new int [6];
       
       while (cont < 6){
           System.out.println("Introduzca número entre el 1 y el 49: "); 
           n=input.nextInt();
           if (n > 0 && n <50){
               vector[cont]=n;
               cont++;
           }
           else
               System.out.println("El número no está en el rango permitido");
       }
       
       return vector;
   }
   static int[] aleatorio(){
       int n, cont=0, vector [];
       vector = new int[6];
       
       while (cont < 6){
           n = randomrango (1,49); 
           if (!estaenarray(n,vector)){
                vector[cont]= n;
                cont++;
           }
       }
       return vector;
   }
    static void mostrar (int v []){
       for (int i=0; i<v.length; i++) 
            System.out.print (v [i] + " ");
   }
   static int randomrango ( int min, int max){
       Random rn = new Random();
       return (rn.nextInt((max - min) + 1) + min);       
   }
   static boolean estaenarray (int n, int v[]){
       int cont;
       for (cont = 0; cont < 6; cont++){
           if (v[cont] == n)
                return true;
       }
       return false;
   }
   static int[] burbuja (int v[]){
       int cont,cont1 ,x=0, aux;
       for (cont = 0; cont < 6; cont++){
           for (cont1 = 0; cont1 < 5; cont1++){
               if (v[cont1] > v[cont1+1]){
                   aux = v[cont1];
                   v[cont1]=v[cont1+1];
                   v[cont1+1] = aux;
               }
           }
       }
       return v;
   }
   static int busquedabinaria (int v[], int x[]){
       int cont , cont1, p, m, f, encontrado = 0;
       
       for (cont = 0; cont < 6; cont++){
           p = 0;
           f = 5;
           while (p<=f){
               m = (p+f)/2;
               if (v[cont]< x[m]){
                   f = m-1;
               }
               else if (v[cont]> x[m]){
                   p= m+1;
               }
               else{
                   encontrado++;
                   p = f+1;
               }
           }
       }
       return encontrado;
   }
}
   
   