/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package us.malfeasant.corporal64.memory;

/**
 * The VIC chip's view of the bus- has intimate knowledge of Bus's innards so Vic doesn't need to
 *
 * @author Malfeasant
 */
public class VicBusView {
    private final Bus bus;

    VicBusView(Bus parent) {
        bus = parent;
    }
    
}
