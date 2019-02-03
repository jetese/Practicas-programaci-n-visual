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
       int n1, n2, solucion;
       boolean oper;
       char resp;
       
       
       System.out.println("BIENVENIDO A LA CALCULADORA \n");
       System.out.println("Introduzca el primer número: "); 
       n1=input.nextInt();
       System.out.println("Introduzca el segundo número: ");
       n2=input.nextInt();
       
       solucion = calculadora(n1,n2);
       
       System.out.println("¿Quiere seguir operando?");
       System.out.println("Introduzca  s para si");
       System.out.println("Introduzca  n para Salir");
       resp = input.next().charAt(0);
       
       while (resp == 's') {
           System.out.println("Introduzca el segundo número: ");
           n2=input.nextInt();
           solucion = calculadora (solucion,n2);
               
           System.out.println("¿Quiere seguir operando?");
           System.out.println("Introduzca  s para si");
           System.out.println("Introduzca  n para Salir");
           resp = input.next().charAt(0);
       }
   }
   static int calculadora (int a, int b){
       char menu;
       int sol = 0;
           
           System.out.println("Bienvenido al menú");
           System.out.println("Introduzca + para realizar la suma lenta");
           System.out.println("Introduzca - para realizar la resta lenta");
           System.out.println("Introduzca * para realizar la multiplicación por sumas");
           System.out.println("Introduzca / para realizar la división por restas");
           System.out.println("Introduzca ^ para realizar la potencia por multiplicaciones");
           System.out.println("Introduzca d para realizar la cuenta de los dígitos");
           System.out.println("Introduzca s para realizar la suma de los dígitos");
           System.out.println("Introduzca p para realizar la suma de los dígitos pares en posiciones impares");
           System.out.println("Introduzca i para realizar la suma de los dígitos impares en posiciones pares");
           System.out.println("Introduzca r para realizar la raiz \n");
           menu = input.next().charAt(0);
       
           switch (menu){
               case '+':
                    sol=suma(a,b);
                    System.out.println("La solución de la suma es:"+sol);
                    
                    break;
               case '-':
                    sol=resta(a,b);
                    System.out.println("La solución de la resta es:"+sol);
                    
                    break;
               case '*':
                    sol = multiplicacion(a,b);
                    System.out.println("La solución de la multiplicación es:"+sol);
                    
                    break;
               case '/':
                    sol = divisionrest(a,b);
                    
                    break;
               case '^':
                    sol = potencia(a,b);
                    System.out.println("La solución de la potencia es:"+sol);
                    
                    break;
               case 'd':
                    sol = contdig(a);
                    System.out.println("El número de digitos es:"+sol);  
                    break;
               case 's':
                    sol = sumdig(a);
                    System.out.println("La suma de digitos es:"+sol);  
                    break;
               case 'p':
                    sol = sumparimp(a);
                    System.out.println("La suma de digitos es:"+sol); 
                    break;
               case 'i':
                    sol = sumimppar(a);
                    System.out.println("La suma de digitos es:"+sol);  
                    break;
               case 'r':
                    sol = raiz(a);
                    System.out.println("La raiz es:"+sol);  
                    break;
                    
               default:
                    System.out.println("La entrada del menú no es correcta");
                    
                    break;
           }
           return sol;
        
   }
   static int suma (int s1, int s2){
       if (s2 == 0)
           return s1;
       else
           return suma (s1+1,s2-1); 
   }
   static int resta (int s1, int s2){     
       if (s2 == 0)
           return s1;
        else
           return( resta (s1-1,s2-1));
   }
   static int multiplicacion (int s1, int s2){
       if (s2 == 0)
           return 0;
       else
           return (s1 + multiplicacion(s1, s2-1)); 
   }
   static int divisionrest (int s1, int s2){
       if (!Valido (s2)) 
       {
            do 
             {
                 System.out.println("No se puede dividir por 0");
                 System.out.println ("Dame el segundo entero");
                 s2 = input.nextInt();
              }
            while (!Valido(s2));
       }
       if (s1 < s2)
            return 0;
       else
            return (1 + divisionrest (s1-s2, s2));
   }
   public static boolean Valido (int n)
   {
        return n != 0;
   }
   static int potencia (int s1, int s2){
       if ( s2 == 0)
           return 1;
       else
           return s1 * potencia (s1,s2-1);
   }
   public static int contdig (int s1){
       if ( s1==0)
           return 0;
       else
           return 1 + contdig (s1 /10);
   }
   public static int sumdig (int s1){
       if (s1 == 0)
            return 0;
       else
            return ((s1 % 10) + sumdig(s1/10));
   }
   public static int sumparimp (int s1){
       if (s1 ==0)
            return 0;
       else {
          if ( s1%2 == 0)
                return ((s1 % 10) + sumparimp (s1/100));
          else
                return sumparimp(s1 /100);
       }
   }
   public static int sumimppar (int s1){
       s1 = s1/10;
       if (s1 <= 9)
          return 0;
       else{
          if ( s1%2 != 0)
                return ((s1 % 10) + sumparimp (s1/10));
          else
                return sumparimp(s1/10);
       }
   }
   public static int raiz (int s1){
       int cont = 0, sol = 0;
       while (s1>=sol){
          cont++;
          sol = cont * cont;
       }
       cont --;
       return cont;
   }
}
   