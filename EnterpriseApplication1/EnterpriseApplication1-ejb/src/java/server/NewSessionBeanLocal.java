/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author smitj
 */
@Local
public interface NewSessionBeanLocal {

    List<String> getNames();
    
}
