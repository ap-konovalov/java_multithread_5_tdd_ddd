package ru.netology;

import java.util.HashMap;
import java.util.Map;

/**
 * Exercise:
 * <a href="https://github.com/netology-code/jd-homeworks/tree/video/tdd_ddd">GitHub link</a>
 **/
public class PhoneBook {

    private final Map<String, String> namesAndPhones = new HashMap<>();

    public int add(String name, String phone) {
        if (namesAndPhones.containsKey(name)) {
            return namesAndPhones.size();
        }
        namesAndPhones.put(name, phone);
        return namesAndPhones.size();
    }

    public String findByNumber(String phone) {
        return namesAndPhones.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(phone))
                .findFirst()
                .orElse(Map.entry("", ""))
                .getKey();
    }

    public String findByName(String name) {
        if (namesAndPhones.containsKey(name)) {
            return namesAndPhones.get(name);
        }
        return "";
    }
}
