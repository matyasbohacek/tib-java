/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;

/**
 *
 * @author Ucebna
 */
public enum Barva {
    ZELENA, MODRA, CERVENA, ZLUTA, FIALOVA;

    public static Barva nahodnaBarva() {
      return values()[new Random().nextInt(values().length)];
    }

}
