// https://leetcode.com/problems/product-of-the-last-k-numbers/description/

package prefixsum.medium;

import java.util.ArrayList;
import java.util.List;

public class ProductOfLastKNumbers {
    List<Integer> products;
    int n = 1;

    public ProductOfLastKNumbers() {
        products = new ArrayList<>();
        products.add(1); // Initialize with 1
        n = 1;
    }

    void add(int num) {
        if (num == 0) {
            products.clear();
            products.add(1);
            n = 1;
        } else {
            products.add(products.get(n++ - 1) * num);
        }
    }

    int getProduct(int k) {
        if (n <= k) return 0;
        return products.get(n - 1) / products.get(n - k - 1);
    }

    public static void main(String[] args) {
        ProductOfLastKNumbers product = new ProductOfLastKNumbers();
        product.add(3);
        product.add(0);
        product.add(2);
        product.add(5);
        product.add(4);
        System.out.println(product.getProduct(2));
        System.out.println(product.getProduct(4));
        product.add(8);
        System.out.println(product.getProduct(2));
    }
// ["getProduct","add","getProduct","add"]
// [[1],[7],[5],[3]]

}
