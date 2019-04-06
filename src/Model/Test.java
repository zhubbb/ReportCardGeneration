package Model;

public class Test {
    int id;
    int course_id;
    int weight;
    public Test(int id, int course_id, int weight){
        this.id=id;
        this.course_id=course_id;
        this.weight=weight;
    }

    public int getId(){
        return id;
    }
    public int getCourse_id(){
        return course_id;
    }
    public int getWeight(){
        return weight;
    }


}
