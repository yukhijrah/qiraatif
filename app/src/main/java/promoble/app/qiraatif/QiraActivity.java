package promoble.app.qiraatif;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import promoble.app.qiraatif.data.DataRepository;
import promoble.app.qiraatif.entity.Qira;

public class QiraActivity extends AppCompatActivity {

    @BindView(R.id.txt_title)
    EditText edtTitle;

    @BindView(R.id.txt_qira)
    EditText edtQira;

    private DataRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qira);

        ButterKnife.bind(this);

        // instance data repositroy
        repository = new DataRepository(this);
    }

    @OnClick(R.id.btn_save)
    public void onQiraSaved(View view){
        String title = edtTitle.getText().toString();
        String qira = edtQira.getText().toString();
        String dateTime = ""; //@TODO(belum di isi)

        // instence object untuk qira baru
        Qira newQira = new Qira();
        newQira.setTitle(title);
        newQira.setQira(qira);
        newQira.setDateTime(dateTime);

        // tambahkan qira ke database lokal
        repository.insertQira(newQira);

        // kembali ke main activity
        onBackPressed();
    }
}
