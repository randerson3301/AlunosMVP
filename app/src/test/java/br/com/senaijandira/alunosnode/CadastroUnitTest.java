package br.com.senaijandira.alunosnode;

import org.junit.Test;

import br.com.senaijandira.alunosnode.util.DateUtil;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CadastroUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public  void conversao_data_correta() {
        String input = "09/01/1999";
        int output = 19990109;

        DateUtil util = new DateUtil();

        int resposta = util.convertToInt(input);

        assertEquals(output, resposta);
    }
}