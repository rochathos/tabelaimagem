/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package entidade;

/**
 *
 * @author Atila
 */
public class Veiculo {

   
   private Long idveiculo;
   private String modelo;
   private String marca;
   private int ano;
   private String placa;
   private byte[] imagem;

    public Long getIdveiculo() {
        return idveiculo;
    }

    public void setIdveiculo(Long idveiculo) {
        this.idveiculo = idveiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

   

   
   
    
}
