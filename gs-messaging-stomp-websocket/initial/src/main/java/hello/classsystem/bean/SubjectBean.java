package hello.classsystem.bean;

/**
 * Created by tiansai on 16/8/30.
 */
public class SubjectBean {
    public static final String[] SESSIONS = {"数学","语文","英语","生物","物理","化学","地理","政治","历史","品德","劳动","体育"};

    private String mSubjectName = "";
    private int mMaxCount = 1;

    public SubjectBean(String name, int max) {
        mSubjectName = name;
        mMaxCount = max;
    }

    public String getmSubjectName() {
        return mSubjectName;
    }

    public void setmSubjectName(String mSubjectName) {
        this.mSubjectName = mSubjectName;
    }

    public int getmMaxCount() {
        return mMaxCount;
    }

    public void setmMaxCount(int mMaxCount) {
        this.mMaxCount = mMaxCount;
    }
}
