import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class TeaTest{
  //REMEMBER TO RENAME!!!!!!1!one!
  @Test
  public void Tea_InstatiatesCorrectly_True() {
    Tea tea = new Tea("Earl Grey", 5, "once");
    assertEquals(true, tea instanceof Tea);
  }

  @Test
  public void getName_returnsmName_String(){
    Tea tea = new Tea("Earl Grey", 5, "once");
    assertEquals("Earl Grey", tea.getName());
  }

  @Test
  public void getSteep_returnsmSteep_String(){
    Tea tea = new Tea("Earl Grey", 5, "once");
    assertEquals("once", tea.getSteep());
  }

  @Test
  public void getRating_returnsmRating_int(){
    Tea tea = new Tea("Earl Grey", 5, "once");
    assertEquals((Integer)5, tea.getRating());
  }

  @Test
  public void all_returnsAllInstancesOfTea_true() {
    Tea firstTea = new Tea("Earl Grey", 5, "once");
    Tea secondTea = new Tea("Shitty cake tea", 1, "once");
    assertEquals(true, Tea.all().contains(firstTea));
    assertEquals(true, Tea.all().contains(secondTea));
  }

  @Test
  public void clear_emptiesAllTeasFromList_0() {
    Tea testTea = new Tea("Earl Grey", 5, "once");
    Tea.clear();
    assertEquals(Tea.all().size(), 0);
  }

  @Test
  public void getId_typesInstantiateWithAnId_1() {
    Tea testTea = new Tea("Earl Grey", 5, "once");
    assertEquals(1, testTea.getId());
  }

  @Test
  public void find_returnsTeaWithSameId_secondTea() {
    Tea.clear();
    Tea firstTea = new Tea("Earl Grey", 5, "once");
    Tea secondTea = new Tea("Shitty cake tea", 1, "once");
    assertEquals(Tea.find(secondTea.getId()), secondTea);
  }
}
