package edu.eci.cvds.persistence.mybatisimpl.mappers;



import java.util.List;

import edu.eci.cvds.entities.Rol;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.entities.Usuario;

public interface UsuarioMapper {

	public Usuario consultarUsuario(@Param("correo") String correo);

	public List<Usuario> consultarUsuarios();

	public void modificarRolUsuario(@Param("correo") String correo, @Param("rol") Rol r);

}
