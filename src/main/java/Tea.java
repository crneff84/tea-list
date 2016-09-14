import java.util.List;
import java.util.ArrayList;

public class Tea {
  private String mName;
  private Integer mRating;
  private String mSteep;
  private int mId;
  private static List<Tea> teas = new ArrayList<Tea>();

  public Tea(String name, Integer rating, String steep) {
    mName = name;
    mRating = rating;
    mSteep = steep;
    teas.add(this);
    mId=teas.size();
  }

  public String getName(){
    return mName;
  }

  public Integer getRating(){
    return mRating;
  }

  public String getSteep(){
    return mSteep;
  }

  public int getId(){
    return mId;
  }

  public static void clear(){
    teas.clear();
  }

  public static List<Tea> all(){
    return teas;
  }

  public static Tea find(int id){
    return teas.get(id-1);
  }
}
