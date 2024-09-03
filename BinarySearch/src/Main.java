

public class Main {
    public static void main(String[] args){
        Integer[] toSearch = new Integer[1000];
        for (int i = 0; i < toSearch.length; i++) {
            toSearch[i] = i+1;
        }

        Search s = new Search();

        System.out.println(s.binarySearch(toSearch, 876));
    }
}
