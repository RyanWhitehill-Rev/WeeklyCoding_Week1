

public class WeeklyFunctions {

    public static void main(String args[]) {


        int[] arr1 = {5, 4, 6, 46, 54, 12, 13, 17};
        int[] arr2 = {46, 54, 466, 544};
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr4 = {13, 6, 17, 18, 19, 20, 37};

        lcmOfArray(arr1);
        lcmOfArray(arr2);
        lcmOfArray(arr3);
        lcmOfArray(arr4);


        lookAndSay(54544666);
        lookAndSay(95);
        lookAndSay(120520);
        lookAndSay(231);
        lookAndSay(1324252651);



    }

    public static int lcmOfArray(int[] arrayIn) {

        int currentLCM = arrayIn[0];

        for(int i = 1; i < arrayIn.length; i++) {
            currentLCM = (currentLCM*arrayIn[i])/euclideanAlgImpl(currentLCM, arrayIn[i]);
        }

        System.out.println(currentLCM);

        return currentLCM;
    }

    //Returns the greatest common denominator of two integers
    public static int euclideanAlgImpl(int int1, int int2) {
        int largerInt;
        int smallerInt;
        int remainder;

        if(int1 >= int2) {
            largerInt = int1;
            smallerInt = int2;
        } else {
            largerInt = int2;
            smallerInt = int1;
        }
        remainder = largerInt;
        while(remainder >= smallerInt) {
            remainder -= smallerInt;
        }

        if(remainder == 0) {
            return smallerInt;
        } else if(remainder == 1) {
            return 1;
        } else {
            return euclideanAlgImpl(smallerInt, remainder);
        }

    }

    public static int lookAndSay(int intIn) {

        String stringIn = Integer.toString(intIn);

        if(stringIn.length() % 2 == 1) {
            //Odd length
            return -1;
        }

        StringBuilder returnString = new StringBuilder();

        for(int i = 0; i < stringIn.length(); i += 2) {

            for(int j = 0; j < Character.getNumericValue(stringIn.charAt(i)); j++) {
                returnString.append(stringIn.charAt(i+1));

            }
        }

        System.out.println(returnString);

        return Integer.parseInt(returnString.toString());
    }


}
