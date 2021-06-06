package com.company;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static Scanner n = new Scanner(System.in);

    public static void main(String[] args) {
        guarda("C:\\Users\\Usuario\\Documents\\IPC1\\Vacas\\p.txt");
        Menú();
    }

    public static String[] todo = new String[26];
    public static String[][] todoo = new String[26][2];
    public static Double[][] A;
    public static Double[][] B;
    public static Double[][] R;

    public static void Menú() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            try {
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
                System.out.println("10 Transpuesta de una Matriz");
                System.out.println("11.Salir");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:

                        break;
                    case 2:
                        System.out.printf("SUMA");
                        suma();

                        break;
                    case 3:
                        System.out.println("RESTA");
                        resta();

                        break;
                    case 4:
                        System.out.println("MULTIPLICACION");
                        System.out.println("ingrese la primera matriz");
                        String Letra = n.nextLine();
                        if (Letra.equalsIgnoreCase("r"))
                            A = R;
                        else
                            A = convertir(Letra);

                        System.out.println("ingrese la segunda matriz");
                        Letra = n.nextLine();
                        if (Letra.equalsIgnoreCase("r"))
                            B = R;
                        else
                            B = convertir(Letra);
                        Multiplicacion(A, B);
                        break;
                    case 5:

                        break;
                    case 6:
                        System.out.println("----------Divicion---------------");
                        System.out.println("ingrese la segunda matriz");
                        Letra = n.nextLine();
                        if (Letra.equalsIgnoreCase("r"))
                            A = R;
                        else
                            A = convertir(Letra);

                        System.out.println("ingrese la segunda matriz");
                        Letra = n.nextLine();
                        if (Letra.equalsIgnoreCase("r"))
                            B = R;
                        else
                            B = convertir(Letra);
                        Divicion(A, B);
                        break;
                    case 7:

                        break;
                    case 8:
                        System.out.println("-----------Inversa --------");
                        Inversa();
                        break;
                    case 9:

                        break;
                    case 10:
                        System.out.println("----Transpuesta -----------");
                        System.out.println("ingrese la primera matriz");
                        Letra = n.nextLine();
                        if (Letra.equalsIgnoreCase("r"))
                            A = R;
                        else
                            A = convertir(Letra);
                        Transpuesta(A);


                        break;

                    case 11:
                        System.out.println("Gracias por utilizar el programa");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        } while (opcion != 11);
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
        todo = recibe(dir).trim().split("\n");
        for (int i = 0; i < todo.length; i++) {
            todoo[i] = todo[i].trim().split(":");
            todoo[i][1] = todoo[i][1].trim();
        }


    }

    public static Double[][] convertir(String g)//devuelve una matriz de dos dimensiones
    {
        int p = 0;
        for (int i = 0; i < 26; i++)
            try {
                if (todoo[i][0].equals(g))
                    p = i;
            } catch (Exception e) {
                i = 26;
            }


        String[] cna = todoo[p][1].trim().split(";");
        String[][] pr = new String[cna.length][(cna[0].length() + 1) / 2];
        Double[][] prd = new Double[cna.length][(cna[0].length() + 1) / 2];
        for (int i = 0; i < cna.length; i++)
            pr[i] = cna[i].trim().split(",");
        System.out.println(todoo[p][0]);
        for (int i = 0; i < cna.length; i++) {
            System.out.println();
            for (int k = 0; k < (cna[0].length() + 1) / 2; k++) {
                prd[i][k] = Double.parseDouble(pr[i][k]);
                System.out.print(prd[i][k] + "  ");
            }
        }
        System.out.println("|" + prd[0][0] + "|");
        return prd;
    }

    //Hola :)
    public static void funciondeabel() {
        int[][] matrizA = {{4, 5, 8}, {2, 6, 7,}, {2, 4, 3}};
        int[][] matrizB = {{6, 7, 2}, {7, 3, 1,}, {5, 1, 8}};
        int[][] matrizC = {{2, 3}, {8, 1}};
        int i, j;
        int op = 0, determinante = 0;
        int MCorden = 0;

        Scanner leer = new Scanner(System.in);

        do {
            System.out.println("Ingrese la matriz para obtener su determinante. ");
            System.out.println("Solo se aceptan matrices cuadradas maximas de orden 3.\n");
            System.out.println("Cual es el orden de la matriz cuadrada?: ");
            MCorden = leer.nextInt();

            if (MCorden > 0 && MCorden < 4) {
                switch (MCorden) {
                    case 1:
                        determinante = matrizB[0][0];
                        System.out.println("El determinante es: " + determinante);

                    case 2:
                        for (i = 0; i <= 2; i++) {
                            for (j = 0; j <= 2; j++) {
                                System.out.print(matrizB[i][j] + " ");
                            }
                            System.out.println();
                        }
                        determinante = ((matrizB[0][0] * matrizB[1][1]) - (matrizB[1][0] * matrizB[0][1]));
                        System.out.println("El determinante es: " + determinante);
                    case 3:
                        for (i = 0; i <= 2; i++) {
                            for (j = 0; j <= 2; j++) {
                                System.out.print(matrizB[i][j] + " ");
                            }
                            System.out.println();
                        }
                        determinante = ((matrizB[0][0]) * (matrizB[1][1]) * (matrizB[2][2]) + (matrizB[1][0]) * (matrizB[2][1]) *
                                (matrizB[0][2]) + (matrizB[2][0]) * (matrizB[0][1]) * (matrizB[1][2]))
                                - ((matrizB[2][0]) * (matrizB[1][1]) * (matrizB[0][2]) + (matrizB[1][0]) * (matrizB[0][1]) * (matrizB[2][2])
                                + (matrizB[0][0]) * (matrizB[2][1]) * (matrizB[1][2]));

                        System.out.println("El determinante es: " + determinante);
                    default:
                }
            } else {
                System.out.println("La matriz cuadrada esta fuera del grado permitido.\n");
            }
            System.out.println("Si desea intentarlo de nuevo ingrese 1 y 0 para salir: ");
            op = leer.nextInt();
        } while (op != 0);
    }


    public static void trns() {
        System.out.println("ingrese la primera matriz");
        String Letra = n.nextLine();
        if (Letra.equalsIgnoreCase("r"))
            A = R;
        else
            A = convertir(Letra);

        System.out.println("ingrese la segunda matriz");
        Letra = n.nextLine();
        if (Letra.equalsIgnoreCase("r"))
            B = R;
        else
            B = convertir(Letra);
    }

    public static void suma() {
        trns();
        R = new Double[A[0].length][A[0].length];
        for (int i = 0; i < A[0].length; i++) {

            System.out.println();
            for (int k = 0; k < A[0].length; k++) {

                R[i][k] = A[i][k] + B[i][k];
                System.out.print(R[i][k] + "  ");

            }
        }
        System.out.println();
    }

    public static void resta() {
        trns();
        R = new Double[A[0].length][A[0].length];
        for (int i = 0; i < A[0].length; i++) {

            System.out.println();
            for (int k = 0; k < A[0].length; k++) {

                R[i][k] = A[i][k] - B[i][k];
                System.out.print(R[i][k] + "  ");

            }
        }
        System.out.println();
    }

    public static void Multiplicacion(Double A[][], Double B[][]) {
        //CONDICIONALES
        //A DEBE TENER EL MISMO NUMERO DE COLUMNAS QUE B DE FILAS

        //COLUMNAS DE A


        int FilasA = A.length;
        int ColumnasA = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                ColumnasA = A[i].length;
            }
        }
        System.out.println("A = " + FilasA + " X " + ColumnasA);

        int filasB = B.length;
        int ColumnasB = 0;

        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                ColumnasB = B[i].length;
            }

        }
        System.out.println("B = " + filasB + " X " + ColumnasB);
        if (ColumnasA != filasB) {
            System.out.println("Numero de Columnas de A"
                    + " No es IGUAL a Numero de Filas de B");

        } else {
            System.out.println("Columnas A = Filas B");

            R = new Double[FilasA][ColumnasB];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    R[i][j] = 0.0;
                }

            }


            //Multiplicacion
            //Recorremos las Filas de la Matriz
            for (int i = 0; i < FilasA; i++) {
                //Recorremos las Columas de la Matriz
                for (int j = 0; j < ColumnasB; j++) {
                    // matriz A[0] para que se recorra para abajo la matriz
                    for (int k = 0; k < A[0].length; k++) {
                        R[i][j] += (A[i][k] * B[k][j]) * 1.0;
                    }
                }
            }
            System.out.println("*-------------------------");
            System.out.println("Resultado ");
            imprimir(R);
            System.out.println("*-------------------------");

        }

    }

    //Imprimir Matrices
    public static void imprimir(Double A[][]) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void imprimirDouble(Double A[][]) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println("");
        }
    }

    ///pasa matriz int a double
    public static Double[][] Int_a_Double(int a[][]) {
        Double md[][];
        int m = a.length;
        int n = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                n = a[i].length;
            }
        }
        md = new Double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                md[i][j] = a[i][j] + 0.0;

            }
        }
        return md;

    }

    //-------------------Codigo de la Matriz Inversa
    public static void fInversa(Double Matriz[][]) {
        R = new Double[Matriz[0].length][Matriz[0].length];
        //Verificar se es una Matriz Cuadrada
        int n = Matriz.length;
        int m = Matriz[0].length;
        if (n != m) {
            System.out.println("No  es una Matriz Cuadrada ");

            return;

        } else {

            //Matriz IDENTIDAD
            Double identidad[][] = new Double[n][n];
            for (int i = 0; i < identidad.length; i++) {
                for (int j = 0; j < identidad[0].length; j++) {
                    identidad[i][j] = 0.0;
                }


            }

            for (int i = 0; i < identidad.length; i++) {

                identidad[i][i] = 1.0;

            }
            imprimirDouble(identidad);
            /*
            //Imprimir matriz identidad
            System.out.println("----Matriz Identida*----");
            //Pasar a double la matriz identidad
            imprimirDouble(identidad);
            System.out.println("------------------------*");
             */

            //Matriz que se va a invertir
            System.out.println("Matriz a Invertir ");
            //Pasando a double la matriz que se va a invertr
            Double a[][] = (Matriz);
            //imprimri matriz que se va a invertir
            imprimirDouble(a);
            System.out.println("-----------------------------*");
            //Procedimiento invertir matriz

            //auxiliar nos va a ayudar a guardar valores
            double aux;
            double pivote;
            //pivote para las operaciones entre filas y columnas

            for (int i = 0; i < n; i++) {
                // pivote para reducir a 0 los datos arriba y abajo
                pivote = a[i][i];
                for (int k = 0; k < n; k++) {
                    //convirtiendo pivote a 1 y aplicar en toda la fila
                    a[i][k] = a[i][k] / pivote;
                    // se aplica tambien a la matriz identiad
                    identidad[i][k] = identidad[i][k] / pivote;

                }

                /// convertir a 0 todo lo que hay abajo y arriba del pivote
                for (int j = 0; j < n; j++) {
                    //condicional si i no es igual a j para saber que no esta en la
                    //diagonal
                    if (i != j) {
                        // aux es igual al pivote
                        aux = a[j][i];

                        for (int k = 0; k < n; k++) {

                            // formula F-aux*F
                            //se multiplicacn las dos matrices para el cambio
                            a[j][k] = a[j][k] - aux * a[i][k];
                            //La matriz identidad sera la Inversa
                            identidad[j][k] = identidad[j][k] - aux * identidad[i][k];

                        }
                    }
                }

            }

            //Matriz inversa que seria la identida
            System.out.println("-MATRIZ INVERSA ");
            R = identidad;
            imprimirDouble(identidad);
            System.out.println("---------------------------");
            //La respuesta va ser igual a la matriz identidad por el cambio

        }


    }

    public static void Inversa() {
        System.out.println("ingrese la primera matriz");
        String Letra = n.nextLine();
        if (Letra.equalsIgnoreCase("r"))
            A = R;
        else
            A = convertir(Letra);

        fInversa(A);


    }

    //Divicion
    public static void Divicion(Double A[][], Double B[][]) {
        //Pasar a double la matriz DIVIDENDO
        Double respuesta[][];
        System.out.println("Matriz Dividendo");
        System.out.println("------------------");
        imprimirDouble(A);
        System.out.println("------------------");
        Double a[][] = (A);
        //MatriZ DIVISORA
        System.out.println("-Matriz Divisora--");
        System.out.println("-------------------------------");
        imprimirDouble(B);
        System.out.println("------------------------------");
        //INVERSA de B
        System.out.println("OBTENIENDO INVERSA DE MATRIZ DIVISORA ");

        System.out.println("Inversa de Matriz Divisora");
        System.out.println("--------------------------------------------");
        fInversa(B);
        Double b[][] = R;

        System.out.println("-------------------------------------");
        //Multiplicacion para la divicion
        System.out.println("----Respuesta Divicion-------");
        Multiplicacion(a, b);
        System.out.println("-----------------------------------------------");

    }

    //--Matriz Tranzpuesta
    public static void Transpuesta(Double a[][]) {
        int n = a.length;
        int m = a[0].length;
        Double T[][] = new Double[m][n];
        for (int x = 0; x < a.length; x++) {
            for (int y = 0; y < a[x].length; y++) {
                T[y][x] = a[x][y];
            }
        }
        System.out.println("Transpuesta");
        imprimirDouble(T);
        R = T;


    }


}




