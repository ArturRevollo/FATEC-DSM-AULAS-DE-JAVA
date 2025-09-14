package com.example;

import java.util.regex.Pattern;

public class Utils {

    // ePrimo: retorna true se n for primo
    public static boolean ePrimo(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    // isValidEmail: validacao basica de email
    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        return email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    }

    // contemPalavra: verifica se 'palavra' aparece em 'frase' (ignore case)
    public static boolean contemPalavra(String frase, String palavra) {
        if (frase == null || palavra == null) return false;
        return frase.toLowerCase().contains(palavra.toLowerCase());
    }

    // calcularIMC: retorna true se o IMC estiver entre 18.5 e 24.9; false para entradas invalidas
    public static boolean calcularIMC(double weight, double height) {
        if (weight <= 0 || height <= 0) return false;
        double imc = weight / (height * height);
        return imc >= 18.5 && imc <= 24.9;
    }
}