package main.db;


import javax.persistence.Id;

/**
 * Created by CarrieSong on 2017/6/24.
 */

public class ss {


    private long stuid;
    private long subid;

    public ss(){}

    public ss(long stuid, long subid){

        this.stuid = stuid;
        this.subid = subid;
    }

    public long getStuid(){
        return stuid;
    }

    public void setStuid(long stuid){
        this.stuid = stuid;
    }

    public long getSubid(){
        return subid;
    }
//    public long getid(){
//        return id;
//    }
//
//    public void  setid(long id){
//        this.id = id;
//    }

    public void setSubid(long subid) {
        this.subid = subid;
    }
}
