package com.dots.client.lists.board;

public class ListadeListasDeCuadros {

    private int largo = 0;
    private ListaCuadros head = null;

    public int getLargo() {
        return this.largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public void anadirElemento(int filas_columnas) {
        if (filas_columnas > 2) {
            int filas = filas_columnas;
            int columnas = filas_columnas;
            while (filas != 0) {
                if (this.head == null) {
                    this.head = new ListaCuadros();
                    while (columnas != 0){
                        this.head.anadirElemento();
                        columnas--;
                    }
                    filas--;
                    columnas = filas_columnas;
                    this.largo++;
                } else {
                    ListaCuadros tmp = this.head;
                    while (tmp.next != null) {
                        tmp = tmp.next;
                    }
                    tmp.next = new ListaCuadros();
                    tmp.next.prev = tmp;
                    while (columnas != 0){
                        tmp.next.anadirElemento();
                        columnas--;
                    }
                    filas--;
                    columnas = filas_columnas;
                    this.largo++;
                }
            }
        } else {
            System.out.println("Error, el tamaño mínimo de la plantilla es de 3x3");
        }
    }

    public void imprimirLista(){
        ListaCuadros tmp = this.head;
        while (tmp != null){
            tmp.imprimirLista();
            tmp = tmp.next;
        }
    }

}
