import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class TeaTest{
  //REMEMBER TO RENAME!!!!!!1!one!
  @Test
  public void Tea_InstatiatesCorrectly_True() {
    Tea tea = new Tea("Earl Grey", "black", 5, "once");
    assertEquals(true, tea instanceof Tea);
  }

  @Test
  public void getName_returnsmName_String(){
    Tea tea = new Tea("Earl Grey", "black", 5, "once");
    assertEquals("Earl Grey", tea.getName());
  }

  @Test
  public void getSteep_returnsmSteep_String(){
    Tea tea = new Tea("Earl Grey", "black", 5, "once");
    assertEquals("once", tea.getSteep());
  }

  @Test
  public void getType_returnsmType_String(){
    Tea tea = new Tea("Earl Grey", "black", 5, "once");
    assertEquals("black", tea.getType());
  }

  @Test
  public void getRating_returnsmRating_String(){
    Tea tea = new Tea("Earl Grey", "black", 5, "once");
    assertEquals(5, tea.getRating());
  }
}
