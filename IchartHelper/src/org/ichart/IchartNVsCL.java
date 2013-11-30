/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ichart;

import java.util.List;

/**
 * name vaules color line_width
 *
 * @author weichengdong
 */
public class IchartNVsCL {

    private String name;
    private String color;
    private List<Object> values;
    private int line_width;

    public IchartNVsCL(String name, List<Object> values, String color, int line_width) {
        this.name = name;
        this.values = values;
        this.color = color;
        this.line_width = line_width;
    }

    public IchartNVsCL(String name, List<Object> values, String color) {
        this.name = name;
        this.values = values;
        this.color = color;
        this.line_width = 2;
    }

    public IchartNVsCL(String name, List<Object> values) {
        this.name = name;
        this.values = values;
        this.color = IchartColor.getColor();
        this.line_width = 2;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public List<Object> getValues() {
        return values;
    }

    public int getLine_width() {
        return line_width;
    }
}
