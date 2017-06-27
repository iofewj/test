package main.db;
import javax.persistence.*;


/**
 * Created by CarrieSong on 2017/6/24.
 */

public class subject {
    @Id
    private long id;

    private String name;
    private String teacher;
    private String time;

    public subject(){

    }

    public subject(long id, String name, String teacher, String time){
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.time = time;
    }


    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getTeacher(){
        return teacher;
    }

    public void setTeacher(String teacher){
        this.teacher = teacher;
    }

    public String getTime(){
        return time;
    }

    public void setTime(String time){
        this.time = time;
    }

}
