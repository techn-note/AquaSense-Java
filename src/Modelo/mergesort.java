package Modelo;

import java.util.ArrayList;

public class mergesort {

    public static void main(String[] args) {
        ArrayList<Integer> v = new ArrayList<>();
        v.add(14);
        v.add(7);
        v.add(8);
        v.add(12);
        v.add(9);
        v.add(11);
        v.add(6);
        v.add(5);

        mergeSort(v, 0, v.size() - 1);
        imprimeVetor(v);
    }

    public static void mergeSort(int[] v, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergeSort(v, esq, meio);
            mergeSort(v, meio + 1, dir);
            merge(v, esq, meio, dir);
        }
    }

    public static void merge(int[] v, int esq, int meio, int dir) {
        int i, j, k;
        int a_tam = meio - esq + 1;
        int b_tam = dir - meio;

        int[] a = new int[a_tam];
        int[] b = new int[b_tam];

        for (i = 0; i < a_tam; i++) {
            a[i] = v[esq + i];
        }

        for (j = 0; j < b_tam; j++) {
            b[j] = v[meio + 1 + j];
        }

        i = 0;
        j = 0;

        for (k = esq; k <= dir; k++) {
            if (i == a_tam) {
                v[k] = b[j++];
            } else if (j == b_tam || a[i] < b[j]) {
                v[k] = a[i++];
            } else {
                v[k] = b[j++];
            }
        }
    }

    public static void imprimeVetor(int[] v, int tam) {
        System.out.println("\nOrdem correta: v = {");
        for (int i = 0; i < tam; i++) {
            System.out.printf("%d ", v[i]);
        }
        System.out.println("}");
    }

    private static void mergeSort(ArrayList<Integer> v, int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void imprimeVetor(ArrayList<Integer> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
