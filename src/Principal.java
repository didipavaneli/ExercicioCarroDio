public class Principal {
    public static void main(String[] args) {
        Carro c = new Carro();   //estado inicial
        c.ligar();
        c.trocarMarcha(1);
        c.acelerar();
        c.acelerar();
        c.virar("esquerda");
        //enta mudar pra marcha 2 = falaha porque veloicade ainta < 21
        try{
            c.trocarMarcha(2);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //acelera ate 21 km/h, troca para marcha 2, etc
        while (c.verificaVelocidade() < 21){
            c.acelerar();
        }
        c.trocarMarcha(2);
        c.frear();  //diminui velocidade
        c.trocarMarcha(0);  //ponto morto
        c.desligar(); //so desliga em marcha 0 e velocidade 0
    }
}
