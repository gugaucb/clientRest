package br.jus.trf1.pocArquitetura.entidades;

import java.io.Serializable;

public abstract class BaseEntity <T extends Serializable>{
	public abstract T getId();
}
