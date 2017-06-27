package main.db;

import org.springframework.data.annotation.Id;
/**
 * Created by CarrieSong on 2017/6/24.
 */


public class student {

    @Id
    private long id;

    private String name;
    private String pwd;

    public student(){}

    public student(long id, String name, String pwd){
        this.id = id;
        this.name = name;
        this.pwd = pwd;
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

    public String getPwd(){
        return pwd;
    }

    public void setPwd(String pwd){
        this.name = pwd;
    }

}
