public class Carro {
    //limites de velocidade por marcha (marcha -> [velMin, velMax])
    private static final int[][] limites = {
            {0,0}, //0 - ponto morto
            {0,20}, //1
            {21,40}, //2
            {41,60}, //3
            {61,80}, //4
            {81,100}, //5
            {101,120} //6
    };

    private boolean ligado;
    private int marcha;
    private int velocidade;

    public Carro() {
        this.ligado = false;
        this.marcha = 0;
        this.velocidade = 0;
        System.out.println("Carro criado: desligado, marcha 0, velocidade 0 km/h");
    }

    //Verificacoes internas
    private void verificaLigado(){
       if(!ligado){
            throw new IllegalStateException("O carro está desligado. Ligue-o primeiro.");
        }
    }
    private void checaLimiteVelocidade(){
        int min = limites[marcha][0];
        int max = limites[marcha][1];
        if(velocidade < min || velocidade > max){
            throw new IllegalStateException(
                    String.format("Velocidade %d km/h fora do intervalo permitido para a marcha %d (%d-%d km/h).",
                            velocidade,marcha, min,max));
        }
    }
    //Operacao do carro
    public void ligar(){
        if(ligado){
            System.out.println("O carro já está ligado.");
            return;
        }
        ligado = true;
        System.out.println("Carro ligado.");
    }
    public void desligar() {
        verificaLigado();
        if (marcha != 0 || velocidade != 0) {
            throw new IllegalStateException(
                    "Para desligar, o carro deve estar em ponto morto (marcha 0) e velocidade 0 km/h.");
        }
        ligado = false;
        System.out.println("Carro desligado.");
    }
    public void acelerar(){
        if(marcha == 0){
            throw new IllegalStateException("Não é possível acelerar em ponto morto (marcha 0).");
        }
        if (velocidade >= 120){
            throw new IllegalStateException("Velocidade máxima atingida (120 km/h).");
        }
        velocidade += 1;
        checaLimiteVelocidade();
        System.out.println("Acelerou: velocidade agora " + velocidade + " km/h.");
    }
    public void frear(){
        verificaLigado();
        if(velocidade ==0){
            System.out.println("Já está parado.");
            return;
        }
        velocidade -= 1;
        checaLimiteVelocidade();
        System.out.println("Freou: velocidade agora " + velocidade + " km/h.");
    }
    /**
     * Troca a marcha respeitando as regras:
     * - não pular marchas (ex.: 1 → 3 não permitido);
     * - velocidade deve estar dentro do intervalo da nova marcha.
     */
    public void trocarMarcha(int novaMarcha){
        verificaLigado();
        if(novaMarcha < 0 || novaMarcha > 6){
            throw new IllegalArgumentException("Marcha deve estar entre 0 e 6.");
        }
        if(Math.abs(novaMarcha - marcha) > 1){
            throw new IllegalStateException(
                    String.format("Não é permitido pular marchas. Marcha atual: %d, tentativa: %d.", marcha, novaMarcha));
        }
        int min = limites[novaMarcha][0];
        int max = limites[novaMarcha][1];
        if(velocidade < min || velocidade > max){
            throw new IllegalStateException(
                    String.format("Velocidade %d km/h incompatível com a marcha %d (deve estar entre %d e %d km/h).",
                            velocidade, novaMarcha, min, max));
        }
        marcha = novaMarcha;
        System.out.println("Marcha alterada para " + marcha + ".");
    }

    /**
     * Direção pode ser "esquerda" ou "direita".
     * Permitido apenas quando velocidade está entre 1 e 40 km/h.
     */
    public void virar(String direcao){
        verificaLigado();
        String dir = direcao.toLowerCase();
        if(!dir.equals("esquerda") && !dir.equals("direita")){
            throw new IllegalArgumentException("Direção inválida. Use \"esquerda\" ou \"direita\".");
        }
        if(velocidade < 1 || velocidade > 40){
            throw new IllegalStateException("Para virar, a velocidade deve estar entre 1 e 40 km/h.");
        }
        System.out.println("Virou para " + dir + " com " + velocidade + " km/h.");
    }

    public  int verificaVelocidade(){
        System.out.println("Velocidade atual: " + velocidade + " km/h." );
        return velocidade;

    }
    @Override
    public String toString() {
        return String.format("<Carro %s, marcha %d, velocidade %d km/h>",
                ligado ? "ligado" : "desligado", marcha, velocidade);
    }

}
