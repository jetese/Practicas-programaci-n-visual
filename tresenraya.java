/**
 * Primitiva
 * 
 * @author Jesús Téllez Serrano 
 * @version 0.0.5
 */

import java.util.*;

public class tresenraya
{ 
   static Scanner input = new Scanner(System.in);
   public static void main (String [] args){
       int x, y;
       char raya[][], menu, t = '0';
       boolean c= false; 
       raya = new char [3][3];
       
       System.out.println("BIENVENIDO AL 3 EN RAYA \n");
       
       
       do{
           System.out.println("Menú");
           System.out.println("Introduzca e para jugar");
           System.out.println("Introduzca x para salir \n");
           menu = input.next().charAt(0);
           switch (menu){
               case 'x':
                    System.out.println("Adios");  
                    break;
                    
               case 'e':
                    raya =inicializar (raya);
                    do{
                        raya = introducircirculo(raya);
                        raya = ordenadorjuega(raya);
                        pintartabla(raya);
                        t = tres(raya);
                        c = completo (raya);
                    }while (t =='0' && !c);
                    if (t!='0'){
                       if(t=='1')
                           System.out.println("Has ganado");
                       else
                           System.out.println("Has perdido");
                    }
                    else
                       System.out.println("Se han completado las casillas, y no tenemos ganador");
                    
                    break;
               
               default:
                    System.out.println("La entrada del menú no es correcta");
                    
                    break;
           }           
       }while (menu != 'x');
   }
   static char[][] inicializar(char v[][]){
       int x, i;
       for( x= 0; x<3; x++){
           for (i = 0; i <3; i++){
               v[x][i]= '0';
           }
       }
       return v;
   }
   static char tres (char v[][]){
       char three= '0';
       three = horizontal (v);
       if (three!='0')
            return three;
       three = vertical (v);
       if (three!='0')
            return three;
       three = diagonal (v);
       return three;
   }
   static char horizontal (char v[][]){
       int i;
       for (i = 0; i < 3; i++){
           if (v[0][i] == v[1][i] && v[1][i] == v[2][i] && v[0][i]!= '0')
                return v[0][i];
       }
       return '0';
   }            
   static char vertical (char v[][]){
       char x;
       for (x = 0; x < 3; x++){
           if (v[x][0] == v[x][1] && v[x][1] == v[x][2] && v[x][0]!= '0')
                return v[x][0];
       }
       return '0';
   }              
   static char diagonal (char v[][]){
       if (v[0][0] == v[1][1] && v[1][1] == v[2][2] && v[0][0]!= '0')
                return v[0][0];
       if (v[0][2] == v[1][1] && v[1][1] == v[2][0] && v[0][2]!= '0')
                return v[0][2];
       return '0';
   }
   static boolean completo (char v[][]){
       int x, i;
       for ( x= 0; x<3; x++){
           for (i = 0; i <3; i++){
               if (v[x][i]== '0')
                    return false;
           }
       }
       return true;
   }
   static char[][] introducircirculo(char v[][]){
      int x, y;
      char tr;
      boolean  completo = false;
      tr = tres(v);
      completo = completo(v);
      if ( completo == false && tr == '0'){
          do{
              System.out.println("Introduzca la coordenada x en la que quiere su O");
              x = input.nextInt();
              System.out.println("Introduzca la coordenada y en la que quiere su O");
              y = input.nextInt();
          }while (x>3 || y>3 || v[x][y]!='0');
          v[x][y] = '1';
      }
      return v;
   }
   static char[][] ordenadorjuega (char v[][]){
      int x, y;
      char tr;
      boolean completo = false;
      tr = tres(v);
      completo = completo(v);
      if ( completo == false && tr == '0'){
          do{
              x = randomrango(0,2);
              y = randomrango(0,2);
          }while (v[x][y]!='0');
          v[x][y] = '2';
      }
      return v;
   }
    static void pintartabla (char v [][]){
       for (int x=0; x<3; x++){
            System.out.print ("--------\n");
            for (int i=0;i<3;i++){
                System.out.print ("|");
                if (v [x][i] == '0')
                    System.out.print (" ");
                else if(v[x][i] == '1')
                    System.out.print ("O");
                else
                    System.out.print ("X");
            }
            System.out.print("| \n");
       }
       System.out.print ("-------- \n \n");
   }
   static int randomrango ( int min, int max){
       Random rn = new Random();
       return (rn.nextInt((max - min) + 1) + min);       
   }
}