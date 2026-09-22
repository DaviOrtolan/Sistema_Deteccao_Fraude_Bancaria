package com.ia.ml.weka;

// ETAPA 1: Importação das bibliotecas
import weka.classifiers.Classifier; // Interface que define métodos obrigatórios para algoritmos de classificação
import weka.classifiers.trees.J48; // Arquivo de decisão que aprende a responder: é fraude ou não?

import weka.core.Attribute; // Representa uma coluna dos dados (ex: "valor", "origem")
import weka.core.Instance; // Representa uma linha de dados
import weka.core.DenseInstance; // Representa uma linha completa de dados com valores reais
import weka.core.Instances; // O conjunto completo de dados (como uma planilha)

// Ferramentas de log usadas para ocultar avisos do Weka (não afetam o código)
import java.util.logging.Level; // Controla o nível de importânica dos avisos exibidos
import java.util.logging.Logger; // Usado para configurar o sistema de logs do Java

import java.util.ArrayList;

public class DeteccaoDeFraudeBancaria {
	private Classifier classificador; // modelo de classificação utilizado
	private Instances dadosTreinamento; // conjunto de dados usado para treinar o modelo
	
	// Atributos do conjunto de dados
	private Attribute atributoValor;
	private Attribute atributoOrigem;
	private Attribute atributoFraude;
	
	// ETAPA 2: Definição dos atributos (colunas da "planilha")
	public void definirAtributos() {
		atributoValor = new Attribute("valor"); // valor da transação
		
		ArrayList<String> valoresOrigem = new ArrayList<>();
		valoresOrigem.add("internacional");
		valoresOrigem.add("nacional");
		atributoOrigem = new Attribute("origem", valoresOrigem); // origem da transação
		
		ArrayList<String> valoresFraude = new ArrayList<>();
		valoresFraude.add("nao");
		valoresFraude.add("sim");
		atributoFraude = new Attribute("fraude", valoresFraude); // rótulo: se é fraude ou não
		
		
		ArrayList<Attribute> atributos = new ArrayList<>();
		atributos.add(atributoValor);
		atributos.add(atributoOrigem);
		atributos.add(atributoFraude);
		
		// ETAPA 3: CRIAÇÃO DO DATASET (estrutura base da "planilha")
		// Cria o dataset chamado "transacoes" com os atributos definidos. Começa vazio.
		dadosTreinamento = new Instances("transacoes", atributos, 0);
		
		// Define o último atributo ("fraude") como classe alvo para previsão.
		dadosTreinamento.setClassIndex(dadosTreinamento.numAttributes() - 1);
	}
	
	// Método auxiliar para criar e adicionar uma nova transação ao dataset de treino.
	// Significa que será criada uma nova instância de dados (uma linha),
	// com a mesma quantidade de colunas (atributos) do dataset dadosTreinamento.
	private void adicionarTransacao(double valor, String origem, String fraude) {
		Instance instancia = new DenseInstance(dadosTreinamento.numAttributes());
		// setDataset(...) é uma configuração obrigatória que diz a instância:
		// "Você vai seguir a mesma estrutura do dataset - os mesmos atributos,
		// na mesma ordem e com os mesmos tipos de dados."
		instancia.setDataset(dadosTreinamento);
		
		instancia.setValue(atributoValor, valor);
		instancia.setValue(atributoOrigem, origem);
		instancia.setValue(atributoFraude, fraude);
		dadosTreinamento.add(instancia);
	}
	
	// ETAPA 4: ADIÇÃO DE EXEMPLOS (dados de treino para o modelo aprender)
	public void adicionarExemplos() {
		// Exemplos de transações fraudulentas (valores altos + origem internacional)
		adicionarTransacao(5000, "internacional", "sim");
		adicionarTransacao(10000, "internacional", "sim");
		adicionarTransacao(7000, "internacional", "sim");
		adicionarTransacao(8000, "internacional", "sim");
		
		// Exemplos de transações válidas (valores baixos + origem nacional)
		adicionarTransacao(200, "nacional", "nao");
		adicionarTransacao(150, "nacional", "nao");
		adicionarTransacao(300, "nacional", "nao");
		adicionarTransacao(400, "nacional", "nao");
		
		// Exemplos adicionais:
		// transações com valores médio/altos em território nacional
		// Pode ser usado para demonstrar variação ou desafiar o modelo
		
		// adicionarTransacao(1000, "nacional", "sim");
		// adicionarTransacao(1500, "nacional", "sim");
		// adicionarTransacao(20000, "nacional", "sim");
	}
	
	// ETAPA 5: TREINAMENTO DO MODELO
	public void treinarModelo() throws Exception {
		classificador = new J48(); // Cria o modelo de decisão chamado J48 (método matemático)
		classificador.buildClassifier(dadosTreinamento); // Treina o modelo com os dados fornecidos
		
	}
}
