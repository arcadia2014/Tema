import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;  

public class BucketSort {

    // Método para ordenar con Insertion Sort
    public static void insertionSort(ArrayList<Integer> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            int key = bucket.get(i);
            int j = i - 1;

            // Mover los elementos mayores hacia la derecha del cubo
            while (j >= 0 && bucket.get(j) > key) {
                bucket.set(j + 1, bucket.get(j));
                j = j - 1;
            }
            bucket.set(j + 1, key);
        }
    }

    public static void bucketSort(int[] array) {
        int n = array.length;

        // Encontrar el valor mínimo y máximo del arreglo para el cubo o cubeta
        int min = array[0];
        int max = array[0];
        for (int num : array) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        // n esta parte de codigo se crean los cubos
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] buckets = (ArrayList<Integer>[]) new ArrayList[n];

        // Inicializar los buckets
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribuir los elementos en los buckets
        for (int num : array) {
            int bucketIndex = (int) ((num - min) / (double) (max - min + 1) * n);
            buckets[bucketIndex].add(num);
        }

        // Ordenar cada bucket usando Insertion Sort
        for (int i = 0; i < n; i++) {
            insertionSort(buckets[i]);
        }

        // Combinar los elementos de los buckets en el array original
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int num : bucket) {
                array[index++] = num;
            }
        }
    }

    // Método para imprimir el arreglo
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Método para leer datos desde el teclado
    public static int[] readFromKeyboard() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese la cantidad de elementos:");
        int n = Integer.parseInt(reader.readLine());

        int[] array = new int[n];
        System.out.println("Ingrese los elementos:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            array[i] = Integer.parseInt(reader.readLine());
        }
        return array;
    }

    // Método principal
    public static void main(String[] args) throws IOException {
        int[] array = readFromKeyboard();

        System.out.println("Arreglo original:");
        printArray(array);

        // Ordenar el arreglo usando Bucket Sort con Insertion Sort en los buckets
        bucketSort(array);

        System.out.println("Arreglo ordenado:");
        printArray(array);
    }
}
