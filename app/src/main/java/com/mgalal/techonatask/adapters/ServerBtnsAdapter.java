package com.mgalal.techonatask.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mgalal.techonatask.R;
import com.mgalal.techonatask.model.ServerButton;

import java.util.List;

/**
 * Created by fujitsu-lap on 26/01/2018.
 */

public class ServerBtnsAdapter extends RecyclerView.Adapter<ServerBtnsAdapter.ViewHolder> {
    private List<ServerButton> items ;
    private OnItemClickedListener listener;

    public ServerBtnsAdapter(OnItemClickedListener listener){
        this.listener = listener;
    }
    public void setItems(List<ServerButton> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View rootView =  LayoutInflater.from(parent.getContext()).
               inflate(R.layout.button_list_item,parent,false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ServerButton item = items.get(position);
        holder.btnItemName.setText(item.getName());
        holder.btnItemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items == null?0:items.size();
    }

    public interface  OnItemClickedListener{
        void onItemClicked(ServerButton item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView btnItemName;
        public ViewHolder(View itemView) {
            super(itemView);
            btnItemName = (TextView) itemView.findViewById(R.id.btn_name);
        }
    }
}
