package promoble.app.qiraatif.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import promoble.app.qiraatif.entity.Qira;

@Database(entities = {Qira.class}, version = 1, exportSchema = false)
public abstract class DataManager extends RoomDatabase {

    public abstract QiraDAO qiraDAO();
}
