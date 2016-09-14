import java.util.List;
import java.util.ArrayList;

public class Type {
  private String mName;
  private int mId;
  private List<Tea> mTeas;
  private static List<Type> types = new ArrayList<Type>();

  public Type(String name){
    mName = name;
    types.add(this);
    mId = types.size();
    mTeas = new ArrayList<Tea>();
  }

  public String getName(){
    return mName;
  }

  public int getId(){
    return mId;
  }

  public List<Tea> getTeas(){
    return mTeas;
  }

  public void addTea(Tea tea){
    mTeas.add(tea);
  }

  //static methods
  public static List<Type> all(){
    return types;
  }

  public static void clear(){
    types.clear();
  }

  public static Type find(int id){
    return types.get(id-1);
  }

}
