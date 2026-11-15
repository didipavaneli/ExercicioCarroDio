# 🚗 Exercício – Controle de Funções de um Carro em Java

Este repositório contém a solução do exercício **“Carro”**, que implementa uma classe capaz de controlar as funções básicas de um automóvel.

## 📋 Funcionalidades da classe `Carro`

- **Ligar o carro**
- **Desligar o carro**
- **Acelerar** (incrementa 1 km/h por chamada)
- **Diminuir velocidade** (decrementa 1 km/h por chamada)
- **Virar para a esquerda** / **virar para a direita**
- **Verificar velocidade atual**
- **Trocar a marcha** (de 0 a 6, sem pular marchas)

## 📚 Regras de negócio

| Regra | Descrição |
|------|------------|
| **Estado inicial** | Ao ser criado, o carro está **desligado**, em **ponto morto (marcha 0)** e com velocidade **0 km/h**. |
| **Carro desligado** | Não pode executar **nenhuma** das funções acima (exceto ligar). |
| **Aceleração** | Cada chamada incrementa a velocidade em **1 km/h** – limite máximo **120 km/h**. |
| **Desaceleração** | Cada chamada decrementa a velocidade em **1 km/h** – limite mínimo **0 km/h**. |
| **Marchas** | O carro possui **6 marchas** (1‑6) + ponto morto (0). Não é permitido **pular** marchas (ex.: de 1 direto para 3). |
| **Velocidade por marcha** | - **Marcha 0**: não pode acelerar.<br>- **Marcha 1**: 0 – 20 km/h.<br>- **Marcha 2**: 21 – 40 km/h.<br>- **Marcha 3**: 41 – 60 km/h.<br>- **Marcha 4**: 61 – 80 km/h.<br>- **Marcha 5**: 81 – 100 km/h.<br>- **Marcha 6**: 101 – 120 km/h. |
| **Desligar** | Só pode ser efetuado quando o carro está em **ponto morto (marcha 0)** **e** a velocidade é **0 km/h**. |
| **Virar** | Só é permitido virar **esquerda** ou **direita** quando a velocidade está entre **1 km/h** e **40 km/h** (inclusive). |

#

> **💡 Dica:** ao trocar de marcha, verifique primeiro se a nova marcha está exatamente a `+1` ou `-1` da marcha atual. Caso contrário, a operação deve ser recusada.

Bom trabalho! 🚀
