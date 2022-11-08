import java.util.ArrayList;

public class dataProcedures {

    private static double liftShift = 0.25;
    private static double liftStart = 0;
    private static double liftFinish = 1.85;

    private static String inchSymbol = "''";
    private static String semicolonSeparator = ";";

    private static String attributeName = "Lift";
    private static String car = "Toyota 4Runner 2010-2022";
    private static String carMake = "Toyota";
    private static String carModel = "4Runner";
    private static int yearStart = 2010;
    private static int yearFinish = 2022;


    public static String carName() {
        String carName = carMake + " " + carModel + " " + yearStart + "-" + yearFinish;
        return carName;
    }

    public static ArrayList<String> liftRange(double liftStart, double liftFinish) {
        ArrayList<Double> liftIntsArrayList = new ArrayList<Double>();
        ArrayList<String> liftStringsArrayList = new ArrayList<String>();

        for (double i = liftStart; i <= liftFinish; i = i + liftShift) {
            liftIntsArrayList.add(i);
        }
        if (liftIntsArrayList.get(liftIntsArrayList.size() - 1) != liftFinish)
            liftIntsArrayList.add(liftFinish);

        for (int i = 0; i < liftIntsArrayList.size(); i++) {
            liftStringsArrayList.add(liftIntsArrayList.get(i) + inchSymbol);
        }
        return liftStringsArrayList;
    }

    public static ArrayList<String> addAttributesNumbers(String carMake, String carModel, int yearStart, int yearFinish, String attributeName, ArrayList<String> attributesValuesList) {
        ArrayList<String> attributesWithAddedNumbers = new ArrayList<String>();

        for (int i = 0; i < attributesValuesList.size(); i++) {
            String s = new String();
            s = (carName() + " " + attributeName + ": " + attributesValuesList.get(i) + ": " +
                    (i + 1) + ": " + "0");
            attributesWithAddedNumbers.add(s);
        }
        return attributesWithAddedNumbers;
    }


    public static ArrayList<String> addSemicolonSeparatorInBetween(ArrayList<String> attributesList) {
        ArrayList<String> attributesWithSeparatorList = new ArrayList<String>();
        for (int i = 0; i < attributesList.size(); i++) {
            attributesWithSeparatorList.add(attributesList.get(i) + semicolonSeparator);
        }

        return attributesWithSeparatorList;
    }

    public static ArrayList<String> lastSemicolonSeparatorRemove(ArrayList<String> attributesWithSeparatorList) {
        String replace = attributesWithSeparatorList.get(attributesWithSeparatorList.size() - 1).replace(semicolonSeparator, "");
        attributesWithSeparatorList.remove(attributesWithSeparatorList.size() - 1);
        attributesWithSeparatorList.add(replace);

        return attributesWithSeparatorList;
    }

    public static void arrayListPrintToConsole(ArrayList<String> stringArrayList) {
        for (int i = 0; i < stringArrayList.size(); i++) {
            System.out.println(stringArrayList.get(i));
        }
    }

    public static void main(String[] args) {
        arrayListPrintToConsole(
                lastSemicolonSeparatorRemove(
                        addSemicolonSeparatorInBetween(
                                addAttributesNumbers(
                                        carMake, carModel, yearStart, yearFinish, attributeName,
                                        liftRange(liftStart, liftFinish))))

        );
    }
}
