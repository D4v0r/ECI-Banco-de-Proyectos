package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.*;
import edu.eci.cvds.services.*;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.services.ServiciosBancoDeProyectos;
import org.apache.ibatis.exceptions.PersistenceException;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;

public class ServiciosBancoDeProyectosImpl implements ServiciosBancoDeProyectos {
    

	@Inject
	private UsuarioDAO usuarioDAO;
	private IniciativaDAO iniciativaDAO;


	// Usuarios

	@Override
	@Transactional
	public void registrarUsuario(Usuario usuario) throws ExcepcionBancoDeProyectos {
		if (usuario == null)
			throw new ExcepcionBancoDeProyectos("El correo no puede ser nulo");

		try {
			usuarioDAO.insertarUsuario(usuario);
		} catch (PersistenceException e) {
			throw new ExcepcionBancoDeProyectos("Error al registrar el correo " + usuario.getCorreo(), e);
		}
	}

	@Override
	public Usuario consultarUsuario(String correo) throws ExcepcionBancoDeProyectos {
		if (correo == null)
			throw new ExcepcionBancoDeProyectos("El numero de documento es inválido");
		try {
			return usuarioDAO.consultarUsuario(correo);
		} catch (PersistenceException e) {
			throw new ExcepcionBancoDeProyectos("Error al consultar el usuario" + correo, e);
		}
	}

	@Override
	public List<Usuario> consultarUsuarios() throws ExcepcionBancoDeProyectos {
		return usuarioDAO.consultarUsuarios();
	}

	@Override
	public void updateUsuario(String correo, String rol) throws Exception {
		usuarioDAO.updateUsuario(correo, rol);
	}

	@Override
	public Iniciativa consultarIniciativa(Integer id) throws ExcepcionBancoDeProyectos {
		if (id < 0)
			throw new ExcepcionBancoDeProyectos("El numero de ID inválido");
		try {
			return iniciativaDAO.consultarIniciativa(id);
		} catch (PersistenceException e) {
			throw new ExcepcionBancoDeProyectos("Error al consultar iniciativa" + id, e);
		}
	}

	@Override
	public void registrarIniciativa(Iniciativa iniciativa) throws ExcepcionBancoDeProyectos {
		if (iniciativa == null)
			throw new ExcepcionBancoDeProyectos("Error al registrar iniciativa");

		try {
			iniciativaDAO.insertarIniciativa(iniciativa);
		} catch (PersistenceException e) {
			throw new ExcepcionBancoDeProyectos("Error al registrar iniciativa " + iniciativa.getId(), e);
		}
	}
}
