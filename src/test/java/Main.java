import javax.swing.*;
import java.util.Random;

public class Main {

    public static plano plano;

    public static void main(String[] args) {

        MergeSort mergeSort = new MergeSort();
        int arr [] = {5,26,12,6,1,4,7,8,77,34};
        int n = arr.length;

       /* System.out.println("Listado Original");
        for (int value : arr) {
            System.out.print(value + " ");
        }
*/
        //System.out.println("Listado Ordenado");
        //mergeSort.sort(arr,0,n-1);
        //mergeSort.printArray(arr);
        int[] arrAleatory = new int[20];
        System.out.println("Generar Grafica");

        for (int i=1;i< 20;i++) {
            Random randomAleatorio = new Random(); // creating Random object
            arrAleatory[i] = randomAleatorio.nextInt(20 * i);
             mergeSort.sort(arrAleatory,0,n-1);
            mergeSort.printArray(arrAleatory);
        }
        System.out.println("Listado Aleatorio");
        mergeSort.printArray(arrAleatory);
        mergeSort.graficMergeSort();

        System.out.println("Generar Grafica Random");
       /// mergeSort.sort(arrAleatory,0,n-1);
        //mergeSort.printArray(arrAleatory);
        for (int value : arrAleatory) {
            System.out.print(value + "pruebas ");
        }
    }

}
