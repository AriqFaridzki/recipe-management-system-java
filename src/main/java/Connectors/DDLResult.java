/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connectors;

/**
 *
 * @author Luminescenents
 */
public class DDLResult {
    private final int rowsAffected;
    private final int generatedKeys;

    public DDLResult(int rowsAffected, int generatedKeys) {
        this.rowsAffected = rowsAffected;
        this.generatedKeys = generatedKeys;
    }

    public int getRowsAffected() {
        return rowsAffected;
    }

    public int getGeneratedKeys() {
        return generatedKeys;
    }
    }

// ...

//public static MyResult something() {
//    int number1 = 1;
//    int number2 = 2;
//
//    return new MyResult(number1, number2);
//}
//
//public static void main(String[] args) {
//    MyResult result = something();
//    System.out.println(result.getFirst() + result.getSecond());
//}
    
