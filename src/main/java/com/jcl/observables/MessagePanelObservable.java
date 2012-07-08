/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcl.observables;

import java.util.Observable;
import org.springframework.stereotype.Component;

/**
 *
 * @author junald
 */
@Component
public class MessagePanelObservable extends Observable {

     public void callObserver(PanelMessage panel){
        setChanged();
        notifyObservers(panel);
    }

    
}
