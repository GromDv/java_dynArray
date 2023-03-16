import java.util.Random;

public class Program {
    public static void main(String[] args) {

        Random r = new Random();
        dynArrayList<Integer> intList = new dynArrayList<>();
        for (int j = 0; j < 20; j++)
            intList.add(r.nextInt(1, 100));
        intList.add(47);
        intList.add(51);

        System.out.println("Массив целых чисел:");
        intList.printArray();

        intList.removeId(2);
        System.out.println("После удаления по индексу:");
        intList.printArray();

        intList.removeData(47);
        System.out.println("После удаления по значению:");
        intList.printArray();

        System.out.println("Минимум:");
        System.out.println(intList.minData());

        System.out.println("Максимум:");
        System.out.println(intList.maxData());

        System.out.println("Сумма:");
        System.out.println(intList.sumData());

        System.out.println("Произведение:");
        System.out.println(intList.multData());

        System.out.println("Поиск индекса по значению:");
        System.out.println(intList.findId(51));
        System.out.println(intList.findId(13));

        System.out.println("Наличие элемента:");
        try {
            System.out.println(intList.findData(51));
            System.out.println(intList.findData(13));
        } catch (NonComparableTypeException e) {
            e.printStackTrace();
        }

        try {
            //System.out.print("Пузырьковая сортировка:");
            //intList.BubbleSort();
            //System.out.print("Сортировка простыми вставками:");
            //intList.InsertionSort();
            System.out.print("Сортировка простым выбором:");
            intList.SelectionSort();
            intList.printArray();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Поиск по индексу:");
        try {
            System.out.println(intList.getElem(51));
            System.out.println(intList.getElem(13));
        } catch (IndexOutOfRange e) {
            e.printStackTrace();
        }
        


        dynArrayList<Double> dblList = new dynArrayList<>();
        for (int j = 0; j < 20; j++)
            dblList.add(r.nextDouble(1, 100)); // добавление элемента
        dblList.add(47.);
        dblList.add(51.);

        System.out.println("Массив вещественных чисел:");
        dblList.printArray();

        dblList.removeId(2);
        System.out.println("После удаления по индексу:");
        dblList.printArray();

        dblList.removeData(47.);
        System.out.println("После удаления по значению:");
        dblList.printArray();

        System.out.println("Минимум:");
        System.out.println(dblList.minData());

        System.out.println("Максимум:");
        System.out.println(dblList.maxData());

        System.out.println("Сумма:");
        System.out.printf("%.5f\n",dblList.sumData());

        System.out.println("Произведение:");
        System.out.printf("%.5f\n",dblList.multData());

        System.out.println("Поиск индекса по значению:");
        System.out.println(dblList.findId(51.));
        System.out.println(dblList.findId(13.));

        System.out.println("Наличие элемента:");
        try {
            System.out.println(dblList.findData(51.));
            System.out.println(dblList.findData(13.));
        } catch (NonComparableTypeException e) {
            e.printStackTrace();
        }
        
        try {
            //System.out.print("Пузырьковая сортировка:");
            //dblList.BubbleSort();
            System.out.print("Сортировка простыми вставками:");
            dblList.InsertionSort();
            //System.out.print("Сортировка простым выбором:");
            //dblList.SelectionSort();//Сортировка простым выбором
            dblList.printArray();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Массив строк:");
        dynArrayList<String> stringList = new dynArrayList<>();
        stringList.add("Слово1");
        stringList.add("Слово2");
        stringList.add("Слово3");
        stringList.add("Слово4");
        stringList.add("Слово5");
        stringList.add("Слово6");
        stringList.add("Слово7");
        stringList.add("Слово8");
        stringList.add("Слово9");
        stringList.add("Слово10");
        stringList.printArray();

        stringList.removeId(1);
        System.out.println("После удаления по индексу:");
        stringList.printArray();

        stringList.removeData("Слово5");
        System.out.println("После удаления по значению:");
        stringList.printArray();

    }
}