package com.ia.ml.weka;

// Importação das bibliotecas
import weka.classifiers.Classifier; // Interface que define métodos obrigatórios para algoritmos de classificação
import weka.classifiers.trees.J48; // Arquivo de decisão que aprende a responder: é fraude ou não?

import weka.core.Attribute; // Representa uma coluna dos dado (ex: "valor", "origem")
import weka.core.Instance; // Representa uma linha de dados
import weka.core.DenseInstance; // Representa uma linha completa de dados com valores reais
import weka.core.Instances; // O conjunto completo de dados (como uma planilha)

// Ferramentas de log usadas para ocultar avisos do Weka (não afetam o código)
import java.util.logging.Level; // Controla o nível de importânica dos avisos exibidos
import java.util.logging.Logger; // Usado para configurar o sistema de logs do Java

import java.util.ArrayList;

public class DeteccaoDeFraudeBancaria {

}
