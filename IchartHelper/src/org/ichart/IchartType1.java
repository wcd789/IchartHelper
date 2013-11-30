/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ichart;

import java.io.IOException;
import java.util.List;

/**
 *  name values labels color
 * @author weichengdong
 */
public class IchartType1<T> extends Ichart<T>{
    
    private List<String> labels = null;
    private List<IchartNVsCL> icharNVsCLs = null;

    public IchartType1(List<IchartNVsCL> icharNVsCLs, List<String> labels) {
        this.icharNVsCLs = icharNVsCLs;
        this.labels = labels;
    }

    @Override
    protected void render() throws IOException {
        this.writeStart();
        this.writeStartData();
        for (int j = 0; j < icharNVsCLs.size(); j++) {
            IchartNVsCL icharNVsCL = icharNVsCLs.get(j);
            this.writeNVsCL(icharNVsCL.getName(), icharNVsCL.getValues(), icharNVsCL.getColor(), 2);
        }
        this.writeEndData();

        this.writeStartlabel();
        for (int i = 0; i < labels.size(); i++) {
            this.writelabel(labels.get(i));
        }
        this.writeEndlabel();
        this.writeEnd();
    }
}
