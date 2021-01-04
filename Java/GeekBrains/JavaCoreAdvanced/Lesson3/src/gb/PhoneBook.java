package gb;

import java.util.HashMap;
import java.util.Map;


public class PhoneBook {
    
    Map <String, String> map = new HashMap<>();

    public void get (String surname){
        System.out.println("Фамилия: " + surname);
        for(Map.Entry <String, String> item : map.entrySet()){
            if (item.getValue().equals(surname))
            System.out.println("Телефон: " + item.getKey());
        }
    }

    public void add(String phoneNumber, String name){
        map.put(phoneNumber, name);
    }
}
