/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOUtil;

import Controller.AdministradorJpaController;
import Controller.AlunoJpaController;
import Controller.DisciplinaHasAlunoJpaController;
import Controller.DisciplinaJpaController;
import Controller.EnderecoalunoJpaController;
import Controller.EnderecoprofessorJpaController;
import Controller.ProfessorJpaController;
import Controller.TelefoneadministradorJpaController;
import Controller.TelefonealunoJpaController;
import Controller.TelefoneprofessorJpaController;

/**
 *
 * @author henri
 */
public interface DaoFactoryInterface {
    
    public AdministradorJpaController criarAdministradorDao();
    
    public AlunoJpaController criarAlunoDao();
    
    public DisciplinaHasAlunoJpaController criarDisciplinaHasAlunoDao();
    
    public DisciplinaJpaController criarDisciplinaDao();
    
    public EnderecoalunoJpaController criarEnderecoAlunoDao();
    
    public EnderecoprofessorJpaController criarEnderecoProfessorDao();
    
    public ProfessorJpaController criarProfessorDao();
    
    public TelefoneadministradorJpaController criarTelefoneAdministadorDao();
    
    public TelefonealunoJpaController criarTelefoneAlunoDao();
    
    public TelefoneprofessorJpaController criarTelefoneProfessorDao();
    
}
