import static org.math.array.DoubleArray.increment;

import java.awt.Dimension;
import java.util.Arrays;
import javax.swing.JFrame;
import org.math.plot.Plot2DPanel;

public class MergeSort {
    int[] countArray ;
    public void sort(int arr[], int left, int right){
        if(left < right){
            //Encuentra el punto medio del vector.
            int middle = (left + right) / 2;
            //Divide la primera y segunda mitad (llamada recursiva).
            sort(arr, left, middle);
            sort(arr, middle +1, right);
            //Une las mitades.
            merge(arr, left, middle, right);
        }
    }

    public void merge(int arr[], int left, int middle, int right) {
        //Encuentra el tamaño de los sub-vectores para unirlos.
        int n1 = middle - left + 1;
        int n2 = right - middle;

        //Vectores temporales.
        int leftArray[] = new int [n1];
        int rightArray[] = new int [n2];

        //Copia los datos a los arrays temporales.
        for (int i=0; i < n1; i++) {
            leftArray[i] = arr[left+i];


        }
        for (int j=0; j < n2; j++) {
            rightArray[j] = arr[middle + j + 1];
        }
        /* Une los vectorestemporales. */

//Índices inicial del primer y segundo sub-vector.
        int i = 0, j = 0;

//Índice inicial del sub-vector arr[].
        int k = left;

//Ordenamiento.
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
                //countArray = i;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;

        }//Fin del while.

        /* Si quedan elementos por ordenar */
//Copiar los elementos restantes de leftArray[].
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
            countArray[k] = new int [i];
        }
//Copiar los elementos restantes de rightArray[].
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i) {
            System.out.println(arr[i] + "Original ");
        }
        System.out.println();
    }

    public void graficMergeSort(int[] arra) {

        double[] x = Arrays.stream(countArray).asDoubleStream().toArray();;// x = 0.0:0.1:1.0
        double[] y = Arrays.stream(arra).asDoubleStream().toArray();

        Plot2DPanel plot = new Plot2DPanel();
        plot.addLegend("SOUTH");
        /*sirve esta parte para agregar colores*/
        // add the histogram (50 slices) of y to the PlotPanel in GREEN
       // plot.addHistogramPlot("Uniform population", Color.RED, y, 50);
        // add a line plot to the PlotPanel
        plot.addLinePlot("Using ", x, y);

        // put the PlotPanel in a JFrame, as a JPanel
        JFrame frame = new JFrame("a plot panel");
        /*sirve esta parte para definir el tamaño de la ventana que se abrira*/
        frame.setSize(new Dimension(300, 300));
        frame.setMinimumSize(new Dimension(200, 200));
        frame.setContentPane(plot);
        frame.setVisible(true);

    }

}