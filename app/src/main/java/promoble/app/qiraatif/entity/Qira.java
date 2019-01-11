package promoble.app.qiraatif.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "qira")
public class Qira implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String qira;

    private String dateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQira() {
        return qira;
    }

    public void setQira(String qira) {
        this.qira = qira;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
