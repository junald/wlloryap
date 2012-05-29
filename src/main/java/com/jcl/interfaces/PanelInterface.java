/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcl.interfaces;

import java.util.LinkedList;

/**
 *
 * @author jlavador
 */
public interface PanelInterface {

    public LinkedList<ModuleApps> getModuleList(String roles);
    public String getModulePanel(String name);
    public String getTitle();
}
