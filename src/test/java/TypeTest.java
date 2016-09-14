import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class TypeTest {

  @Test
  public void type_instantiatesCorrectly_true() {
    Type testType = new Type("Black");
    assertEquals(true, testType instanceof Type);
  }

  @Test
  public void getName_typeInstantiatesWithName_String() {
    Type testType = new Type("Black");
    assertEquals("Black", testType.getName());
  }

  @Test
  public void all_returnsAllInstancesOfType_true() {
    Type firstType = new Type("Black");
    Type secondType = new Type("Green");
    assertEquals(true, Type.all().contains(firstType));
    assertEquals(true, Type.all().contains(secondType));
  }

  @Test
  public void clear_emptiesAllTypesFromList_0() {
    Type testType = new Type("Black");
    Type.clear();
    assertEquals(Type.all().size(), 0);
  }

  @Test
  public void getId_typesInstantiateWithAnId_1() {
    Type testType = new Type("Black");
    assertEquals(1, testType.getId());
  }

  @Test
  public void find_returnsTypeWithSameId_secondType() {
    Type.clear();
    Type firstType = new Type("Black");
    Type secondType = new Type("Green");
    assertEquals(Type.find(secondType.getId()), secondType);
  }

  @Test
  public void getTeas_initiallyReturnsEmptyList_ArrayList() {
    Type.clear();
    Type testType = new Type("Black");
    assertEquals(0, testType.getTeas().size());
  }

  @Test
  public void addTea_addsTeaToList_true() {
    Type testType = new Type("Black");
    Tea testTea = new Tea("Earl Grey", 5, "Once");
    testType.addTea(testTea);
    assertTrue(testType.getTeas().contains(testTea));
  }
}
