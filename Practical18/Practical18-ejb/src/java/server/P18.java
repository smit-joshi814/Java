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
public class P18 implements P18Local {

    @Override
    public int DollerToRs(int Doller) {
        return Doller * 82;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
