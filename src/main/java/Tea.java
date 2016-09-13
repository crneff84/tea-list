public class Tea {
  private String mName;
  private String mType;
  private int mRating;
  private String mSteep;

  public Tea(String name, String type, int rating, String steep) {
    mName = name;
    mType = type;
    mRating = rating;
    mSteep = steep;
  }

  public String getName(){
    return mName;
  }

  public String getType(){
    return mType;
  }

  public int getRating(){
    return mRating;
  }

  public String getSteep(){
    return mSteep;
  }

}
