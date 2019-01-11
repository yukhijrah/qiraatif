package promoble.app.qiraatif.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import promoble.app.qiraatif.entity.Qira;

@Dao
public interface QiraDAO {

    @Insert
    void insert(Qira qira);

    @Query("SELECT * FROM qira")
    List<Qira> qiras();

    @Update
    void update(Qira qira);

    @Delete
    void delete(Qira qira);
}
