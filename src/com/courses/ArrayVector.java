package com.courses;



public class ArrayVector {
    private double[] defaultArray;
    private int length;

    public ArrayVector() {
        defaultArray = new double[0];
        length = 0;
    }

    public ArrayVector(int length) {
        defaultArray = new double[length];
        this.length = length;
        for (int i = 0; i < length; i++)
            defaultArray[i] = 0;

    }

    public void vec(double value) {
        length++;
        if (defaultArray.length - length == -1) {
            double[] tmp = defaultArray;
            defaultArray = new double[length*2];
            for (int i = 0; i < length - 1; i++)
                defaultArray[i] = tmp[i];
        }
        defaultArray[length-1] = value;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return defaultArray.length;
    }

    public double getElement(int index) {
        return defaultArray[index];
    }

    public void setElement(int index,double value) {
        defaultArray[index] = value;
    }

    public double getMin() {
        double min = defaultArray[0];
        for (int i = 1; i < length; i++) {
            if (defaultArray[i] < min)
                min = defaultArray[i];
        }
        return min;
    }

    public double getMax() {
        double max = defaultArray[0];
        for (int i = 1; i < length; i++) {
            if (defaultArray[i] > max)
                max = defaultArray[i];
        }
        return max;
    }
    public int findNumber(double value) {
        int i = 0;
        while ((i < length) && (defaultArray[i] != value))
            i++;
        if (i < length)
            return i;
        else
            return -1;
    }


    public static double scalarMult(ArrayVector first,ArrayVector second) {
        double res = 0;
        if (first.length == second.length) {
            for (int i = 0; i < second.length; i++) {
                res += first.defaultArray[i] * second.defaultArray[i] ;
            }
        }
        return res;
    }

    public double getAverage() {
        double summ = 0;
        for (int i = 0; i < length; i++)
            summ += defaultArray[i];
        if (length != 0)
            return summ / length;
        else
            return 0;
    }

    public double getNorm() {
        double norm = 0;
        for (int i = 0; i < length; i++)
            norm += defaultArray[i]*defaultArray[i];
        norm = Math.sqrt(norm);
        return norm;
    }


    public static ArrayVector mult(ArrayVector vector, double value) {
        ArrayVector res = new ArrayVector();
        for (int i = 0; i < vector.length; i++)
            res.vec(value*vector.defaultArray[i]);
        return res;
    }

    public static ArrayVector sum(ArrayVector first,ArrayVector second) {
        int len = first.length;
        if (first.length < second.length)
            len = second.length;
        ArrayVector res = new ArrayVector(len);
        for (int i = 0; i < second.length; i++)
            res.defaultArray[i] = first.defaultArray[i];
        for (int i = 0; i < second.length; i++)
            res.defaultArray[i] += second.defaultArray[i];
        return res;
    }

}
