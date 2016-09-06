package hello.classsystem;

import hello.classsystem.bean.GradeBean;
import hello.classsystem.bean.SubjectBean;
import hello.classsystem.bean.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tiansai on 16/8/30.
 */
public class FakeKeeper {

    private static FakeKeeper fakeKeeper;

    private HashMap<String, Keeper> keeperMap = new HashMap<>();

    private FakeKeeper() {

    }

    public static FakeKeeper getInstance() {
        if(fakeKeeper == null) {
            fakeKeeper = new FakeKeeper();
        }
        return fakeKeeper;
    }

    public Keeper getKeeper(String schoolName) {
        if(keeperMap.get(schoolName) == null) {
            Keeper keeper = new Keeper(schoolName);
            keeperMap.put(schoolName, keeper);
            return keeper;
        } else {
            return keeperMap.get(schoolName);
        }
    }

    public class Keeper {
        private String schoolName;
        private List<GradeBean> grades = new ArrayList<>();
        private List<Teacher> teachers = new ArrayList<>();

        public Keeper(String schoolName) {
            this.schoolName = schoolName;
        }

        public void addGrade(String name, int classNum) {
            GradeBean gradeBean = new GradeBean(name, classNum);
            grades.add(gradeBean);
        }

        public GradeBean getGrade(String gradeName) {
            for(GradeBean grade : grades) {
                if(grade.mGradName.equals(gradeName)) {
                    return grade;
                }
            }
            return null;
        }

        public void deleteGrade(String gradeName) {
            for(int i = 0; i < grades.size(); i++) {
                if(grades.get(i).mGradName.equals(gradeName)){
                    grades.remove(i);
                }
            }
        }

        public List<String> getTotalSubject() {
            List<String> subjects = new ArrayList<>();
            for (GradeBean gradeBean : grades) {
                for(SubjectBean subjectBean : gradeBean.mSubjects) {
                    if(!subjects.contains(subjectBean.getmSubjectName())) {
                        subjects.add(subjectBean.getmSubjectName());
                    }
                }
            }

            return subjects;
        }
        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }

        public List<GradeBean> getGrades() {
            return grades;
        }

        public void setGrades(List<GradeBean> grades) {
            this.grades = grades;
        }

        public List<Teacher> getTeachers() {
            return teachers;
        }

        public void setTeachers(List<Teacher> teachers) {
            this.teachers = teachers;
        }
    }
}
