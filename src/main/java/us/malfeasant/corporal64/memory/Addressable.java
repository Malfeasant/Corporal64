/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package us.malfeasant.corporal64.memory;

/**
 *
 * @author Malfeasant
 */
public interface Addressable {
    int peek(int addr);
    void poke(int addr, int data);
}
