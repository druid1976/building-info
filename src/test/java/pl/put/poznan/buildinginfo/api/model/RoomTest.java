package pl.put.poznan.buildinginfo.api.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void getId() {
        Room room = new Room();
        room.setId("101");
        assertEquals("101", room.getId());
    }

    @Test
    void setId() {
        Room room = new Room();
        room.setId("101");
        assertEquals("101", room.getId());
    }

    @Test
    void getName() {
        Room room = new Room();
        room.setName("Room 101");
        assertEquals("Room 101", room.getName());
    }

    @Test
    void setName() {
        Room room = new Room();
        room.setName("Room 101");
        assertEquals("Room 101", room.getName());
    }

    @Test
    void getArea() {
        Room room = new Room();
        room.setArea(50.0);
        assertEquals(50.0, room.getArea());
    }

    @Test
    void setArea() {
        Room room = new Room();
        room.setArea(50.0);
        assertEquals(50.0, room.getArea());
    }

    @Test
    void getCube() {
        Room room = new Room();
        room.setCube(100.0);
        assertEquals(100.0, room.getCube());
    }

    @Test
    void setCube() {
        Room room = new Room();
        room.setCube(100.0);
        assertEquals(100.0, room.getCube());
    }

    @Test
    void getLight() {
        Room room = new Room();
        room.setLight(500.0);
        assertEquals(500.0, room.getLight());
    }

    @Test
    void setLight() {
        Room room = new Room();
        room.setLight(500.0);
        assertEquals(500.0, room.getLight());
    }
}