package com.xp_educacao.projeto_aplicado.utils;

public class DocumentoValidator {
    private DocumentoValidator() {
        throw new UnsupportedOperationException("Esta é uma classe utilitária e não pode ser instanciada.");
    }

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    public static boolean isValid(String cpfCnpj) {
        return (isValidCPF(cpfCnpj) || isValidCNPJ(cpfCnpj));
    }

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        int tamanho = str.length();
        for (int i = 0; i < tamanho; i++) {
            int digito = Integer.parseInt(str.substring(i, i + 1));
            soma += digito * peso[peso.length - tamanho + i];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    private static String padLeft(String text, char character) {
        return String.format("%11s", text).replace(' ', character);
    }

    private static boolean isValidCPF(String cpf) {
        cpf = cpf.trim().replace(".", "").replace("-", "");
        if ((cpf == null) || (cpf.length() != 11)) return false;

        for (int j = 0; j < 10; j++)
            if (padLeft(Integer.toString(j), Character.forDigit(j, 10)).equals(cpf))
                return false;

        int digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
        int digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0, 9) + digito1 + digito2);
    }

    private static boolean isValidCNPJ(String cnpj) {
        cnpj = cnpj.trim().replace(".", "").replace("-", "");
        if ((cnpj == null) || (cnpj.length() != 14)) return false;

        int digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
        int digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
        return cnpj.equals(cnpj.substring(0, 12) + digito1 + digito2);
    }
}