/**
 * Write a description of class mayor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class inverso
{
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        int n, aux, sol = 0;
        System.out.println("BIENVENIDO AL INVERSO"); 
        n=input.nextInt();
        aux = n;
        while (aux!=0){
            sol = sol * 10 + (aux%10);
            aux = aux/10;
          
        }
        System.out.println("El inverso es  "+sol);
        if ( n == sol)
            System.out.println ("El número es capicúo "+n +"="+sol);
        else
            System.out.println ("El número no es capicúo "+n +"!="+sol); 
    }
}
