package com.dgse.viperapp.presentation.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dgse.viperapp.R;
import com.dgse.viperapp.domain.model.AbuBoardModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 16.01.2017.
 */

public class BoardsAdapter extends RecyclerView.Adapter<BoardsAdapter.ViewHolder> {

    List<AbuBoardModel> items = new ArrayList<>();

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public void appendItems(List<AbuBoardModel> newItems) {
        if (newItems == null) {
            return;
        }
        int changePosition = items.size();
        this.items.addAll(newItems);
        notifyItemRangeInserted(changePosition, newItems.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.boards_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(items.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;

        public ViewHolder(View view) {
            super(view);
            text = (TextView) view.findViewById(R.id.tv_recycler_item);
        }
    }
}
