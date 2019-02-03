/**
 * Calculadora
 * 
 * @author Jesús Téllez Serrano 
 * @version 0.0.5
 */

import java.util.*;

public class calc
{ 
   static Scanner input = new Scanner(System.in);
   public static void main (String [] args){
       int n1, n2, sol;
       char menu;
       
       
       System.out.println("BIENVENIDO A LA CALCULADORA \n");
       
       
       do{
           System.out.println("Menú");
           System.out.println("Introduzca * para realizar la multiplicación rusa recursiva");
           System.out.println("Introduzca m para realizar la multiplicación rusa iteratica");
           System.out.println("Introduzca d para realizar la conversión decimal - binario");
           System.out.println("Introduzca b para realizar la conversión binario - decimal");
           System.out.println("Introduzca o para realizar la conversión decimal - binario en array");
           System.out.println("Introduzca c para realizar la conversión binario - decimal en array");
           System.out.println("Introduzca x para salir \n");
           menu = input.next().charAt(0);
           switch (menu){
               case 'x':
                    System.out.println("Adios");  
                    break;
                    
               case '*':
                    System.out.println("Introduzca el primer número: "); 
                    n1=input.nextInt();
                    System.out.println("Introduzca el segundo número: ");
                    n2=input.nextInt();
                    sol = multrusa (n1,n2);
                    System.out.println("La solución de la multiplicación es:"+sol);
                    break;
               case 'm':
                    System.out.println("Introduzca el primer número: "); 
                    n1=input.nextInt();
                    System.out.println("Introduzca el segundo número: ");
                    n2=input.nextInt();
                    sol = multrusait (n1,n2);
                    System.out.println("La solución de la multiplicación es:"+sol);
                    break;
               case 'd':
                    System.out.println("Introduzca el primer número: "); 
                    n1=input.nextInt();
                    sol = decbin (n1);
                    System.out.println("La conversion de n1 "+n1+" -> "+sol);
                    
                    break;
               
               case 'b':
                    System.out.println("Introduzca el primer número: "); 
                    n1=input.nextInt();
                    sol = bindec (n1);
                    System.out.println("La conversion de n1 "+n1+" -> "+sol);
                    break;
                    
               case 'o':
                    System.out.println("Introduzca el primer número: "); 
                    n1=input.nextInt();
                    System.out.println("La conversion de n1 es");
                    Mostrar (decarbin (n1));
                    System.out.println("\n\n");
                    break;
                    
               case 'c':
                    System.out.println("Introduzca el primer número: "); 
                    n1=input.nextInt();
                    System.out.println("La conversion de n1 es");
                    Mostrar (binardec (n1));
                    System.out.println("\n\n");
                    break;
                
               default:
                    System.out.println("La entrada del menú no es correcta");
                    
                    break;
           }
       }while (menu != 'x');
       }
   static int multrusa (int s1, int s2){
       if (s1 >= 1){
           if ( s1%2 != 0 )
                return s2 + multrusa (s1/2,s2*2);
           return multrusa (s1/2,s2*2);
       }
       else
            return 0;
   }
   static int multrusait (int s1, int s2){
       int sol = 0, aux1 = Math.abs(s1), aux2 = Math.abs(s2);
       while (aux1 >= 1){
           if ( aux1%2 != 0 )
                sol = sol + aux2;
           aux1=aux1/2;
           aux2 = aux2 *2;
       }
       if (s2<0)
            sol = -sol;
       if (s1<0)
            sol = -sol;
       return sol;
   }
   static int decbin (int s1){
       if (s1>=2)
           return s1%2  + 10*decbin (s1/2);
       else
           return s1;
   }
   public static int contdig (int s1){
       if ( s1==0)
           return 0;
       else
           return 1 + contdig (s1 /10);
   }
   static int potencia (int s1, int s2){
       if ( s2 == 0)
           return 1;
       else
           return s1 * potencia (s1,s2-1);
   }
   static int bindec (int s1){
       if (s1==0){
            return 0;
       }
       else
            return  potencia(2, contdig (s1)-1)* (s1 / potencia (10, contdig (s1)-1))  + bindec (s1 % potencia (10,contdig (s1)-1));
   }
   static int[] decarbin (int n1){
       int vector[],sol = 0, cont = 0, i;
       while (n1 != 0){
           sol = sol + (n1%2) * potencia(10, cont); 
           n1 =n1 / 2;
           cont ++;
       }
       vector = new int [cont];
       for (i = cont-1; i >= 0; i--){
           vector [i] = sol%10;
           sol = sol /10;
       }
       return  vector;  
   }
   static int[] binardec (int n1){
       int vector[],ndig,sol = 0,cont = 0, i;
       while (n1 > 0){
           sol = sol  + potencia(2,cont)*(n1 %10); 
           n1 =n1 / 10;
           cont++;
       }
       ndig = contdig(sol);
       vector = new int [ndig];
       for (i = ndig-1; i >= 0; i--){
           vector [i] = sol%10;
           sol = sol /10;
       }
       return  vector;  
   }
   public static void Mostrar (int v []){
       for (int i=0; i<v.length; i++) 
            System.out.print (v [i] + " ");
   }
}
   
   
  