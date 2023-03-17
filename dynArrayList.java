public class dynArrayList<T> {
    private int length;
    private T[] data;

    public dynArrayList() {
        this.length = 0;
        this.data = (T[]) new Object[0];
    }

    public dynArrayList(T[] data) {
        this.length = data.length;
        this.data = data;
    }

    public int getLength() {
        return this.length;
    }

    public T[] getData() {
        return this.data;
    }

    /***
     * Печать
     */
    public void printArray() {
        System.out.printf("{ ");
        for (T t : data) {
            if (t instanceof Double)
                System.out.printf("%.2f; ", t);
            else
                System.out.printf("%s; ", t.toString());
        }
        System.out.printf(" }\n");
    }

    public void add(T element) {
        int newlen = length + 1;
        T[] newData = (T[]) new Object[newlen];
        //for (int i = 0; i < length; i++) {
        //    newData[i] = data[i];
        //}
        System.arraycopy(data, 0, newData, 0, length);
        data = newData;
        data[length++] = element;
    }

    /***
     * Удаление по индексу
     * 
     * @param idx
     * @throws IndexOutOfBoundsException
     */
    public void removeId(int id) throws IndexOutOfBoundsException {
        if (id < 0 || id > this.length) {
            throw new IndexOutOfBoundsException("in removeId()");
        } else {
            int newlen = length - 1;
            T[] newData = (T[]) new Object[newlen];
            int i = 0;
            while (i < id) {
                newData[i] = data[i];
                i++;
            }
            // i++;
            while (i < newlen) {
                newData[i] = data[i + 1];
                i++;
            }
            data = newData;
            length--;
        }
    }

    /****
     * Удаление элемента по значению
     * 
     * @param element
     */
    public void removeData(T el) {
        for (int i = 0; i < length; i++) {
            if (el instanceof Double) {
                if (compareD((Double) data[i], (Double) el) == 0) {
                    removeId(i);
                    break;
                }
            } else {
                if (data[i] == el) {
                    removeId(i);
                    break;
                }
            }

        }
    }

    public T minData() {
        T min = data[0];
        for (int i = 0; i < data.length; i++) {
            if (min instanceof Integer) {
                if ((Integer) min > (Integer) data[i])
                    min = data[i];
            } else if (min instanceof Double) {
                if ((Double) min > (Double) data[i])
                    min = data[i];
            }
        }
        return min;
    }

    public T maxData() {
        T max = data[0];
        for (int i = 0; i < data.length; i++) {
            if (max instanceof Integer) {
                if ((Integer) max < (Integer) data[i])
                    max = data[i];
            } else if (max instanceof Double) {
                if ((Double) max < (Double) data[i])
                    max = data[i];
            }
        }
        return max;
    }

    public T sumData() {
        T result = data[0];
        if (result instanceof Integer) {
            Integer res = 0;
            for (int i = 0; i < length; i++) {
                res += (int) data[i];
            }
            result = ((T) res);
        } else if (result instanceof Double) {
            Double res = (double) 0;
            for (int i = 0; i < data.length; i++) {
                res += (Double) data[i];
            }
            result = ((T) res);
        }
        return result;
    }

    public T multData() {
        T result = data[0];
        if (result instanceof Integer) {
            Integer res = (Integer) data[0];
            for (int i = 1; i < length; i++) {
                res *= (int) data[i];
            }
            result = ((T) res);
        } else if (result instanceof Double) {
            Double res = (double) data[0];
            for (int i = 1; i < data.length; i++) {
                res *= (Double) data[i];
            }
            result = ((T) res);
        }
        return result;
    }

    public int findId(T el) {
        int i = 0;
        if (el instanceof Integer) {
            for (T t : data) {
                if (t == el)
                    return i;
                i++;
            }
        } else if (el instanceof Double) {
            for (T t : data) {
                if (compareD((Double) t, (Double) el) == 0)
                    return i;
                i++;
            }
        }
        return -1;
    }

    public int compareD(Double a, Double b) {
        Double c = a - b;
        if (c > 0) {
            return 1;
        } else if (c < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public boolean findData(T el) throws NonComparableTypeException {
        if (el instanceof Comparable) {
            Comparable<T> elem = (Comparable<T>) el;
            for (T t : data) {
                if (elem.compareTo(t) == 0) 
                    return true;
            }
        } else {
            throw new NonComparableTypeException(el.getClass().getSimpleName());
        }
        return false;
    }

    public T getElem(int id) throws IndexOutOfRange {
        if (id >= 0 && id < length)
            return data[id];
        else {
            throw new IndexOutOfRange("getElem");
        }
    }

    public void BubbleSort() throws NonComparableTypeException {
        T tmp = data[0];
        if (tmp instanceof Comparable) {
            for (int i = 0; i < length - 1; i++) {
                boolean hasSwap = false;
                for (int j = 0; j < length - i - 1; j++) {
                    Comparable<T> elem = (Comparable<T>) data[j];
                    T nextElem = data[j + 1];
                    if (elem.compareTo(nextElem) > 0) {
                        swap(j, j + 1);
                        hasSwap = true;
                    }
                }
                if (!hasSwap) {
                    break;
                }
            }
        } else {
            throw new NonComparableTypeException(tmp.getClass().getSimpleName());
        }
    }

    public void InsertionSort() throws NonComparableTypeException {
        T tmp = data[0];
        if (tmp instanceof Comparable) {
            for (int i = 1; i < length; i++) {
                for (int j = i; j > 0; j--) {
                    Comparable<T> elem = (Comparable) data[j];
                    T prevElem = data[j - 1];
                    if (elem.compareTo(prevElem) < 0) {
                        swap(j, j - 1);
                    } else {
                        break;
                    }
                }
            }
        } else {
            throw new NonComparableTypeException(tmp.getClass().getSimpleName());
        }
    }

    public void SelectionSort() throws NonComparableTypeException {
        T min = data[0];
        if (min instanceof Comparable) {
            for (int i = 0; i < getLength(); i++) {
                min = data[i];
                int min_idx = i;

                for (int j = i; j < length; j++) {
                    Comparable<T> elem = (Comparable<T>) data[j];
                    if (elem.compareTo(min) < 0) {
                        min = data[j];
                        min_idx = j;
                    }
                }

                if (i != min_idx) {
                    swap(i, min_idx);
                }
            }
        } else {
            throw new NonComparableTypeException(min.getClass().getSimpleName());
        }
    }

    private void swap(int i, int j) {
        T tmp = this.data[i];
        this.data[i] = this.data[j];
        this.data[j] = tmp;
    }

}
