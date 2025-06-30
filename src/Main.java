public class Main {
    public static void main(String[] args) {
        //Hacer un programa que dada la matriz de secuencias de caracteres definida
        // y precargada elimine todas las secuencias que tienen orden descendente entre
        // sus elementos.
        int[][] matriz ={
                {0,0,4,3,2,0,0,2,4,0},
                {0,5,2,1,0,0,0,2,1,0},
                {0,2,3,2,0,2,2,1,0,0},
                {0,3,4,2,0,9,2,1,0,0},
                {0,2,2,2,0,2,2,0,0,0},
        };
        final int MAXF = 5;
        final int MAXC = 10;
        eliminarSecuenciasDesendientes(matriz,MAXF,MAXC);
    }
    public static void eliminarSecuenciasDesendientes (int[][] matriz, final int MAXF, final int MAXC) {
        int tamanoSecuencia;
        for (int i = 0; i<MAXF; i++){
            int inicioSecuencia = 0;
            int finSecuencia = -1;
            while (inicioSecuencia<MAXC){
                inicioSecuencia=buscarInicio(finSecuencia+1,MAXC,matriz[i]);
                if (inicioSecuencia<MAXC){
                    finSecuencia=buscarFin(inicioSecuencia,MAXC,matriz[i]);
                }
                tamanoSecuencia=((finSecuencia-inicioSecuencia)+1);
                if (tamanoSecuencia!=1){
                    revisarSecuencia(matriz[i],inicioSecuencia,finSecuencia,tamanoSecuencia, MAXC);
                }
            }
        }
        mostrarMatriz(matriz,MAXF,MAXC);
    }
    public static void  mostrarMatriz (int[][] matriz, final int MAXF, final int MAXC) {
        for (int i = 0; i<MAXF; i++){
            for (int j = 0; j<MAXC; j++){
                System.out.print(matriz[i][j]+" | ");
            }
            System.out.println();
        }
    }
    public static void eliminarSecuencia (int[] array, int inicio, int fin, int tamanoSecuencia) {
        for (int i = 0; i<=tamanoSecuencia; i++) {
            for (int j = inicio; j<=fin; j++){
                array[j]=array[j+1];
            }
        }
    }
    public static void revisarSecuencia (int[] array, int inicio, int fin, int tamanoSecuencia, final int MAXC) {
        int contador = 0;
        for (int i = inicio; i<fin && i<MAXC; i++){
            if (array[i]>array[i+1]){
                contador++;
            }
        }
        if (contador==tamanoSecuencia-1){
                eliminarSecuencia(array,inicio,fin, tamanoSecuencia);
        }
    }
    public static int buscarInicio (int fin, final int MAXC, int[] array){
        int inicio = fin;
        while (inicio<MAXC && array[inicio]==0){
            inicio++;
        }
        return inicio;
    }
    public static int buscarFin (int inicio, final int MAXC, int[] array) {
        while (inicio<MAXC && array[inicio]!=0){
            inicio++;
        }
        return inicio-1;
    }
}