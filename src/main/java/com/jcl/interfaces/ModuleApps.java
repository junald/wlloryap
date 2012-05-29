/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcl.interfaces;

/**
 *
 * @author jlavador
 */
public class ModuleApps {

    private String moduleId;
    private String name;
    private String description;
    private String className;
    private boolean activate;
    private boolean readOnly;

    /**
     * @return the moduleId
     */
    public String getModuleId() {
        return moduleId;
    }

    /**
     * @param moduleId the moduleId to set
     */
    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * @return the activate
     */
    public boolean isActivate() {
        return activate;
    }

    /**
     * @param activate the activate to set
     */
    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    /**
     * @return the readOnly
     */
    public boolean isReadOnly() {
        return readOnly;
    }

    /**
     * @param readOnly the readOnly to set
     */
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    @Override
    public String toString(){
        return this.name + " : " + this.className;
    }

}
