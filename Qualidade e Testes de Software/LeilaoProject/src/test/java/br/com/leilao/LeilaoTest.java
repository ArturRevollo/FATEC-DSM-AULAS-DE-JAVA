package br.com.leilao;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LeilaoTest {

    @Test
    void deveAceitarUmUnicoLance() {
        Leilao leilao = new Leilao("Notebook");
        Usuario joao = new Usuario("João");
        leilao.propoe(new Lance(joao, 2000.0));

        List<Lance> lances = leilao.getLances();
        assertEquals(1, lances.size());
        assertEquals(2000.0, lances.get(0).getValor());
        assertEquals("João", lances.get(0).getUsuario().getNome());
    }

    @Test
    void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
        Leilao leilao = new Leilao("Smart TV");
        Usuario maria = new Usuario("Maria");
        leilao.propoe(new Lance(maria, 1000.0));
        leilao.propoe(new Lance(maria, 1100.0)); // Deve ser ignorado

        List<Lance> lances = leilao.getLances();
        assertEquals(1, lances.size());
        assertEquals(1000.0, lances.get(0).getValor());
    }

    @Test
    void deveAceitarDoisLancesDeUsuariosDiferentes() {
        Leilao leilao = new Leilao("Console");
        Usuario ana = new Usuario("Ana");
        Usuario bruno = new Usuario("Bruno");
        leilao.propoe(new Lance(ana, 500.0));
        leilao.propoe(new Lance(bruno, 550.0));

        List<Lance> lances = leilao.getLances();
        assertEquals(2, lances.size());
    }

    @Test
    void naoDeveAceitarMaisDeCincoLancesDoMesmoUsuario() {
        Leilao leilao = new Leilao("Celular");
        Usuario joao = new Usuario("João");
        Usuario maria = new Usuario("Maria");

        // Lances intercalados até o limite de João
        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(maria, 400.0));
        leilao.propoe(new Lance(joao, 500.0));
        leilao.propoe(new Lance(maria, 600.0));
        leilao.propoe(new Lance(joao, 700.0));
        leilao.propoe(new Lance(maria, 800.0));
        leilao.propoe(new Lance(joao, 900.0)); // 5º lance de João
        leilao.propoe(new Lance(maria, 1000.0));

        // Este 6º lance de João deve ser ignorado
        leilao.propoe(new Lance(joao, 1100.0));

        assertEquals(10, leilao.getLances().size());
    }

    @Test
    void naoDeveAceitarLanceComValorMenorQueAnterior() {
        Leilao leilao = new Leilao("Geladeira");
        Usuario ana = new Usuario("Ana");
        leilao.propoe(new Lance(ana, 500.0));

        // Lance de outro usuário, mas com valor menor. Deve ser ignorado.
        Usuario bruno = new Usuario("Bruno");
        leilao.propoe(new Lance(bruno, 400.0));

        assertEquals(1, leilao.getLances().size());
        assertEquals(500.0, leilao.getLances().get(0).getValor());
    }


    @Test
    void naoDeveFazerNadaSeReceberUmLanceNulo() {
        Leilao leilao = new Leilao("Produto X");
        leilao.propoe(null);
        assertTrue(leilao.getLances().isEmpty());
    }

    @Test
    void leilaoSemLancesDeveRetornarListaVazia() {
        Leilao leilao = new Leilao("Produto Y");
        assertTrue(leilao.getLances().isEmpty());
    }


}