package com.hh.demoSpring.repository.model;

import com.hh.demoSpring.repository.IUsuarioRepository;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UsuarioDBRepository implements IUsuarioRepository {
    @Override
    public Usuario addUsuario(Usuario usuario) {
        Usuario user = null;
        DataSource ds = ConectorDataSource.getMySQL();
        String query = "insert into usuarios(nombre,apellidos) values (?,?)";
        try(Connection connection = ds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)
        ){
            preparedStatement.setString(1,usuario.getNombre());
            preparedStatement.setString(2,usuario.getApellidos());
            int i = preparedStatement.executeUpdate(); //para añadir , executeQuery -> devolver datos
//            if (rs.next()) { //para cuando te devuelve un dato solo
//                user = Usuario.builder().id(rs.getInt(1)).nombre(rs.getString(2)).apellidos(rs.getString(3)).build();
//            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public boolean deleteUsuario(int id) {
        return false;
    }

    @Override
    public Usuario getUsuarioById(int id) {
        return null;
    }

    public List<Usuario> getAllUsuarios() throws SQLException {
        ArrayList<Usuario> usuariosDB = new ArrayList<>();
        String query = "SELECT * FROM usuarios";

        try(Connection connection = ConectorDataSource.getMySQL().getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query)){

            while(rs.next()){
                usuariosDB.add(Usuario.builder().id(rs.getInt(1)).nombre(rs.getString(2)).apellidos(rs.getString(3)).build());
            }
        }

        return usuariosDB;
    }
}
