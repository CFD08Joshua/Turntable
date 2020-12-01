package com.example.turntable.view.bigggfish;

/**
 * 轉盤旋轉狀態監聽器
 */
public interface OnRotationListener {
    /**
     * 動畫結束
     * @param currentItem
     */
    void onStop(int currentItem);
}
