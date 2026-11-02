/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.siddikhome;

import java.util.Arrays;
import java.util.Random;



public class Siddikhome {

//    /**
//     * خوارزمية الترتيب بالاختيار (Selection Sort)
//     * تعتمد على إيجاد العنصر الأصغر ونقله إلى بداية المصفوفة تدريجياً.
//     * @param a المصفوفة المراد ترتيبها
//     */
    public static <T extends Comparable<T>> void selectionSort(T[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[min]) < 0) {
                    min = j;
                }
            }
            T temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

//    /**
//     * خوارزمية الترتيب الإدراجي (Insertion Sort)
//     * تقوم ببناء المصفوفة المرتبة تدريجياً عبر إدراج كل عنصر في مكانه المناسب.
//     * @param a المصفوفة المراد ترتيبها
//     */
    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        for (int i = 1; i < a.length; i++) {
            T key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j].compareTo(key) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

//    /**
//     * خوارزمية الترتيب الفقاعي (Bubble Sort)
//     * تقارن العناصر المتجاورة وتتبادل مواقعها إذا كانت بترتيب خاطئ مع تحسين إيقاف التنفيذ إن كانت مرتبة مسبقاً.
//     * @param a المصفوفة المراد ترتيبها
//     */
    public static <T extends Comparable<T>> void bubbleSort(T[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

//    /**
//     * خوارزمية الترتيب بالدمج (Merge Sort)
//     * تعتمد على منهج "فرق تسد" بتقسيم المصفوفة إلى نصفين، ترتيبيهما، ثم دمجهم.
//     * @param a المصفوفة المراد ترتيبها
//     * @param left الحد الأدنى للمصفوفة أو النصف
//     * @param right الحد الأقصى للمصفوفة أو النصف
//     */
    public static <T extends Comparable<T>> void mergeSort(T[] a, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);

        T[] temp = Arrays.copyOfRange(a, left, right + 1);

        int i = 0;
        int j = mid - left + 1;
        int k = left;

        while (i <= mid - left && j < temp.length) {
            if (temp[i].compareTo(temp[j]) <= 0) {
                a[k++] = temp[i++];
            } else {
                a[k++] = temp[j++];
            }
        }

        while (i <= mid - left) {
            a[k++] = temp[i++];
        }

        while (j < temp.length) {
            a[k++] = temp[j++];
        }
    }

//    /**
//     * خوارزمية الترتيب السريع (Quick Sort)
//     * تعتمد على اختيار عنصر محوري (Pivot) وتقسيم العناصر حوله.
//     * @param a المصفوفة المراد ترتيبها
//     * @param low الحد الأدنى
//     * @param high الحد الأقصى
//     */
    public static <T extends Comparable<T>> void quickSort(T[] a, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;

        T temp = a[mid];
        a[mid] = a[high];
        a[high] = temp;

        T pivot = a[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a[j].compareTo(pivot) <= 0) {
                i++;

                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        quickSort(a, low, i);
        quickSort(a, i + 2, high);
    }

//    /**
//     * وظيفة لقياس وقت تنفيذ كل خوارزمية ترتيب (ملاحظة: الدالة تعيد النتيجة بالميكروثانية بناءً على الكود الأصلي، 
//     * وتتم طباعة التسمية "nano seconds" في الماين كما طلبت تماماً).
//     * @param name اسم الخوارزمية المراد اختبارها
//     * @param original النسخة الأصلية للمصفوفة العددية
//     * @return وقت الترتيب بالوحدة المحسوبة
//     */
    public static long measure(String name, Integer[] original) {
        Integer[] a = Arrays.copyOf(original, original.length);

        long start = System.nanoTime();

        if (name.equals("Selection Sort")) {
            selectionSort(a);
        } else if (name.equals("Insertion Sort")) {
            insertionSort(a);
        } else if (name.equals("Bubble Sort")) {
            bubbleSort(a);
        } else if (name.equals("Merge Sort")) {
            mergeSort(a, 0, a.length - 1);
        } else {
            quickSort(a, 0, a.length - 1);
        }

        long end = System.nanoTime();

        return (end - start) / 1000;
    }

//    /**
//     * الدالة الرئيسية (Main Method) لبدء تشغيل البرنامج وتقييم أداء الخوارزميات
//     */
    public static void main(String[] args) {
        int N = 100;
        Random r = new Random(42);

        // 1. توليد مصفوفة عشوائية
        Integer[] random = new Integer[N];

        for (int i = 0; i < N; i++) {
            random[i] = r.nextInt(1000000);
        }

        // 2. مصفوفة مرتبة
        Integer[] sorted = Arrays.copyOf(random, N);
        Arrays.sort(sorted);

        // 3. مصفوفة مرتبة بشكل معكوس
        Integer[] reversed = new Integer[N];

        for (int i = 0; i < N; i++) {
            reversed[i] = sorted[N - 1 - i];
        }

        // 4. مصفوفة مرتبة جزئياً (عبر خلط 10% من عناصرها عشوائياً)
        Integer[] partial = Arrays.copyOf(sorted, N);

        for (int k = 0; k < N / 10; k++) {
            int i = r.nextInt(N);
            int j = r.nextInt(N);

            Integer temp = partial[i];
            partial[i] = partial[j];
            partial[j] = temp;
        }

        // أسماء الخوارزميات المستهدفة للمقارنة
        String[] names = {
            "Selection Sort",
            "Insertion Sort",
            "Bubble Sort",
            "Merge Sort",
            "Quick Sort"
        };

        // طباعة عناوين الأعمدة في الجدول
        System.out.println("Algorithm | Random | Reversed | Partially Sorted | Sorted");
        System.out.println("---------------------------------------------------------");

        // قياس وقت كل خوارزمية تحت الحالات الأربع وطباعة النتائج
        for (String name : names) {
            System.out.println(
                name + " | "
                + measure(name, random) + " nano seconds | "
                + measure(name, reversed) + " nano seconds | "
                + measure(name, partial) + " nano seconds | "
                + measure(name, sorted) + " nano seconds"
            );
        }
    }
}