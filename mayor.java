

/**
 * Write a description of class mayor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class mayor
{
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        int n, n1, n2, n3;
        System.out.println("BIENVENIDO A MI CALCULADORA"); 
        do {
        n1=input.nextInt();
        n2=input.nextInt();
        n3=input.nextInt();
    }while (n1 == n2 || n2 == n3 || n3 == n1);
        if (n1 < n2){
            n = n1;
            n1 = n2;
            n2 = n;
          
        }
        if (n1 < n3){
                n = n1;
                n1 = n3;
                n3 = n;
        }
        else {
            if (n2 < n3){
                    n = n2;
                    n2 = n3;
                    n3 =n;
            }
        }
        System.out.println("De mayor a menor  "+n1+">"+n2+">"+n3);      
    }
}
