package server.models.player;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Logs {

    @Id
    private String name;
    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> logs;

    public Logs(){

    }
    public Logs(String name){
        this.name=name;
        this.logs=new ArrayList<>();
    }

    public void writeLog(String log,int index){
        if(index==-1){
            logs.add(log);
        }else{
            logs.add(index,log);
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLogs() {
        return logs;
    }

    public void setLogs(List<String> logs) {
        this.logs = logs;
    }
}
