/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import entidade.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Atila
 */
public class Persistencia {
    
    private Connection con;
    private PreparedStatement stmt;
    private final String USER = "root";
    private final String PASS ="root";
    private final String URL = "jdbc:mysql://127.0.0.1:3306/?user=root/veiculos";
    
    
    public  void conectar () throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(USER, PASS, URL);
      
        
        } catch (ClassNotFoundException |  SQLException  ex) {
           ex.printStackTrace();
        }
        
    }
    
    public void inserir(Veiculo veiculo){
        String sql = "INSERT INTO veiculos(modelo,marca,ano,placa,imagem) VALUES(?,?,?,?,?,)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1 , veiculo.getModelo());
           stmt.setString(2, veiculo.getMarca());
           stmt.setInt(3, veiculo.getAno());
           stmt.setString(4, veiculo.getPlaca());
           stmt.setBytes(5, veiculo.getImagem());
           
           stmt.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void excluir(Veiculo veiculo){
        
        String sql = "DELETE FROM veiculo WHERE idveiculo = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, veiculo.getIdveiculo());
            stmt.execute();
            
                    } catch (SQLException ex) {
                        
            ex.printStackTrace();
        }
    }
        
    
    public void alterar( Veiculo veiculo){
        String sql = "UPDATE veiculo SET modelo = ?, marca = ?, ano=?,placa = ?,imagem = ? WHERE idveiculo = ?";
        try {
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1 , veiculo.getModelo());
           stmt.setString(2, veiculo.getMarca());
           stmt.setInt(3, veiculo.getAno());
           stmt.setString(4, veiculo.getPlaca());
           stmt.setBytes(5, veiculo.getImagem());
           stmt.setLong(6, veiculo.getIdveiculo());
           stmt.execute();
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
    }
    
    public List<Veiculo> listar(){
        String sql = "SELECT * FROM veiculo";
        List<Veiculo> lista = new ArrayList<Veiculo>();
        
        try {
            stmt = con.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            
            while(res.next()){
                Veiculo veiculo = new Veiculo();
                veiculo.setIdveiculo(res.getLong("idveiculo"));
                veiculo.setModelo(res.getString("modelo"));
                veiculo.setMarca(res.getString("marca"));
                veiculo.setAno(res.getInt("ano"));
                veiculo.setPlaca(res.getString("placa"));
                veiculo.setImagem(res.getBytes("imagem"));
                
                lista.add(veiculo);
                
                
            }
        
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return lista;
    }
    
    
    
   
        
        public void fecharCon(){
        try {
            con.close();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        }
    
}
