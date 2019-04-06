package Model;

public class Mark {
    int test_id;
    int student_id;
    double mark;
    public Mark(int test_id,int student_id, double mark){
        this.test_id=test_id;
        this.student_id=student_id;
        this.mark=mark;
    }
    public int getTest_id(){
        return test_id;
    }
    public int getStudent_id(){
        return student_id;
    }
    public double getScore(){
        return mark;
    }

}
