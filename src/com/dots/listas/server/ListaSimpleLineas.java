package com.dots.listas.server;

public class ListaSimpleLineas {

    private NodoLineas head;
    private NodoLineas tail;
    private int largo;
    private static ListaSimpleLineas ListaLineas;

    private ListaSimpleLineas() {
        this.head = null;
        this.largo = 0;
        this.tail = null;
    }

    public static ListaSimpleLineas getLista(){
        if (ListaLineas == null){
            ListaLineas = new ListaSimpleLineas();
        }
        else{
            return ListaLineas;
        }
        return null;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public void anadirElemento(int posxi, int posxf, int posyi, int posyf){
        if (this.head == null){
            this.head = new NodoLineas(posxi, posxf, posyi, posyf);
            this.tail = this.head;
            this.largo++;
        }
        else{
            NodoLineas tmp = this.head;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = new NodoLineas(posxi, posxf, posyi, posyf);
            tmp.next.prev = tmp;
            this.tail = tmp.next;
            this.largo++;
        }
    }

    public void comprobarAdyacentes(){
        if (this.largo > 2){
            NodoLineas tmp1 = this.head;
            NodoLineas tmp2 = tmp1;
            while(tmp1 != null){
                while (tmp2 != null){
                    if (tmp1 == tmp2){
                        tmp2 = tmp2.next;
                    }
                    else if (tmp1.getPosxf() == tmp2.getPosxi() && tmp1.getPosyf() == tmp2.getPosyi()){
                        NodoLineas tmp3 = this.head;
                        while (tmp3 != null){
                            if (tmp1 == tmp3 || tmp2 == tmp3){
                                tmp3 = tmp3.next;
                            }
                            else if (tmp2.getPosxf() == tmp3.getPosxf() && tmp2.getPosyf() == tmp3.getPosyf()){
                                if (tmp1.getPosxi() == tmp3.getPosxi() && tmp1.getPosyi() == tmp3.getPosyi()){
                                    if (this.tail == tmp1 || this.tail == tmp2 || this.tail == tmp3){
                                        System.out.println("Triangulo con ultima linea");
                                        tmp3 = tmp3.next;
                                    }
                                    else{
                                        System.out.println("Triangulo");
                                        tmp3 = tmp3.next;
                                    }
                                }
                                else{
                                    NodoLineas tmp4 = this.head;
                                    while (tmp4 != null){
                                        if (tmp1 == tmp4 || tmp2 == tmp4 || tmp3 == tmp4){
                                            tmp4 = tmp4.next;
                                        }
                                        else if (tmp3.getPosxi() == tmp4.getPosxf() && tmp3.getPosyi() == tmp4.getPosyf()){
                                            if (tmp1.getPosxi() == tmp4.getPosxi() && tmp1.getPosyi() == tmp4.getPosyi()){
                                                if (this.tail == tmp1 || this.tail == tmp2 || this.tail == tmp3 || this.tail == tmp4){
                                                    System.out.println("Cuadrado con ultima linea");
                                                    tmp4 = tmp4.next;
                                                }
                                                else{
                                                    System.out.println("Cuadrado");
                                                    tmp4 = tmp4.next;
                                                }
                                            }
                                            else{
                                                tmp4 = tmp4.next;
                                            }
                                        }
                                        else{
                                            tmp4 = tmp4.next;
                                        }
                                    }
                                    tmp3 = tmp3.next;
                                }
                            }
                            else{
                                tmp3 = tmp3.next;
                            }
                        }
                        tmp2 = tmp2.next;
                    }
                    else{
                        tmp2 = tmp2.next;
                    }
                }
                tmp1 = tmp1.next;
                tmp2 = this.head;
            }
        }
        else{
            System.out.println("Error");
        }
    }
}
