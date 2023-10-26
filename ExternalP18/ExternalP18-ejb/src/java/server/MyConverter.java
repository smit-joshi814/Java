/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import javax.ejb.Stateless;

/**
 *
 * @author smitj
 */
@Stateless
public class MyConverter implements MyConverterLocal {

    @Override
    public int rsToDoller(int value) {
        return value*68;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
