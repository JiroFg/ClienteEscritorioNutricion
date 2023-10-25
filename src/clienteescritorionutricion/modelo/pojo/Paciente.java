//Edson Jair Fuentes García
package clienteescritorionutricion.modelo.pojo;


public class Paciente {

    private int idPaciente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String sexo;
    private float peso;
    private float estatura;
    private float tallaInicial;
    private String email;
    private String telefono;
    private String contrasena;
    private byte[] fotografia;
    private int idDomicilio;
    private int idMedico;
    private String fotoBase64;
    
    public Paciente(){}
    
    public Paciente(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String sexo, float peso, float estatura, float tallaInicial, String email, String telefono, String contrasena, int idMedico) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.peso = peso;
        this.estatura = estatura;
        this.tallaInicial = tallaInicial;
        this.email = email;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.idMedico = idMedico;
    }
    
    public Paciente(int idPaciente, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String sexo, float peso, float estatura, float tallaInicial, String email, String telefono, String contrasena, byte[] fotografia, int idDomicilio, int idMedico) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.peso = peso;
        this.estatura = estatura;
        this.tallaInicial = tallaInicial;
        this.email = email;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.fotografia = fotografia;
        this.idDomicilio = idDomicilio;
        this.idMedico = idMedico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
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

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public float getTallaInicial() {
        return tallaInicial;
    }

    public void setTallaInicial(float tallaInicial) {
        this.tallaInicial = tallaInicial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public byte[] getFotografia() {
        return fotografia;
    }

    public void setFotografia(byte[] fotografia) {
        this.fotografia = fotografia;
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }
    
    public String getFotoBase64() {
        return fotoBase64;
    }

    public void setFotoBase64(String fotoBase64) {
        this.fotoBase64 = fotoBase64;
    }
    
    @Override
    public String toString() {
        return "Paciente{" + "idPaciente=" + idPaciente + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", peso=" + peso + ", estatura=" + estatura + ", tallaInicial=" + tallaInicial + ", email=" + email + ", telefono=" + telefono + ", contrasena=" + contrasena + ", fotografia=" + fotografia + ", idDomicilio=" + idDomicilio + ", idMedico=" + idMedico + '}';
    }
    
}
//Edson Jair Fuentes García