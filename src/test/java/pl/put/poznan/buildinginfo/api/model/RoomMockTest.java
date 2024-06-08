package pl.put.poznan.buildinginfo.api.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RoomMockTest {

    @Mock
    private Room room;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetId() {
        String id = "123";

        when(room.getId()).thenReturn(id);

        assertEquals(id, room.getId());
    }

    @Test
    public void testGetName() {
        String name = "Test Room";

        when(room.getName()).thenReturn(name);

        assertEquals(name, room.getName());
    }

    @Test
    public void testGetArea() {
        double area = 100.0;

        when(room.getArea()).thenReturn(area);

        assertEquals(area, room.getArea(), 0.001);
    }


    @Test
    public void testSetId() {
        String id = "456";

        room.setId(id);

        verify(room).setId(id);
    }

    @Test
    public void testSetName() {
        String name = "New Test Room";

        room.setName(name);

        verify(room).setName(name);
    }

}

