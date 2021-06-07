package com.company;

import javax.swing.*;
import java.io. *;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.sql.SQLOutput;
import java.util.Scanner;
class Main {

    public static Scanner n = new Scanner(System.in);

    public static void main(String[] args) {


        guarda("C:\\Users\\Alberto\\Downloads\\p.txt");
        Menú();

    }

    public static String[] todo = new String[26];
    public static String[][] todoo = new String[26][2];
    public static Double[][] A;
    public static Double[][] B;
    public static Double[][] R;
    public static String temp,As,Bs,Rtemp;
    public static int cont = 0;
    public static  Scanner sc = new Scanner(System.in);
    public static String direccion;
    public static Double auxiliar[][];
    public static String RR="";

    public static void Menú() {

        int opcion = 0;
        do {
            //try {
            //  System.out.println("INGRESE LA DIRECCION DE LA MATRIZ");
            //  direccion = sc.nextLine();
            //  guarda("C:\\Users\\Alberto\\Downloads\\p.txt");


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


                    carga();

                    break;
                case 2:
                    System.out.println("SUMA");
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
                    MatrizxNum();

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
                    Potencia();

                    break;
                case 8:
                    System.out.println("-----------Inversa --------");
                    Inversa();
                    break;
                case 9:
                    Determinante();
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
            // } catch (Exception e) {
            System.out.println("Ingrese un número válido \n");
            sc = new Scanner(System.in);
            // }
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
                if (todoo[i][0].equalsIgnoreCase(g))
                    p = i;
            } catch (Exception e) {
                i = 26;
            }


        temp = "";

        String[] cna = todoo[p][1].trim().split(";");
        int co=0;
        for ( int i = 0; i < cna[0].length(); i++)
            if  (cna[0].charAt(i) == ' ' || cna[0].charAt(i) == '\t' || cna[0].charAt(i) == '\r' || cna[0].charAt(i) == '\n' )
                co++;



        System.out.println("el valor de co: "+co);
        String[][] pr = new String[cna.length][cna[0].split(",").length ];
        Double[][] prd = new Double[cna.length][cna[0].split(",").length ];
        System.out.println(cna.length+"X"+(cna[0].split(",").length));
        for (int i = 0; i < cna.length; i++)
            pr[i] = cna[i].split(",");
        System.out.println(todoo[p][0]);
        for (int i = 0; i < cna.length; i++) {
            System.out.println();
            for (int k = 0; k < cna[0].split(",").length; k++) {
                // System.out.println(Double.parseDouble(pr[i][k]));

                prd[i][k] = Double.parseDouble(pr[i][k]);

                temp = temp + prd[i][k] + "     ";
                System.out.print(prd[i][k] + "  ");
            }
            temp = temp + " </br> ";
        }

        System.out.println();
        System.out.println();
        System.out.println();
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
        if (A.length > 3 && A[0].length > 3 || A.length < 1 && A[0].length < 1) {
            System.out.println("ERROR: La matriz no es del grado permitido. ");
        } else {
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
        else {
            A = convertir(Letra);
            As = temp;
        }


        System.out.println("ingrese la segunda matriz");
        Letra = n.nextLine();
        if (Letra.equalsIgnoreCase("r"))
            B = R;
        else {
            B = convertir(Letra);
            Bs = temp;
        }
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
        Respuestas(R);
        html();
    }
    public static void Respuestas(Double R[][]){

        //llamando a la tabla
        //Inicializacion de la tabla

        for (int i = 0; i < R.length; i++) {
            //recorriendo filas
            // Para recorrer las filas de la tabla

            for (int j = 0; j < R[i].length; j++) {
                //recorriendo columanas y asignando a encriptado;
                RR +=  +R[i][j] + "  ";

            }
            //cerrar columna
            RR +=  " </br> ";
        }
        //cerrar tabla

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
        Respuestas(R);
        html();
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


    public static void carga() {
        for (int i = 0; i < todo.length; i++)
            convertir(todoo[i][0]);

    }
    public static String crga()
    {
        return "";
    }
    //Multiplicación de Matriz por un número

    public static void MatrizxNum(){
        System.out.println("Ingrese la Matriz");
        String Letra = n.nextLine();
        if (Letra.equalsIgnoreCase("r"))
            A = R;
        else
            A = convertir(Letra);
        System.out.println("Ingrese el número para multiplicar por la matriz");
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] *= numero;
            }
        }
        MostrarMxNumero(A);
    }
    public static void MostrarMxNumero(Double[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print( A[i][j] + " \t");
            }
            System.out.println(" ");
        }
    }


    //Potencia de Matrices
    public static void Potencia (){
        System.out.println("Ingrese la Matriz");
        String Letra = n.nextLine();
        if (Letra.equalsIgnoreCase("r"))
            A = R;
        else
            A = convertir(Letra);
        System.out.println("Ingrese el número de la potencia");
        Scanner sc = new Scanner(System.in);
        int potencia = sc.nextInt();
        for (int h = 0; h<potencia; h++){
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    Multiplicacion(A,A);
                    Multiplicacion(R,A);
                    R[i][j]=auxiliar[i][j];
                }
            }
        }
        MostrarMxNumero(auxiliar);
    }

    public static void html()
    {
        File css = new File("C:\\Users\\Alberto\\Desktop\\borar\\bordar.css");
        String csss = "@import url(https://fonts.googleapis.com/css?family=Fjalla+One);\n" +
                "\n" +
                "$background: linear-gradient(to bottom, #405166 0%,#656f6f 100%);\n" +
                "$red: #e55643 ;\n" +
                "$green: #2b9f5e;\n" +
                "$yellow: #f1c83c;\n" +
                "$shadow: #533d4a;\n" +
                "\n" +
                "html{\n" +
                "  height: 100%;\n" +
                "}\n" +
                "\n" +
                "body{\n" +
                "  font-family: 'Fjalla One', sans-serif;\n" +
                "  background: $background;\n" +
                "}\n" +
                "\n" +
                ".container{\n" +
                "  transform: translate(-50%, -50%);\n" +
                "  top: 50%;\n" +
                "  left: 50%;\n" +
                "  display: block;\n" +
                "  position: absolute;\n" +
                "  max-width: 225px;\n" +
                "}\n" +
                "\n" +
                ".button{\n" +
                "  float: left;\n" +
                "  position: relative;\n" +
                "  bottom: -65px;\n" +
                "  left: 50%;\n" +
                "  transform: translateX(-50%) rotate(-10deg);\n" +
                "  color: $red;\n" +
                "  text-transform: uppercase;\n" +
                "  opacity: 0;\n" +
                "  visibility: hidden;\n" +
                "  cursor: pointer;\n" +
                "  \n" +
                "  span{\n" +
                "    transform: skew(-10deg);\n" +
                "    display: block;\n" +
                "    float: left;\n" +
                "    text-shadow: $shadow 1px 1px, $shadow 2px 2px, $shadow 3px 3px, $shadow 4px 4px;\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "h1{\n" +
                "  color: red;\n" +
                "  text-transform: uppercase;\n" +
                "  font-size: 42px;\n" +
                "  margin: 0;\n" +
                "  line-height: 47px;\n" +
                "  letter-spacing: 2px;\n" +
                "}\n" +
                "h3{\n" +
                "  color: cyan;\n" +
                "  text-transform: uppercase;\n" +
                "  transform: translateX(-50%) rotate(-10deg);\n" +
                "   transform: skew(-10deg);\n" +
                "  font-size: 42px;\n" +
                "  margin: 0;\n" +
                "  line-height: 47px;\n" +
                "  letter-spacing: 2px;\n" +
                "}\n" +
                "\n" +
                ".title{\n" +
                "  transform: translateX(-50%) rotate(-10deg);\n" +
                "  display: block;\n" +
                "  float: left;\n" +
                "  left: 50%;\n" +
                "  position: relative;\n" +
                "  \n" +
                "  span {\n" +
                "    transform: skew(-10deg);\n" +
                "    display: block;\n" +
                "    float: left;\n" +
                "    text-shadow: $shadow 1px 1px, $shadow 2px 2px, $shadow 3px 3px, $shadow 4px 4px, $shadow 5px 5px, $shadow 6px 6px;\n" +
                "    min-width: 10px;\n" +
                "    min-height: 10px;\n" +
                "    position: relative;\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                ".title{\n" +
                "  &:nth-child(1){\n" +
                "    color: $red;\n" +
                "  }\n" +
                "  &:nth-child(2){\n" +
                "    color: $green;\n" +
                "  }\n" +
                "  &:nth-child(3){\n" +
                "    color: $yellow;\n" +
                "  }\n" +
                "}\n";
        try {
            BufferedWriter l = new BufferedWriter(new FileWriter(css));
            l.write(csss);
            l.close();



        }
        catch (Exception e)
        {
            e.printStackTrace();


        }
        File c = new File("C:\\Users\\Alberto\\Desktop\\borar\\bordar"+cont+".html");
        String j = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<img src=\"data:image/jpeg;base64,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\" alt=\"usac\" width=\"20%\"  >\n" +
                "<head>\n" +
                "\t<title></title>\n" +
                "\t<link rel=\"stylesheet\" type=\"text/css\" href=\"bordar.css\">\n" +
                "\t\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>\n" +
                "<h1 ><span class=\"title\">PRACTICA</span>\n" +
                "    <span class=\"title\">#</span>\n" +
                "    <span class=\"title\">1</span>\n" +
                "</h1>\n" +
                "</div>\n" +
                "</br>\n" +
                "</br>\n" +
                "</br>\n" +
                "<div>\n" +
                "<h3 align=\"left\"><span class=\"hd\">INTEGRANTES</span>\n" +
                " \n" +
                "</h3>\n" +
                "<ul>\n" +
                "\t<li>ALBERTO JOSUÉ HERNANDEZ ARMAS 201903553</li>\n" +
                "\t<li>LEONEL ANTONIO GONZALEZ GARCIA 201709088</li\n" +
                "\t<li>TULIO JAFETH PIRIR SCHUMAN 201700698</li>\n" +
                "\t<li>FRENDY ABEL COY CASTILLO 201942321</li>\t\n" +
                "</ul>\n" +
                "</div>\n" +
                "\n" +
                "</br>\n" +
                "</br>\n" +
                "</br>\n" +
                "\n" +
                "\n" +
                "<a href=\"https://github.com/betebetoven/IPC1_PRACTICA1_G16/blob/main/src/com/company/Main.java\"  target=\"_blank\">visitar repositorio</a>\n" +
                "</br>\n" +
                "</br>\n" +
                "</br>\n" +
                "<div>\n" +
                "<h3 align=\"left\"><span class=\"hd\">PROGRAMA</span>\n" +
                "\t</div>\n" +
                " \n" +
                "</h3>\n" +
                "<div>\n" +
                "\t<p>\n" + "LA PRIMERA MATRIZ "+"</br>\n"+
                As +"</br>\n"
                +"LA SEGURNA MATRIZ"+
                "</br>\n"+"</br>\n"+"</br>\n"+Bs +"</br>\n"
                +"</br>\n"+"</br>\n"+
                "EL RESULTADO"
                +"</br>\n"+"</br>\n"+
                "\t</p>\n" +
                RR +
                "</div>\n" +
                "</body>\n" +
                "</html>";
        try {
            BufferedWriter k = new BufferedWriter(new FileWriter(c));
            k.write(j);
            k.close();





            String url = "C:\\Users\\Alberto\\Desktop\\borar\\bordar"+cont+".html";
            String urls = "C:\\Users\\Alberto\\Desktop\\borar\\bordar.css";
            String browser = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";

            try {
                Runtime r = Runtime.getRuntime();
                r.exec(browser + " " + url);
                cont++;
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Not a valid file!", "ERROR!",
                        JOptionPane.ERROR_MESSAGE);

            }
            /*Thread.sleep(1000);

            Files.deleteIfExists(Paths.get(url));
            Files.deleteIfExists(Paths.get(urls));*/





        }
        catch (Exception e)
        {
            e.printStackTrace();


        }
    }
}




