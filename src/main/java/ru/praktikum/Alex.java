package ru.praktikum;

import java.util.List;

public class Alex extends Lion {

    public Alex() throws Exception {
        super("Самец");
    }

    public List<String> getFriends() {
        return List.of("зебра Марти", "бегемотиха Глории", "жираф Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return feline.getKittens(0);
    }

}
