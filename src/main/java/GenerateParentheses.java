package main.java;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate("", n, n,n, list);
        return list;
    }

    void generate(String item, int n, int left, int right, List<String> list) {
        if (item.length() >= 2*n) {
            list.add(item);
            return;
        }
        if (left > 0) {
            generate(item + "(", n, left - 1, right, list);
        }
        if (right > left) {
            generate(item + ")", n, left, right - 1, list);
        }
    }


    public static void main(String[] args) {
        GenerateParentheses test = new GenerateParentheses();
        test.generateParenthesis(2);
    }
}
