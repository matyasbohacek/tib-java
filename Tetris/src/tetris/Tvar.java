/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author Ucebna
 */
public enum Tvar {
    ESKO_L, ESKO_R, CTVEREC, ICKO, TECKO, ELKO_L, ELKO_R;
    
    public boolean[][] vTabulce() {
        switch (this) {
            
            case CTVEREC:
                return new boolean[][] {{true, true}, {true, true}, {false, false}, {false, false}};
                
            case ICKO:
                return new boolean[][] {{true, false}, {true, false}, {true, false}, {true, false}};
                
            case ELKO_L:
                return new boolean[][] {{false, true}, {false, true}, {true, true}, {false, false}};
                
            case ELKO_R:
                return new boolean[][] {{true, false}, {true, false}, {true, true}, {false, false}};
                
            case ESKO_L:
                return new boolean[][] {{false, true}, {true, true}, {true, false}, {false, false}};
                
            case ESKO_R:
                return new boolean[][] {{true, false}, {true, true}, {false, true}, {false, false}};
                
            case TECKO:
                return new boolean[][] {{true, false}, {true, true}, {true, false}, {false, false}};
            default:
                return new boolean[][]{};
        }
    };
    
}