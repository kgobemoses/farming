/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.util;

/**
 *
 * @author moses
 */
public class FunctionalLib {

 
    public String capitilizeFirstLetter(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    public String lowerCaseFirstLetter(String input) {
        return input.substring(0, 1).toLowerCase() + input.substring(1);
    }
}
