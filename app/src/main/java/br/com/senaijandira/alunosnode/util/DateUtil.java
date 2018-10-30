package br.com.senaijandira.alunosnode.util;

public class DateUtil {

    public int convertToInt(String data) {
        String [] dataSplit = data.split("/");

        String dia = dataSplit[0];
        String mon = dataSplit[1];
        String year = dataSplit[2];

        String dataFormatada = year + mon + dia;

        return Integer.parseInt(dataFormatada);
    }
}
