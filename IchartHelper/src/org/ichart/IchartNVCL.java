/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ichart;

/**
 * name vaule color line_width
 *
 * @author weichengdong
 */
public class IchartNVCL {

    private String name;
    private String color;
    private Object value;
    private int line_width;

    public IchartNVCL(String name, Object value, String color, int line_width) {
        this.name = name;
        this.value = value;
        this.color = color;
        this.line_width = line_width;
    }

    public IchartNVCL(String name, Object value, String color) {
        this.name = name;
        this.value = value;
        this.color = color;
        this.line_width = 2;
    }

    public IchartNVCL(String name, Object value) {
        this.name = name;
        this.value = value;
        this.color = IchartColor.getColor();//将会随机的生成一个颜色
        this.line_width = 2;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Object getValue() {
        return value;
    }

    public int getLine_width() {
        return line_width;
    }
}
