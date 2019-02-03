/**
 * Write a description of class mayor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class primos
{
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        int n1, n2, contprimo = 0, cont;
        boolean primo=true;
    
        System.out.println("BIENVENIDO AL PRIMO \n");
        System.out.println("Introduzca el primer número: "); 
        n1=input.nextInt();
        System.out.println("Introduzca el segundo número: ");
        n2=input.nextInt();
       
            while (n1<n2){
                for (cont=2;cont<=n1/2 && primo==true;cont++){
                    primo=(n1%cont!=0);
                }
                if(primo)
                    contprimo++;
                else
                    primo=true;
                n1++;
            }
        
        
            while (n1>n2){
                for (cont=2;cont<=n1/2 && primo==true;cont++){
                    primo=(n1%cont!=0);
                }
                if(primo)
                    contprimo++;
                    else
                    primo=true;
                if (cont == 2)
                    contprimo++;
                n1--;    
            }
        
        System.out.println("El número de primos es "+contprimo);
        
    }
}
