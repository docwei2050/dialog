package com.jiuhulu.mall.cameraphotodemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jiuhulu.mall.cameraphotodemo.dialog.DialogPlus;
import com.jiuhulu.mall.cameraphotodemo.dialog.Holder;

/**
 * Created by git on 2018/4/13.
 */

public class ViewHolder implements Holder {
    private Context mContext;

    private View mContentContainer;

    public ViewHolder(Context context) {
        mContext = context;
    }

    @Override
    public View getInflatedView(LayoutInflater inflater, DialogPlus dialogPlus) {
       mContentContainer = inflater.inflate(R.layout.dialog_photo_camera_select, null);
       init(mContentContainer,dialogPlus);
       mContentContainer.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });
       return mContentContainer;
    }

    private void init(View view, final DialogPlus dialogPlus) {
        TextView tv_photo  =view.findViewById(R.id.select_photo);
        TextView tv_camera =view.findViewById(R.id.select_camera);
        TextView tv_cancel =view.findViewById(R.id.select_cancel);
        tv_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogPlus.dismiss();
            }
        });
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogPlus.dismiss();
            }
        });
        tv_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogPlus.dismiss();
            }
        });
    }

}
