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
public enum RomanCharEnum {
    I('I'),
    V('V'),
    X('X'),
    L('L'),
    C('C'),
    D('D'),
    M('M');
    
    private final char value;

    private RomanCharEnum(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
