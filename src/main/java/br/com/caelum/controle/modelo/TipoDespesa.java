package br.com.caelum.controle.modelo;


public enum TipoDespesa {

	TELEFONE {
		@Override
		String getExtensaoArquivo() {
			return "xml";
		}
	},
	CARTAO {

		@Override
		String getExtensaoArquivo() {
			return "txt";
		}

	},
	GASOLINA {

		@Override
		String getExtensaoArquivo() {
			return "csv";
		}
	};

	abstract String getExtensaoArquivo();
	
	
	
}
