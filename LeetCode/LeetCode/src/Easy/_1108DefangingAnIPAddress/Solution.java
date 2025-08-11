package Easy._1108DefangingAnIPAddress;
// Для заданного действительного (IPv4) IP address верните упрощённую версию этого IP-адреса.
//ненормальный IP-адрес заменяет каждую точку "." на "[.]".
//Пример 1:
//Ввод: адрес = «1.1.1.1»
//Вывод: «1[.]1[.]1[.]1»
//Пример 2:
//Ввод: адрес = «255.100.50.0»
//Вывод: «255[.]100[.]50[.]0»
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
