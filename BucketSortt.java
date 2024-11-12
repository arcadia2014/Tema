import java.util.ArrayList;
import java.util.Collections;

public class BucketSortt {

    // Función de Bucket Sort
    public static void bucketSort(float[] arr) {
        int n = arr.length;
        if (n <= 0) return;

        // Crear n buckets vacíos
        ArrayList<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<Float>();
        }

        // Distribuir los elementos en los buckets
        for (float num : arr) {
            int index = (int) (n * num); // Calcular el índice del bucket
            buckets[index].add(num);
        }

        // Ordenar cada bucket individualmente
        for (ArrayList<Float> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Combinar todos los buckets en el arreglo original
        int index = 0;
        for (ArrayList<Float> bucket : buckets) {
            for (float num : bucket) {
                arr[index++] = num;
            }
        }
    }

    // Método principal para probar el Bucket Sort
    public static void main(String[] args) {
        float[] arr = {0.42f, 0.32f, 0.53f, 0.25f, 0.47f, 0.51f};

        System.out.println("Arreglo original:");
        for (float num : arr) {
            System.out.print(num + " ");
        }

        // Llamar a la función de Bucket Sort
        bucketSort(arr);

        System.out.println("\nArreglo ordenado:");
        for (float num : arr) {
            System.out.print(num + " ");
        }
    }
}