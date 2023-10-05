package clienteescritorionutricion.modelo.pojo;

public class Medico {
    
    private int idMedico;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String sexo;
    private String numeroPersonal;
    private String numeroCedulaProfesional;
    private String contrasena;
    private int idRol;
    private int idDomicilio;
    private byte[] fotografia;
    
    public Medico(){}

    public Medico(int idMedico, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String sexo, String numeroPersonal, String numeroCedulaProfesional, String contrasena, int idRol, int idDomicilio, byte[] fotografia) {
        this.idMedico = idMedico;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.numeroPersonal = numeroPersonal;
        this.numeroCedulaProfesional = numeroCedulaProfesional;
        this.contrasena = contrasena;
        this.idRol = idRol;
        this.idDomicilio = idDomicilio;
        this.fotografia = fotografia;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNumeroPersonal() {
        return numeroPersonal;
    }

    public void setNumeroPersonal(String numeroPersonal) {
        this.numeroPersonal = numeroPersonal;
    }

    public String getNumeroCedulaProfesional() {
        return numeroCedulaProfesional;
    }

    public void setNumeroCedulaProfesional(String numeroCedulaProfesional) {
        this.numeroCedulaProfesional = numeroCedulaProfesional;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public byte[] getFotografia() {
        return fotografia;
    }

    public void setFotografia(byte[] fotografia) {
        this.fotografia = fotografia;
    }
    
}
