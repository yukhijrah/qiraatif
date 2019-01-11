package promoble.app.qiraatif;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import promoble.app.qiraatif.adapter.QiraAdapter;
import promoble.app.qiraatif.data.DataRepository;
import promoble.app.qiraatif.entity.Qira;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lst_qira)
    RecyclerView lstQira;

    // untuk menampung qira secara temporary yang ada di databases lokal
    private List<Qira> qiras = new ArrayList<>();
    private QiraAdapter adapter;

    @BindView(R.id.btn_add)
    FloatingActionButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fungsikan anotasi bindView
        ButterKnife.bind(this);

        // set layout manager untuk recyclerview mengunakan grid
        lstQira.setLayoutManager(new GridLayoutManager(this, 2));

        // set adapter untuk lst_qira
        adapter = new QiraAdapter(qiras);
        lstQira.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getQiras();
    }

    @OnClick(R.id.btn_add)
    public void onAddClicked(View view) {
        Intent qiraIntent = new Intent(this, QiraActivity.class);
        startActivity(qiraIntent);
    }

    private  void getQiras() {

        final DataRepository repository = new DataRepository(this);
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                qiras.clear();
                qiras.addAll(repository.getQiras());
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                adapter.notifyDataSetChanged();
            }
        }.execute();
    }
}
