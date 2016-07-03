package com.dream.java.senior.reflect.entity;

/**
 * TODO.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016-05-26 下午3:44.
 * @phone 152-5320-8570
 */
@Test(tag = "Student class Test Annoatation")
public class Student extends Person implements Examination {
    // 年级
    @Test(tag = "mGrade Test Annotation ")
    int mGrade;

    public Student(String aName) {
        super(aName);
    }

    public Student(int grade, String aName) {
        super(aName);
        mGrade = grade;
    }

    private void learn(String course) {
        System.out.println(mName + " learn " + course);
    }

    public void takeAnExamination() {
        System.out.println(" takeAnExamination ");
    }

    public String toString() {
        return " Student :  " + mName;
    }
}