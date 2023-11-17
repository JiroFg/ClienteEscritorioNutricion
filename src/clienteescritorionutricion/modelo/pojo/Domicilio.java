/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteescritorionutricion.modelo.pojo;


public class Domicilio {
    
    private int idDomicilio;
    private String calle;
    private String numero;
    private String colonia;
    private String codigoPostal;
    private int idMunicipio;
    private String municipio;
    private int idEstado;
    private String estado;
    private int idPaciente;

    public Domicilio() {
    }

    public Domicilio(int idDomicilio, String calle, String numero, String colonia, String codigoPostal, int idMunicipio, String municipio, int idEstado, String estado, int idPaciente) {
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.idMunicipio = idMunicipio;
        this.municipio = municipio;
        this.idEstado = idEstado;
        this.estado = estado;
        this.idPaciente = idPaciente;
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public String toString() {
        return "Domicilio{" + "idDomicilio=" + idDomicilio + ", calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + ", codigoPostal=" + codigoPostal + ", idMunicipio=" + idMunicipio + ", municipio=" + municipio + ", idEstado=" + idEstado + ", estado=" + estado + ", idPaciente=" + idPaciente + '}';
    }
    
}

