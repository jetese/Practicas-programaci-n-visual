
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
           System.out.println("Introduzca m para realizar la multiplicación rusa");
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
               case 'm':
                    sol = multrusa(a,b);
                    System.out.println("La solución de la multiplicación rusa es:"+sol);
                    
                    break;
               case '^':
                    sol = potencia(a,b);
                    System.out.println("La solución de la potencia es:"+sol);
                    
                    break;
               case '|':
                    sol = division(a,b);
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
       int nx;
       if((s1>0 && s2<0) || (s1<0 && s2<0)){
           nx=s2;
           s2=s1;
           s1=nx;
       }
       while (s2 != 0){
           s1++;
           s2--;
       }
       return s1;
   }
   static int resta (int s1, int s2){
       if ( (s1 > 0 && s2 > 0) || (s1<0 && s2 < 0)){
           while (s2 != 0){
               s1 --;
               s2--;
           }
       }
       else{
           while (s2!=0){
               s1++;
               s2++;
           }
       }
       return s1;
   }
   static int multiplicacion (int s1, int s2){
       int sol =0, aux = Math.abs(s2); 
       while (aux != 0){
           sol = sol + s1;
           aux--;
       }
       if (s2<0)
           sol = -sol;
       return sol;
   }
   static int divisionrest (int s1, int s2){
       int sol = 0, aux1 = Math.abs(s1), aux2 = Math.abs(s2);
       
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
       while (aux1 >= aux2){
               aux1 = aux1-aux2;
               sol++;
           }
       if (s2 < 0)
                sol = -sol;
       if (s1 < 0)
                sol = -sol;
       System.out.println ("El cociente es "+sol);
       System.out.println ("El resto es "+aux1);
       return sol;
       }
   public static boolean Valido (int n)
   {
        return n != 0;
   }
   static int multrusa (int s1, int s2){
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
   static int potencia (int s1, int s2){
       int sol = 1, cont;
       for (cont=1; cont <= s2; cont++)
           sol = sol * s1;
       return sol;
   }
   public static int division (int x, int y)
   {
        if (!Valido (y)) 
        {
            do 
             {
                 System.out.println ("Dame el segundo entero");
                 y = input.nextInt();
              }
            while (!Valido(y));
        }
        return x / y;
      
   }
   public static int contdig (int s1){
       int cont = 0;
       while ( s1!=0){
           s1 = s1/10;
           cont ++;
       }
       return cont;
   }
   public static int sumdig (int s1){
       int cont = 0, suma = 0;
       while (s1 != 0){
            suma = suma + (s1%10);
            s1 = s1 /10;
            cont++;
       }
       return suma;
   }
   public static int sumparimp (int s1){
       int cont = 0, suma = 0;
       while (Math.abs(s1)!=0){
          if ( s1%2 == 0)
                suma = suma + (s1%10);
          s1 = s1 / 10;
       }
       return suma;
   }
   public static int sumimppar (int s1){
       int cont = 0, suma = 0;
       while (Math.abs(s1)> 9){
          s1 = s1/10;
          if ( s1%2 != 0)
                suma = suma + (s1%10);
          s1 = s1 / 10;
       }
       return suma;
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
   
      