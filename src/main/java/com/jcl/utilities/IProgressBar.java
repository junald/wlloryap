/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcl.utilities;

/**
 *
 * @author junald
 */
public interface IProgressBar {
    public void setPMax(int v);
    public void setPMin(int v);
    public void setPValue(int v);
    public void setPTitle(String s);
}
