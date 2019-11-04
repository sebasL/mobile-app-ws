package prueba.administracion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author
 */
public class Numeros {
	// ~ Methods
	// ------------------------------------------------------------------------------------

	public static void main(String[] args) {
        int[] numeros = new int[] {
        		12, 10, 26, 21, 23,  27, 9, 10, 29, 04, 20, 35, 05, 15, 28, 1, 2, 3, 21, 20, 32};
        List seleccionados = new ArrayList();
        List boletas = new ArrayList();
        List boleta = new ArrayList();
        boletas.add(boleta);
        while (seleccionados.size() < numeros.length) {
            if (boleta.size() == 6) {
                boleta = new ArrayList();
                boletas.add(boleta);
            }
            int indice = new Double(Math.random() * numeros.length).intValue();
            if (!seleccionados.contains(new Integer(indice)) && !boleta.contains(new Integer(numeros[indice]))) {
                seleccionados.add(new Integer(indice));
                boleta.add(new Integer(numeros[indice]));
            }
        }
        Iterator itBoletas = boletas.iterator();
        while (itBoletas.hasNext()) {
            List boletaLista = (List) itBoletas.next();
            Collections.sort(boletaLista);
            Iterator itBoleta = boletaLista.iterator();
            System.out.print("Boleta: ");
            while (itBoleta.hasNext()) {
                System.out.print(itBoleta.next() + " ");
            }
            System.out.println();
        }
    }
}
