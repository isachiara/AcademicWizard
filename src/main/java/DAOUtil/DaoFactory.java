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
public class DaoFactory implements DaoFactoryInterface{
    
    private static final DaoFactory instancia = new DaoFactory();
    
    public DaoFactory(){
        
    }
    
    public static DaoFactory getInstance(){
        return instancia;
    }
    
    @Override
    public AdministradorJpaController criarAdministradorDao(){
        return new AdministradorJpaController();
    }
    
    @Override
    public AlunoJpaController criarAlunoDao(){
        return new AlunoJpaController();
    }
    
    @Override
    public DisciplinaHasAlunoJpaController criarDisciplinaHasAlunoDao(){
        return new DisciplinaHasAlunoJpaController();
    }
    
    @Override
    public DisciplinaJpaController criarDisciplinaDao(){
        return new DisciplinaJpaController();
    }
    
    @Override
    public EnderecoalunoJpaController criarEnderecoAlunoDao(){
        return new EnderecoalunoJpaController();
    }
    
    @Override
    public EnderecoprofessorJpaController criarEnderecoProfessorDao(){
        return new EnderecoprofessorJpaController();
    }
    
    @Override
    public ProfessorJpaController criarProfessorDao(){
        return new ProfessorJpaController();
    }
    
    @Override
    public TelefoneadministradorJpaController criarTelefoneAdministadorDao(){
        return new TelefoneadministradorJpaController();
    }
    @Override
    public TelefonealunoJpaController criarTelefoneAlunoDao(){
        return new TelefonealunoJpaController();
    }
    @Override
    public TelefoneprofessorJpaController criarTelefoneProfessorDao(){
        return new TelefoneprofessorJpaController();
    }
}
