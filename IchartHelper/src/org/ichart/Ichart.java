/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ichart;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;

/**
 * 图标基类 提供了最基本的实现方法
 *
 * @author weichengdong
 * @param <T>
 */
public abstract class Ichart<T> {

    protected StringWriter writer = null;
    protected JsonFactory jf = null;
    protected JsonGenerator jcreater = null;

    /**
     * 整个图标的开始
     *
     * @return
     * @throws IOException
     */
    protected Ichart<T> writeStart() throws IOException {
        writer = new StringWriter();
        jf = new JsonFactory();
        jcreater = jf.createJsonGenerator(writer);
        jcreater.writeStartObject();
        return this;
    }

    /**
     * 整个图标结束
     *
     * @return
     * @throws IOException
     */
    protected Ichart<T> writeEnd() throws IOException {
        jcreater.writeEndObject();
        jcreater.close();
        return this;
    }

    /**
     * 写一个json内部对象，即{key:val,key2:val2},其中的一个k,v对，不包括括号
     *
     * @param key
     * @param val
     * @return
     * @throws IOException
     */
    protected Ichart<T> writeInnerObj(String key, Object val) throws IOException {
        jcreater.writeFieldName(key);
        jcreater.writeObject(val);
        return this;
    }

    /**
     * 数据区域开始
     *
     * @return
     * @throws IOException
     */
    protected Ichart<T> writeStartData() throws IOException {
        jcreater.writeFieldName("data");
        jcreater.writeStartArray();
        return this;
    }

    /**
     * 数据区域结束
     *
     * @return
     * @throws IOException
     */
    protected Ichart<T> writeEndData() throws IOException {
        jcreater.writeEndArray();
        return this;
    }

    /**
     * 在data数据区域写name ist<object>value color line_width
     *
     * @param name
     * @param values
     * @param color
     * @param line_width
     * @return
     * @throws IOException
     */
    protected Ichart<T> writeNVsCL(String name, List<Object> values, String color, int line_width) throws IOException {
        jcreater.writeStartObject();
        this.writeInnerObj("name", name);
        jcreater.writeFieldName("value");
        jcreater.writeStartArray();
        for (int i = 0; i < values.size(); i++) {
            jcreater.writeObject(values.get(i));
        }
        jcreater.writeEndArray();
        this.writeInnerObj("color", color);
        this.writeInnerObj("line_width", line_width);
        jcreater.writeEndObject();
        return this;
    }

    
        /**
     * 在data数据区域写name list<object>value color
     *
     * @param name
     * @param values
     * @param color
     * @return
     * @throws IOException
     */
    protected Ichart<T> writeNVsC(String name, List<Object> values, String color) throws IOException {
        jcreater.writeStartObject();
        this.writeInnerObj("name", name);
        jcreater.writeFieldName("value");
        jcreater.writeStartArray();
        for (int i = 0; i < values.size(); i++) {
            jcreater.writeObject(values.get(i));
        }
        jcreater.writeEndArray();
        this.writeInnerObj("color", color);    
        jcreater.writeEndObject();
        return this;
    }
    
    
    /**
     * 在data数据区域写name value color line_width 嵌套在writeStartData 和writeEndData之间
     *
     * @param name
     * @param value
     * @param color
     * @return
     * @throws IOException
     */
    protected Ichart<T> writeNVC(String name, Object value, String color) throws IOException {
        jcreater.writeStartObject();
        this.writeInnerObj("name", name);
        this.writeInnerObj("value", value);
        this.writeInnerObj("color", color);
        jcreater.writeEndObject();
        return this;
    }

    /**
     * lable开始
     *
     * @return
     * @throws IOException
     */
    protected Ichart<T> writeStartlabel() throws IOException {
        jcreater.writeFieldName("labels");
        jcreater.writeStartArray();
        return this;
    }

    /**
     * 写label 嵌套在writeStartlabel 和writeEndlabel之间
     *
     * @param label
     * @return
     * @throws IOException
     */
    protected Ichart<T> writelabel(String label) throws IOException {
        jcreater.writeString(label);
        return this;
    }

    /**
     * 写lable结束
     *
     * @return
     * @throws IOException
     */
    protected Ichart<T> writeEndlabel() throws IOException {
        jcreater.writeEndArray();
        return this;
    }

    /**
     * 渲染为json格式字符串
     *
     * @return
     * @throws IOException
     */
    public String toIchartJson() throws IOException {
        this.render();
        return writer.toString();
    }

    /**
     * 需要重写的渲染方法
     *
     * @throws IOException
     */
    protected abstract void render() throws IOException;
}
