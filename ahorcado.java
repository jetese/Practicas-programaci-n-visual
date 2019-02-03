
/**
 * Write a description of class ahorcado here.
 * Juego del ahorcado
 * @author Jesús Téllez Serrano 
 * @version 1.0.0
 */
import java.util.*;
public class ahorcado
{
    static Scanner input = new Scanner(System.in);
    public static void main (String [] args){
        char solucion[], adivinar[], letra, menu;
        String s;
        boolean esta, ganar = false;
        int error, posiciones[];
        
        do{
           System.out.println("Menú");
           System.out.println("Introduzca e para jugar al AHORCADO");
           System.out.println("Introduzca x para salir \n");
           menu = input.next().charAt(0);
           switch (menu){
               case 'x':
                    System.out.println("Adios");  
                    break;
                    
               case 'e':
                    error = 0;
                    s = introducirpalabra();
                    System.out.println(s);
                        
                    solucion = new char [s.length()];
                    adivinar = new char [s.length()];
                    posiciones = new int [s.length()];
                        
                    solucion = pasarstringarray(s);
                    adivinar = creararraybarras(s);
                    do{
                        System.out.println();
                        representaradivinanza(adivinar);
                        System.out.println();
                        System.out.println("Introduzca una letra");
                        letra = input.next().charAt(0);
                        System.out.println();
                        posiciones = estaletra(letra, solucion);
                        
                        if (posiciones[0]!= -1){
                            adivinar = cambiaradiv(posiciones, adivinar,solucion);
                            ganar = estacompleto( adivinar, solucion);
                        }
                        else{
                            error++;
                            System.out.println("Has fallado, te quedan "+(5-error)+" oportunidades.");
                            System.out.println();
                        }
                    }while (error < 5 && !ganar);
                    if (error == 5)
                        System.out.println ("Has perdido");
                        
                    else
                        System.out.println ("Has ganado");
                    System.out.println();
                    break;
               
               default:
                    System.out.println("La entrada del menú no es correcta");
                    
                    break;
           }           
        }while (menu != 'x');    
    }
    static String introducirpalabra (){ //Introduce el texto en un string
        String s;
        input.nextLine();//Limpiar el buffer
        System.out.print("Introduzca el texto ");
        s = input.nextLine();
        
        return s;
    }
    static char [] pasarstringarray (String cadena){ //Pasa el string a un array de caracteres
        char array[];
        array = new char [cadena.length()];
        
        for (int i = 0; i<cadena.length(); i++){
            array[i] = cadena.charAt(i);
        }
        
        return array;
    }
    static char [] creararraybarras (String cadena){ //Crea un array de guiones bajos y espacios según el texto
        char array[];
        array = new char [cadena.length()];
        
        for (int i = 0; i<cadena.length(); i++){
            if ( cadena.charAt(i) != ' ')
                array[i] = '_';
            else
                array[i] = ' ';
        }
        
        return array;
    }
    static void representaradivinanza (char array[]){ //Imprime array
        for ( int i=0; i < array.length; i++){
            System.out.print(array[i]+" ");
            if( array[i] == ' ')
                System.out.print(" ");
        }
        System.out.println ();
    }
    static int [] estaletra (char letra, char array[]){ // Comprueba que esta la letra introducida en el array y devuelve un array de las posiciones donde se encuentran las letras (en el caso de que estén)
       int posiciones [], x = 0;
       posiciones = new int [array.length];
       for (int cont = 0; cont < array.length; cont++){
           if (array[cont] == letra){
                posiciones[x] = cont;
                x++;
           }
       }
       if (x < posiciones.length )
          posiciones[x] = -1;
       return posiciones;
    }
    static char [] cambiaradiv (int pos[], char adi [], char comp[]){ //modifica el array de guiones bajos, introduciendo las letras acertadas
        int i = 0;
        while (i<pos.length && pos[i]!=-1){
           adi[pos[i]] = comp[pos[i]];
           i++;
        }
        return adi; 
    }
    static boolean estacompleto (char adi[], char comp[]){ //comprueba si en el array de guiones bajos, ya no hay mas guiones, es decir ha ganado. 
        for (int i=0; i < adi.length; i++){
            if (adi [i] != comp[i])
                return false;
        }
        return true;
    }
}