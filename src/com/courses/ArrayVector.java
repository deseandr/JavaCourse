package com.courses;



public class ArrayVector {
    private double[] defaultArray;
    private int dlina;

    public ArrayVector() {
        defaultArray = new double[0];
        dlina = 0;
    }

    public ArrayVector(int dlina) {
        defaultArray = new double[dlina];
        this.dlina = dlina;
        for (int i = 0; i < dlina; i++)
            defaultArray[i] = 0;

    }

    public void vec(double value) {
        dlina++;
        if (defaultArray.length - dlina == -1) {
            double[] tmp = defaultArray;
            defaultArray = new double[dlina*2];
            for (int i = 0; i < dlina - 1; i++)
                defaultArray[i] = tmp[i];
        }
        defaultArray[dlina-1] = value;
    }

    public int getSize() {
        return dlina;
    }


    public double getElement(int index) {

        return defaultArray[index];
    }

    public void setElement(int index,double value) {
        defaultArray[index] = value;
    }

    public double getMin() {
        double min = defaultArray[0];
        for (int i = 1; i < dlina; i++) {
            if (defaultArray[i] < min)
                min = defaultArray[i];
        }
        return min;
    }

    public double getMax() {
        double max = defaultArray[0];
        for (int i = 1; i < dlina; i++) {
            if (defaultArray[i] > max)
                max = defaultArray[i];
        }
        return max;
    }
    public int findNumber(double value) {
        int i = 0;
        while ((i < dlina) && (defaultArray[i] != value))
            i++;
        if (i < dlina)
            return i;
        else
            return -1;
    }


    public static double scalarMult(ArrayVector first,ArrayVector second) {
        double umn = 0;
        if (first.dlina == second.dlina) {
            for (int i = 0; i < second.dlina; i++) {
                umn += first.defaultArray[i] * second.defaultArray[i] ;
            }
        }
        return umn;
    }

    public double getAverage() {
        double summ = 0;
        for (int i = 0; i < dlina; i++)
            summ += defaultArray[i];
        if (dlina != 0)
            return summ / dlina;
        else
            return 0;
    }

    public double getNorm() {
        double norm = 0;
        for (int i = 0; i < dlina; i++)
            norm += defaultArray[i]*defaultArray[i];
        norm = Math.sqrt(norm);
        return norm;
    }


    public static ArrayVector mult(ArrayVector vector, double value) {
        ArrayVector res = new ArrayVector();
        for (int i = 0; i < vector.dlina; i++)
            res.vec(value*vector.defaultArray[i]);
        return res;
    }

    public static ArrayVector sum(ArrayVector first,ArrayVector second) {
        int len = first.dlina;
        if (first.dlina < second.dlina)
            len = second.dlina;
        ArrayVector res = new ArrayVector(len);
        for (int i = 0; i < second.dlina; i++)
            res.defaultArray[i] = first.defaultArray[i];
        for (int i = 0; i < second.dlina; i++)
            res.defaultArray[i] += second.defaultArray[i];
        return res;
    }

}
