/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prospaceconverter;

/**
 *
 * @author Billy
 */
public enum RomanIntEnum {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);
    
    private final int value;

    private RomanIntEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
