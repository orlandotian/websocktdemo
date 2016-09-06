package hello.classsystem.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiansai on 16/8/30.
 */
public class GradeBean {
    public static int classId = 1;
    public List<SubjectBean> mSubjects = new ArrayList<>();
    public String mGradName;
    public List<StudentClass> mStudentClasses = new ArrayList<>();

    public GradeBean(String name, int totalClassNum) {
        this.mGradName = name;
        for(int i = 0; i < totalClassNum; i ++) {
            StudentClass studentClass = new StudentClass(this, i);
            mStudentClasses.add(studentClass);
        }
    }

    public void deleteClass(int roomId) {
        for(int i = 0; i < mStudentClasses.size(); i++) {
            if(mStudentClasses.get(i).getClassRoom() == roomId) {
                mStudentClasses.remove(i);
            }
        }
    }

    public void setSubject(String subject, int num) {
        for(int i = 0; i < mSubjects.size(); i++) {
            if(mSubjects.get(i).getmSubjectName().equals(subject)) {
                if(num > 0) {
                    mSubjects.get(i).setmMaxCount(num);
                    return;
                } else {
                    mSubjects.remove(i);
                    return;
                }
            }
        }
        if(num > 0) {
            mSubjects.add(new SubjectBean(subject, num));
        }
    }
}
