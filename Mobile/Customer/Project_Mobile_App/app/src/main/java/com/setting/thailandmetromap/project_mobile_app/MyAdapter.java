package com.setting.thailandmetromap.project_mobile_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<Data_Car> mDatas;
    private LayoutInflater mLayoutInflater;

    public MyAdapter(Context context, List<Data_Car> aList) {
        mDatas = aList;
        mLayoutInflater = LayoutInflater.from((Context) context);
    }




    static class ViewHolder {
        TextView txtBrand;
        TextView txtModel;
        TextView txtDetail;
        ImageView img;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.row_layout,viewGroup,false);
            holder = new ViewHolder();
            holder.txtBrand = (TextView)view.findViewById(R.id.brand);
            holder.txtModel = (TextView)view.findViewById(R.id.txtModel);
            holder.txtDetail= (TextView)view.findViewById(R.id.detail);
            holder.img = (ImageView)view.findViewById(R.id.imgCar);
            view.setTag(holder);
        } else {
            holder = (ViewHolder)view.getTag();
        }
        String title = mDatas.get(position).getBrand();
        holder.txtBrand.setText(title);
        holder.txtModel.setText(mDatas.get(position).getModel());
        holder.txtDetail.setText(mDatas.get(position).getDetail());
        holder.img.setImageResource(mDatas.get(position).getImage());

        return view;
    }
}
