package ru.praktikum;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AlexTest {

    @Test
    public void getFriendsTest() throws Exception {
        Alex alex = new Alex();
        assertEquals(List.of("зебра Марти", "бегемотиха Глории", "жираф Мелман"), alex.getFriends());
    }

    @Test
    public void getPlaceOfLivingTest() throws Exception {
        Alex alex = new Alex();
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void getKittens() throws Exception {
        Alex alex = new Alex();
        assertEquals(0, alex.getKittens());
    }

}