/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package us.malfeasant.corporal64.memory;

/**
 *
 * @author Malfeasant
 */
public class ArrayView {
    private final byte[] bytes;
    private final int length;
    private final int offset;

    /**
     * Builds a new view with a new backing array
     * @param length
     */
    public ArrayView(int length) {
        this(new byte[length], length, 0);
    }
    
    /**
     * Builds a new view from an existing one, reusing its backing array
     * All derived views must be no larger than the previous
     * @param other another view whose backing array we will use
     * @param length in bytes- capped at other view's end
     * @param offset in bytes- limited to other view's range
     */
    public ArrayView(ArrayView other, int length, int offset) {
        if (offset >= other.length) throw new ArrayIndexOutOfBoundsException("Offset exceeds existing view length.");
        if (offset < 0) throw new ArrayIndexOutOfBoundsException("Offset must be positive.");
        length = Math.min(length, other.length - offset);
        this(other.bytes, length, offset);
    }

    ArrayView(byte[] bytes, int length, int offset) {
        this.bytes = bytes;
        this.length = length;
        this.offset = offset;
    }

    public int get(int addr) {
        checkBounds(addr);
        return bytes[addr + offset & 0xff]; // otherwise we might get negatives
    }

    public void set(int addr, int data) {
        checkBounds(addr);
        bytes[addr + offset] = (byte) data;
    }
    
    private void checkBounds(int addr) {
        if (addr >= offset + length || addr < 0) {
            throw new IllegalArgumentException();
        }
    }
}
