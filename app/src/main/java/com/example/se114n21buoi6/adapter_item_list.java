package com.example.se114n21buoi6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class adapter_item_list extends BaseAdapter {
    private Context context;
    private int idLayout;
    private ArrayList<ItemList>  listItems;
    public adapter_item_list(Context context, int idLayout, ArrayList<ItemList>  listItems){
        this.context = context;
        this.listItems = listItems;
        this.idLayout = idLayout;
    }
    @Override
    public int getCount() {
        if (listItems != null) {
            return listItems.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View v = convertView;
        ViewHolder viewHolder;
        if (v==null){
            v = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tv_nameJob = (TextView) v.findViewById(R.id.work);
            viewHolder.tv_stt = (TextView) v.findViewById(R.id.stt);
            viewHolder.finishDate = (TextView) v.findViewById(R.id.finishDate);
            viewHolder.mark = (CheckBox) v.findViewById(R.id.checkbox);
            v.setTag(viewHolder);
            v.setLongClickable(true);
        }
        else {
            viewHolder = (ViewHolder) v.getTag();
        }
        ItemList item = (ItemList) getItem(position);

        if (item!=null){
            viewHolder.tv_stt.setText(String.valueOf(position + 1));
            viewHolder.tv_nameJob.setText(item.getName());
            viewHolder.finishDate.setText(item.getFinishDate());
            viewHolder.mark.setChecked(item.isMark());
        }
        return v;
    }
    private static class ViewHolder{
        TextView tv_stt, tv_nameJob, finishDate;
        CheckBox mark;
    }
}
