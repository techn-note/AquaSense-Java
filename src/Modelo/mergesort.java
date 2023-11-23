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
        if (esq == dir) {
            return;
        }
        int meio = (esq + dir) / 2;
        mergeSort(lista, esq, meio);
        mergeSort(lista, meio + 1, dir); 
        merge(lista, esq, meio, dir); 
    }

    public static void merge(List<Integer> lista, int esq, int meio, int dir) {
        int a_tam = meio - esq + 1;
        int b_tam = dir - meio;

        List<Integer> a = new ArrayList<>(lista.subList(esq, esq + a_tam));
        List<Integer> b = new ArrayList<>(lista.subList(meio + 1, meio + 1 + b_tam));

        int i = 0, j = 0, k = esq;

        for (; i < a_tam && j < b_tam; k++) {
            if (a.get(i) < b.get(j)) {
                lista.set(k, a.get(i++));
            } else {
                lista.set(k, b.get(j++));
            }
        }

        for (; i < a_tam; k++, i++) {
            lista.set(k, a.get(i));
        }

        for (; j < b_tam; k++, j++) {
            lista.set(k, b.get(j));
        }
    }
}
