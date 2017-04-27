package br.jus.trf1.pocArquitetura.dao;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.transaction.Transactional;

import br.jus.trf1.pocArquitetura.entidades.Funcionario;

@Stateless
@Default
@Transactional
public class FuncionarioDAO extends GenericDaoJpa<Funcionario>{

	



}
