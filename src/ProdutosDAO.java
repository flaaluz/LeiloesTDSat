/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
        //conn = new conectaDAO().connectDB();
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    public void venderProduto(int id) {

    String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";

    conn = new conectaDAO().connectDB();

    try {

        prep = conn.prepareStatement(sql);

        prep.setInt(1, id);

        prep.execute();

        JOptionPane.showMessageDialog(null, "Produto vendido!");

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, "Erro ao vender produto");
    }
}
        
public ArrayList<ProdutosDTO> listarProdutosVendidos() {

    String sql = "SELECT * FROM produtos WHERE status = 'Vendido'";

    conn = new conectaDAO().connectDB();

    try {

        prep = conn.prepareStatement(sql);

        resultset = prep.executeQuery();

        while(resultset.next()) {

            ProdutosDTO produto = new ProdutosDTO();

            produto.setId(resultset.getInt("id"));
            produto.setNome(resultset.getString("nome"));
            produto.setValor(resultset.getInt("valor"));
            produto.setStatus(resultset.getString("status"));

            listagem.add(produto);
        }

   } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Erro ao vender produto: " + e.getMessage());
}
    return listagem;
}}

