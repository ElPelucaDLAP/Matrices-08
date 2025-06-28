public class Main {
    public static void main(String[] args) {
        //Hacer un programa que dada la matriz de secuencias de caracteres definida
        // y precargada elimine todas las secuencias que tienen orden descendente entre
        // sus elementos.
        int[][] matriz ={
                {1,0,2,3,4,0,0,2,4,0},
                {0,3,2,4,0,0,0,2,1,0},
                {0,2,3,2,0,2,2,1,0,0},
                {0,3,4,2,0,9,2,1,0,0},
                {0,2,2,2,2,2,2,0,0,0},
        };
        final int MAXF = 5;
        final int MAXC = 10;
        eliminarSecuenciasDesendientes(matriz,MAXF,MAXC);
    }
    public static void eliminarSecuenciasDesendientes (int[][] matriz, final int MAXF, final int MAXC) {
        int tamanoSecuencia;
        boolean estado;
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
                    if (revisarSecuencia(matriz[i],inicioSecuencia,finSecuencia,tamanoSecuencia,MAXC)){
                        estado=revisarSecuencia(matriz[i],inicioSecuencia,finSecuencia,tamanoSecuencia, MAXC);
                        System.out.println(estado);
                    }
                }
            }
        }
    }
    public static boolean revisarSecuencia (int[] array, int inicio, int fin, int tamanoSecuencia, final int MAXC) {
        boolean descendente = false;
        int contador = 0;
        for (int i = inicio; i<fin-1; i++){
            if (array[i]>array[i+1]){
                contador++;
            }
        }
        if (contador==tamanoSecuencia-1){
            descendente = true;
        }
        return descendente;
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
        return inicio;
    }
}