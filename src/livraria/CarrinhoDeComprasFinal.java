package livraria;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CarrinhoDeComprasFinal {

    private static final double DESCONTO_PADRAO = 0.16; // 16%
    private static final DecimalFormat DF = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(Locale.of("pt", "BR")));

    private double totalLiquido;      // soma após descontos
    private double totalBruto;        // soma antes dos descontos
    private double totalEconomizado;  // soma das economias
    private int itens;                // contador de itens

    /** Usa o desconto padrão (16%). */
    public void adiciona(Livro livro) {
        adiciona(livro, DESCONTO_PADRAO);
    }

    /** Permite informar o desconto por item (ex.: 0.10 = 10%). */
    public void adiciona(Livro livro, double desconto) {
        // Normaliza/valida o percentual: evita negativos ou >100%
        if (desconto < 0) desconto = 0;
        if (desconto > 1) desconto = 1;

        String tipo = livro.getClass().getSimpleName();
        String nome = (livro.getNome() != null && !livro.getNome().isBlank()) ? livro.getNome() : "(sem nome)";

        double valorOriginal = livro.getValor();
        boolean aplicado = livro.aplicaDescontoDe(desconto);
        double valorFinal = livro.getValor();

        itens++;
        totalBruto += valorOriginal;
        totalLiquido += valorFinal;

        System.out.println("Item: " + tipo + " - " + nome);
        System.out.println("Preço original:     R$ " + DF.format(valorOriginal));
        System.out.println("Desconto tentado:   " + formatPercent(desconto));

        if (aplicado) {
            double economia = valorOriginal - valorFinal;
            totalEconomizado += economia;
            System.out.println("Resultado:          APLICADO");
            System.out.println("Preço final:        R$ " + DF.format(valorFinal));
            System.out.println("Você economizou:    R$ " + DF.format(economia));
        } else {
            System.out.print("Resultado:          NÃO APLICADO");
            if (livro instanceof Ebook) {
                System.out.println(" (limite 15%)");
            } else {
                System.out.println(" (limite 30%)");
            }
            System.out.println("Preço final:        R$ " + DF.format(valorOriginal));
            System.out.println("Você economizou:    R$ 0,00");
        }
        System.out.println("-----------------------------");
    }

    public double getTotal() { return totalLiquido; }
    public double getTotalEconomizado() { return totalEconomizado; }

    public void imprimeResumo() {
        System.out.println("\n=========== RESUMO ===========");
        System.out.println("Itens:              " + itens);
        System.out.println("Valor bruto:        R$ " + DF.format(totalBruto));
        System.out.println("Descontos:          R$ " + DF.format(totalEconomizado));
        System.out.println("TOTAL A PAGAR:      R$ " + DF.format(totalLiquido));
        System.out.println("==============================");
    }

    private String formatPercent(double p) {
        long inteiro = Math.round(p * 100);
        return inteiro + "%";
    }
}
