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
	}
}
