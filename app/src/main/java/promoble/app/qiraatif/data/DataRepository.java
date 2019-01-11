package promoble.app.qiraatif.data;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import promoble.app.qiraatif.entity.Qira;

public class DataRepository {

    private final static String DB_NAME = "qira";
    private DataManager dataManager;

    /**
     * Constructor
     * @param context
     */

    public DataRepository(Context context) {
        dataManager = Room.databaseBuilder(
                context,
                DataManager.class,
                DB_NAME
        ).build();
    }

    public void insertQira(final Qira qira) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                dataManager.qiraDAO().insert(qira);
                return null;
            }
        }.execute();
    }

    public void deleteQira(final Qira qira) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                dataManager.qiraDAO().insert(qira);
                return null;
            }
        }.execute();
    }

    public List<Qira> getQiras() {
        return dataManager.qiraDAO().qiras();
    }
}
