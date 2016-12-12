package com.tenda.tdrecyclerview;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.allen.library.SuperTextView;
import com.tenda.tdrecycler.NRecyclerView;
import com.tenda.tdrecycler.adapter.BaseViewAdapter;

/**
 * Created by DongHao on 2016/11/10
 * Description:
 */

public class ViewBindingAdapter {

//    @BindingAdapter("url")
//    public static void loadImage(ImageView view, String url) {
//        Glide.with(view.getContext()).load(url).placeholder(R.mipmap.icon_log).error(R.mipmap.icon_log).into(view);
//
//    }

    @BindingAdapter("layoutManager")
    public static void setLayoutManager(NRecyclerView view, RecyclerView.LayoutManager manager) {
        view.setLayoutManager(manager);
    }

    @BindingAdapter("adapter")
    public static void setAdapter(NRecyclerView view, BaseViewAdapter adapter) {
        view.setAdapter(adapter);
    }

    @BindingAdapter("sLeftBottomTextString")
    public static void setLeftBottomTextString(SuperTextView view, String str) {
        view.setLeftBottomString(str);
    }

    @BindingAdapter("sLeftTopTextString")
    public static void setLeftTopTextString(SuperTextView view, String str) {
        view.setLeftTopString(str);
    }



//    @BindingAdapter("image")
//    public static void loadImage(ImageView view, boolean isOpen) {
//        if (isOpen) {
//            view.setImageResource(R.mipmap.icon_unfold);
//        } else {
//            view.setImageResource(R.mipmap.icon_next);
//        }
//    }
//
//    @BindingAdapter("rightImage")
//    public static void textRightImage(TextView view, boolean isChecked) {
//        if (isChecked) {
//            Drawable rightDrawable = view.getResources().getDrawable(R.mipmap.image_selected);
//            rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());
//            view.setCompoundDrawables(null, null, rightDrawable, null);
//        } else {
//            view.setCompoundDrawables(null, null, null, null);
//        }
//    }
//
//    @BindingAdapter("leftImage")
//    public static void textLeftImage(TextView view, boolean isChecked) {
//        if (isChecked) {
//            Drawable leftDrawable = view.getResources().getDrawable(R.mipmap.icon_import_selected);
//            leftDrawable.setBounds(0, 0, leftDrawable.getMinimumWidth(), leftDrawable.getMinimumHeight());
//            view.setCompoundDrawables(leftDrawable, null, null, null);
//        } else {
//            Drawable leftDrawable = view.getResources().getDrawable(R.mipmap.icon_import_unselected);
//            leftDrawable.setBounds(0, 0, leftDrawable.getMinimumWidth(), leftDrawable.getMinimumHeight());
//            view.setCompoundDrawables(leftDrawable, null, null, null);
//        }
//    }
//
//    @BindingAdapter("fontColor")
//    public static void fontColor(TextView view, boolean isPassCheck) {
//        if (isPassCheck) {
//            view.setTextColor(Color.parseColor("#1aad19"));
//        } else {
//            view.setTextColor(Color.parseColor("#fe6270"));
//        }
//    }
//
//    @BindingAdapter("textStatus")
//    public static void textStatus(TextView view, boolean isEdit) {
//        if (isEdit) {
//            view.setText("完成");
//            Drawable drawable = view.getResources().getDrawable(R.drawable.blue_radius_full);
//            view.setTextColor(Color.parseColor("#ffffff"));
//            view.setBackground(drawable);
//        } else {
//            view.setText("修改");
//            Drawable drawable = view.getResources().getDrawable(R.drawable.blue_radius_stroke);
//            view.setTextColor(Color.parseColor("#2790db"));
//            view.setBackground(drawable);
//        }
//    }
//
//    @BindingAdapter("btnText")
//    public static void btnText(TextView view, boolean isEdit) {
//        if (isEdit) {
//            view.setText("完成");
//        } else {
//            view.setText("确定");
//        }
//    }

//    @BindingAdapter("radioGroup")
//    public static void radioGroup(RadioGroup view, final CheckItemBean checkItemBean) {
//        final RadioButton btn= (RadioButton) view.findViewById(R.id.radio_already_btn_pass);
//        view.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                if (btn.getId()==i){
//                    checkItemBean.setStatus("不通过");
//                }
//            }
//        });
//    }
}
