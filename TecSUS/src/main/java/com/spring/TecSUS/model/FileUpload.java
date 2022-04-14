package com.spring.TecSUS.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="documento_residencia")
public class FileUpload {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeDocumentoResidencia;
    private String tipoDocumentoResidencia;
    private String tamannhoDocumentoResidencia;

    @Lob
    private byte[] bytes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDocumentoResidencia() {
        return nomeDocumentoResidencia;
    }

    public void setNomeDocumentoResidencia(String nomeDocumentoResidencia) {
        this.nomeDocumentoResidencia = nomeDocumentoResidencia;
    }

    public String getTipoDocumentoResidencia() {
        return tipoDocumentoResidencia;
    }

    public void setTipoDocumentoResidencia(String tipoDocumentoResidencia) {
        this.tipoDocumentoResidencia = tipoDocumentoResidencia;
    }

    public String getTamannhoDocumentoResidencia() {
        return tamannhoDocumentoResidencia;
    }

    public void setTamannhoDocumentoResidencia(String tamannhoDocumentoResidencia) {
        this.tamannhoDocumentoResidencia = tamannhoDocumentoResidencia;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }


}
