/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package us.malfeasant.corporal64.memory;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Malfeasant
 */
class ROM extends BusRider {
    private final ArrayView bytes;

    ROM(int width, InputStream stream) throws IOException {
        int length = 1 << width;
        super(length - 1);
        byte[] arr = stream.readAllBytes();
        bytes = new ArrayView(arr, length, 0);
    }
    
    @Override
    public int peek(int addr) {
        addr &= addrMask;
        return bytes.get(addr);
    }

    @Override
    public void poke(int addr, int data) {
        // TODO this shouldn't happen to a ROM, but should we throw an
        // exception, or just do nothing?
        // actually, should we even use a byte array, or should we just
        // use an ArrayView?  We might want to allow editing outside of
        // emulation...
    }
}
