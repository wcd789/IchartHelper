/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ichart;

import java.io.IOException;
import java.util.List;

/**
 * name values color
 * @author weichengdong
 */
public class IchartType3<T> extends Ichart<T>{
   private List<IchartNVsCL> icharNVsCLs = null;

    public IchartType3(List<IchartNVsCL> icharNVsCLs) {
        this.icharNVsCLs = icharNVsCLs;
    }
    
   @Override
    protected void render() throws IOException {
        this.writeStart();
        this.writeStartData();
        for (int j = 0; j < icharNVsCLs.size(); j++) {
            IchartNVsCL icharNVsCL = icharNVsCLs.get(j);
            this.writeNVsC(icharNVsCL.getName(), icharNVsCL.getValues(), icharNVsCL.getColor());
        }
        this.writeEndData();
        this.writeEnd();
    }  
}
