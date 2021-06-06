package com.company;

import java.io. *;
import java.util.Scanner;

public class Main {

    public static Scanner n = new Scanner(System.in);

    public static void main(String[] args) {
        guarda("C:\\Users\\Garcia\\Downloads\\p.txt");
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
                        suma();

                        break;
                    case 3:
                        resta();

                        break;
                    case 4:
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
                        Multiplicacion(A,B);
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
                        Determinante();
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
    public static void Determinante() {
       double determinante = 0;
		System.out.println("ingrese la matriz cuadrada no mayor de orden 3");
		String Letra = n.nextLine();
		if (Letra.equalsIgnoreCase("r")) {
			A = R;
		} else {
			A = convertir(Letra);
		}
		if(A.length > 3 && A[0].length > 3 || A.length < 1 && A[0].length < 1){
			System.out.println("ERROR: La matriz no es del grado permitido. ");
		}else {
			if (A.length == 3 && A[0].length == 3) {
				determinante = ((A[0][0]) * (A[1][1]) * (A[2][2]) + (A[1][0]) * (A[2][1]) *
						(A[0][2]) + (A[2][0]) * (A[0][1]) * (A[1][2]))
						- ((A[2][0]) * (A[1][1]) * (A[0][2]) + (A[1][0]) * (A[0][1]) * (A[2][2])
						+ (A[0][0]) * (A[2][1]) * (A[1][2]));

				System.out.println("El determinante es: " + determinante);

			} else if (A.length == 2 && A[0].length == 2) {
				determinante = ((A[0][0] * A[1][1]) - (A[1][0] * A[0][1]));
				System.out.println("El determinante es: " + determinante);

			} else if (A.length == 1 && A[0].length == 1) {
				determinante = A[0][0];
				System.out.println("El determinante es: " + determinante);

			}
		}
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
                    R[i][j]=0.0;
                }

            }


            //Multiplicacion
            //Recorremos las Filas de la Matriz
            for (int i = 0; i < FilasA; i++) {
                //Recorremos las Columas de la Matriz
                for (int j = 0; j < ColumnasB; j++) {
                    // matriz A[0] para que se recorra para abajo la matriz
                    for (int k = 0; k < A[0].length; k++) {
                        R[i][j] += (A[i][k] * B[k][j])*1.0;
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
                md[i][j] = a[i][j]+0.0;

            }
        }
        return md;

    }
}




