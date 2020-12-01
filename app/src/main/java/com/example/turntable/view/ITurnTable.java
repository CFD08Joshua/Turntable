package com.example.turntable.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.example.turntable.view.hnsycsxhzcsh.ITurntableListener;

import java.util.ArrayList;

public interface ITurnTable {

    /**
     * hnsycsxhzcsh
     */
    void initView();

    void initView(Context context, AttributeSet attrs);

    /**
     * bigggfish
     */
    /**
     * 初始化子View
     * @param context
     */
    void initChildView(Context context);

    /**
     * 初始化旋轉動畫
     */
    void initRotationAnim();

    /**
     * 畫圓的整體背景
     *
     * @param canvas
     */
    void drawWheelBackground(Canvas canvas);

    /**
     * 畫圖像
     *
     * @param canvas
     */
    void drawImage(Canvas canvas);

    /**
     * 畫文字
     *
     * @param canvas
     */
    void drawText(Canvas canvas);

    /**
     * hnsycsxhzcsh
     */

    /**
     * 設置旋轉值
     *
     * @param rotation
     */
    void setRotate(float rotation);

    /**
     * 開始選轉
     *
     * @param listener
     */
    void startRotate(ITurntableListener listener);

    /**
     * 開始選轉
     * @param position
     * @param listener
     */
    void startRotate(int position, ITurntableListener listener);


    /**
     * bigggfish
     */
    void startRotating(int stopPosition);

    void setStartBtnClickable(boolean clickable);

    void removeAnimationListener();

    /**
     * 取得隨機值
     *
     * @param num
     * @return
     */
    int getRandom(int num);

    /**
     * 轉盤滾動終點隨機停止的位置
     * @return
     */
    float getRandomPositionPro();

    /**
     * 滾動到position位置
     *
     * @param position
     */
    void setScrollToPosition(int position);

    /**
     * 設置輪盤項目背景顏色
     *
     * @param colors
     */
    void setWheelItemBackgroundColor(ArrayList<Integer> colors);

    /**
     * 設置輪盤項目的資料
     *
     * @param num
     * @param names
     * @param bitmaps
     */
    void setWheelItemData(int num, ArrayList<String> names, ArrayList<Bitmap> bitmaps);

}
