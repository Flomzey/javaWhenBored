public class Search {
    

    public int binarySearch(Integer[] toSearch, int number){
        int half = (toSearch.length/2)+(toSearch.length%2);

        System.out.println(half);
        
        if(toSearch[half] == number){
            return half;
        }

        if(toSearch[half] > number){
            return binarySearch(splitRightLeft(false, toSearch), number);
        }

        if(toSearch[half] < number){
            return binarySearch(splitRightLeft(true, toSearch), number);
        }
        return 0;
    }

    public Integer[] splitRightLeft(boolean rightLeft, Integer[] toSplit){
        int half = (toSplit.length/2)+(toSplit.length%2);
        Integer[] splitted = new Integer[half];
        int j = 0;

        if(rightLeft == true){
            for (int i = half; i < toSplit.length; i++) {
                splitted[j] = toSplit[i];
                j++;
            }
        }
        if(rightLeft == false){
            for (int i = 0; i < half; i++) {
                splitted[j] = toSplit[i];
                j++;
            }
        }

        return splitted;
    }

    public String outArray(Integer[] out){
        String arr = "[";
        for (int i = 0; i < out.length; i++) {
            arr += out[i] + ", ";
        }
        arr += "]";

        return arr;
    }
}
