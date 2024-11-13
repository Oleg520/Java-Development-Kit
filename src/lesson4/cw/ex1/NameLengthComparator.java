package lesson4.cw.ex1;

import java.util.Comparator;

public class NameLengthComparator implements Comparator<String>  {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
