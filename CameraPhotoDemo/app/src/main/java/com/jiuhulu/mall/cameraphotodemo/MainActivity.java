package com.jiuhulu.mall.cameraphotodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jiuhulu.mall.cameraphotodemo.dialog.DialogPlus;

public class MainActivity extends AppCompatActivity {

    private TextView    mTv_show;
    private ViewGroup   mDecorView;
    private FrameLayout mBaseContainer;
    private FrameLayout mContent_container;
    private View mContentView;
    private FrameLayout mContent_container1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv_show = findViewById(R.id.tv_show);
        initClick8();

    }



    private void initClick8() {
       mTv_show.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               show();
           }
       });
    }

    private void show() {
       ViewHolder viewHolder=new ViewHolder(this);
        DialogPlus dialog = DialogPlus.newDialog(this)
                                      .setContentHolder(viewHolder)
                                      .setCancelable(true)
                                      .setGravity(Gravity.BOTTOM)
                                      .create();
        dialog.show();
    }















/*

    private void initclick4(){
       Interpolator interpolator = AnimationUtils.loadInterpolator(MainActivity.this,
                                                                   android.R.interpolator.fast_out_linear_in);
             // Icon scale to zero
       mTv_show .animate()
                     .scaleX(0)
                      .scaleY(0)
                     .setDuration(200)
                     .setInterpolator(interpolator)
                      .start();

   }


    private void initClick() {
        mTv_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                View view=View.inflate(MainActivity.this,R.layout.dialog_photo_camera_select,null);
                builder.setView(view);
                final AlertDialog selectDialog =builder.show();
                TextView          tv_photo     =view.findViewById(R.id.select_photo);
                TextView          tv_camera    =view.findViewById(R.id.select_camera);
                TextView          tv_cancel    =view.findViewById(R.id.select_cancel);
                Window window=selectDialog.getWindow();
                window.setGravity(Gravity.BOTTOM);
                window.setWindowAnimations(R.style.anim_panel_up_from_bottom);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //设置属性
                final WindowManager.LayoutParams params = window.getAttributes();
                params.width = WindowManager.LayoutParams.MATCH_PARENT;
                params.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
                window.setAttributes(params);
                tv_photo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //选择图片
                        selectDialog.dismiss();
                    }
                });
                tv_camera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                tv_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        selectDialog.dismiss();
                    }
                });

            }
        });
    }
    private void initClick2() {
        mTv_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view=View.inflate(MainActivity.this,R.layout.dialog_photo_camera_select,null);
                TextView          tv_photo     =view.findViewById(R.id.select_photo);
                TextView          tv_camera    =view.findViewById(R.id.select_camera);
                TextView          tv_cancel    =view.findViewById(R.id.select_cancel);
                PopupWindow popupWindow=new PopupWindow(MainActivity.this);
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setContentView(view);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
                //设置属性
                final Window                     window =MainActivity.this.getWindow();
                final WindowManager.LayoutParams params = window.getAttributes();
                params.alpha=0.5f;
                window.setAttributes(params);
                popupWindow.setAnimationStyle(R.style.anim_panel_up_from_bottom);

                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                popupWindow.showAtLocation(findViewById(R.id.root),Gravity.BOTTOM, 0, 0);
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        params.alpha=1.0f;
                        window.setAttributes(params);
                    }
                });
            }
        });
    }
   private void initClick3(){
       mTv_show.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               WindowManager wm = MainActivity.this.getWindowManager();

               //构造函数的第二个参数可以设置BottomSheetDialog的主题样式
               //        selectDialog = new BottomSheetDialog(this,R.style.MyBottomDialog);
               final BottomSheetDialog selectDialog = new BottomSheetDialog(MainActivity.this);
               //导入底部reycler布局
               View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_photo_camera_select, null, false);
               TextView          tv_photo     =view.findViewById(R.id.select_photo);
               TextView          tv_camera    =view.findViewById(R.id.select_camera);
               TextView          tv_cancel    =view.findViewById(R.id.select_cancel);
              
               selectDialog.setContentView(view);

               //设置点击dialog外部不消失
               selectDialog.setCanceledOnTouchOutside(true);

               if (!selectDialog.isShowing()) {
                   selectDialog.show();
               } else {
                   selectDialog.dismiss();
               }
               tv_photo.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       //选择图片
                       selectDialog.dismiss();
                   }
               });
               tv_camera.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                       //运行时授权:
                       CheckPermission.getInstance(MainActivity.this)
                                      .request(new PermissionOptions.Builder()
                                                       .setRationalMessage("财酷需要您授予相机权限,拒绝该权限将不能进行拍照!")
                                                       .setPermissions(Manifest.permission.CAMERA)
                                                       .build(),
                                               new PermissionResultListener() {
                                                   @Override
                                                   public void onGranted() {
                                                       Toast.makeText(MainActivity.this, "进行拍照", Toast.LENGTH_SHORT).show();
                                                       //选择图片
                                                       selectDialog.dismiss();
                                                   }

                                                   @Override
                                                   public void onDenied(List<String> permissions) {

                                                       Toast.makeText(MainActivity.this, "权限拒绝了", Toast.LENGTH_SHORT).show();
                                                   }
                                               });
                   }
               });
               tv_cancel.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       selectDialog.dismiss();
                   }
               });
           }
       });
       }*/

}
