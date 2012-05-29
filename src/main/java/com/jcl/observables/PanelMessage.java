/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.observables;

/**
 *
 * @author junald
 */
public class PanelMessage {

    private String panelName;
    private String panelAction;

    public PanelMessage(String name, String action) {
        this.panelName = name;
        this.panelAction = action;
    }

    /**
     * @return the panelName
     */
    public String getPanelName() {
        return panelName;
    }

    /**
     * @param panelName the panelName to set
     */
    public void setPanelName(String panelName) {
        this.panelName = panelName;
    }

    /**
     * @return the panelAction
     */
    public String getPanelAction() {
        return panelAction;
    }

    /**
     * @param panelAction the panelAction to set
     */
    public void setPanelAction(String panelAction) {
        this.panelAction = panelAction;
    }


}
