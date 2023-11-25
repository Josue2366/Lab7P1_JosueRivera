/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1_josuerivera;
import java.util.Scanner;
import java.util.Random;
//fila 2 asiento 11
/**
 *
 * @author josue
 */
public class Lab7P1_JosueRivera {
static Scanner sc = new Scanner (System.in);
static Random rand = new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("//////menu//////");
        System.out.println("1. tres en raya ");
        System.out.println("2. ");
        System.out.println("3.salir ");
        System.out.println("introduce su opcion");
        int opcion = sc.nextInt();
        while (opcion < 3 && opcion > 0){
            switch (opcion){
                case 1:
                    int cont = 0;
                    char maquina = '0';
                    char x ='x';
                    boolean ver;
                    System.out.println("Bienvenido al tres en rayas");
                    boolean seg = true;
                    char seguir = 's';
                    while(seguir == 'S' || seguir == 's'){
                        int tam = 3;
                        char [][] tablero = new char [tam][tam];
                        tablero = generarTablero(tam);
                        imprimir(tablero);
                        while (seg == true){
                            System.out.println("es el turno de x");
                            System.out.println("ingrese el numero de  fila (0,1,2)");
                            int fila = sc.nextInt();
                            System.out.println("ingrese el numero de columnas (0,1,2)");
                            int columnas = sc.nextInt();
                            ver = verificarpocisionvalida(tablero,fila,columnas);
                            cont++;
                            if (ver == false){
                                while(ver == false){
                                    System.out.println("es el turno de x");
                                    System.out.println("ingrese el numero de  fila (0,1,2)");
                                    fila = sc.nextInt();
                                    System.out.println("ingrese el numero de columnas (0,1,2)");
                                    columnas = sc.nextInt();
                                    ver = verificarpocisionvalida(tablero,fila,columnas);
                                }
                            }
                            if (ver == true){
                                System.out.println("el usuario ha elegido la pocicion"+"("+fila+","+columnas+")");
                                tablero [fila][columnas] = x;
                                imprimir(tablero);
                                
                            }
                            cont++;
                            if (cont == 10){
                                System.out.println("empate");
                                break;
                            }
                            System.out.println("es el turno de 0");
                            fila = rand.nextInt((3-1)+1);
                            columnas = rand.nextInt((3-1)+1);
                            ver = verificarpocisionvalida(tablero,fila,columnas);
                            if (ver == false){
                                while(ver == false){
                                    fila = rand.nextInt((3-1)+1);
                                    columnas = rand.nextInt((3-1)+1);
                                    ver = verificarpocisionvalida(tablero,fila,columnas);
                                }
                            }
                            if (ver == true){
                                System.out.println("la maquina ha elegido la pocicion"+"("+fila+","+columnas+")");
                                tablero [fila][columnas] = maquina;
                                imprimir(tablero);
                                
                            }
                            boolean vic_m =verificarvictoria(tablero,maquina);
                            boolean vic_x = verificarvictoria(tablero,x);
                            if (vic_m == true){
                                System.out.println("gano la maquina");
                                break;
                            }
                            else if (vic_x == true){
                                System.out.println("gano el usuario");
                                break;
                            }
                            
                            
                            System.out.println("ok1");
                        }
                        System.out.println("le gustaria seguir? "
                                + "S/N");
                        seguir = sc.next().charAt(0);
                        cont = 0;
                    }
                    System.out.println("ok1");
                    break;
                case 2:
                    System.out.println("ingrese la fila");
                    int dim = sc.nextInt();
                    System.out.println("ingrese la columna");
                    int dim2 = sc.nextInt();
                    dim = dim2;
                    int [][] matriz = new int [dim][dim];
                    matriz = generarintmatrizaleatoria(dim,dim2);
                    imprimir2(matriz);
                    encontrarpuntosSilla(matriz);
                    System.out.println("ok2");
                    break;
            }
            System.out.println("//////menu//////");
            System.out.println("1.tres en raya ");
            System.out.println("2. ");
            System.out.println("3.salir");
            System.out.println("introduce su opcion");
            
                    opcion = sc.nextInt();
        }
        // TODO code application logic here
    }
    public static void encontrarpuntosSilla(int [][] x){
        int cont = 0;
        int indi2 = 0;
        boolean mayor = false;
        int indi = 0;
        int menor = 101;
        for (int i = 0; i < x.length; i++) {
            
            for (int j = 0; j < x.length; j++) {
                if (x[i][j]< menor){
                    menor = x[i][j];
                    indi = j;
                    indi2 = i;
                }
                
            }
            mayor = num_mayor(menor,indi,x);
            if (mayor == true){
                cont++;
                System.out.println("punto de silla en Matriz"+"["+indi2+"]"+"["+indi+"]: "+menor);
                menor = 101;
                indi = 0;
                indi2 = 0;
                
            }
            else{
                menor = 101;
                indi = 0;
                indi2 = 0;
                continue;
                
            }
            
            
        }
        if (cont == 0){
            System.out.println("no se encontro ningun punto de silla en la matriz");
        }
    }
    public static boolean num_mayor(int menor, int indi, int [][] x){
        boolean num = false;
        int mayor = 0;
        for (int i = 0; i <x.length ; i++) {
            /*for (int j = 0; j < x.length; j++) {
                if (x[i][indi]> mayor){
                    mayor = x[i][indi];
                }
                
            }*/
            if (x[i][indi]> mayor){
                    mayor = x[i][indi];
            }
            
        }
        if (menor == mayor){
            num = true;
            mayor = 0;
            return num;
        }
        return num;
    }
    public static void imprimir2 (int [][] x){
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                System.out.print(x[i][j]+" ");
            }
            System.out.println("");
            
        }
    }
    public static int [][] generarintmatrizaleatoria(int x, int y){
        int [][] temp = new int [x][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                temp [i][j] = rand.nextInt(100);
            }
            
        }
        return temp;
    }
    public static boolean verificarvictoria(char[][]x, char m){
        boolean vic = false;
        if (x[0][0] == m && x[0][1] == m && x[0][2] == m){
            vic = true;
        }
        if (x[1][0] == m && x[1][1] == m && x[1][2] == m){
            vic = true;
        }
        if (x[2][0] == m && x[2][1] == m && x[2][2] == m){
            vic = true;
        }
        if (x[0][0] == m && x[1][0] == m && x[2][0] == m){
            vic = true;
        }
        if (x[0][1] == m && x[1][1] == m && x[2][1] == m){
            vic = true;
        }
        if (x[0][2] == m && x[1][2] == m && x[2][2] == m){
            vic = true;
        }
        if (x[0][0] == m && x[1][1] == m && x[2][2] == m){
            vic = true;
        }
        if (x[0][2] == m && x[1][1] == m && x[2][0] == m){
            vic = true;
            
        }
        return vic;
    }
    public static char [][] generarTablero (int x){
        char [][] temp = new char [x][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                temp [i][j]= ' ';
                
            }
            
        }
        return temp;
    }
    public static void imprimir(char [][] x){
        int j = 0;
        for (int i = 0; i < x.length; i++) {
            System.out.println("["+x[i][j]+","+x[i][j+1]+","+x[i][j+2]+"]");
            
        }
    }
    public static boolean verificarpocisionvalida(char [][] x, int i, int j){
        boolean temp = false;
        /*while ((i > 2  || i < 0) || (j > 2 || j < 0)){
            
            System.out.println("valores invalidos:");
            System.out.println("ingrese el numero de  fila (0,1,2)");
            i = sc.nextInt();
            System.out.println("ingrese el numero de columnas (0,1,2)");
            j = sc.nextInt();
        }*/
        if ((i > 2  || i < 0) || (j > 2 || j < 0)){
            temp = false;
        }
        else {
            temp = true;
        }
        if (temp == true){
            if (x[i][j] != ' '){
            temp = false;
            }
        }
        
        
        
        return temp;
        /*for (int k = 0; k < x.length; k++) {
            for (int l = 0; l < x.length; l++) {
                if (x[k][l] == " x" || x[k][l]== " 0" ){
                    temp = 
                }
            }
            
        }*/
    }
    
}
