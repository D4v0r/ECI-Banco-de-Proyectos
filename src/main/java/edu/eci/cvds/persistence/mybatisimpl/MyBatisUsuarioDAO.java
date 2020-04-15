package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import java.util.List;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.*;
import edu.eci.cvds.entities.*;
import java.util.Date;
import org.apache.ibatis.exceptions.PersistenceException;

public class MyBatisUsuarioDAO implements UsuarioDAO {

	@Inject
	private UsuarioMapper usuarioMapper;


	@Override
	public Usuario consultarUsuario(String correo) throws PersistenceException {
		try {
			return usuarioMapper.consultarUsuario(correo);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al consultar el usuario: " + correo, e);
		}

	}

	@Override
	public List<Usuario> consultarUsuarios() throws PersistenceException {
		try {
			return usuarioMapper.consultarUsuarios();
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al consultar el usuarios: ", e);
		}
	}

	@Override
	public void updateUsuario(String correo, String rol) throws Exception {
		try {
			usuarioMapper.updateUsuario(correo,rol);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error en actulizacion de rol de: " + correo, e);
		}
	}


}
