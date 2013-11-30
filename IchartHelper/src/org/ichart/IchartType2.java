/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ichart;

import java.io.IOException;
import java.util.List;

/**
 * name value color
 * @author weichengdong
 */
public class IchartType2<T> extends Ichart<T> {

    private List<IchartNVCL> nVCLs = null;

    /**
     * name vaule color 
     *
     * @param nVCLs
     */
    public IchartType2(List<IchartNVCL> nVCLs) {
        this.nVCLs = nVCLs;
    }

    @Override
    protected void render() throws IOException {
        this.writeStart();
        this.writeStartData();
        for (int i = 0; i < nVCLs.size(); i++) {
            IchartNVCL icharNVCL = nVCLs.get(i);
            this.writeNVC(icharNVCL.getName(), icharNVCL.getValue(), icharNVCL.getColor());
        }
        this.writeEndData();
        this.writeEnd();
    }
}
