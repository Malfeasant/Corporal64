/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package us.malfeasant.corporal64.memory;

/**
 *
 * @author Malfeasant
 */
public class ArrayView implements Addressable {
    private final byte[] bytes;
    private final int length;
    private final int offset;

    public ArrayView(int length) {
        this(new byte[length], length, 0);
    }
    
    public ArrayView(ArrayView other, int length, int offset) {
        this(other.bytes, length, offset);
    }

    ArrayView(byte[] bytes, int length, int offset) {
        this.bytes = bytes;
        this.length = length;
        this.offset = offset;
    }

    @Override
    public int peek(int addr) {
        checkBounds(addr);
        return bytes[addr + offset & 0xff]; // otherwise we might get negatives
    }

    @Override
    public void poke(int addr, int data) {
        checkBounds(addr);
        bytes[addr + offset] = (byte) data;
    }
    
    private void checkBounds(int addr) {
        if (addr >= offset + length || addr < 0) {
            throw new IllegalArgumentException();
        }
    }
}
