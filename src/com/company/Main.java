package com.company;
import java.io. *;
import java.util.Scanner;

public class Main {

    public static   Scanner n = new Scanner(System.in);
    public static void main(String[] args) {

	guarda("C:\\Users\\Alberto\\Desktop\\k.txt");
	convertir(0);

    }
    public static  String[] todo = new String[26];
    public static  String[][] todoo = new String[26][2];
    public static Double[][] A;
    public static  Double[][]B;
    public static Double[][] R;

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

    public static Double[][] convertir(int p)//devuelve una matriz de dos dimensiones
    {

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
    public static void relleno()
    {

    }
//Hola :)

}
