package com.company;

import java.io. *;
import java.util.Scanner;

public class Main {

    public static   Scanner n = new Scanner(System.in);
    public static String g="B";
    public static void main(String[] args) {
    Menu();

        guarda("C:\\Users\\Usuario\\Documents\\IPC1\\Vacas\\p.txt");
        convertir(g);
        System.out.println("Hola mundo");
    }
    public static  String[] todo = new String[26];
    public static  String[][] todoo = new String[26][2];
    public static Double[][] A;
    public static  Double[][]B;
    public static Double[][] R;
    public static void Menú (){
    Scanner sc = new Scanner(System.in);
    int opcion=0;
        do{
        try{
            System.out.println("--- MENU PRINCIPAL ---");
            System.out.println("1. Cargar Matrices");
            System.out.println("2. Sumar Matrices");
            System.out.println("3. Restar Matrices");
            System.out.print("4. Multiplicar Matriz por Matriz ");
            System.out.println("5. Multiplicar Matriz por Número");
            System.out.println("6. Dividir Matrices");
            System.out.println("7. Potencia de Matrices");
            System.out.println("8. Inversa de la Matriz");
            System.out.println("9. Determinante de una Matriz");
            System.out.println("10 Traspuesta de una Matriz");
            System.out.println("11.Salir");
            opcion = sc.nextInt();
            switch(opcion){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;

                case 11:
                    System.out.println("Gracias por utilizar el programa");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }while(opcion != 11);
}

    public static String recibe(String pathname) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(pathname);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String content = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                content += linea + "\n";
            }
            return content.trim();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }//funcion de leer
    public static void guarda(String dir)//funcion de guardarla en el vector general llamado "todo"
    {
        todo =recibe(dir).trim().split("\n");
        for (int i = 0; i < todo.length; i++) {
            todoo[i] = todo[i].trim().split(":");
            todoo[i][1]=todoo[i][1].trim();
        }


    }

    public static Double[][] convertir(String g)//devuelve una matriz de dos dimensiones
    {
        int p=0;
        for (int i = 0; i < 26; i++)
            try {
                if (todoo[i][0].equalsIgnoreCase(g))
                    p = i;
            }
            catch (Exception e)
            {
                i = 26;
            }


        String[] cna = todoo[p][1].trim().split(";");
        String[][] pr = new String[cna.length][(cna[0].length()+1)/2];
        Double[][] prd = new Double[cna.length][(cna[0].length()+1)/2];
        for (int i = 0; i < cna.length; i++)
            pr[i] = cna[i].trim().split(",");
        System.out.println(todoo[p][0]);
        for (int i = 0; i < cna.length; i++)
        {
            System.out.println();
            for (int k = 0; k < (cna[0].length()+1)/2; k++) {
                prd[i][k] = Double.parseDouble(pr[i][k]);
                System.out.print(prd[i][k] + "  ");
            }
        }
        System.out.println("|"+prd[0][0]+"|");
        return prd;
    }

    //Hola :)
    public static void funciondeabel()
    {
        int [][] matrizA ={{4,5,8},{2,6,7,},{2,4,3}};
        int [][] matrizB ={{6,7,2},{7,3,1,},{5,1,8}};
        int [][] matrizC ={{2,3},{8,1}};
        int i = 0, j = 0;
        int op = 0;

        Scanner leer = new Scanner(System.in);

        do{
            System.out.println("Ingrese la matriz para obtener su determinante. ");
            System.out.println("Solo se aceptan matrices maximas de 3X3.\n");


            if(i>3 || j>3){
                System.out.println("Es invalido una matriz mayor de 3X3");

            }else if(i != j){
                System.out.println("Las dimensiones de la matriz son diferentes");

            }else if(i==3 && j==3){
                for (i = 0; i <= 2; i++) {
                    for (j = 0; j <= 2; j++) {
                        System.out.print(matrizA[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            System.out.println("Si desea intentarlo de nuevo ingrese 1 y 0 para salir: ");
            op=leer.nextInt();
        }while(op != 0);
    }
    //Menu
    public static void Menu(){
        // bandera
        boolean flag = true;
        do {
            System.out.println(" ------------MenuñN------------- ");
            System.out.println("║1.Ingrese Matriz                 ║");
            System.out.println("║2.Suma                           ║");
            System.out.println("║3.Resta                          ║");
            System.out.println("║4.Multiplicacion          ║");
            System.out.println("║5.SALIR                     ║");
            System.out.println(" ----------------------------- ");

            String opcion = n .nextLine();
            switch (opcion) {
                case "1":

                    break;
                case "2":


                    break;
                case "3":

                    break;
                case "4":



                case "5":
                    flag = false;
                    break;
                default:


            }

        } while (flag);


    }
    //XD xD XD 



}

