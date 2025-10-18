package br.com.leilao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Leilao {
    private String descricao;
    private List<Lance> lances = new ArrayList<>();
    private static final int MAX_LANCES_POR_USUARIO = 5;

    public Leilao(String descricao) {
        this.descricao = descricao;
    }

    public void propoe(Lance lance) {
        if (lance == null || lance.getUsuario() == null) {
            return; // Ignora lances nulos ou com usuário nulo
        }

        if (lanceInvalido(lance)) {
            return;
        }
        lances.add(lance);
    }

    private boolean lanceInvalido(Lance lance) {
        Lance ultimo = ultimoLance();
        if (ultimo != null) {
            // Regra 1: Mesmo usuário do lance anterior
            if (ultimo.getUsuario().equals(lance.getUsuario())) return true;

            // Regra 2: Valor menor ou igual ao lance anterior
            if (lance.getValor() <= ultimo.getValor()) return true;
        }

        // Regra 3: Usuário já deu 5 lances
        return totalLancesDoUsuario(lance.getUsuario()) >= MAX_LANCES_POR_USUARIO;
    }

    private long totalLancesDoUsuario(Usuario usuario) {
        return lances.stream()
                .filter(l -> l.getUsuario().equals(usuario))
                .count();
    }

    public List<Lance> getLances() {
        return lances;
    }

    private Lance ultimoLance() {
        if (lances.isEmpty()) {
            return null;
        }
        return lances.get(lances.size() - 1);
    }
}