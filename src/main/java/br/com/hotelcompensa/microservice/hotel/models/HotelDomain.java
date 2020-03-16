package br.com.hotelcompensa.microservice.hotel.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "Hotel")
public class HotelDomain {

    @Id
    private String id;
    private String nome;
    private String endereco;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    public static final String CACHE_NAME = "Hotel";

    public HotelDomain (String nome,String endereco,String cep,String cidade,String estado,String pais  ){
    this.nome = nome;
    this.endereco = endereco;
    this.cep = cep;
    this.cidade = cidade;
    this.estado = estado;
    this.pais = pais;

    }

    public HotelDomain(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "HotelDomain{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
