package _1108DefangingAnIPAddress;

public class Solution {

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        String address1 = "1.1.1.1";
        String address2 = "255.100.50.0";
        System.out.println(new Solution().defangIPaddr(address1));
        System.out.println(new Solution().defangIPaddr(address2));
    }

}
