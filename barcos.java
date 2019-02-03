
/**
 * Juego de los barquitos.
 * 
 * @author Jesús Téllez Serrano
 * @version (a version number or a date)
 */
import java.util.*;
public class barcos
{
    static Scanner input = new Scanner (System.in);
    
    public static void main (String [] args){
        char menu;
        boolean jugador = false, ordenador = false;
        int tablerojugador [][], tableroordenador[][], tiradasjugador[][], tiradasordenador[][];
        tablerojugador = new int [10][10];
        tableroordenador = new int [10][10];
        tiradasjugador = new int [10][10];
        tiradasordenador = new int [10][10];
        
        System.out.println("Bienvenido al juego de los barquitos");
        do{
            System.out.println("Menú:");
            System.out.println("Introduzca j para jugar");
            System.out.println("Introduzca x para salir");
            menu = input.next().charAt(0);
            switch(menu){
                case 'j':
                    tablerojugador = inicializatablero();
                    tableroordenador = inicializatablero();
                    tiradasjugador = inicializatablero();
                    tiradasordenador = inicializatablero();
                    tablerojugador = jugadorcolocabarcos(tablerojugador);
                    tableroordenador = ordenadorcolocabarcos(tableroordenador);
                    do{
                        tiradasjugador = jugadorjuega(tiradasjugador, tableroordenador);
                        tiradasordenador = ordenadorjuega(tiradasordenador, tablerojugador);
                        mostrartiradas(tiradasjugador);
                        jugador = comprobarganador(tiradasjugador, tableroordenador);
                        ordenador = comprobarganador(tiradasordenador, tablerojugador);
                    }while (!jugador && !ordenador);
                    break;
            
                case 'x':
                    System.out.println("Hasta pronto");
                    break;
                
                default:
                    System.out.println("La entrada no es correcta");
                    break;
            }
        }while (menu != 'x');
    }
    public static int [][] inicializatablero (){
        int matriz [][];
        matriz = new int [10][10];
        
        for (int i=0; i < matriz.length; i++){
            for (int j=0; j < matriz.length; j++){
                matriz[i][j] = 0;
            }
        }
        
        return matriz;
    }
    public static int [][] jugadorcolocabarcos (int matriz [][]){
        int x, y, xfin, yfin;
        
        do{
            System.out.println ("Coloque el portaaviones (5 posiciones), introduciendo las coordenadas iniciales y finales");
            System.out.println ("Ejemplo x -> 1 y->1, xfin->5 yfin->1");
            System.out.println ("x -> ");
            x = input.nextInt();
            System.out.println ("y -> ");
            y = input.nextInt();
            System.out.println ("xfin -> ");
            xfin = input.nextInt();
            System.out.println ("yfin -> ");
            yfin = input.nextInt();
        }while (x<10 && x >1 && y<10 && y>1 && xfin<10 && xfin >1 && yfin<10 && yfin>1 && ((xfin-x == 4 && y==yfin)||(yfin-y==4 && x==xfin)));
        for (int i=x-1; i<xfin;i++){
            for (int j=y-1;j<yfin;j++)
                matriz[i][j] = 1;
        }
        for (int k=0; k<2; k++){
            do{
                System.out.println ("Coloque los 2 acorazados (4 posiciones), introduciendo las coordenadas iniciales y finales");
                System.out.println ("Ejemplo x -> 1 y->1, x->4 y->1");
                System.out.println ("x -> ");
                x = input.nextInt();
                System.out.println ("y -> ");
                y = input.nextInt();
                System.out.println ("xfin -> ");
                xfin = input.nextInt();
                System.out.println ("yfin -> ");
                yfin = input.nextInt();
            }while (x<10 && x >1 && y<10 && y>1 && xfin<10 && xfin >1 && yfin<10 && yfin>1 && ((xfin-x == 3 && y==yfin)||(yfin-y==3 && x==xfin)) && !haybarcoscerca(matriz, x, y, xfin, yfin));
            for (int i=x-1; i<xfin;i++){
                for (int j=y-1;j<yfin;j++)
                    matriz[i][j] = 1;
            }
        }
        for (int k=0; k<3; k++){
            do{
                System.out.println ("Coloque los 3 cruceros/submarinos (3 posiciones), introduciendo las coordenadas iniciales y finales");
                System.out.println ("Ejemplo x -> 1 y->1, x->3 y->1");
                System.out.println ("x -> ");
                x = input.nextInt();
                System.out.println ("y -> ");
                y = input.nextInt();
                System.out.println ("xfin -> ");
                xfin = input.nextInt();
                System.out.println ("yfin -> ");
                yfin = input.nextInt();
            }while (x<10 && x >1 && y<10 && y>1 && xfin<10 && xfin >1 && yfin<10 && yfin>1 && ((xfin-x == 2 && y==yfin)||(yfin-y==2 && x==xfin)) && !haybarcoscerca(matriz, x, y, xfin, yfin));
            for (int i=x-1; i<xfin;i++){
                for (int j=y-1;j<yfin;j++)
                    matriz[i][j] = 1;
            }
        }
        for (int k=0; k<4; k++){
            do{
                System.out.println ("Coloque los 4 destructores (2 posiciones), introduciendo las coordenadas iniciales y finales");
                System.out.println ("Ejemplo x -> 1 y->1, x->2 y->1");
                System.out.println ("x -> ");
                x = input.nextInt();
                System.out.println ("y -> ");
                y = input.nextInt();
                System.out.println ("xfin -> ");
                xfin = input.nextInt();
                System.out.println ("yfin -> ");
                yfin = input.nextInt();
            }while (x<10 && x >1 && y<10 && y>1 && xfin<10 && xfin >1 && yfin<10 && yfin>1 && ((xfin-x == 1 && y==yfin)||(yfin-y==1 && x==xfin)) && !haybarcoscerca(matriz, x, y, xfin, yfin));
            for (int i=x-1; i<xfin;i++){
                for (int j=y-1;j<yfin;j++)
                    matriz[i][j] = 1;
            }
        }
        return matriz;
        
    }
    public static int randomrango ( int min, int max){
       Random rn = new Random();
       return (rn.nextInt((max - min) + 1) + min);       
    }
    public static int [][] ordenadorcolocabarcos (int matriz[][]){
        int x, y, xfin, yfin;
        
        do{
            x = randomrango (1,9);
            y = randomrango(1,9);
            xfin = randomrango(1,9);
            yfin = randomrango(1,9);
        }while (((xfin!=x && y==yfin)||(yfin!=y && x==xfin)) && !haybarcoscerca(matriz, x, y, xfin, yfin));
        if (x== xfin){
            for (int j=0;j<5;j++){
                matriz[x][y-1] = 1;
                y ++;
            }
        }
        else{
            for (int j=0;j<5;j++){
                matriz[x-1][y] = 1;
                x ++;
            }
        } 
        for (int k=0; k<2; k++){
            do{
                x = randomrango (1,9);
                y = randomrango(1,9);
                xfin = randomrango(1,9);
                yfin = randomrango(1,9);
            }while (((xfin!=x && y==yfin)||(yfin!=y && x==xfin)) && !haybarcoscerca(matriz, x, y, xfin, yfin));
            if (x== xfin){
                for (int j=0;j<4;j++){
                     matriz[x][y-1] = 1;
                     y ++;
                }
            }
            else{
                for (int j=0;j<4;j++){
                     matriz[x-1][y] = 1;
                     x ++;
                }
            }
        }
        for (int k=0; k<3; k++){
            do{
                x = randomrango (1,9);
                y = randomrango(1,9);
                xfin = randomrango(1,9);
                yfin = randomrango(1,9);
            }while (((xfin!=x && y==yfin)||(yfin!=y && x==xfin)) && !haybarcoscerca(matriz, x, y, xfin, yfin));
            if (x== xfin){
                for (int j=0;j<3;j++){
                     matriz[x][y-1] = 1;
                     y ++;
                }
            }
            else{
                for (int j=0;j<3;j++){
                     matriz[x-1][y] = 1;
                     x ++;
                }
            }            
        }
        for (int k=0; k<4; k++){
            do{
                x = randomrango (1,9);
                y = randomrango(1,9);
                xfin = randomrango(1,9);
                yfin = randomrango(1,9);
            }while (((xfin!=x && y==yfin)||(yfin!=y && x==xfin)) && !haybarcoscerca(matriz, x, y, xfin, yfin));
            if (x== xfin){
                for (int j=0;j<2;j++){
                     matriz[x][y-1] = 1;
                     y ++;
                }
            }
            else{
                for (int j=0;j<2;j++){
                     matriz[x-1][y] = 1;
                     x ++;
                }
            }
        }
        return matriz;
    }
    public static boolean haybarcoscerca (int matriz [][], int x, int y, int xfin, int yfin){
        for (int i=x-2; i<xfin+1;i++){
            for (int j=y-2;j<yfin+1;j++){
                if (matriz[i][j] == 1)
                    return true;
            }
        }
        return false;
    }
    public static int [][] jugadorjuega (int matriztirada[][], int matrizcontrario[][]){
        int x,y;
        do{
             System.out.println ("x -> ");
             x = input.nextInt();
             System.out.println ("y -> ");
             y = input.nextInt();
        }while (matriztirada[x][y] == 0 && x<10 && x >1 && y<10 && y>1);
        matriztirada[x][y] = matrizcontrario[x][y];
        return matriztirada;
    }
    public static int[][] ordenadorjuega (int matriztirada[][], int matrizcontrario[][]){
        int x,y;
        do{
            x = randomrango(1,9);
            y = randomrango(1,9);
        }while (matriztirada[x][y] == 0 && x<10 && x >1 && y<10 && y>1);
        matriztirada[x][y] = matrizcontrario[x][y];
        return matriztirada;
    }
    public static void mostrartiradas (int matriz[][]){
        for (int i=0; i < matriz.length; i++){
            for (int j=0; j < matriz.length; j++){
                System.out.print (" "+matriz[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
    public static boolean comprobarganador (int matriztirada[][], int matrizcontrario[][]){
        for (int i=0; i < matriztirada.length; i++){
            for (int j=0; j < matriztirada.length; j++){
                if (matrizcontrario[i][j] == 1 && matriztirada[i][j] != 1)
                    return false;
            }
        }
        return true;
    }
}    