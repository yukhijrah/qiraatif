package promoble.app.qiraatif.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import promoble.app.qiraatif.R;

public class QiraHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_title)
    TextView txtTitle;

    @BindView(R.id.txt_time)
    TextView txtTime;

    public QiraHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setQira(String title, String time) {
        txtTitle.setText(title);
        txtTime.setText(time);
    }
}
