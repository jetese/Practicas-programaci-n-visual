
/**
 * Juego del 2048
 * 
 * Se juega con w a s d
 * @author Jesús Téllez Serrano 
 * @version 1.0.0
 */
import java.util.*;
public class dosmilcuarentayocho
{
    static Scanner input = new Scanner (System.in);
    
    public static void main (String [] args)
    {
        char menu, movimiento;
        boolean gana=false, suma=true;
        int tablero[][],puntuaciones[], juego = 0;
        tablero = new int[4][5];
        puntuaciones = new int [10];
        
        System.out.println("Bienvenido al 2048 \n");
        
        do {
            System.out.println("Si desea jugar introduzca j");
            System.out.println("Si desea salir introduzca x");
            menu = input.next().charAt(0);
            switch (menu){
                case 'j':
                    gana = false;
                    suma = true;
                    System.out.println("Para jugar utilice w a s d");
                    tablero = inicializartablero(tablero);
                    tablero = nuevodos(tablero);
                    tablero = nuevodos(tablero);
                    do{
                        mostrartablero(tablero);
                        System.out.println("Introduzca movimiento (wasd)");
                        movimiento = input.next().charAt(0);
                        tablero = moverysumar(tablero,movimiento);
                        mostrarpuntuacion (tablero, puntuaciones);
                        if (hayhueco(tablero))
                            tablero = nuevodos(tablero);
                        else
                            suma = haysuma(tablero);
                        gana = gana(tablero);
                    }while (suma && !gana);
                    puntuaciones = acumpunt (tablero,puntuaciones,juego);
                    juego++;
                    if (gana)
                        System.out.println ("Has ganado consiguiendo 2048");
                    else
                        System.out.println ("Oh, has perdido");
                    break;
                case 'x':
                    System.out.println("Hasta la próxima");
                    break;
                default:
                    System.out.println("La entrada de menú no es correcta");
                    break;
            }
        }while (menu != 'x');
    }
    public static int[][] inicializartablero (int matriz[][]){
        for (int i=0; i < 4; i++){
            for (int j=0; j<5; j++)
                matriz[i][j] = 0;
        }
        return matriz;
    }
    public static void mostrartablero (int matriz[][]){
        for (int i=0; i<4; i++){
            System.out.print ("---------\n");
            for (int j=0;j<4;j++){
                System.out.print ("|");
                if (matriz[i][j] == 0)
                    System.out.print ("  ");
                else
                    System.out.print (matriz[i][j]);
            }
            System.out.print("| \n");
       }
       System.out.print ("--------- \n \n");
    }
    public static int randomrango ( int min, int max){
       Random rn = new Random();
       return (rn.nextInt((max - min) + 1) + min);       
    }
    public static int[][] nuevodos (int matriz[][]){
       int i, j;
      
       do{
           i = randomrango(0,3);
           j = randomrango(0,3);
       }while (matriz[i][j]!=0 && matriz[i][j]!=2);
       matriz[i][j] = matriz[i][j] + 2;
       if (matriz[i][j] == 4)
            matriz = nuevodos(matriz);
       return matriz;
    }
    public static int[][] moverysumar (int matriz[][], char entrada){
        switch (entrada){
            case 'w':
                matriz = moverarriba(matriz);
                matriz = sumararriba(matriz);
                break;
            case 'a':
                matriz = moverizquierda(matriz);
                matriz = sumarizquierda(matriz);
                break;
            case 's':
                matriz = moverabajo(matriz);
                matriz = sumarabajo(matriz);
                break;
            case 'd':
                matriz = moverderecha(matriz);
                matriz = sumarderecha(matriz);
                break;
            default:
                System.out.println ("El movimiento no es válido");
                System.out.println("Introduzca movimiento (wasd)");
                entrada = input.next().charAt(0);
                matriz = moverysumar(matriz,entrada);    
        }
        return matriz;
    }
    public static int[][] moverarriba (int matriz[][]){
        boolean intercambio;
        for (int j=0; j < 4; j++){
            for (int x=0; x<3; x++){
                for (int i =0; i<3; i++){
                    if (matriz[i][j] == 0 && matriz[i+1][j]!=0){
                        matriz[i][j] = matriz[i+1][j];
                        matriz[i+1][j] = 0;
                    }
                }
            }
        }
        return matriz;
    }
    public static int[][] sumararriba (int matriz[][]){
        for (int j=0; j<4; j++){
            if (matriz[0][j] == matriz[1][j] && matriz[0][j]!=0){
                matriz[0][j] = matriz[0][j] * 2;
                matriz[1][j] = 0;
                matriz[0][4] = matriz[0][4] + matriz[0][j];
                if (matriz[2][j] == matriz[3][j] && matriz[2][j]!=0){
                    matriz[2][j] = matriz[2][j] * 2;
                    matriz[3][j] = 0;
                    matriz[0][4] = matriz[0][4] + matriz[2][j];
                }
            }
            else if (matriz[1][j] == matriz[2][j] && matriz[1][j]!=0){
                matriz[1][j] = matriz[1][j] * 2;
                matriz[2][j] = 0;
                matriz[0][4] = matriz[0][4] + matriz[1][j];
            }
            else if (matriz[2][j] == matriz[3][j] && matriz[2][j]!=0){
                matriz[2][j] = matriz[2][j] * 2;
                matriz[3][j] = 0;
                matriz[0][4] = matriz[0][4] + matriz[2][j];
            }
        }
        matriz = moverarriba(matriz);
        return matriz;
    }
    public static int[][] moverabajo (int matriz[][]){
        boolean intercambio;
        for (int j=0; j < 4; j++){
            for (int x=0; x<3; x++){
                for (int i =3; i>0; i--){
                    if (matriz[i][j] == 0 && matriz[i-1][j]!=0){
                        matriz[i][j] = matriz[i-1][j];
                        matriz[i-1][j] = 0;
                    }
                }
            }
        }
        return matriz;
    }
    public static int[][] sumarabajo (int matriz[][]){
        for (int j=0; j<4; j++){
            if (matriz[3][j] == matriz[2][j] && matriz[3][j]!=0){
                matriz[3][j] = matriz[3][j] * 2;
                matriz[2][j] = 0;
                matriz[0][4] = matriz[0][4] + matriz[3][j];
                if (matriz[1][j] == matriz[0][j] && matriz[1][j]!=0){
                    matriz[1][j] = matriz[1][j] * 2;
                    matriz[0][j] = 0;
                    matriz[0][4] = matriz[0][4] + matriz[1][j];
                }
            }
            else if (matriz[2][j] == matriz[1][j] && matriz[2][j]!=0){
                matriz[2][j] = matriz[2][j] * 2;
                matriz[1][j] = 0;
                matriz[0][4] = matriz[0][4] + matriz[2][j];
            }
            else if (matriz[1][j] == matriz[0][j] && matriz[1][j]!=0){
                matriz[1][j] = matriz[1][j] * 2;
                matriz[0][j] = 0;
                matriz[0][4] = matriz[0][4] + matriz[1][j];
            }
        }
        matriz = moverabajo(matriz);
        return matriz;
    }
    public static int[][] moverizquierda (int matriz[][]){
        boolean intercambio;
        for (int i=0; i < 4; i++){
            for (int x=0; x<3; x++){
                for (int j =0; j<3; j++){
                    if (matriz[i][j] == 0 && matriz[i][j+1]!=0){
                        matriz[i][j] = matriz[i][j+1];
                        matriz[i][j+1] = 0;
                    }
                }
            }
        }
        return matriz;
    }
    public static int[][] sumarizquierda (int matriz[][]){
        for (int i=0; i<4; i++){
            if (matriz[i][0] == matriz[i][1] && matriz[i][0]!=0){
                matriz[i][0] = matriz[i][0] * 2;
                matriz[i][1] = 0;
                matriz[0][4] = matriz[0][4] + matriz[i][0];
                if (matriz[i][2] == matriz[i][3] && matriz[i][2]!=0){
                    matriz[i][2] = matriz[i][2] * 2;
                    matriz[i][3] = 0;
                    matriz[0][4] = matriz[0][4] + matriz[i][2];
                }
            }
            else if (matriz[i][1] == matriz[i][2] && matriz[i][1]!=0){
                matriz[i][1] = matriz[i][1] * 2;
                matriz[i][2] = 0;
                matriz[0][4] = matriz[0][4] + matriz[i][1];
            }
            else if (matriz[i][2] == matriz[i][3] && matriz[i][2]!=0){
                matriz[i][2] = matriz[i][2] * 2;
                matriz[i][3] = 0;
                matriz[0][4] = matriz[0][4] + matriz[i][2];
            }
        }
        matriz = moverizquierda(matriz);
        return matriz;
    }
    public static int[][] moverderecha (int matriz[][]){
        boolean intercambio;
        for (int i=0; i < 4; i++){
            for (int x=0; x<3; x++){
                for (int j =3; j>0; j--){
                    if (matriz[i][j] == 0 && matriz[i][j-1]!=0){
                        matriz[i][j] = matriz[i][j-1];
                        matriz[i][j-1] = 0;
                    }
                }
            }
        }
        return matriz;
    }
    public static int[][] sumarderecha (int matriz[][]){
        for (int i=0; i<4; i++){
            if (matriz[i][3] == matriz[i][2] && matriz[i][3]!=0){
                matriz[i][3] = matriz[i][3] * 2;
                matriz[i][2] = 0;
                matriz[0][4] = matriz[0][4] + matriz[i][3];
                if (matriz[i][1] == matriz[i][0] && matriz[i][1]!=0){
                    matriz[i][1] = matriz[i][1] * 2;
                    matriz[i][0] = 0;
                    matriz[0][4] = matriz[0][4] + matriz[i][1];
                }
            }
            else if (matriz[i][2] == matriz[i][1] && matriz[i][2]!=0){
                matriz[i][2] = matriz[i][2] * 2;
                matriz[i][1] = 0;
                matriz[0][4] = matriz[0][4] + matriz[i][2];
            }
            else if (matriz[i][1] == matriz[i][0] && matriz[i][1]!=0){
                matriz[i][1] = matriz[i][1] * 2;
                matriz[i][0] = 0;
                matriz[0][4] = matriz[0][4] + matriz[i][1];
            }
        }
        matriz = moverderecha(matriz);
        return matriz;
    }
    public static void mostrarpuntuacion (int matriz[][],int array[]){
        System.out.println ("Tu puntuación es :"+matriz[0][4]);
        System.out.println ("El record a batir es :"+array[0]);
    }
    public static int[] acumpunt (int matriz[][],int array[] ,int juego){
        int i = 0;
        while (i<=juego && array[i]>matriz[0][4]){
            i++;             
        } 
        for(int x = 9; x>i; x--){
            array[x] = array[x-1];
        }
        array[i] = matriz[0][4];
        return array;
    }
    public static boolean hayhueco (int matriz [][]){
        for (int i=0; i<4; i++){
            for (int j=0; j<4;j++){
                if (matriz[i][j] == 0)
                    return true;
            }
        }
        return false;
    }
    public static boolean gana (int matriz [][]){
        for (int i=0; i<4; i++){
            for (int j=0; j<4;j++){
                if (matriz[i][j] == 2048)
                    return true;
            }
        }
        return false;
    }
    public static boolean haysuma (int matriz[][]){
        for (int i=0; i<3; i++){
            for (int j=0; j<3;j++){
                if (matriz[i][j] == matriz[i][j+1] || matriz[i][j] == matriz[i+1][j])
                    return true;
            }
        }
        return false;
    }
}