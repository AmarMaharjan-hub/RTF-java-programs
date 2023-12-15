package newjavaprograms;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class KangarooTest {
    @Test
    public void starting_point_is_same_and_velocity_is_different(){
        String output = Kangaroo.kangaroo(3, 2, 3, 3);
        assertEquals(output,"NO");
    }

    @Test
    public void starting_point_and_velocity_are_same(){
        String output = Kangaroo.kangaroo(5,7,5,7);
        assertEquals(output, "YES");
    }

    @Test
    public void starting_point_and_velocity_are_different(){
        String output = Kangaroo.kangaroo(4, 6, 25, 3);
        assertEquals(output, "YES");
    }

    @Test
    public void different_starting_point_same_velocity(){
        String output = Kangaroo.kangaroo(3, 2, 6, 2);
        assertEquals(output,"NO");
    }

    @Test
    public void kangaroo1_starting_point_and_velocity_more_than_kangaroo2(){
        String output = Kangaroo.kangaroo(6, 4, 3, 2);
        assertEquals(output,"NO");
    }

    @Test
    public void starting_point_delta_not_a_factor_of_velocity_delta(){
        String output = Kangaroo.kangaroo(4, 6, 21, 2);
        assertEquals(output,"NO");
    }
}