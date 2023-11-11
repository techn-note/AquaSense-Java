/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dsm2
 */
public class mergesort {

    public static void mergeSort(List<Integer> lista, int esq, int dir) {
        if (esq == dir) { // 1
            return;
        }
        int meio = (esq + dir) / 2; // 3
        mergeSort(lista, esq, meio);// f(n/2)
        mergeSort(lista, meio + 1, dir); //f(n/2)
        merge(lista, esq, meio, dir); 
    }

    public static void merge(List<Integer> lista, int esq, int meio, int dir) {
        int a_tam = meio - esq + 1; // 3
        int b_tam = dir - meio; // 2

        List<Integer> a = new ArrayList<>(lista.subList(esq, esq + a_tam)); // 1
        List<Integer> b = new ArrayList<>(lista.subList(meio + 1, meio + 1 + b_tam)); // 1

        int i = 0, j = 0, k = esq; //3

        for (; i < a_tam && j < b_tam; k++) { // 10*n/2
            if (a.get(i) < b.get(j)) { // 1
                lista.set(k, a.get(i++)); //1
            } else {
                lista.set(k, b.get(j++)); //1
            }
        }

        for (; i < a_tam; k++, i++) { // 5 * n/2
            lista.set(k, a.get(i));
        }

        for (; j < b_tam; k++, j++) { // 5 * n/2
            lista.set(k, b.get(j));
        }
    }
/*
    public static void imprimeLista(List<Integer> lista) {
        System.out.println("\nOrdem correta: lista = {");
        for (Integer elemento : lista) {
            System.out.printf("%d ", elemento);
        }
        System.out.println("}");
    }
*/
}
