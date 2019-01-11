package promoble.app.qiraatif.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import promoble.app.qiraatif.R;
import promoble.app.qiraatif.entity.Qira;
import promoble.app.qiraatif.holder.QiraHolder;

public class QiraAdapter extends RecyclerView.Adapter<QiraHolder> {

    private List<Qira> qiras;

    public QiraAdapter(List<Qira> qiras) {
        this.qiras = qiras;
    }

    @NonNull
    @Override
    public QiraHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemQira = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_qira, parent, false);
        QiraHolder qiraHolder = new QiraHolder(itemQira);
        qiraHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return qiraHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QiraHolder holder, int position) {
        String title = qiras.get(position).getTitle();
        String dateTime = qiras.get(position).getDateTime();
        holder.setQira(title, dateTime);
    }

    @Override
    public int getItemCount() {
        return qiras.size();
    }
}
