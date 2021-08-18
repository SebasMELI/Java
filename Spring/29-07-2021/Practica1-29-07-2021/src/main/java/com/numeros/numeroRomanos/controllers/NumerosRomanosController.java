package com.numeros.numeroRomanos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    @GetMapping(path ="/getNumeroRomano/{num}")
    public String getNumeroRomano(@PathVariable double num){

        if (num > 3999)
            return "No se admiten numeros mayores a 3999";

        String un = "", de = "", ce = "", mi = "";
        int u, d, c, m;

        m = (int)num / 1000;
        c = ((int)num % 1000) / 100;
        d = (((int)num % 1000) % 100) / 10;
        u = ((((int)num % 1000) % 100) % 10);

        switch (m) {
            case 1:
                mi += "M";
                break;
            case 2:
                mi += "MM";
                break;
            case 3:
                mi += "MMM";
                break;
        }

        switch (c) {
            case 1:
                ce += "C";
                break;
            case 2:
                ce += "CC";
                break;
            case 3:
                ce += "CCC";
                break;
            case 4:
                ce += "CD";
                break;
            case 5:
                ce += "D";
                break;
            case 6:
                ce += "DC";
                break;
            case 7:
                ce += "DCC";
                break;
            case 8:
                ce += "DCCC";
                break;
            case 9:
                ce += "CM";
                break;
        }

        switch (d) {
            case 1:
                de += "X";
                break;
            case 2:
                de += "XX";
                break;
            case 3:
                de += "XXX";
                break;
            case 4:
                de += "XL";
                break;
            case 5:
                de += "L";
                break;
            case 6:
                de += "LX";
                break;
            case 7:
                de += "LXX";
                break;
            case 8:
                de += "LXXX";
                break;
            case 9:
                de += "XC";
                break;
        }

        switch (u) {
            case 1:
                un += "I";
                break;
            case 2:
                un += "II";
                break;
            case 3:
                un += "III";
                break;
            case 4:
                un += "IV";
                break;
            case 5:
                un += "V";
                break;
            case 6:
                un += "VI";
                break;
            case 7:
                un += "VII";
                break;
            case 8:
                un += "VIII";
                break;
            case 9:
                un += "IX";
                break;
        }

        return num + " en romano es: " + mi + ce + de + un;

    }

    @GetMapping(path = "/getNumeroDecimal/{roman}")
    public double getNumeroDecimal(@PathVariable String roman){
        double decimal = 0;

        String romanNumeral = roman.toUpperCase();
        for(int x = 0;x<romanNumeral.length();x++)
        {
            char convertToDecimal = roman.charAt(x);

            switch (convertToDecimal){
                case 'M':
                    decimal += 1000;
                    break;

                case 'D':
                    decimal += 500;
                    break;

                case 'C':
                    decimal += 100;
                    break;

                case 'L':
                    decimal += 50;
                    break;

                case 'X':
                    decimal += 10;
                    break;

                case 'V':
                    decimal += 5;
                    break;

                case 'I':
                    decimal += 1;
                    break;
            }
        }
        if (romanNumeral.contains("IV"))
        {
            decimal-=2;
        }
        if (romanNumeral.contains("IX"))
        {
            decimal-=2;
        }
        if (romanNumeral.contains("XL"))
        {
            decimal-=10;
        }
        if (romanNumeral.contains("XC"))
        {
            decimal-=10;
        }
        if (romanNumeral.contains("CD"))
        {
            decimal-=100;
        }
        if (romanNumeral.contains("CM"))
        {
            decimal-=100;
        }
        return decimal;
    }

}
