package org.enset.model.Ex1;

import org.enset.Exceptions.NombreNegatifException;

public class EntierNaturel {
    private int Val;
    public EntierNaturel(int val) throws NombreNegatifException {
        if (val < 0)
            throw new NombreNegatifException("Value Is Negative!!",val);
          Val = val;
    }
    public int getVal() {
        return Val;
    }
    public void setVal(int val) throws NombreNegatifException {
        if(val < 0){
            throw new NombreNegatifException("Value Is Negative!!",val);
        }
          Val = val;
    }

    public int decrementer() throws NombreNegatifException{
        if(this.Val == 0){
            throw new NombreNegatifException("La valeur est déjà nulle", 0);
        }
        return this.Val--;
    }
}
