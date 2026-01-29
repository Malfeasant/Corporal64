/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package us.malfeasant.corporal64.memory;

/**
 * Models something that lives on the bus
 *
 * @author Malfeasant
 */
abstract class BusRider implements Addressable {
    final int addrMask;

    /**
     * @param width - number of bits of the address we are capable of receiving
     */
    BusRider(int width) {
        addrMask = (1 << width) - 1;
    }
}
