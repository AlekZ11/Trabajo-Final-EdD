/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.lista;

//import controlador.ControladorCliente;
import controlador.utiles.Utilidades;

import controlador.utiles.TipoOrdenacion;
import static controlador.utiles.Utilidades.getMethod;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
//import modelo.Cliente;

/**
 *
 * @author sebastian
 */
//E   T    K   V
//E = T
public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;

    private Integer size;

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    /**
     * Constructor de la clase se inicializa la lista en null y el tamanio en 0
     */
    public ListaEnlazada() {
        cabecera = null;
        size = 0;
    }

    /**
     * Permite ver si la lista esta vacia
     *
     * @return Boolean true si esta vacia, false si esta llena
     */
    public Boolean estaVacia() {
        return cabecera == null;
    }

    private void insertar(E dato) {
        NodoLista<E> nuevo = new NodoLista<>(dato, null);
        if (estaVacia()) {
            cabecera = nuevo;
        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        size++;
    }

    public void insertarCabecera(E dato) {
        if (estaVacia()) {
            insertar(dato);
        } else {
            NodoLista<E> nuevo = new NodoLista<>(dato, null);

            nuevo.setSiguiente(cabecera);
            cabecera = nuevo;
            size++;
        }
    }

    public void insertar(E dato, Integer pos) throws PosicionException {
        //lista size = 1
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < size) {
            NodoLista<E> nuevo = new NodoLista<>(dato, null);
            if (pos == (size - 1)) {
                insertar(dato);

            } else {

                NodoLista<E> aux = cabecera;
                for (int i = 0; i < pos - 1; i++) {
                    aux = aux.getSiguiente();
                }
                NodoLista<E> siguiente = aux.getSiguiente();
                aux.setSiguiente(nuevo);
                nuevo.setSiguiente(siguiente);
                size++;
            }

        } else {
            throw new PosicionException("Error en insertar: No existe la posicion dada");
        }
    }

    public void imprimir() {
        System.out.println("**************************");
        NodoLista<E> aux = cabecera;
        for (int i = 0; i < getSize(); i++) {
            System.out.print(aux.getDato().toString() + "\t");
            aux = aux.getSiguiente();
        }
        System.out.println("\n" + "**************************");
    }

    public Integer getSize() {
        return size;
    }

    /**
     * Metodo que permite obtener un dato segun la posicion
     *
     * @param pos posicion en la lista
     * @return Elemento
     */
    public E obtenerDato(Integer pos) throws PosicionException {
        if (!estaVacia()) {
            if (pos >= 0 && pos < size) {
                E dato = null;
                if (pos == 0) {
                    dato = cabecera.getDato();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                }

                return dato;
            } else {
                throw new PosicionException("Error en obtener dato: No existe la posicion dada");
            }

        } else {
            throw new PosicionException("Error en obtener dato: La lista esta vacia, por endde no hay esa posicion");
        }
    }

    public E eliminarDato(Integer pos) throws PosicionException {
        E auxDato = null;
        if (!estaVacia()) {
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    auxDato = cabecera.getDato();
                    cabecera = cabecera.getSiguiente();
                    size--;
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos - 1; i++) {
                        aux = aux.getSiguiente();
                    }
                    auxDato = aux.getDato();
                    NodoLista<E> proximo = aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    size--;
                }
                return auxDato;

            } else {
                throw new PosicionException("Error en eliminar dato: No existe la posicion dada");
            }

        } else {
            throw new PosicionException("Error en eliminar dato: La lista esta vacia, por endde no hay esa posicion");
        }
    }

    public void vaciar() {
        cabecera = null;
        size = 0;
        //en c utilizamos el free
        //malloc
    }

    public void modificarDato(Integer pos, E datoM) throws PosicionException {
        if (!estaVacia()) {
            if (pos >= 0 && pos < size) {
                // E dato = null;
                if (pos == 0) {
                    cabecera.setDato(datoM);
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    aux.setDato(datoM);
                }

            } else {
                throw new PosicionException("Error en obtener dato: No existe la posicion dada");
            }

        } else {
            throw new PosicionException("Error en obtener dato: La lista esta vacia, por endde no hay esa posicion");
        }
    }

    public E[] toArray() {
        // E[] matriz = (E[]) (new Object[this.size]);
        Class<E> clazz = null;
        E[] matriz = null;
        if (this.size > 0) {
            matriz = (E[]) java.lang.reflect.Array.newInstance(cabecera.getDato().getClass(), this.size);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < this.size; i++) {
                matriz[i] = aux.getDato();
                //System.out.print(aux.getDato().toString() + "\t");
                aux = aux.getSiguiente();
            }
        }
        return matriz;
    }

    public ListaEnlazada<E> toList(E[] matriz) {
        //E[] matriz = (E[]) (new Object[this.size]);
        ListaEnlazada<E> aux = new ListaEnlazada<>();
        for (int i = 0; i < matriz.length; i++) {
            if (i == 0) {
                aux.insertarCabecera(matriz[i]);
            } else {
                aux.insertar(matriz[i]);
            }
        }
        return aux;
    }

    public ListaEnlazada<E> quicksort(String atributo, TipoOrdenacion tipoOrdenacion, int izq, int der) throws Exception {
        Class<E> clazz = (Class<E>) cabecera.getDato().getClass();
        Boolean isObject = Utilidades.isObject(clazz);
        Field field = Utilidades.getField(atributo, clazz);
        E[] matriz = quickSort(atributo, tipoOrdenacion, izq, der, toArray(), clazz, isObject, field);
        return toList(matriz);
    }

    public E[] quickSort(String atributo, TipoOrdenacion tipoOrdenacion, int izq, int der, E[] matriz, Class<E> clazz, boolean isObject, Field field) throws Exception {
        if (size > 0) {
            E pivote = matriz[izq]; // tomamos primer elemento como pivote
            int i = izq;         // i realiza la búsqueda de izquierda a derecha
            int j = der;         // j realiza la búsqueda de derecha a izquierda
            while (i < j) {
                int[] aux = evaluarCambioQsort(atributo, tipoOrdenacion, matriz, izq, der, isObject, clazz, field);
                i = aux[0];
                j = aux[1];
                if (i < j) {
                    E t = matriz[i];
                    matriz[i] = matriz[j];
                    matriz[j] = t;
                }
            }
            matriz[izq] = matriz[j];      // se coloca el pivote en su lugar de forma que tendremos                                    
            matriz[j] = pivote;      // los menores a su izquierda y los mayores a su derecha

            if (izq < j - 1) {
                quickSort(atributo, tipoOrdenacion, izq, j - 1, matriz, clazz, isObject, field);          // ordenamos subarray izquierdo
            }
            if (j + 1 < der) {
                quickSort(atributo, tipoOrdenacion, j + 1, der, matriz, clazz, isObject, field);          // ordenamos subarray derecho
            }
        }
        return matriz;
    }

    public int[] evaluarCambioQsort(String atributo, TipoOrdenacion tipoOrdenacion, E[] matriz, int izq, int der, boolean isObject, Class<E> clazz, Field field) throws Exception {
        int i = izq;
        int j = der;
        E pivote = matriz[izq];
        if (isObject) {
            Method method = getMethod("get" + Utilidades.capitalizar(atributo), matriz[i].getClass());
            Method method1 = getMethod("get" + Utilidades.capitalizar(atributo), matriz[j].getClass());
            Method methodp = getMethod("get" + Utilidades.capitalizar(atributo), matriz[izq].getClass());
            if (Utilidades.isNumber(field.getType())) {
                if (tipoOrdenacion.toString().equalsIgnoreCase("ASCENDENTE")) {
                    while ((((Number) method.invoke(matriz[i])).doubleValue() <= ((Number) (methodp.invoke(matriz[izq]))).doubleValue() && i < j)) {
                        i++;
                    }
                    while ((((Number) method1.invoke(matriz[j])).doubleValue() > ((Number) (methodp.invoke(matriz[izq]))).doubleValue())) {
                        j--;
                    }
                } else {
                    while ((((Number) method.invoke(matriz[i])).doubleValue() >= ((Number) (methodp.invoke(matriz[izq]))).doubleValue() && i < j)) {
                        i++;
                    }
                    while ((((Number) method1.invoke(matriz[j])).doubleValue() < ((Number) (methodp.invoke(matriz[izq]))).doubleValue())) {
                        j--;
                    }
                }
            } else if (Utilidades.isString(field.getType())) {
                if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                    while ((((String) method.invoke(matriz[i])).toLowerCase().compareTo(((String) methodp.invoke(matriz[izq])).toLowerCase()) <= 0) && i < j) {
                        i++;
                    }
                    while ((((String) method1.invoke(matriz[j])).toLowerCase().compareTo(((String) methodp.invoke(matriz[izq])).toLowerCase()) > 0)) {
                        j--;
                    }
                } else {
                    while ((((String) method.invoke(matriz[i])).toLowerCase().compareTo(((String) methodp.invoke(matriz[izq])).toLowerCase()) >= 0) && i < j) {
                        i++;
                    }
                    while ((((String) method1.invoke(matriz[j])).toLowerCase().compareTo(((String) methodp.invoke(matriz[izq])).toLowerCase()) < 0)) {
                        j--;
                    }
                }

            } else if (Utilidades.isCharacter(field.getType())) {
                if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                    while ((Character) method.invoke(matriz[i]) <= (Character) methodp.invoke(matriz[izq]) && i < j) {
                        i++;
                    }
                    while ((Character) method1.invoke(matriz[j]) > (Character) methodp.invoke(matriz[izq])) {
                        j--;
                    }
                } else {
                    while ((Character) method.invoke(matriz[i]) >= (Character) methodp.invoke(matriz[izq]) && i < j) {
                        i++;
                    }
                    while ((Character) method1.invoke(matriz[j]) < (Character) methodp.invoke(matriz[izq])) {
                        j--;
                    }
                }
            }
        } else {
            if (Utilidades.isNumber(clazz)) {
                if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                    while ((((Number) matriz[i]).doubleValue() <= ((Number) (pivote)).doubleValue() && i < j)) {
                        i++;
                    }
                    while ((((Number) matriz[j]).doubleValue() > ((Number) (pivote)).doubleValue())) {
                        j--;
                    }
                } else {
                    while ((((Number) matriz[i]).doubleValue() >= ((Number) (pivote)).doubleValue() && i < j)) {
                        i++;
                    }
                    while ((((Number) matriz[j]).doubleValue() < ((Number) (pivote)).doubleValue())) {
                        j--;
                    }
                }
            } else if (Utilidades.isString(clazz)) {
                if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                    while ((((String) matriz[i]).toLowerCase().compareTo(((String) matriz[izq]).toLowerCase()) <= 0) && i < j) {
                        i++;
                    }
                    while ((((String) matriz[j]).toLowerCase().compareTo(((String) matriz[izq]).toLowerCase()) > 0)) {
                        j--;
                    }
                } else {
                    while ((((String) matriz[i]).toLowerCase().compareTo(((String) matriz[izq]).toLowerCase()) >= 0) && i < j) {
                        i++;
                    }
                    while ((((String) matriz[j]).toLowerCase().compareTo(((String) matriz[izq]).toLowerCase()) < 0)) {
                        j--;
                    }
                }
            } else if (Utilidades.isCharacter(clazz)) {
                if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                    while ((Character) matriz[i] <= (Character) pivote && i < j) {
                        i++;
                    }
                    while ((Character) matriz[j] > (Character) pivote) {
                        j--;
                    }
                } else {
                    while ((Character) matriz[i] >= (Character) pivote && i < j) {
                        i++;
                    }
                    while ((Character) matriz[j] < (Character) pivote) {
                        j--;
                    }
                }

            }
        }
        return new int[]{i, j};

    }

    public ListaEnlazada<E> ordenar_Shell(String atributo, TipoOrdenacion tipoOrdenacion) throws Exception {
        Class<E> clazz = null;
        E[] matriz = null;
        if (size > 0) {
            matriz = toArray();
            clazz = (Class<E>) cabecera.getDato().getClass();//primitivo, Dato envolvente, Object
            Boolean isObject = Utilidades.isObject(clazz);//si es objeto
            Integer i, salto;
            boolean cambios;
            for (salto = matriz.length / 2; salto != 0; salto /= 2) {
                cambios = true;
                while (cambios) {
                    cambios = false;
                    for (i = salto; i < matriz.length; i++) {
                        if (isObject) {
                            Field field = Utilidades.getField(atributo, clazz);
                            Method method = getMethod("get" + Utilidades.capitalizar(atributo), matriz[i - salto].getClass());
                            Method method1 = getMethod("get" + Utilidades.capitalizar(atributo), matriz[i].getClass());
                            boolean aux = evaluaCambiarDato(field.getType(), method, method1, tipoOrdenacion, i, matriz[i - salto], matriz);
                            if (aux) {
                                E t = matriz[i];
                                matriz[i] = matriz[i - salto];
                                matriz[i - salto] = t;
                                cambios = true;
                            }
                        } else {
                            boolean aux = evaluaCambiarDatoNoObjeto(clazz, tipoOrdenacion, i, matriz[i - salto], matriz);
                            if (aux) {
                                E t = matriz[i];
                                matriz[i] = matriz[i - salto];
                                matriz[i - salto] = t;
                                cambios = true;
                            }
                        }
                    }
                }
            }
        }
        if (matriz != null) {
            return toList(matriz);
        }
        return null;
    }

    /**
     * Permite hacer el cambio con datos que no son objetos
     *
     * @param clazz El tipo de clase q permite identificar q tipo de dato es
     * @param auxJ Dato en la posicion J
     * @param auxJ1 Dato en la posicion J + 1
     * @param tipoOrdenacion El tipo de ordenacion si es Ascendente o
     * Descendente
     * @param j Posicion
     * @throws Exception
     */
    private boolean evaluaCambiarDatoNoObjeto(Class clazz, TipoOrdenacion tipoOrdenacion, Integer i, E dato, E[] matriz) throws Exception {
        boolean aux = false;
        if (Utilidades.isNumber(clazz)) {
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if ((((Number) matriz[i]).doubleValue() < ((Number) dato).doubleValue())) {
                    aux = true;
                    //  cambioBurbuja(j, matriz);
                }
            } else {
                if ((((Number) matriz[i]).doubleValue() > ((Number) dato).doubleValue())) {
                    // cambioBurbuja(j, matriz);
                    aux = true;
                }
            }
        } else if (Utilidades.isString(clazz)) {
            String datoJ = (String) matriz[i];
            String datoJ1 = (String) dato;
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if ((datoJ.toLowerCase().compareTo(datoJ1.toLowerCase()) < 0)) {
                    //cambioBurbuja(j, matriz);
                    aux = true;
                }
            } else {
                if ((datoJ.toLowerCase().compareTo(datoJ1.toLowerCase()) > 0)) {
                    //cambioBurbuja(j, matriz);
                    aux = true;
                }
            }

        } else if (Utilidades.isCharacter(clazz)) {
            Character datoJ = (Character) matriz[i];
            Character datoJ1 = (Character) dato;
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if (datoJ < datoJ1) {
                    //cambioBurbuja(j, matriz);
                    aux = true;
                }
            } else {
                if (datoJ > datoJ1) {
                    //cambioBurbuja(j, matriz);
                    aux = true;
                }
            }

        }
        return aux;
    }

    /**
     * Permite hacer el cambio con datos que son objetos del modelo
     *
     * @param clazz El tipo de clase del atributo
     * @param auxJ dato en la posicion J
     * @param auxJ1 dato en la posicion J + 1
     * @param method El metodo get de J
     * @param method1 El metodo get de J + 1
     * @param tipoOrdenacion El tipo de ordenacion si es Ascendente o
     * Descendente
     * @param j posicion
     * @throws Exception
     */
    private boolean evaluaCambiarDato(Class clazz, Method method, Method method1, TipoOrdenacion tipoOrdenacion, Integer j, E dato, E[] matriz) throws Exception {
        boolean aux = false;
        if (Utilidades.isNumber(clazz)) {
            Number datoJ = (Number) method.invoke(dato);
            Number datoJ1 = (Number) method1.invoke(matriz[j]);
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if ((datoJ.doubleValue() > datoJ1.doubleValue())) {
                    // cambioBurbuja(j, matriz);
                    aux = true;
                }
            } else {
                if ((datoJ.doubleValue() < datoJ1.doubleValue())) {
                    //    cambioBurbuja(j, matriz);
                    aux = true;
                }
            }
        } else if (Utilidades.isString(clazz)) {
            String datoJ = (String) method.invoke(dato);
            String datoJ1 = (String) method1.invoke(matriz[j]);
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if ((datoJ.toLowerCase().compareTo(datoJ1.toLowerCase()) > 0)) {
                    //   cambioBurbuja(j, matriz);
                    aux = true;
                }
            } else {
                if ((datoJ.toLowerCase().compareTo(datoJ1.toLowerCase()) < 0)) {
                    //  cambioBurbuja(j, matriz);
                    aux = true;
                }
            }

        } else if (Utilidades.isCharacter(clazz)) {
            Character datoJ = (Character) method.invoke(dato);
            Character datoJ1 = (Character) method1.invoke(matriz[j]);
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if (datoJ > datoJ1) {
                    // cambioBurbuja(j, matriz);
                    aux = true;
                }
            } else {
                if (datoJ < datoJ1) {
                    //  cambioBurbuja(j, matriz);
                    aux = true;
                }
            }

        }
        return aux;
    }

    public ListaEnlazada<E> buscar_Secuencial(String atributo, Object dato) throws Exception {
        ListaEnlazada<E> resultado = new ListaEnlazada<>();
        Class<E> clazz = null;
        E[] matriz = null;
        if (size > 0) {
            matriz = toArray();
            clazz = (Class<E>) cabecera.getDato().getClass();//primitivo, Dato envolvente, Object
            Boolean isObject = Utilidades.isObject(clazz);//si es objeto
            if (isObject) {
                Field field = Utilidades.getField(atributo, clazz);
                for (int i = 0; i < matriz.length; i++) {
                    Method method1 = getMethod("get" + Utilidades.capitalizar(atributo), matriz[i].getClass());
                    boolean aux = buscarDatoPosicionObjeto(i, matriz, field.getType(), dato, method1);
                    if (aux) {
                        resultado.insertar(matriz[i]);
                    }
                }
            } else {
                for (int i = 0; i < matriz.length; i++) {
                    boolean aux = buscarDatoPosicion(i, matriz, clazz, dato);
                    if (aux) {
                        resultado.insertar(matriz[i]);
                    }
                }
            }
        }
        System.out.println("Busqueda Secuencial Terminada");
        return resultado;
    }

    /**
     * Metodo para busqueda secuencial
     *
     * @param atributo el atributo donde deseo buscar
     * @param dato El dato a buscar
     * @param izq
     * @param der
     * @param resultado
     * @return ListaEnlazada<E> El listado de datos a buscar
     * @throws java.lang.Exception
     */
    public ListaEnlazada<E> buscar_Binario(String atributo, Object dato, int izq, int der, ListaEnlazada<E> resultado) throws Exception {
        E[] arreglo = toArray();
        int izquierda = 0, derecha = arreglo.length - 1;

        while (izquierda <= derecha) {
            // Calculamos las mitades...
            int indiceDelElementoDelMedio = (int) Math.floor((izquierda + derecha) / 2);
            Method m = getMethod("get" + Utilidades.capitalizar(atributo), arreglo[indiceDelElementoDelMedio].getClass());

            // Primero vamos a comparar y ver si el resultado es negativo, positivo o 0
            int resultadoDeLaComparacion = (String.valueOf(dato)).toLowerCase().compareTo(String.valueOf(m.invoke(arreglo[indiceDelElementoDelMedio])).toLowerCase());

            // Si el resultado de la comparación es 0, significa que ambos elementos son iguales
            // y por lo tanto quiere decir que hemos encontrado la búsqueda
            if (resultadoDeLaComparacion == 0
                    || (String.valueOf(m.invoke(arreglo[indiceDelElementoDelMedio])).toLowerCase().startsWith(((String.valueOf(dato))).toLowerCase()))
                    || (String.valueOf(m.invoke(arreglo[indiceDelElementoDelMedio])).toLowerCase().endsWith(((String.valueOf(dato))).toLowerCase()))) {
                resultado.insertar(arreglo[indiceDelElementoDelMedio]);
                return resultado;
            }

            if (resultadoDeLaComparacion < 0) {
                derecha = indiceDelElementoDelMedio - 1;
            } else {
                izquierda = indiceDelElementoDelMedio + 1;
            }
        }

        return resultado;
    }

    private boolean buscarDatoPosicion(Integer j, E[] matriz, Class<E> clazz, Object dato) throws Exception {
        boolean aux = false;
        if (Utilidades.isNumber(clazz)) {
            Number datoJ = (Number) dato;
            Number datoJ1 = (Number) matriz[j];
            if (datoJ.doubleValue() == datoJ1.doubleValue()) {
                aux = true;
            }
        } else if (Utilidades.isString(clazz)) {
            String datoJ = (String) dato;
            String datoJ1 = (String) matriz[j];

            if (datoJ1.toLowerCase().startsWith(datoJ.toLowerCase())
                    || datoJ1.toLowerCase().endsWith(datoJ.toLowerCase())
                    || datoJ1.toLowerCase().equalsIgnoreCase(datoJ.toLowerCase())) {
                //cambioBurbuja(j, matriz);
                aux = true;
            }

        } else if (Utilidades.isCharacter(clazz)) {
            Character datoJ = (Character) dato;
            Character datoJ1 = (Character) matriz[j];
            if (Objects.equals(datoJ, datoJ1)) {
                aux = true;
            }
        }
        return aux;
    }

    private boolean buscarDatoPosicionObjeto(Integer j, E[] matriz, Class clazz, Object dato, Method method1) throws Exception {
        boolean aux = false;
        if (clazz.getSuperclass().getSimpleName().equalsIgnoreCase("Number")
                && dato.getClass().getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
            //Number datoJ = (Number) dato;
            Number x = (Number) method1.invoke(matriz[j]);
            String datoJ = String.valueOf((int) ((Number) dato).doubleValue());
            String datoJ1 = String.valueOf((int) (x).doubleValue());
            /*if (datoJ.doubleValue() == datoJ1.doubleValue()) {
                aux = true;
            }*/
            if (datoJ1.toLowerCase().startsWith(datoJ.toLowerCase())
                    || datoJ1.toLowerCase().endsWith(datoJ.toLowerCase())
                    || datoJ1.toLowerCase().equalsIgnoreCase(datoJ.toLowerCase())) {
                aux = true;
            }
        } else if (Utilidades.isString(clazz) && Utilidades.isString(dato.getClass())) {
            String datoJ = (String) dato;
            String datoJ1 = (String) method1.invoke(matriz[j]);

            if (datoJ1.toLowerCase().startsWith(datoJ.toLowerCase())
                    || datoJ1.toLowerCase().endsWith(datoJ.toLowerCase())
                    || datoJ1.toLowerCase().equalsIgnoreCase(datoJ.toLowerCase())) {
                //cambioBurbuja(j, matriz);
                aux = true;
            }

        } else if (Utilidades.isCharacter(clazz) && Utilidades.isCharacter(dato.getClass())) {
            Character datoJ = (Character) dato;
            Character datoJ1 = (Character) method1.invoke(matriz[j]);
            if (datoJ.charValue() == datoJ1.charValue()) {
                aux = true;
            }

        }
        return aux;
    }

    /*public static void main(String[] args) {

        try {
            ControladorCliente cc = new ControladorCliente();
            cc.llenar(10);
            String atributo = "nombres";
            cc.getListaCliente().setLista(cc.getListaCliente().getLista().ordenar_Shell(atributo, TipoOrdenacion.ASCENDENTE));
            for (int i = 0; i < cc.getSize(); i++) {
                cc.getListaCliente().obtenerDato(i).imprimir();
            }
            String nombre = cc.getListaCliente().obtenerDato(4).getNombres().trim();
            System.out.println(nombre);
            ListaEnlazada<Cliente> busqueda = new ListaEnlazada<>();
            try {
                busqueda = cc.getListaCliente().getLista().buscar_Binario(atributo, nombre, 0, cc.getSize() - 1, busqueda);
                System.out.println("Busqueda Binaria Temrinada");
            } catch (Exception e) {
                System.out.println("Se requirio llamar a la busqueda Secuencial()");
                busqueda = cc.getListaCliente().getLista().buscar_Secuencial(atributo, nombre);
            }
            System.out.println(busqueda.getSize());
            busqueda.obtenerDato(0).imprimir();
        } catch (Exception e) {
            System.out.println("erro " + e);
        }
    }*/
}
