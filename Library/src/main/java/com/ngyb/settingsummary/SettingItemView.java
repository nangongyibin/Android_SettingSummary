package com.ngyb.settingsummary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/11/3 17:09
 */
public class SettingItemView extends RelativeLayout {
    public static final String NAMESPACE = "http://schemas.android.com/apk/res-auto";
    private ImageView ivSettingToggle;
    private boolean openState;

    public SettingItemView(Context context) {
        this(context, null);
    }

    public SettingItemView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public SettingItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        View view = View.inflate(getContext(), R.layout.iv_setting_item_view, null);
        addView(view);
        String title = attrs.getAttributeValue(NAMESPACE, "title");
        boolean isToggle = attrs.getAttributeBooleanValue(NAMESPACE, "isToggle", true);
        TextView tvSettingTitle = view.findViewById(R.id.tv_setting_title);
        ivSettingToggle = findViewById(R.id.iv_setting_toggle);
        tvSettingTitle.setText(title);
        if (isToggle) {
            ivSettingToggle.setVisibility(VISIBLE);
        } else {
            ivSettingToggle.setVisibility(GONE);
        }
    }

    public void reverseState(){
        openState =!openState;
        if (openState){
            ivSettingToggle.setBackgroundResource(R.drawable.on);
        }else{
            ivSettingToggle.setBackgroundResource(R.drawable.off);
        }
    }

    public boolean getOpenState(){
        return openState;
    }

    public void setOpenState(boolean openState){
        this.openState = openState;
        if (openState){
            ivSettingToggle.setBackgroundResource(R.drawable.on);
        }else{
            ivSettingToggle.setBackgroundResource(R.drawable.off);
        }
    }
}
