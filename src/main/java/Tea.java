public class Tea {
  private String mName;
  private String mType;
  private Integer mRating;
  private String mSteep;

  public Tea(String name, String type, Integer rating, String steep) {
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

  public Integer getRating(){
    return mRating;
  }

  public String getSteep(){
    return mSteep;
  }

}
