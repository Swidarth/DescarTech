package dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConexaoBD;
import model.Administrador;
import model.Usuario;

public class UsuarioDao {
    private final Connection conexao;
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList <Usuario> lista = new ArrayList<>();
    ArrayList <Administrador> listaadm = new ArrayList<>();
    
    public UsuarioDao() {
           this.conexao = new ConexaoBD().getConnection();
    }
    
    public void adicionaUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario " +
                     "(nome, celular, email, senha)" +
                     "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getCelular());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getSenha());
            ps.execute();
            ps.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean login(String nome, String senha) {
        String sql = "SELECT * FROM Usuario WHERE nome = ? AND senha = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return true;
            }
            else {
                return false;
            }       
        }
        catch (SQLException e){
               throw new RuntimeException(e);
    }
    }
    
    public List<Usuario> getLista() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Usuario";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setEmail(rs.getString("email"));
                usuarios.add(usuario);
            }
            rs.close();
            ps.close();
            return usuarios;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Usuario getUsuarioById(Integer id) {
        Usuario usuario = new Usuario();
        try {
            String sql = "SELECT * FROM Usuario WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
            }
            rs.close();
            ps.close();
            return usuario;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Usuario getUsuario(String nome) {
        Usuario usuario = new Usuario();
        try {
            String sql = "SELECT * FROM Usuario WHERE nome LIKE ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setNome(rs.getString("nome"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setEmail(rs.getString("email"));
            }
            rs.close();
            ps.close();
            return usuario;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void alteraUsuario (Usuario usuario) {
        String sql = "UPDATE usuario SET nome=?, celular=?, email=?, senha=?" +
                "WHERE id=?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getCelular());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getSenha());
            ps.setLong(5, usuario.getId());
            ps.execute();
            ps.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void removeUsuario (Integer id) {
        try {
            PreparedStatement ps = conexao.prepareStatement("DELETE" +  
                    "FROM usuario WHERE id=?");
            ps.setLong(1, id);
            ps.execute();
            ps.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    
    
    public ResultSet autenticacaoUsuario(Usuario usuario){
        conn = new ConexaoBD().getConnection();
        try {
            String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ResultSet rs = ps.executeQuery();
            return rs;
        }
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDao: " + erro);
            return null;
        }
    }
    
    public ArrayList<Usuario> pesquisarFuncionario() {
        String sql = "SELECT * FROM Usuario";
        conn = new ConexaoBD().getConnection();
        
        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setEmail(rs.getString("email"));
                
                lista.add(usuario);
                
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDao Pesquisar: " + erro);
        }
        return lista;
    }
    
        public void adicionaAdministrador (Administrador administrador) {
        String sql = "INSERT INTO administrador " +
                     "(apelido, celular, email, senha)" +
                     "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, administrador.getApelido());
            ps.setString(2, administrador.getCelular());
            ps.setString(3, administrador.getEmail());
            ps.setString(4, administrador.getSenha());
            ps.execute();
            ps.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        
            public ResultSet autenticacaoAdministrador(Administrador administrador){
        conn = new ConexaoBD().getConnection();
        try {
            String sql = "SELECT * FROM administrador WHERE apelido = ? AND senha = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, administrador.getApelido());
            ps.setString(2, administrador.getSenha());
            ResultSet rs = ps.executeQuery();
            return rs;
        }
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDao: " + erro);
            return null;
        }
    }
            
    public ArrayList<Administrador> pesquisarAdministrador() {
        String sql = "SELECT * FROM administrador";
        conn = new ConexaoBD().getConnection();
        
        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()){
                Administrador administrador = new Administrador();
                administrador.setId(rs.getInt("id"));
                administrador.setApelido(rs.getString("apelido"));
                administrador.setCelular(rs.getString("celular"));
                administrador.setEmail(rs.getString("email"));
                
                listaadm.add(administrador);
                
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "AdministradorDao Pesquisar: " + erro);
        }
        return listaadm;
    }
}
