/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ichart;

import java.util.Random;

/**
 * 颜色 //http://www.fhjh.tp.edu.tw/mid07/RGBList.htm
 *
 * @author weichengdong
 */
public class IchartColor {

    private static Random random = new Random();
    public static final String RED = "#FF0000";
    public static final String GREEN = "#008000";
    public static final String BLUE = "#0000FF";
    public static final String YELLOW = "#FFFF00";
    public static final String FUNCHSIA = "#FF00FF";
    private static final String[] color = {
        "#a5c2d5", "#cbab4f", "#de9972", "#28847f", "#90abc0","#aad0db",
        "#76a871", "#a56f8f", "#c12c44", "#9f7961", "#6f83a5","#f68f70",
        "#fedd74", "#82d8ef", "#f76864", "#80bd91", "#fd9fc1"};

    /**
     * 获取一种颜色
     *
     * @param index
     * @return
     */
    public static String getColor(int index) {
        return color[index % color.length];
    }

    /**
     * 获取一种颜色，这个颜色是随机的
     *
     * @return
     */
    public static String getColor() {
        int rom = Math.abs(random.nextInt());
        return color[rom % color.length];
    }
}
